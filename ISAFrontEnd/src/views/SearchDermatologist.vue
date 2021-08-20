<template>
  <div>
    <h1 id="searchDermatologistsCaption">Search and filter dermatologists</h1>
    <div class="pt-1">
      <v-card
        width="40%"
        class="mx-auto mt-3"
        v-bind:style="{ opacity: opacity }"
      >
        <v-card-text>
          <v-form class="mx-auto mt-5 mb-5 mr-10 ml-10">
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="First name"
                v-model="searchFirstName"
                color="blue"
                type="text"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Last name"
                v-model="searchLastName"
                color="blue"
                type="text"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Enter min for rating"
                v-model="minRating"
                color="blue"
                type="number"
                min="0"
                max="10"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Enter max for rating"
                v-model="maxRating"
                color="blue"
                type="number"
                min="0"
                max="10"
              />
            </v-row>
          </v-form>
        </v-card-text>

        <v-card-actions class="justify-center">
          <v-btn
            v-on:click="searchDermatologist"
            color="info"
            class="mt-2 mr-10 p-5 mb-5"
            x-medium
            width="260px"
            height="40px"
            >Search dermatologist</v-btn
          >
          <v-btn
            v-on:click="cancelSearch"
            color="info"
            class="mt-2 ml-10 p-5 mb-5"
            x-medium
            width="260px"
            height="40px"
            >Cancel search</v-btn
          >
        </v-card-actions>
      </v-card>
    </div>
    <div class="mt-2 ml-10 mr-10">
      <p id="dermatologistsSubtitle">Dermatologists</p>
      <v-simple-table id="searchTable">
        <template v-slot:default>
          <thead>
            <tr>
              <th class="text-center">First name</th>
              <th class="text-center">Last name</th>
              <th class="text-center">Raiting of a dermatologist</th>
            </tr>
          </thead>
          <tbody v-bind:hidden="showList">
            <tr v-for="item in dermatologists" :key="item.firstName">
              <td class="text-center">{{ item.firstName }}</td>
              <td class="text-center">{{ item.lastName }}</td>
              <td class="text-center">{{ item.rating }}</td>
            </tr>
          </tbody>
          <tbody v-bind:hidden="!showList">
            <tr v-for="item in dermatologistList" :key="item.firstName">
              <td class="text-center">{{ item.firstName }}</td>
              <td class="text-center">{{ item.lastName }}</td>
              <td class="text-center">{{ item.rating }}</td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchDermatologist",
  data: () => ({
    opacity: 0.9,
    searchFirstName: "",
    searchLastName: "",
    minRating: "",
    maxRating: "",
    dermatologists: null,
    dermatologistList: null,
    showList: false,
  }),
  mounted() {
    this.init();
  },
  methods: {
    init() {
      this.axios
        .get("http://localhost:8091/dermatologists/all")
        .then((resp) => {
          console.log(resp.data);
          this.dermatologists = resp.data;
        });
    },
    searchDermatologist() {
      if (this.searchFirstName != "" && this.searchLastName == "") {
        console.log("Search dermatologists by first name");
        this.axios
          .get(
            "http://localhost:8091/dermatologists/searchDermatologistsByFirstName/" +
              this.searchFirstName
          )
          .then((response) => {
            if (response.data.length == 0) {
              alert("No results");
              this.clearInputFields();
            }
            this.dermatologistList = response.data;
            this.showList = true;
          })
          .catch((err) => {
            console.log(err);
          });
      } else if (this.searchFirstName == "" && this.searchLastName != "") {
        console.log("Search dermatologists by last name");
        this.axios
          .get(
            "http://localhost:8091/dermatologists/searchDermatologistsByLastName/" +
              this.searchLastName
          )
          .then((response) => {
            if (response.data.length == 0) {
              alert("No results");
              this.clearInputFields();
            }
            this.dermatologistList = response.data;
            this.showList = true;
          });
      } else if (this.searchFirstName != "" && this.searchLastName != "") {
        console.log("Search dermatologist by first and last name");
        this.axios
          .get(
            "http://localhost:8091/dermatologists/searchDermatologists/" +
              this.searchFirstName +
              "/" +
              this.searchLastName
          )
          .then((response) => {
            if (response.data.length == 0) {
              alert("No results");
              this.clearInputFields();
            }
            this.dermatologistList = response.data;
            this.showList = true;
          });
      } else if (this.minRating != "" && this.maxRating != "") {
        if ((Number(this.minRating) < 0 || Number(this.minRating) > 10) && (Number(this.maxRating) < 0 || Number(this.maxRating) > 10))
        {
          alert("Min and max rating must be in the range 0 to 10");
          this.clearInputFields();
        }
        else if (Number(this.minRating) > Number(this.maxRating)) {
          alert("Not valid input for rating");
          this.clearInputFields(); 
        }
        else {
          console.log("Search dermatologist by rating");
          this.axios
            .get(
              "http://localhost:8091/dermatologists/filterDermatologistByRating/" +
                this.minRating +
                "/" +
                this.maxRating
            )
            .then((response) => {
              if (response.data.length == 0) {
                alert("No results");
                this.clearInputFields();
              }
              this.dermatologistList = response.data;
              this.showList = true;
            });
        }
      } else {
        alert(
          "The fields based on which the search is performed are empty! You must fill in at least one of the search fields!"
        );
      }
    },
    cancelSearch() {
      console.log("Cancel search");
      this.showList = false;
      this.clearInputFields();
    },
    clearInputFields() {
      this.searchFirstName = "";
      this.searchLastName = "";
      this.minRating = "";
      this.maxRating = "";
    },
  },
};
</script>

<style scoped>
#searchDermatologistsCaption {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-weight: bold;
}

#dermatologistsSubtitle {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-size: 1.8em;
  font-weight: bold;
}
</style>
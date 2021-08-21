<template>
  <div>
    <h1 id="searchPharmacistsCaption">Search and filter pharmacists</h1>
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
            v-on:click="searchPharmacist"
            color="info"
            class="mt-2 mr-10 p-5 mb-5"
            x-medium
            width="260px"
            height="40px"
            >Search pharmacist</v-btn
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
      <p id="pharmacistsSubtitle">Pharmacists</p>
      <v-simple-table id="searchTable">
        <template v-slot:default>
          <thead>
            <tr>
              <th class="text-center">First name</th>
              <th class="text-center">Last name</th>
              <th class="text-center">Raiting of a pharmacist</th>
              <th class="text-center">Pharmacy name</th>
            </tr>
          </thead>
          <tbody v-bind:hidden="showList">
            <tr v-for="item in pharmacists" :key="item.firstName">
              <td class="text-center">{{ item.firstName }}</td>
              <td class="text-center">{{ item.lastName }}</td>
              <td class="text-center">{{ item.rating }}</td>
              <td class="text-center">{{ item.pharmacyName }}</td>
            </tr>
          </tbody>
          <tbody v-bind:hidden="!showList">
            <tr v-for="item in pharmacistList" :key="item.firstName">
              <td class="text-center">{{ item.firstName }}</td>
              <td class="text-center">{{ item.lastName }}</td>
              <td class="text-center">{{ item.rating }}</td>
              <td class="text-center">{{ item.pharmacyName }}</td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchPharmacist",
  data: () => ({
    opacity: 0.9,
    searchFirstName: "",
    searchLastName: "",
    minRating: "",
    maxRating: "",
    pharmacists: null,
    pharmacistList: null,
    showList: false,
  }),
  mounted() {
    this.init();
  },
  methods: {
    init() {
      this.axios
        .get("http://localhost:8091/pharmacists/all", {
          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
          },
        })
        .then((response) => (this.pharmacists = response.data))
        .catch((err) => console.log(err));
    },
    searchPharmacist() {
      if (this.searchFirstName != "" && this.searchLastName == "") {
        console.log("Search pharmacists by first name");
        this.axios
          .get(
            "http://localhost:8091/pharmacists/searchPharmacistsByFirstName/" +
              this.searchFirstName,
            {
              headers: {
                Authorization: "Bearer " + localStorage.getItem("token"),
              },
            }
          )
          .then((response) => {
            this.pharmacistList = response.data;
            this.showList = true;
            if (response.data.length == 0) {
              alert("No results found try another search");
              this.clearInputFields();
            }
          })
          .catch(err => console.log(err));
      }
      },
      cancelSearch() {
        console.log("Cancel search");
        this.showList = false;
        this.clearInputFields();
      },
      clearInputFields() {
         this.searchFirstName = '';
         this.searchLastName = '';
         this.minRating = '';
         this.maxRating = '';
      },
    },
};
</script>

<style scoped>
#searchPharmacistsCaption {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-weight: bold;
}

#pharmacistsSubtitle {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-size: 1.8em;
  font-weight: bold;
}
</style>
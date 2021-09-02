<template>
  <div>
    <h1 id="myPharmacyCaption">My pharmacy</h1>
    <div class="pt-1">
      <v-card id="pharmacyInfoCard" v-bind:style="{ opacity: opacity }">
        <v-card-text>
          <v-form class="mx-auto mt-5 mb-5 mr-10 ml-10">
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Pharmacy name"
                v-model="name"
                color="blue"
                type="text"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Pharmacy street"
                v-model="addressStreet"
                color="blue"
                type="text"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Pharmacy street number"
                v-model="streetNumber"
                color="blue"
                type="text"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="City"
                v-model="city"
                color="blue"
                type="text"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Country"
                v-model="country"
                color="blue"
                type="text"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Pharmacy rating"
                v-model="rating"
                color="blue"
                type="text"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Description"
                v-model="description"
                color="blue"
                type="text"
              />
            </v-row>
          </v-form>
        </v-card-text>
      </v-card>
      <v-spacer></v-spacer>
      <v-card id="medicinesInPharmacyCard">
        <div>
          <v-data-table
            :headers="medicinesHeaders"
            :items="medicinesInPharmacy"
            sort-by="quantity"
          >
            <template v-slot:top>
              <v-toolbar dense dark color="light-blue darken-2">
                <v-spacer></v-spacer>
                <v-toolbar-title class="text-center">
                  All medicine items in {{name}} pharmacy
                </v-toolbar-title>
                <v-spacer></v-spacer>
              </v-toolbar>
            </template>
          </v-data-table>
        </div>
      </v-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "MyPharmacy",
  data: () => ({
    opacity: 0.9,
    name: "",
    addressStreet: "",
    streetNumber: "",
    city: "",
    country: "",
    rating: "",
    description: "",
    pharmacy: null,
    medicinesInPharmacy: [],
    medicinesHeaders: [
      {
        text: "Medicine code",
        value: "medicineCode",
        align: "center",
        sortable: true,
      },
      {
        text: "Medicine name",
        value: "name",
        align: "center",
        sortable: true,
      },
      {
        text: "Medicine type",
        value: "type",
        align: "center",
        sortable: true,
      },
      {
        text: "Medicine form",
        value: "medicineForm",
        align: "center",
        sortable: true,
      },
      {
        text: "Prescription type",
        value: "prescriptionType",
        align: "center",
        sortable: true,
      },
      {
        text: "Quantity",
        value: "quantity",
        align: "center",
        sortable: true,
      },
    ],
  }),
  mounted() {
    this.initialize();
  },
  methods: {
    initialize() {
      this.axios
        .get(
          "http://localhost:8091/pharmacy/getPharmacyById/" +
            localStorage.getItem("pharmacyId"),
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((response) => {
          console.log(response.data);
          this.myPharmacy = response.data;
          this.name = response.data.name;
          this.addressStreet = response.data.street;
          this.streetNumber = response.data.streetNumber;
          this.city = response.data.city;
          this.country = response.data.country;
          this.rating = response.data.rating;
          this.description = response.data.description;
        })
        .catch((err) => console.log(err));

      this.axios
        .get(
          "http://localhost:8091/medicineItem/findMedicineItemsByPharmacy/" +
            localStorage.getItem("pharmacyId"),
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((response) => {
          console.log(response.data);
          this.medicinesInPharmacy = response.data;
        });
    },
  },
};
</script>

<style scoped>
#myPharmacyCaption {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-weight: bold;
}
#pharmacyInfoCard {
  width: 60%;
  margin: auto;
}
#medicinesInPharmacyCard {
  width: 60%;
  text-align: center;
  margin: auto;
  margin-top: 5%;
  opacity: 0.9;
}
</style>
<template>
  <div>
    <h1 id="makeAnOrderCaption">Make an order for a pharmacy</h1>
    <v-card id="makeAnOrderCard" elevation="10" justify-center>
      <div>
        <v-data-table :headers="headers" :items="medicineItemsPharmacy" :items-per-page="5">
          <template v-slot:top>
            <v-toolbar dense dark color="light-blue darken-2">
              <v-spacer></v-spacer>
              <v-toolbar-title class="text-center">
                Medicines that exist in the {{ pharmacyName }} pharmacy
              </v-toolbar-title>
              <v-spacer></v-spacer>
            </v-toolbar>
          </template>
          <template v-slot:item="row">
            <tr>
              <td>
                {{ row.item.medicineId }}
              </td>
              <td>
                {{ row.item.medicineCode }}
              </td>
              <td>
                {{ row.item.name }}
              </td>
              <td>
                {{ row.item.type }}
              </td>
              <td>
                {{ row.item.medicineForm }}
              </td>
              <td>
                <v-text-field
                  type="number"
                  min="0"
                  v-model="row.item.newQuantity"
                >
                  {{ row.item.newQuantity }}
                </v-text-field>
              </td>
            </tr>
          </template>
        </v-data-table>
      </div>
      <div>
        <v-data-table
          class="mt-5 elevation-1"
          :headers="headers"
          :items="potentiallyNewMedicineItems"
          :items-per-page="10"
        >
          <template v-slot:top>
            <v-toolbar dense dark color="light-blue darken-2">
              <v-spacer></v-spacer>
              <v-toolbar-title class="text-center">
                New medicines that the pharmacy has not ordered so far
              </v-toolbar-title>
              <v-spacer></v-spacer>
            </v-toolbar>
          </template>
          <template v-slot:item="row">
            <tr>
              <td>
                {{ row.item.medicineId }}
              </td>
              <td>
                {{ row.item.medicineCode }}
              </td>
              <td>
                {{ row.item.name }}
              </td>
              <td>
                {{ row.item.type }}
              </td>
              <td>
                {{ row.item.medicineForm }}
              </td>
              <td>
                <v-text-field
                  type="number"
                  min="0"
                  v-model="row.item.newQuantity"
                >
                  {{ row.item.newQuantity }}
                </v-text-field>
              </td>
            </tr>
          </template>
        </v-data-table>
      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "MakeAnOrder",
  data: () => ({
    medicineItemsPharmacy: [],
    potentiallyNewMedicineItems: [],
    headers: [
      {
        text: "Medicine ID",
        value: "medicineId",
        align: "left",
        sortable: true,
      },
      {
        text: "Medicine code",
        value: "medicineCode",
        align: "left",
        sortable: true,
      },
      {
        text: "Medicine name",
        value: "name",
        align: "left",
        sortable: true,
      },
      {
        text: "Medicine type",
        value: "type",
        align: "left",
        sortable: true,
      },
      {
        text: "Medicine form",
        value: "medicineForm",
        align: "left",
        sortable: true,
      },
      {
        text: "New quantity",
        value: "newQuantity",
        align: "left",
        sortable: false,
        width: "16%",
      },
    ],
    pharmacy: null,
    pharmacyName: "",
    pharmacyId: "",
  }),
  mounted() {
    this.initialize();
  },
  computed:{
    pageTxt(){
      return this.$vuetify.dataFooter.pageText
    }
  },
  methods: {
    initialize() {
      this.axios
        .get(
          "http://localhost:8091/pharmacy/" +
            localStorage.getItem("pharmacyId"),
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((resp) => {
          console.log(resp.data);
          this.pharmacy = resp.data;
          this.pharmacyName = this.pharmacy.name;
        });

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
          this.medicineItemsPharmacy = response.data;
        });

      this.axios
        .get(
          "http://localhost:8091/medicineItem/findPotentiallyNewMedicineItemsForPharmacy/" +
            localStorage.getItem("pharmacyId"),
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((response) => {
          console.log(response.data);
          this.potentiallyNewMedicineItems = response.data;
        });
    },
  },
};
</script>


<style scoped>
#makeAnOrderCaption {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-weight: bold;
}
#makeAnOrderCard {
  width: 80%;
  text-align: center;
  margin: auto;
}
</style>
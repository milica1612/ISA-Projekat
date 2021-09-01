<template>
  <div>
    <h1 id="defineFreeTermWithDermatologistCaption">
      Define free term for examination with dermatologist who work in
      {{ this.pharmacyName }} pharmacy
    </h1>
    <v-card id="defineFreeTermWithDermatologistCard">
      <v-data-table
        :headers="headers"
        :items="dermatologistList"
        :items-per-page="10"
        :sort-by="userId"
      >
        <template v-slot:top>
          <v-toolbar dense dark color="light-blue darken-2">
            <v-spacer></v-spacer>
            <v-toolbar-title class="text-center">
              Select one of the dermatologists who works in the
              {{ pharmacyName }} pharmacy
            </v-toolbar-title>
            <v-spacer></v-spacer>
          </v-toolbar>
        </template>
          <v-spacer></v-spacer>
        <template v-slot:[`item.action`]="{ item }">
          <v-card-actions>
              <v-spacer></v-spacer>
            <v-btn color="primary" text @click="selectDermatologist(item)">
              SELECT DERMATOLOGIST
            </v-btn>
              <v-spacer></v-spacer>
          </v-card-actions>
        </template>
      </v-data-table>
    </v-card>
  </div>
</template>


<script>
export default {
  name: "DefineFreeTermWithDermatologist",
  data: () => ({
    pharmacyAdmin: null,
    dermatologistList: [],
    pharmcayId: localStorage.getItem("pharmacyId"),
    pharmacyName: "",
    headers: [
      {
        text: "Dermatologist ID",
        value: "userId",
        align: "center",
        sortable: true,
      },
      {
        text: "First name",
        value: "firstName",
        align: "center",
        sortable: true,
      },
      {
        text: "Last name",
        value: "lastName",
        align: "center",
        sortable: true,
      },
      {
        text: "E-mail",
        value: "email",
        align: "center",
        sortable: true,
      },
      {
        text: "Phone number",
        value: "phoneNumber",
        align: "center",
        sortable: true,
      },
      {
        value: "action",
        aling: "center",
        sortable: false,
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
          "http://localhost:8091/pharmacyAdmin/" +
            localStorage.getItem("userId"),
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((response) => {
          console.log(response.data);
          this.pharmacyAdmin = response.data;
        });

      this.axios
        .get("http://localhost:8091/pharmacy/" + this.pharmcayId, {
          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
          },
        })
        .then((resp) => {
          console.log(resp.data);
          this.pharmacy = resp.data;
          this.pharmacyName = this.pharmacy.name;
        });

      this.axios
        .get(
          "http://localhost:8091/dermatologists/allDermatologistByPharmacyId/" +
            this.pharmcayId,
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((response) => (this.dermatologistList = response.data));
    },
    selectDermatologist(item) {
        console.log(item);
    }
  },
};
</script>


<style scoped>
#defineFreeTermWithDermatologistCaption {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-weight: bold;
}
#defineFreeTermWithDermatologistCard {
  width: 80%;
  text-align: center;
  margin: auto;
}
</style>
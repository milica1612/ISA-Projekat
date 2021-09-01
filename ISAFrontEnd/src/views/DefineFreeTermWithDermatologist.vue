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
      <div v-if="showDermatologistVacationList">
        <v-data-table
          :headers="headersVacation"
          :items="dermatologistVacationList"
          :items-per-page="5"
          :sort-by="dermatologistName"
        >
          <template v-slot:top>
            <v-toolbar dense dark color="light-blue darken-2">
              <v-spacer></v-spacer>
              <v-toolbar-title class="text-center">
                Current vacation list for a dermatologist {{ dermatologist }}
              </v-toolbar-title>
              <v-spacer></v-spacer>
            </v-toolbar>
          </template>
        </v-data-table>
      </div>
      <div v-if="showShift || showValidFor">
        <h2 id = "shiftText">{{shift}}</h2>
        <h3 id = "validForText">{{validFor}}</h3>
      </div>
    </v-card>
  </div>
</template>


<script>
export default {
  name: "DefineFreeTermWithDermatologist",
  data: () => ({
    pharmacyAdmin: null,
    dermatologistList: [],
    dermatologistVacationList: [],
    pharmcayId: localStorage.getItem("pharmacyId"),
    pharmacyName: "",
    dermatologist: "",
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
    headersVacation: [
      {
        text: "Dermatologist name",
        value: "dermatologistName",
        align: "center",
        sortable: true,
      },
      {
        text: "Email",
        value: "email",
        align: "center",
        sortable: true,
      },
      {
        text: "Description",
        value: "description",
        align: "center",
        sortable: true,
      },
    ],
    showDermatologistVacationList: false,
    showShift: false,
    showValidFor: false,
    shift: "",
    validFor: "",
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
      this.axios
        .get(
          "http://localhost:8091/dermatologistVacation/isOnVacation/" +
            item.userId,
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((response) => {
          this.dermatologistVacationList = response.data;
          if (this.dermatologistVacationList.length > 0) {
            this.showDermatologistVacationList = true;
            this.dermatologist = item.firstName + " " + item.lastName;
          } else {
            this.showDermatologistVacationList = false;
          }
        });

      this.axios
        .get(
          "http://localhost:8091/workScheduleDermatologist/findShiftByDermatologistId/" +
            item.userId,
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((response) => {
          this.shift = response.data;
          if (this.shift != "") {
            this.showShift = true;
          } else {
            this.showShift = false;
          }
        });

      this.axios
        .get(
          "http://localhost:8091/workScheduleDermatologist/findValidForByDermatologistId/" +
            item.userId,
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((response) => {
          this.validFor = response.data;
          if (this.validFor != "") {
            this.showValidFor = true;
          } else {
            this.showValidFor = false;
          }
        });
    },
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
#shiftText {
  color: rgb(2, 2, 117);
  text-align: center;
}
#validForText {
  color: rgb(2, 2, 117);
  text-align: center;
}
</style>
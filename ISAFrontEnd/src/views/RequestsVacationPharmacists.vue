<template>
  <div>
    <h1 id="requestVacationCaption">Vacation requests from pharmacists</h1>

    <div class="table">
      <v-data-table
        :headers="headers"
        :items="vacatoionList"
        sort-by="vacationId"
        class="elevation-1"
      >
        <template v-slot:top>
          <v-toolbar dense dark color="light-blue darken-2">
            <v-spacer></v-spacer>
            <v-toolbar-title class="text-center"
              >Pending vacation requests</v-toolbar-title
            >
            <v-spacer></v-spacer>

            <v-dialog v-model="dialogAcceptRequest" max-width="60%">
              <v-card>
                <v-spacer></v-spacer>
                <v-card-title class="text-h4 justify-center"
                  >Are you sure you want to accept this vacation
                  request?</v-card-title
                >
                <v-card-actions>
                  <v-spacer></v-spacer>

                  <v-btn color="green" text @click="acceptRequest"
                    >Accept</v-btn
                  >
                  <v-spacer></v-spacer>

                  <v-btn color="red" text @click="closeAcceptRequest"
                    >Cancel</v-btn
                  >

                  <v-spacer></v-spacer>
                </v-card-actions>
              </v-card>
            </v-dialog>

            <v-dialog v-model="dialogDeclineRequest" max-width="60%">
              <v-card>
                <v-spacer></v-spacer>
                <v-card-title class="text-h4 justify-center"
                  >Are you sure you want to decline this vacation
                  request?</v-card-title
                >
                <v-card-actions>
                  <v-spacer></v-spacer>

                  <v-btn color="green" text @click="declineRequest"
                    >Decline</v-btn
                  >
                  <v-spacer></v-spacer>

                  <v-btn color="red" text @click="closeDeclineRequest"
                    >Cancel</v-btn
                  >

                  <v-spacer></v-spacer>
                </v-card-actions>
              </v-card>
            </v-dialog>

          </v-toolbar>
        </template>
        <template v-slot:[`item.actions`]="{ item }">
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="green" text @click="accept(item)"> ACCEPT </v-btn>
            <v-spacer></v-spacer>
            <v-btn color="red" text @click="decline(item)"> DECLINE </v-btn>
            <v-spacer></v-spacer>
          </v-card-actions>
        </template>
      </v-data-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "RequestsVacationPharmacists",
  data: () => ({
    vacatoionList: [],
    dialogDeclineRequest: false,
    dialogAcceptRequest: false,
    headers: [
      {
        text: "Vacation ID",
        value: "vacationId",
        align: "center",
        sortable: true 
      },
      { text: "Pharmacist ID", value: "pharmacistId", align: "center" },
      { text: "First name", value: "firstName", align: "center" },
      { text: "Last name", value: "lastName", align: "center"  },
      { text: "E-mail", value: "email", align: "center" },
      { text: "Start date", value: "startDate", align: "center" },
      { text: "End date", value: "endDate", align: "center"  },
      { text: "Status", value: "status", align: "center", sortable: false},
      { text: "Actions", value: "actions", align: "center" , sortable: false},
    ],
  }),
  watch: {
    dialogDeclineRequest(val) {
      val || this.closeDeclineRequest();
    },
    dialogAcceptRequest(val) {
      val || this.closeAcceptRequest();
    },
  },
  mounted() {
    this.initialize();
  },
  methods: {
    initialize() {
      this.vacatoionList = [
        {
          vacationId: "1",
          pharmacistId: "12",
          firstName: "Branko",
          lastName: "Sudic",
          email: "mail",
          startDate: "2021-09-10",
          endDate: "2021-09-20",
          status: "waiting",
        },
        {
          vacationId: "2",
          pharmacistId: "6",
          firstName: "Nikola",
          lastName: "Spasic",
          email: "mail",
          startDate: "2021-10-10",
          endDate: "2021-10-20",
          status: "waiting",
        },
        {
          vacationId: "3",
          pharmacistId: "9",
          firstName: "Maja",
          lastName: "Lakic",
          email: "mail",
          startDate: "2021-09-20",
          endDate: "2021-09-30",
          status: "waiting",
        },
      ];
    },

    decline(item) {
      this.editedIndex = this.vacatoionList.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogDeclineRequest = true;
    },

    accept(item) {
      this.editedIndex = this.vacatoionList.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogAcceptRequest = true;
    },

    acceptRequest() {
      this.vacatoionList.splice(this.editedIndex, 1);
      this.closeAcceptRequest();
    },

    declineRequest() {
      this.vacatoionList.splice(this.editedIndex, 1);
      this.closeDeclineRequest();
    },

    closeDeclineRequest() {
      this.dialogDeclineRequest = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    closeAcceptRequest() {
      this.dialogAcceptRequest = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

  },
};
</script>

<style scoped>
#requestVacationCaption {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-weight: bold;
}
</style>
 
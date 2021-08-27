<template>
  <div>
    <h1 id="pharmacyOrdersCaption">All pharmacy orders</h1>

    <div>
      <v-data-table :headers="headers" :items="orderList" sort-by="orderId">
        <template v-slot:top>
          <v-toolbar dense dark color="light-blue darken-2">
            <v-spacer></v-spacer>
            <v-toolbar-title class="text-center">
              Orders
            </v-toolbar-title>
            <v-spacer></v-spacer>

            <v-dialog v-model="dialogShowOffer" max-width="60%">
              <v-card>
                <v-spacer></v-spacer>
                <v-card-title class="text-h4 justify-center"
                  >Offers</v-card-title
                >
                <v-card-actions>
                  <v-spacer></v-spacer>

                  <v-btn color="green" text @click="acceptOffer"
                    >Accept</v-btn
                  >
                  <v-spacer></v-spacer>

                  <v-btn color="red" text @click="closeShowOffer"
                    >Cancel</v-btn
                  >

                  <v-spacer></v-spacer>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-toolbar>
        </template>
        <template v-slot:[`item.action`]="{ item }">
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue" text @click="showOffer(item)">
              SHOW OFFER
            </v-btn>
            <v-spacer></v-spacer>
          </v-card-actions>
        </template>
      </v-data-table>
    </div>
  </div>
</template>


<script>
export default {
  name: "PharmacyOrders",
  data: () => ({
    dialogShowOffer: false,
    orderList: [],
    headers: [
      {
        text: "Order ID",
        value: "orderId",
        align: "center",
        sortable: true,
      },
      {
        text: "Pharmacy admin name",
        value: "adminName",
        align: "center",
        sortable: true,
      },
      {
        text: "Offer deadline",
        value: "offerDeadline",
        align: "center",
        sortable: true,
      },
      {
        text: "Order status",
        value: "orderStatus",
        align: "center",
        sortable: true,
      },
      { text: "Action", value: "action", align: "center", sortable: false },
    ],
    orderId: null,
    orderItem: null,
  }),
  watch: {
    dialogShowOffer(val) {
      val || this.closeShowOffer();
    },
  },
  mounted() {
    this.initialize();
  },
  methods: {
    initialize() {
      this.axios
        .get("http://localhost:8091/orders/forPharmacy", {
          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
          },
        })
        .then((response) => {
          console.log(response.data);
          this.orderList = response.data;
        });
    },
    showOffer(item) {
      this.orderId = this.orderList.indexOf(item);
      this.dialogShowOffer = true;
    },
    acceptOffer() {

    },
    closeShowOffer() {
      this.dialogShowOffer = false;
      this.$nextTick(() => {
        this.orderItem = Object.assign({}, this.defaultItem);
        this.orderId = -1;
      });
    },
  },
};
</script>


<style scoped>
#pharmacyOrdersCaption {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-weight: bold;
}
</style>

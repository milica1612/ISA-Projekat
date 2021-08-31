<template>
  <div>
    <h1 id="orderEditingCaption">Edit my orders</h1>
    <v-card id="orderEditingCard" elevation="7" justify-center>
      <div>
        <v-data-table
          :headers="headers"
          :items="waitingOrderList"
          sort-by="orderId"
          class="elevation-1"
        >
          <template v-slot:top>
            <v-toolbar dense dark color="light-blue darken-2">
              <v-spacer></v-spacer>
              <v-toolbar-title class="text-center"
                >List of orders we can edit</v-toolbar-title
              >
              <v-spacer></v-spacer>
                  <v-dialog v-model="dialogShowOffer" max-width="60%">
                <v-card>
                  <v-spacer></v-spacer>
                  <v-card-title class="text-h4 justify-center"
                    >Offers</v-card-title
                  >
                  <v-data-table
                    :headers="headers2"
                    :items="offerList"
                    sort-by="offerId"
                  >
                  </v-data-table>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="red" text @click="closeShowOffer"
                      >Close</v-btn
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
    </v-card>
  </div>
</template>

<script>
export default {
  name: "OrderEditing",
  data: () => ({
    waitingOrderList: [],
    dialogShowOffer: false,
    offerList: [],
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
     headers2: [
      {
        text: "Offer ID",
        value: "offerId",
        align: "center",
        sortable: true,
      },
      {
        text: "Supplier name",
        value: "supplierName",
        align: "center",
        sortable: true,
      },
      {
        text: "Supplier email",
        value: "supplierEmail",
        align: "center",
        sortable: true,
      },
      {
        text: "Offer price ( RSD )",
        value: "offerPrice",
        align: "center",
        sortable: true,
      },
      {
        text: "Delivery deadline",
        value: "deliveryDeadline",
        align: "center",
        sortable: true,
      },
      {
        text: "Action",
        value: "actionAcceptOffer",
        align: "center",
        sortable: false,
      },
    ],
    orderItem: null,
    index: null,
    id: null,
    pharmacyAdminId: localStorage.getItem("userId"),
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
        .get("http://localhost:8091/orders/waitingOfferForPharmacy", {
          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
          },
        })
        .then((response) => {
          this.waitingOrderList = response.data;
        });
    },
    showOffer(item) {
      this.index = this.waitingOrderList.indexOf(item);
      this.orderItem = Object.assign({}, item);
      this.dialogShowOffer = true;

      this.axios
        .get(
          "http://localhost:8091/offers/findOffersByOrderId/" +
            this.orderItem.orderId,
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((resp) => {
          console.log(resp.data);
          this.offerList = resp.data;
        });
    },
    closeShowOffer() {
      this.dialogShowOffer = false;
      this.$nextTick(() => {
        this.orderItem = Object.assign({}, this.defaultItem);
        this.index = -1;
      });
    },
  },
};
</script>

<style scoped>
#orderEditingCaption {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-weight: bold;
}
#orderEditingCard {
  width: 80%;
  text-align: center;
  margin: auto;
}
</style>

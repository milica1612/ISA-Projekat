<template>
  <div>
    <h1 id="pharmacyOrdersCaption">All pharmacy orders</h1>

    <div>
      <v-data-table :headers="headers1" :items="orderList" sort-by="orderId">
        <template v-slot:top>
          <v-toolbar dense dark color="light-blue darken-2">
            <v-spacer></v-spacer>
            <v-toolbar-title class="text-center"> Orders </v-toolbar-title>
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
                  <template v-slot:[`item.actionAcceptOffer`]="{ item }" >
                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn v-if="item.adminId == pharmacyAdminId" color="green" text @click="acceptOffer(item)"
                        >Accept</v-btn
                      >
                      <v-btn v-else color="blue" text @click="seeNote(item)"
                        >See note</v-btn
                      >
                      <v-spacer></v-spacer>
                    </v-card-actions>
                  </template>
                </v-data-table>
                <v-card-actions>
                  <v-spacer></v-spacer>

                  <v-btn color="red" text @click="closeShowOffer">Close</v-btn>

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
    offerList: [],
    isMyOrder: true,
    headers1: [
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
    pharmacyAdminId: null,
    pharmacyAdminNote: null,
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
      this.pharmacyAdminId = localStorage.getItem("userId");
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
      this.index = this.orderList.indexOf(item);
      this.orderItem = Object.assign({}, item);
      this.dialogShowOffer = true;
      
      console.log(this.orderId);

      this.axios
      .get("http://localhost:8091/offers/findOffersByOrderId/" + this.orderItem.orderId,
      {
          headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
          },
      })
      .then(resp => {
          console.log(resp.data);
          this.offerList = resp.data;
      });
    },
    acceptOffer(offer) 
    {
      console.log(offer);
      this.axios
        .post(
          "http://localhost:8091/offers/acceptOffer",
          {
            offerId: offer.offerId,
          },
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then(response => 
        {
          console.log(response.data);
          alert("The offer was accepted!");
        });
      this.closeShowOffer();

    },
    closeShowOffer() {
      this.dialogShowOffer = false;
      this.$nextTick(() => {
        this.orderItem = Object.assign({}, this.defaultItem);
        this.index = -1;
      });
    },
    seeNote(item) {
      console.log(item);
       this.axios
        .get("http://localhost:8091/pharmacyAdmin/" + item.adminId, {
          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
          },
        })
        .then((response) => {
          console.log(response.data);
          this.pharmacyAdminNote = response.data;
          alert("This order was placed by another pharmacy administrator, " + this.pharmacyAdminNote.firstName + " " + this.pharmacyAdminNote.lastName + " email " + this.pharmacyAdminNote.email + " , you can't select an offer.");
        });
    }
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

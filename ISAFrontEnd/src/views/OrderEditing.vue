<template>
  <div>
    <h1 class="orderEditingCaption">Edit or delete my orders</h1>
    <v-card class="orderEditingCard" elevation="7" justify-center>
      <div>
        <v-data-table
          :headers="headers"
          :items="possibleEditingOrderList"
          :items-per-page="5"
          sort-by="orderId"
        >
          <template v-slot:top>
            <v-toolbar dense dark color="light-blue darken-2">
              <v-spacer></v-spacer>
              <v-toolbar-title class="text-center"
                >List of orders we can edit or delete</v-toolbar-title
              >
              <v-spacer></v-spacer>
              <v-dialog v-model="dialogEditOrder" max-width="60%">
                <v-card>
                  <v-spacer></v-spacer>
                  <v-card-title
                    class="text-h4 justify-center orderEditingCaption"
                    >Edit order</v-card-title
                  >
                  <v-card class="orderEditingCard" elevation="7" justify-center>
                    <v-data-table
                      :headers="headersEdit"
                      :items="orderMedicineItems"
                    >
                      <template v-slot:top>
                        <v-toolbar dark color="light-blue darken-2">
                          <v-spacer></v-spacer>
                          <v-toolbar-title>
                            Medicine items that exist in the order
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
                            {{ row.item.quantity }}
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
                    <v-data-table
                      :headers="headersNew"
                      :items="possibleNewMedicineItems"
                    >
                      <template v-slot:top>
                        <v-toolbar dark color="light-blue darken-2">
                          <v-spacer></v-spacer>
                          <v-toolbar-title>
                           Add new medicine items to the order
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
                  </v-card>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="red" text @click="closeEditOrderDialog"
                      >Close</v-btn
                    >
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-dialog>

              <v-dialog v-model="dialogDeleteOrder" max-width="60%">
                <v-card>
                  <v-spacer></v-spacer>
                  <v-card-title class="text-h4 justify-center"
                    >Are you sure you want to delete the order ?</v-card-title
                  >

                  <v-spacer></v-spacer>

                  <v-card-actions>
                    <v-spacer></v-spacer>

                    <v-btn color="green" text @click="deleteThisOrder"
                      >Delete</v-btn
                    >
                    <v-spacer></v-spacer>

                    <v-btn color="red" text @click="closeDeleteOrderDialog"
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
              <v-btn color="blue" text @click="editOrder(item)"> EDIT </v-btn>
              <v-spacer></v-spacer>
              <v-btn color="red" text @click="deleteOrder(item)">
                DELETE
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
    possibleEditingOrderList: [],
    dialogEditOrder: false,
    dialogDeleteOrder: false,
    orderMedicineItems: [],
    possibleNewMedicineItems: [],
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
    headersEdit: [
      {
        text: "Medicine ID",
        value: "medicineId",
        align: "center",
        sortable: true,
      },
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
        text: "Old quantity",
        value: "quantity",
        align: "center",
        sortable: true,
        width: "16%",
      },
      {
        text: "New quantity",
        value: "newQuantity",
        align: "center",
        sortable: false,
        width: "16%",
      },
    ],
     headersNew: [
      {
        text: "Medicine ID",
        value: "medicineId",
        align: "center",
        sortable: true,
      },
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
        text: "New quantity",
        value: "newQuantity",
        align: "center",
        sortable: false,
        width: "16%",
      },
    ],
    orderItem: null,
    index: null,
    id: null,
    pharmacyAdminId: localStorage.getItem("userId"),
    deleteOrderId: null,
  }),
  mounted() {
    this.initialize();
  },
  methods: {
    initialize() {
      this.axios
        .get("http://localhost:8091/orders/possibleEditingOrders", {
          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
          },
        })
        .then((response) => {
          console.log(response.data);
          if (response.data.length != 0)
            alert(
              "There is an order that can be edit or delete by pharmacy admin who created them."
            );
          this.possibleEditingOrderList = response.data;
        });
    },
    editOrder(item) {
      this.index = this.possibleEditingOrderList.indexOf(item);
      this.orderItem = Object.assign({}, item);
      this.dialogEditOrder = true;

      this.axios
        .get(
          "http://localhost:8091/medicineItem/findMedicineItemsByOrderId/" +
            this.orderItem.orderId,
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((resp) => {
          console.log(resp.data);
          this.orderMedicineItems = resp.data;
        });

     this.axios
        .get(
          "http://localhost:8091/medicineItem/findMedicineItemsNotExistByOrderId/" +
            this.orderItem.orderId,
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((resp) => {
          console.log(resp.data);
          this.possibleNewMedicineItems = resp.data;
        });
    },
    closeEditOrderDialog() {
      this.dialogEditOrder = false;
      this.$nextTick(() => {
        this.orderItem = Object.assign({}, this.defaultItem);
        this.index = -1;
      });
    },
    deleteOrder(item) {
      this.index = this.possibleEditingOrderList.indexOf(item);
      this.orderItem = Object.assign({}, item);
      this.dialogDeleteOrder = true;
      this.deleteOrderId = this.orderItem.orderId;
    },
    closeDeleteOrderDialog() {
      this.dialogDeleteOrder = false;
      this.$nextTick(() => {
        this.orderItem = Object.assign({}, this.defaultItem);
        this.index = -1;
      });
    },
    deleteThisOrder() {
      console.log(this.deleteOrderId);
      this.axios
        .get("http://localhost:8091/orders/delete/" + this.deleteOrderId, {
          headers: {
            Authorization: "Bearer " + localStorage.getItem("token"),
          },
        })
        .then((resp) => {
          alert("Order is deleted.");
          console.log(resp.data);
          window.location.href = "/homePagePharmacyAdmin";
        });
    },
  },
};
</script>

<style scoped>
.orderEditingCaption {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-weight: bold;
}
.orderEditingCard {
  width: 80%;
  text-align: center;
  margin: auto;
}
</style>

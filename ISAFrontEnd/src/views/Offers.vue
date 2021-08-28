<template>
<div id="offer">
  <div class = "container">

        <v-row
            align="center"
            justify="space-around"
            style="margin-top: 3%" 
        >
        <h2 
            text-align:left
            color:blue
        >Filter offers by:</h2>
            <v-btn
                v-on:click = "filtrateOffersA"
            >Accepted</v-btn>
            <v-btn
                v-on:click = "filtrateOffersD"
            >Declined</v-btn>
            <v-btn
                v-on:click = "filtrateOffersW"
            >Waiting</v-btn>
            <v-btn
                v-on:click = "showAll"
            >No Filter</v-btn>
        </v-row>


      <v-simple-table style="margin-top: 1%"  >
        <template v-slot:default>
          <thead>
          <tr>
            <th class="text-left">
              Delivery Deadline
            </th>
            <th class="text-left">
              Offer Status
            </th>
            <th class="text-left">
              Order Status
            </th>
            <th class="text-left">
              Price
            </th>
            <th class="text-left">
              Pharmacy
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="offer in offers"
              :key="offer"
          >
            <td>{{ offer.deliveryDeadline }}</td>
            <td>{{ offer.status }}</td>
            <td>{{ offer.order.orderStatus}}</td>
            <td>{{ offer.price }}</td>
            <td>{{ offer.order.pharmacy.name }}</td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>


  <h2 
            text-align:left
            color:blue
          >New arrived orders:</h2>

      <v-simple-table style="margin-top: 1%;"  
            show-select  >
        <h2 >New arrived orders:</h2>

        <template v-slot:default>
          <thead>
          <tr>
            <th class="text-left">
              Offer Deadline
            </th>
            <th class="text-left">
              Status
            </th>
            <th class="text-left">
              Pharmacy
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="order in orders"
              :key="order"
          >
            <td>{{ order.offerDeadline}}</td>
            <td>{{order.orderStatus }}</td>
            <td>{{ order.pharmacy.name }}</td>
            <td>

          <v-row justify="center">
            <v-dialog
            v-model="dialog"
            persistent
            max-width="600px"
            >
            <template v-slot:activator="{ on, attrs }">
                <v-btn
                color="primary"
                dark
                v-bind="attrs"
                v-on="on"
                >
                Create Offer
                </v-btn>
            </template>
            <v-card>
                <v-card-title>
                <span class="text-h5">Offer</span>
                </v-card-title>
                <v-card-text>
                <v-container>
                    <v-row>
                    <v-col cols="12">
                        <v-text-field
                        label="Price*"
                        v-model= "price"
                        required
                        ></v-text-field>
                    </v-col>
                    <v-col cols="12">
                         <v-menu
        v-model="menu2"
        :close-on-content-click="false"
        :nudge-right="40"
        transition="scale-transition"
        offset-y
        min-width="auto"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-text-field
            v-model="deliveryDeadline"
            label="Delivery Deadline*"
            prepend-icon="mdi-calendar"
            readonly
            v-bind="attrs"
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker
          v-model="deliveryDeadline"
          @input="menu2 = false"
        ></v-date-picker>
      </v-menu>
                    </v-col>
                    </v-row>
                </v-container>
                <small>*indicates required field</small>
                </v-card-text>
                <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                    color="blue darken-1"
                    text
                    @click="dialog = false"
                >
                    Close
                </v-btn>
                <v-btn
                    color="blue darken-1"
                    text
                    @click="dialog = false"
                >
                    Save
                </v-btn>
                </v-card-actions>
            </v-card>
            </v-dialog>
        </v-row>
        </td>
        <td>
                <v-btn
                    color="primary"
                    dark
                    @click="dialog = false"
                    v-on:click= "addOfferForOrder(order)"
                >
                    Send
                </v-btn>
   
            </td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>


    </div>
</div>
</template>

<script>

export default {
    name: "Offers",
    data: function() {
     return {
        deliveryDeadline: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
        dialog: false,
        menu2: false,
        logged: false,
        offers: [],
        orders: [],
        singleSelect: false,
        selected: []
     }
    },
    mounted() { 
    {
        this.axios
            .get('http://localhost:8091/offers/seeOffers/' + localStorage.getItem("userId"), {
              headers: {
                  Authorization: 'Bearer ' + localStorage.getItem("token")
            }
            })
            .then(r => (this.offers = r.data));
        
        this.axios
            .get('http://localhost:8091/orders/allOrders', {
              headers: {
                  Authorization: 'Bearer ' + localStorage.getItem("token")
            }
            })
            .then(r => (this.orders = r.data))
    }   
    },
    methods: {
        filtrateOffersA: function(){
			this.axios
			.get("http://localhost:8091/offers/filtrate/ACCEPTED/" + localStorage.getItem("userId"), {
          headers: {
              Authorization: 'Bearer ' + localStorage.getItem("token")
          }
      })
			.then(response => (this.offers = response.data));
		},
        filtrateOffersD: function(){
			this.axios
			.get("http://localhost:8091/offers/filtrate/DECLINED/" + localStorage.getItem("userId"), {
          headers: {
              Authorization: 'Bearer ' + localStorage.getItem("token")
          }
      })
			.then(response => (this.offers = response.data));
		},
     filtrateOffersW: function(){
			this.axios
			.get("http://localhost:8091/offers/filtrate/WAITING/" + localStorage.getItem("userId"), {
          headers: {
              Authorization: 'Bearer ' + localStorage.getItem("token")
          }
      })
			.then(response => (this.offers = response.data));
        },
     showAll: function() {
            this.axios
            .get('http://localhost:8091/offers/seeOffers/' + localStorage.getItem("userId"), {
              headers: {
                Authorization: 'Bearer ' + localStorage.getItem("token")
            }
            })
            .then(r => (this.offers = r.data));
        },
      addOfferForOrder: function(order){
        this.axios
          .post("http://localhost:8091/offers/createOffer/" + order.orderId + "/add", {
              id: order.orderId,
              price: this.price,
              deliveryDeadline: this.deliveryDeadline},{
              headers: {
                  Authorization: 'Bearer ' + localStorage.getItem("token")}
            })
            .then(() => {
                console.log('Successfully sent offer.');
            })
            .catch((er) => {
              alert("Error!");
              console.log(er.response.data);
            });
          }
    }

  }
</script>

<style scoped>

td{
    padding: 7%;
}

h2 {

    text-align:center;
    color:white
}
</style>
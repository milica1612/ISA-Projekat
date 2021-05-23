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
        >Filter orders by:</h2>
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
              v-for="offer of offers"
              :key="offer"
          >
            <td>{{ offer.deliveryDeadline.substring(0, 10) }}</td>
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
              v-for="order of orders"
              :key="order"
          >
            <td>{{ order.offerDeadline.substring(0, 10) }}</td>
            <td>{{order.orderStatus }}</td>
            <td>{{ order.pharmacy.name }}</td>
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
            .get('http://localhost:8090/application/offers/seeOffers/3')
            .then(r => (this.offers = r.data));
        
        this.axios
            .get('http://localhost:8090/application/orders/allOrders')
            .then(r => (this.orders = r.data))
    }   
    },
    methods: {
        filtrateOffersA: function(){
			this.axios
			.get("http://localhost:8090/application/offers/filtrate/ACCEPTED/3")
			.then(response => (this.offers = response.data));
		},
        filtrateOffersD: function(){
			this.axios
			.get("http://localhost:8090/application/offers/filtrate/DECLINED/3")
			.then(response => (this.offers = response.data));
		},
     filtrateOffersW: function(){
			this.axios
			.get("http://localhost:8090/application/offers/filtrate/WAITING/3")
			.then(response => (this.offers = response.data));
        },
        showAll: function() {
            this.axios
            .get('http://localhost:8090/application/offers/seeOffers/3')
            .then(r => (this.offers = r.data));
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
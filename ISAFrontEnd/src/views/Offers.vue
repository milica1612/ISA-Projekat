<template>
<div id="offer">
  <div class = "container">
      <v-simple-table>
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
              Pharmacy Name
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="o in offers"
              :key="o"
          >
            <td>{{o.deliveryDeadline}}</td>
            <td>{{o.status}}</td>
            <td>{{o.order.orderStatus}}</td>
            <td>{{o.price}}</td>
            <td>{{o.order.pharmacy.name}}</td>
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
        offers: []
     }
    },
    mounted() { 
        this.axios
            .get('http://localhost:8090/application/offers/seeOffers/3')
            .then(r => (this.offers = r.data))
        
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
            }
    }
  }
</script>

<style scoped>

</style>
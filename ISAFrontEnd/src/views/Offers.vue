<template>
  <v-card style="margin-top: 3%"  class="mx-auto">
    <v-card-title>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
      :headers="headers"
      :items="items"
      :search="search"
    >
    <tbody>
         <tr v-for="(item,index) in items" :key="index">
          <td>{{item.postId}}</td>
          <td>{{item.email}}</td>
          <td>{{item.name}}</td>
        </tr>
      </tbody>
    </v-data-table>
  </v-card>
</template>


<script>

export default {
    name: "Offers",
    data: () => ({
        search: '',
        items: [],
        headers: [
          {
            text: 'Delivery Deadline',
            value: 'deliveryDeadline',
            align: 'start',
            filterable: false
          },
          { text: 'Price', value: 'price' },
          { text: 'Offer Status', value: 'offerStatus' },
          { text: 'Order Status', value: 'orderStatus' },
          { text: 'Pharmacy', value: 'pharmacy' },
        ],
        
    }),
    methods: {
      showAllOffers() {
        this.$http
            .get("http://localhost:8090/application/offers/seeOffers/3")
            .then(response => (this.headers = response.data));
    },   
    },
  }
</script>
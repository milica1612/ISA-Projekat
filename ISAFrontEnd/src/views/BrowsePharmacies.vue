<template>
  <div id = "homePage">
    <h2>Pharmacies</h2>
    <a href = "#/searchMedicine">Show medicines</a>
    <br>

    <label for="searchPharmacies">Search Pharmacies:</label>
    <input type="search" v-model = "searchField" id="searchPharmacies" name="searchPharmacies" required>
    <button type="submit" v-on:click = "searchPharmacies">Search</button>
    <br>
    <label class = "filtrate">Filtrate by rating higher than:</label>

    <label>5</label>
    <input type="radio" value=5 name="rating" @change = "filtrate(5)">

    <label>4</label>
    <input type="radio" value=4 name="rating" @change = "filtrate(4)">

    <label>3</label>
    <input type="radio" value=3 name="rating" @change = "filtrate(3)">

    <label>2</label>
    <input type="radio" value=2 name="rating" @change = "filtrate(2)">

    <label>1</label>
    <input type="radio" value=1 name="rating" @change = "filtrate(1)">

    <div class = "container">
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th class="text-left">
              Name
            </th>
            <th class="text-left">
              Rating
            </th>
            <th class="text-left">
              Address
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="p in pharmacies"
              :key="p"
          >
            <td>{{ p.name }}</td>
            <td>{{ p.rating }}</td>
            <td>{{p.adress.street + " " + p.adress.streetNumber + ", " + p.adress.city + ", " + p.adress.country}}</td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "BrowsePharmacies",

  data: function () {
    return {
      logged: false,
      pharmacies: [],
      searchField: ""
    }
  },
mounted() {
  {
  this.axios
      .get('http://localhost:8090/application/pharmacy')
      .then(r => (this.pharmacies = r.data))
  }
},
  methods: {
    searchPharmacies: function() {
      this.axios
          .get("http://localhost:8090/application/pharmacy/getByNameOrAddress/" + this.searchField)
          .then(response => (this.pharmacies = response.data));
    },
    filtrate: function(rating){
      this.axios
          .get("http://localhost:8090/application/pharmacy/filtrateByRating/" + rating)
          .then(response => (this.pharmacies = response.data));
    }
  }
}
</script>

<style scoped>

</style>
<template>
  <div id = "searchMedicine">

    <h1>Search Medicine</h1>
    <br>
    <v-btn
        elevation="6"
        large
        outlined
        color="white"
    ><router-link to="/browsePharmacies" tag="button">Browse pharmacies</router-link></v-btn>
    <br>

    <h3>Search Medicines:</h3>
    <input placeholder="Enter medicine" type="search" v-model = "searchMedicine" id="search" name="searchMedicine" required>
    <v-btn
        color="secondary"
        elevation="3"
        x-small
        v-on:click = "searchMedicines"
    >Search</v-btn>
    <br>
    <h3>Filtrate by rating higher than:</h3>

    <label>Rating 5</label>
    <input type="radio" value=5 name="rating" @change = "filtrate(5)">

    <label>Rating4</label>
    <input type="radio" value=4 name="rating" @change = "filtrate(4)">

    <label>Rating 3</label>
    <input type="radio" value=3 name="rating" @change = "filtrate(3)">

    <label>Rating 2</label>
    <input type="radio" value=2 name="rating" @change = "filtrate(2)">

    <label>Rating 1</label>
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
              Type
            </th>
            <th class="text-left">
              Rating
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="m in medicines"
              :key="m"
          >
            <td>{{ m.name }}</td>
            <td>{{ m.type }}</td>
            <td>{{ m.rating }}</td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>
    </div>

    <h2>Available In</h2>
    <div class = "container">
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th class="text-left">
              Name
            </th>
            <th class="text-left">
              Type
            </th>
            <th class="text-left">
              Price
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="a in availableInPharmacies" :key="a"
          >
            <td>{{ a.name }}</td>
            <td>{{ a.price }}</td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "BrowseMedicine",
  data: function () {
    return {
      medicines: [],
      availableInPharmacies: [],
      searchMedicine: ""
    }
  },
  mounted(){
    this.axios
        .get('http://localhost:8091/medicine')
        .then(response => (this.medicines = response.data));
    this.axios
        .get('http://localhost:8091/pharmacy')
        .then(response => (this.availableInPharmacies = response.data));
  },
  methods: {
    searchMedicines: function() {
      this.axios
          .get("http://localhost:8091/medicine/getMedicineByName/" + this.searchMedicine)
          .then(response => (this.medicines = response.data));
    }
  }
}
</script>

<style scoped>
#search{
  background-color: white;
}
#searchButton{
  color: white;
  border: white;
  border-width: 10px;
}

.container {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 12px;
  cursor: pointer;
  font-size: 22px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
input[type=radio]{
  border-radius: 10px;
  box-shadow: inset 0 1px 1px hsla(0,0%,100%,.8),
  0 0 0 1px hsla(0,0%,0%,.6),
  0 2px 3px hsla(0,0%,0%,.6),
  0 4px 3px hsla(0,0%,0%,.4),
  0 6px 6px hsla(0,0%,0%,.2),
  0 10px 6px hsla(0,0%,0%,.2);
  cursor: pointer;
  display: inline-block;
  height: 15px;
  margin-right: 15px;
  position: relative;
  width: 15px;
  -webkit-appearance: none;
}

input[type="radio"]:after {
  border-radius: 25px;
  box-shadow: inset 0 0 0 1px hsla(0,0%,0%,.4),
  0 1px 1px hsla(0,0%,100%,.8);
  content: '';
  display: block;
  height: 7px;
  left: 4px;
  position: relative;
  top: 4px;
  width: 7px;
}
input[type="radio"]:checked:after {
  background-color: #444;
  box-shadow: inset 0 0 0 1px hsla(0,0%,0%,.4),
  inset 0 2px 2px hsla(0,0%,100%,.4),
  0 1px 1px hsla(0,0%,100%,.8),
  0 0 2px 2px hsla(0,70%,70%,.4);
}

</style>
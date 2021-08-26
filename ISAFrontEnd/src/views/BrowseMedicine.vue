<template>
  <div id = "searchMedicine">
    <br>
    <div class = "container">
    <h3>Search Medicines:</h3>
    <input placeholder="Enter medicine" type="search" v-model = "searchMedicine" id="search" name="searchMedicine" required>
    <v-btn
        color="secondary"
        elevation="3"
        small
        v-on:click = "searchMedicines"
        v-if="notFilled"
    >Search</v-btn>
    <br>
    <h3>Filtrate by rating higher than:</h3>

    <label>Rating 10</label>
    <input type="radio" value=5 name="rating" @change = "filtrate(10)">

    <label>Rating 9</label>
    <input type="radio" value=4 name="rating" @change = "filtrate(9)">

    <label>Rating 8</label>
    <input type="radio" value=3 name="rating" @change = "filtrate(8)">

    <label>Rating 7</label>
    <input type="radio" value=2 name="rating" @change = "filtrate(7)">

    <label>Rating 6</label>
    <input type="radio" value=1 name="rating" @change = "filtrate(6)">


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
                      Medicine Specification
                      </v-btn>
                  </template>
                  <v-card>
                      <v-card-title>
                      <span class="text-h5">Medicine Specification</span>
                      </v-card-title>
                      <v-card-text>
                      <v-container>
                          <v-row>
                          <v-col cols="12">
                              <v-text-field
                              label="Dosage*"
                              v-model= "m.medicineSpecification.dosage"
                              required
                              ></v-text-field>
                          </v-col>
                          <v-col cols="12">
                              <v-text-field
                              label="Ingridients*"
                              v-model = "m.medicineSpecification.ingridient.name"
                              required
                              ></v-text-field>
                          </v-col>
                          <v-col cols="12">
                              <v-text-field
                              label="Contraindication*"
                              v-model = "m.medicineSpecification.contraindication.description"
                              required
                              ></v-text-field>
                          </v-col>
                          </v-row>
                      </v-container>
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
                      </v-card-actions>
                  </v-card>
                  </v-dialog>
              </v-row>
              
            </td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>
    </div>

    <div class = "container">
    <h3>Available In:</h3>
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th class="text-left">
              Name
            </th>
            <th class="text-left">
              Price
            </th>
            <th class="text-left">
              Medicine Specification
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
      dialog: false,
      medicines: [],
      medicineSpecification: {
          dosage: "",
          contraindication: {
              description: ""
          },
          ingridient: {
              name: ""
          },
      },
      availableInPharmacies: [],
      searchMedicine: ""
    }
  },
  mounted(){
    this.axios
        .get('http://localhost:8091/medicine')
        .then(response => (this.medicines = response.data));
  },
  methods: {
    searchMedicines: function() {
      this.axios
          .get("http://localhost:8091/medicine/getMedicineByName/" + this.searchMedicine)
          .then(response => (this.medicines = response.data));
       this.axios
          .get("http://localhost:8091/medicine/checkMedicineInPharmacy/" + this.searchMedicine)
          .then(r => (this.availableInPharmacies = r.data));
    },
    filtrate: function(rating) {
      this.axios  
          .get("http://localhost:8091/medicine/filtrate/" + rating)
          .then(response => (this.medicines = response.data));
    },
  },

  computed:{
    notFilled: function () {
      if (this.searchMedicine.trim() == ""){
        return false
      }
      else {
        return true
      }
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
  font-size: 18px;
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
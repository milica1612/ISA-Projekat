<template>
  <div id = "homePage">
    <div class = "container">
    <h2>Rate or report:</h2>
      <br>
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th>
              Pharmacist
            </th>
            <th>
              Rating
            </th>
            <th>
              Pharmacy
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="p in pharmacists"
              :key="p"
          >
            <td>{{ p.firstName + " " + p.lastName}}</td>
            <td>{{ p.rating }}</td>
            <td>{{p.pharmacy.name}}</td>
            <td>
            <v-dialog
                transition="dialog-top-transition"
                max-width="600"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                    color="secondary"
                    elevation="3"
                    x-small
                    v-bind="attrs"
                    v-on="on"
                >Rate</v-btn>
              </template>
              <template v-slot:default="dialog">
                <v-card>
                  <v-toolbar
                      color="primary"
                      dark
                  >Rate pharmacist:</v-toolbar>
                  <template>
                    <br>
                    <label>Rating 10</label>
                    <input type="radio" value=10 name="rating" @change = "setRating(10)">

                    <label>Rating 9</label>
                    <input type="radio" value=4 name="rating" @change = "setRating(9)">

                    <label>Rating 8</label>
                    <input type="radio" value=3 name="rating" @change = "setRating(8)">

                    <label>Rating 7</label>
                    <input type="radio" value=2 name="rating" @change = "setRating(7)">

                    <label>Rating 6</label>
                    <input type="radio" value=1 name="rating" @change = "setRating(6)">
                    <br>
                    <br>
                  </template>
                  <v-btn
                      width="300"
                      color="primary"
                      small
                      @click="submit(p, dialog)"
                  >Submit</v-btn>
                  <v-btn
                      width="300"
                      color="primary"
                      small
                      @click="dialog.value=false"
                  >Cancel</v-btn>
                </v-card>
              </template>
            </v-dialog>
            </td>

            <td>
              <v-btn
                  color="secondary"
                  elevation="3"
                  x-small
                  v-if="isLogged"
              >Report</v-btn>
            </td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>

        <br>
        <br>
        <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th>
              Dermatologist
            </th>
            <th>
              Rating
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="d in dermatologists"
              :key="d"
          >
            <td>{{ d.firstName + " " + d.lastName}}</td>
            <td>{{ d.rating }}</td>
            <td>
              <v-dialog
                  transition="dialog-top-transition"
                  max-width="600"
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                      color="secondary"
                      elevation="3"
                      x-small
                      v-bind="attrs"
                      v-on="on"
                  >Rate</v-btn>
                </template>
                <template v-slot:default="dialog">
                  <v-card>
                    <v-toolbar
                        color="primary"
                        dark
                    >Rate dermatologist:</v-toolbar>
                    <template>
                      <label>Rating 10</label>
                      <input type="radio" value=10 name="rating" @change = "setRating(10)">

                      <label>Rating 9</label>
                      <input type="radio" value=4 name="rating" @change = "setRating(9)">

                      <label>Rating 8</label>
                      <input type="radio" value=3 name="rating" @change = "setRating(8)">

                      <label>Rating 7</label>
                      <input type="radio" value=2 name="rating" @change = "setRating(7)">

                      <label>Rating 6</label>
                      <input type="radio" value=1 name="rating" @change = "setRating(6)">
                    </template>
                    <v-btn
                        width="300"
                        text
                        @click="submit(p, dialog)"
                    >Submit</v-btn>
                  </v-card>
                </template>
              </v-dialog>
            </td>
            <td>
              <v-btn
                  color="secondary"
                  elevation="3"
                  x-small
                  v-if="isLogged"
              >Report</v-btn>
            </td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>

      <br>
      <br>
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th>
              Pharmacy
            </th>
            <th>
              Rating
            </th>
            <th>
              Address
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="p in pharmacies"
              :key="p"
          >
            <td>{{ p.name}}</td>
            <td>{{ p.rating }}</td>
            <td>{{p.address.street + " " + p.address.streetNumber + ", " + p.address.city + ", " + p.address.country}}</td>
            <td>
              <v-dialog
                  transition="dialog-top-transition"
                  max-width="600"
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                      color="secondary"
                      elevation="3"
                      x-small
                      v-bind="attrs"
                      v-on="on"
                  >Rate</v-btn>
                </template>
                <template v-slot:default="dialog">
                  <v-card>
                    <v-toolbar
                        color="primary"
                        dark
                    >Rate pharmacy:</v-toolbar>
                    <template>
                      <label>Rating 10</label>
                      <input type="radio" value=10 name="rating" @change = "setRating(10)">

                      <label>Rating 9</label>
                      <input type="radio" value=4 name="rating" @change = "setRating(9)">

                      <label>Rating 8</label>
                      <input type="radio" value=3 name="rating" @change = "setRating(8)">

                      <label>Rating 7</label>
                      <input type="radio" value=2 name="rating" @change = "setRating(7)">

                      <label>Rating 6</label>
                      <input type="radio" value=1 name="rating" @change = "setRating(6)">
                    </template>
                    <v-btn
                        width="300"
                        text
                        @click="submit(p, dialog)"
                    >Submit</v-btn>
                  </v-card>
                </template>
              </v-dialog>
            </td>
            <td>
              <v-btn
                  color="secondary"
                  elevation="3"
                  x-small
                  v-if="isLogged"
              >Report</v-btn>
            </td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>
      <br>
      <br>
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th>
              Medicine
            </th>
            <th>
              Rating
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="m in medicine"
              :key="m"
          >
            <td>{{ m.name}}</td>
            <td>{{ m.rating }}</td>
            <td>
              <v-dialog
                  transition="dialog-top-transition"
                  max-width="600"
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                      color="secondary"
                      elevation="3"
                      x-small
                      v-bind="attrs"
                      v-on="on"
                  >Rate</v-btn>
                </template>
                <template v-slot:default="dialog">
                  <v-card>
                    <v-toolbar
                        color="primary"
                        dark
                    >Rate medicine:</v-toolbar>
                    <template>
                      <label>Rating 10</label>
                      <input type="radio" value=10 name="rating" @change = "setRating(10)">

                      <label>Rating 9</label>
                      <input type="radio" value=4 name="rating" @change = "setRating(9)">

                      <label>Rating 8</label>
                      <input type="radio" value=3 name="rating" @change = "setRating(8)">

                      <label>Rating 7</label>
                      <input type="radio" value=2 name="rating" @change = "setRating(7)">

                      <label>Rating 6</label>
                      <input type="radio" value=1 name="rating" @change = "setRating(6)">
                    </template>
                    <v-btn
                        width="300"
                        text
                        @click="submit(p, dialog)"
                    >Submit</v-btn>
                  </v-card>
                </template>
              </v-dialog>
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
  name: "RateAndReport",

  data: function () {
    return {
      logged: false,
      dermatologists: [],
      pharmacists: [],
      pharmacies: [],
      medicine: [],
      rating: 10,
      searchField: "",
      token: localStorage.getItem("token"),
      sort: {
        key: '',
        isAsc: false
      }
    }
  },
mounted() {
  
  this.axios
      .get('http://localhost:8091/examination/getAllDermatologistByPatient/' + localStorage.getItem("userId"), {
              headers: {
                Authorization: 'Bearer ' + localStorage.getItem("token")
              }
            })
      .then(r => (this.dermatologists = r.data))
  ,
  this.axios
      .get('http://localhost:8091/consultation/getAllPharmacistsByPatient/' + localStorage.getItem("userId"), {
              headers: {
                Authorization: 'Bearer ' + localStorage.getItem("token")
              }
            })
      .then(r => (this.pharmacists = r.data))
  ,
  this.axios
      .get('http://localhost:8091/pharmacy/getPharmaciesForPatient/' + localStorage.getItem("userId"), {
              headers: {
                Authorization: 'Bearer ' + localStorage.getItem("token")
              }
            })
      .then(r => (this.pharmacies = r.data));
  this.axios
      .get('http://localhost:8091/medicine/getMedicineForRating/' + localStorage.getItem("userId"), {
        headers: {
          Authorization: 'Bearer ' + localStorage.getItem("token")
        }
      })
      .then(r => (this.medicine = r.data));
},
  methods: {
    setRating: function (rating){
        this.rating = rating
    },
    submit: function(e, dialog){
      dialog.value = false
      this.axios
          .post("http://localhost:8091/rateEmployee/ratePharmacist",{rating: this.rating, pharmacyEmployee: e},
              {headers: {
              Authorization: 'Bearer ' + localStorage.getItem("token")
            }})
          .then(
              window.location.href = "http://localhost:8080/rateAndReport"
          );
    }
  },
  computed:{
    isLogged: function (){
      if (this.token == ""){
        return false
      }else{
        return true
      }
    }

  }
}
</script>

<style scoped>
#searchPharmacies{
  background-color: white;
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
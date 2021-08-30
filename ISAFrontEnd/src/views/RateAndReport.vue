<template>
  <div id = "homePage">
    <div class = "container">
    <h2>Rate or report pharmacies and dermatologists:</h2>
      <br>
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th>
              Name
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
              v-for="p in pharmacists"
              :key="p"
          >
            <td>{{ p.firstName + " " + p.lastName}}</td>
            <td>{{ p.rating }}</td>
            <td>{{p.address.street + " " + p.address.streetNumber + ", " + p.address.city + ", " + p.address.country}}</td>
            <td>
              <v-btn
                  color="secondary"
                  elevation="3"
                  x-small
                  v-if="isLogged"
              >Rate</v-btn>
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
              Name
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
              v-for="d in dermatologists"
              :key="d"
          >
            <td>{{ d.firstName + " " + d.lastName}}</td>
            <td>{{ d.rating }}</td>
            <td>{{d.address.street + " " + d.address.streetNumber + ", " + d.address.city + ", " + d.address.country}}</td>
            <td>
              <v-btn
                  color="secondary"
                  elevation="3"
                  x-small
                  v-if="isLogged"
              >Rate</v-btn>
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
              Name
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
            <td>{{ p.firstName + " " + p.lastName}}</td>
            <td>{{ p.rating }}</td>
            <td>{{p.address.street + " " + p.address.streetNumber + ", " + p.address.city + ", " + p.address.country}}</td>
            <td>
              <v-btn
                  color="secondary"
                  elevation="3"
                  x-small
                  v-if="isLogged"
              >Rate</v-btn>
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
      .then(r => (this.pharmacists = r.data));
},
  methods: {
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
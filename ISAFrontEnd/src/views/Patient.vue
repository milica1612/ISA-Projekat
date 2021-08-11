<template>
  <div>

    <h1 style = "margin:0 auto; text-align:center;">User profile</h1>
    <br>
    <div class = "container">
    <v-simple-table>
      <template v-slot:default>
      <tr>
        <th colspan="2" id="personal_info"><h3>Personal information</h3></th>
      </tr>
      <tr>
        <th>Name</th>
        <td><input type = "text" v-model = "patient.firstName" disabled/></td>
      </tr>
      <tr>
        <th>Last Name</th>
        <td><input type = "text" v-model = "patient.lastName" disabled/></td>
      </tr>
      <tr>
        <th>Phone Number</th>
        <td><input type = "text" v-model = "patient.phoneNumber" disabled/></td>
      </tr>
      <tr>
        <th>Country</th>
        <td><input type = "text" v-model = "patient.address.country" disabled/></td>
      </tr>
      <tr>
        <th>City</th>
        <td><input type = "text" v-model = "patient.address.city" disabled/></td>
      </tr>
      <tr>
        <th>Street</th>
        <td><input type = "text" v-model = "patient.address.street" disabled/></td>
      </tr>
      <tr>
        <th>Home Number</th>
        <td><input type = "text" v-model = "patient.address.streetNumber" disabled/></td>
      </tr>
      <tr>
        <th>E-mail</th>
        <td>{{patient.email}}</td>
      </tr>
      </template>
    </v-simple-table>
    </div>
    <br>

    <h3 style = "margin:0 auto; text-align:center;">Loyalty card</h3>
    <div class = "container">
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th class="text-left">
              Loyalty points
            </th>
            <th class="text-left">
              Loyalty category
            </th>
          </tr>
          </thead>
          <tbody>
          <tr style="align-content: center">
            <td>{{loyalty_card.points}}</td>
            <td>{{loyalty_card.loyaltyCategory}}</td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>
    </div>

    <div class = "container">
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th class="text-left">
              Allergies to medicine
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="m in patient.allergy.medicine"
              :key="m"
          >
            <td>{{ m.name }}</td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>
    </div>
    <br>
  <v-row
    align="center"
    justify="space-around">
          <v-btn
              color="primary"
              elevation="3"
              medium>
    <router-link to="/editPatientInfo" tag="button">Edit</router-link>
          </v-btn>
  </v-row>
  </div>
</template>

<script>
export default {
  name: "Patient",
  data: function(){
    return{
      mode: 'BROWSE',
      patient: null,
      loyalty_card: null,
      medicine: [],
      patient_id: null
    }
  },
  mounted(){
    console.log(this.role)
        console.log(localStorage.getItem("userId"))

        this.axios
          .get('http://localhost:8091/users/' + localStorage.getItem("userId"), {
            headers: {
              Authorization: 'Bearer ' + localStorage.getItem("token")
            }
          })
          .then(response => (this.patient = response.data));
        
        this.axios
          .get('http://localhost:8091/loyaltyCard/user/' + localStorage.getItem("userId"), {
             headers: {
              Authorization: 'Bearer ' + localStorage.getItem("token")
            }
          })
          .then(response => (this.loyalty_card = response.data));
  }
}
</script>

<style scoped>
#personal_info{
  text-align: center;
}
th{
  text-align: justify;
  padding: 7px;
}
input[type = text]{
  text-align: justify;
}
input[type = password]{
  text-align: justify;
}
</style>
<template>
  <div>
    <h1 style = "margin:0 auto; text-align:center;">User profile</h1>
    <br/>
    <v-simple-table style = "margin:0 auto; padding: 20px;">
      <tr>
        <th><h3>Personal information</h3></th>
      </tr>
      <tr>
        <th>Name</th>
        <td><input type = "text" v-model = "patient.firstName" /></td>
      </tr>
      <tr>
        <th>Last Name</th>
        <td><input type = "text" v-model = "patient.lastName" /></td>
      </tr>
      <tr>
        <th>Phone Number</th>
        <td><input type = "text" v-model = "patient.phoneNumber" /></td>
      </tr>
      <tr>
        <th>Country</th>
        <td><input type = "text" v-model = "patient.address.country" /></td>
      </tr>
      <tr>
        <th>City</th>
        <td><input type = "text" v-model = "patient.address.city" /></td>
      </tr>
      <tr>
        <th>Street</th>
        <td><input type = "text" v-model = "patient.address.street" /></td>
      </tr>
      <tr>
        <th>Home Number</th>
        <td><input type = "text" v-model = "patient.address.streetNumber" /></td>
      </tr>
      <tr>
        <th>E-mail</th>
        <td>{{patient.email}}</td>
      </tr>
      <tr>
      <tr>
        <th>Password</th>
        <td><input type = "text" v-model = "patient.password" /></td>
      </tr>
    </v-simple-table>

    <table style = "margin:0 auto; padding: 20px;">
      <tr>
        <th><h3>Loyalty card</h3></th>
      </tr>
      <tr>
        <th>Loyalty Points</th>
        <td>{{this.loyalty_card.points}}</td>
      </tr>
      <tr>
        <th>Loyalty Category</th>
        <td>{{this.loyalty_card.loyaltyCategory}}</td>
      </tr>
    </table>

    <!-- <table style = "margin:0 auto; padding: 20px;">
       <tr>
         <th><h3>Allergies to medicine</h3></th>
       </tr>
       <tr v-for="m in patient.allergy.medicine" : key="m">
         <td>{{m.name}}</td>
       </tr>
     </table>-->

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
            <td>
              <v-btn
                  color="secondary"
                  elevation="3"
                  x-small
                  v-on:click = "addAllergy(med)"
              >Add medicine to allergy</v-btn>
            </td>
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
              medium
              v-on:click = "editInformation"
          >Edit</v-btn>
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
    this.axios
        .get('http://localhost:8090/application/users/1')
        .then(response => (this.patient = response.data));
    this.axios
        .get('http://localhost:8090/application/loyaltyCard/user/1')
        .then(response => (this.loyalty_card = response.data));

  },
  methods: {

    editInformation : function(){
      this.mode = "EDIT";
      this.patient_id = this.patient.userId;

      this.axios
          .put('http://localhost:8090/application/medicine/forAllergies', this.patient.allergy)
          .then(response => (this.medicine = response.data));
    },

    saveInformation : function(){
      this.mode = "BROWSE";

      this.axios
          .post("http://localhost:8090/application/users/update", this.patient);

      this.axios
          .put('http://localhost:8090/application/medicine/forAllergies', this.patient.allergy)
          .then(response => (this.medicine = response.data));
    },
    addAllergy :function(med){

      this.mode = "ADD";

      this.axios
          .put("http://localhost:8090/application/allergy/" + this.patient_id + "/add", med)
          .then(response => (this.patient.allergy.medicine = response.data));

    }
  }
}
</script>

<style scoped>

</style>
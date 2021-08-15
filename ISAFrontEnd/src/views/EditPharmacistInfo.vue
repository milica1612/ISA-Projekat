<template>
  <div>

    <h1 style = "margin:0 auto; text-align:center;">Pharmacist profile</h1>
    <br>
    <div class = "container">

      <v-simple-table>
        <template v-slot:default>
          <tr>
            <th colspan="2" id="personal_info"><h3>Personal information</h3></th>
          </tr>
          <tr>
            <th>Name</th>
            <td><input type = "text" v-model = "pharmacist.firstName" /></td>
          </tr>
          <tr>
            <th>Last Name</th>
            <td><input type = "text" v-model = "pharmacist.lastName" /></td>
          </tr>
          <tr>
            <th>Phone Number</th>
            <td><input type = "text" v-model = "pharmacist.phoneNumber" /></td>
          </tr>
          <tr>
            <th>Country</th>
            <td><input type = "text" v-model = "pharmacist.address.country" /></td>
          </tr>
          <tr>
            <th>City</th>
            <td><input type = "text" v-model = "pharmacist.address.city" /></td>
          </tr>
          <tr>
            <th>Street</th>
            <td><input type = "text" v-model = "pharmacist.address.street" /></td>
          </tr>
          <tr>
            <th>Home Number</th>
            <td><input type = "text" v-model = "pharmacist.address.streetNumber" /></td>
          </tr>
          <tr>
            <th>E-mail</th>
            <td>{{pharmacist.email}}</td>
          </tr>
          <tr>
          <tr>
            <th>Password</th>
            <td><input type = "password" v-model = "pharmacist.password" /></td>
          </tr>
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
          v-on:click="saveInformation()"
          router-link to="/pharmacistProfile"
      >Save</v-btn>
    </v-row>
  </div>
</template>

<script>

export default {
  name: "EditPharmacistInfo",
  data: function(){
    return{
      mode: 'BROWSE',
      pharmacist: null,
      pharmacist_id: null
    }
  },
  mounted(){
    this.axios
        .get('http://localhost:8091/users/' + localStorage.getItem("userId"), {
          headers: {
            Authorization: 'Bearer ' + localStorage.getItem("token")
          }
        })
        .then(response => (this.pharmacist = response.data));
  },
  methods: {

    saveInformation : function(){
      this.mode = "BROWSE";

      this.axios
          .post("http://localhost:8091/users/update", this.pharmacist, {
            headers: {
              Authorization: 'Bearer ' + localStorage.getItem("token")
            }
          });
    }
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
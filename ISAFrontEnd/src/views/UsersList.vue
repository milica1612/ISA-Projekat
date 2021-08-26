<template>
  <div>
    <v-table>
      <tr>
        <v-text-field
            label="Enter Patient Name"
             hide-details="auto"
            v-model="fName"
            background-color="white"
        ></v-text-field>
         <td align="center"><v-btn
          color="primary"
          elevation="2"
          medium
          v-on:click= "searchPatient"
      >Search Patients</v-btn></td>
      </tr>
    </v-table>
    <br>
    <br>
    <v-simple-table>
      <template v-slot:default>
        <thead>
        <tr>
          <th class="text-left">
            FirstName
          </th>
          <th class="text-left">
            LastName
          </th>
          <th class="text-left">
            SeeProfile
          </th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="p in allpatients" :key="p">
          <td>{{ p.firstName }}</td>
          <td>{{ p.lastName }}</td>
          <td align="center">
            <v-btn
                color="primary"
                elevation="2"
                v-on:click = "seeProfile(p)"
                small
                >See profile</v-btn></td>
          <td align="center">
            <v-btn
                color="primary"
                elevation="2"
                v-on:click = "startAppointment(p)"
                small
                >Start Appointment</v-btn></td>
        </tr>
        </tbody>
      </template>
    </v-simple-table>
  </div>
</template>

<script>
export default {
  name: "UsersList",
  data: () => ({
      allpatients: [],
      mode: 'BROWSE',
      backup: [],
      patient: {},
      employee : {},
      user: {},
      fName: '',

  }),
  mounted() {

      if(localStorage.getItem("userType") == "DERMATOLOGIST"
        || localStorage.getItem("userType") == "PHARMACIST") {

        this.axios
            .get('http://localhost:8091/users/' + localStorage.getItem("userId"), {
              headers: {
                Authorization: 'Bearer ' + localStorage.getItem("token")
              }
            })
           .then(response => {
              this.employee = response.data

             const ne={
               fullName : '',
               employeeId : this.employee.userId
             }
              this.axios
                  .put("http://localhost:8091/users/searchUser", ne, {
                    headers: {
                      Authorization: 'Bearer ' + localStorage.getItem("token")
                    }
                  })
                  .then((resp) => this.allpatients = resp.data)
              })
        }
      else {
          window.location.href = "http://localhost:8080/logIn";
        }
  },
  methods: {
    searchPatient: function () {

      const ne={
        fullName : this.fName,
        employeeId : this.employee.userId
      }

      this.axios
          .put("http://localhost:8091/users/searchUser", ne, {
              headers: {
                Authorization: 'Bearer ' + localStorage.getItem("token")
              }
            })
          .then((resp) => (this.allpatients = resp.data))
    },
    seeProfile: function(p) {
      localStorage.setItem("patientId", p.userId);
      window.location.href = "http://localhost:8080/DermatologistPatientProfile";
    },
    startAppointment: function (p) {
      localStorage.setItem("patientId", p.userId);
      if(localStorage.getItem("userType") == "DERMATOLOGIST"){
        window.location.href = "http://localhost:8080/reportForExamination";
      }
      else{
        window.location.href = "http://localhost:8080/reportForConsultation";
      }
    }
  }
};
</script>
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
              <v-btn>   
                  <v-col cols="auto">
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
                        v-if="isLogged"
                    >Write Complaint</v-btn>
                  </template>
                  <template v-slot:default="dialog">
                    <v-card>
                      <v-toolbar
                          color="primary"
                          dark
                      >Write Complaint for {{p.firstName + " " + p.lastName}}</v-toolbar>
                        <v-textarea
                                background-color="white"
                                filled
                                name="input-7-4"
                                label="Write Complaint:"
                                v-model = "textEmp"
                          ></v-textarea>
                    <v-btn
                          width="300"
                          text
                          @click="createComplaintForPharmacist(p, dialog)"
                      >Send</v-btn>
                    </v-card>
                </template>
              </v-dialog>
            </v-col>
              </v-btn>
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
              >Rate</v-btn>
            </td>
            <td>
              <v-btn>   
                  <v-col cols="auto">
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
                        v-if="isLogged"
                    >Write Complaint</v-btn>
                  </template>
                  <template v-slot:default="dialog">
                    <v-card>
                      <v-toolbar
                          color="primary"
                          dark
                      >Write Complaint for {{d.firstName + " " + d.lastName}}</v-toolbar>
                        <v-textarea
                                background-color="white"
                                filled
                                name="input-7-4"
                                label="Write Complaint:"
                                v-model = "textEmp"
                          ></v-textarea>
                    <v-btn
                          width="300"
                          text
                          @click="createComplaintForDermatologist(d, dialog)"
                      >Send</v-btn>
                    </v-card>
                </template>
              </v-dialog>
            </v-col>
              </v-btn>
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
              v-for="ph in pharmacies"
              :key="ph"
          >
            <td>{{ ph.name}}</td>
            <td>{{ ph.rating }}</td>
            <td>{{ph.address.street + " " + ph.address.streetNumber + ", " + ph.address.city + ", " + ph.address.country}}</td>
            <td>
              <v-btn
                  color="secondary"
                  elevation="3"
                  x-small
                  v-if="isLogged"
              >Rate</v-btn>
            </td>
            <td>
              <v-btn>   
                  <v-col cols="auto">
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
                        v-if="isLogged"
                    >Write Complaint</v-btn>
                  </template>
                  <template v-slot:default="dialog">
                    <v-card>
                      <v-toolbar
                          color="primary"
                          dark
                      >Write Complaint for {{ph.name}}</v-toolbar>
                        <v-textarea
                                background-color="white"
                                filled
                                name="input-7-4"
                                label="Write Complaint:"
                                v-model = "textEmp"
                          ></v-textarea>
                    <v-btn
                          width="300"
                          text
                          @click="createComplaintForPharmacy(ph, dialog)"
                      >Send</v-btn>
                    </v-card>
                </template>
              </v-dialog>
            </v-col>
              </v-btn>
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
      pharmacist: "",
      dialog: false,
      textEmp: "",
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
},
  methods: {
      createComplaintForPharmacist: function(p, dialog){
            dialog.value = false
            this.axios
                .post("http://localhost:8091/complaint/createComplaint",  {
                            textEmp: this.textEmp,
                            patientId: localStorage.getItem("userId"),
                            pharmacyEmployeeId: p.userId,
                        },
                        {
                             headers: {
                                Authorization: 'Bearer ' + localStorage.getItem("token")
                        }
                        })
                     .then(() => {
                        alert("Successfully sent complaint!");
                        })
                    .catch((er) => {
                        alert("Try later!");
                        this.textComplaint = "";
                        console.log(er.response.data);
                        });
      },
      createComplaintForDermatologist: function(d, dialog){
            dialog.value = false
            this.axios
                .post("http://localhost:8091/complaint/createComplaint",  {
                            textEmp: this.textEmp,
                            patientId: localStorage.getItem("userId"),
                            pharmacyEmployeeId: d.userId,
                        },
                        {
                             headers: {
                                Authorization: 'Bearer ' + localStorage.getItem("token")
                        }
                        })
                     .then(() => {
                        alert("Successfully sent complaint!");
                        })
                    .catch((er) => {
                        alert("Try later!");
                        this.textComplaint = "";
                        console.log(er.response.data);
                        });
      },
      createComplaintForPharmacy: function(ph, dialog){
            dialog.value = false
            this.axios
                .post("http://localhost:8091/complaint/createComplaintForPharmacy",  {
                            textEmp: this.textEmp,
                            patientId: localStorage.getItem("userId"),
                            pharmacyId: ph.pharmacyId,
                        },
                        {
                             headers: {
                                Authorization: 'Bearer ' + localStorage.getItem("token")
                        }
                        })
                     .then(() => {
                        alert("Successfully sent complaint!");
                        })
                    .catch((er) => {
                        alert("Try later!");
                        this.textComplaint = "";
                        console.log(er.response.data);
                        });
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
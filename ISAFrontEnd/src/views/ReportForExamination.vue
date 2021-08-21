<template>
  <div>
    <div class = "container">
      <v-simple-table>
      <template v-slot:default>
        <tr>
          <td align="center"><v-btn
              color="primary"
              elevation="2"
              medium
              v-on:click= "modeChange"
              :disabled="isActive"
              >Start Examination</v-btn></td>
          <td align="center"><v-btn
              color="primary"
              elevation="2"
              medium
              v-on:click="patientDidntCome"
              :disabled="isPatientCome"
              >Patient did not come.</v-btn></td>
        </tr>
      </template>
      </v-simple-table>
      <div v-if="this.mode == 'BROWSE'">
      <br><br>
      <v-textarea
          background-color="white"
          filled
          name="input-7-4"
          label="Information about examination:"
      ></v-textarea>
      <h3>Browse new medicine for patient:</h3>
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th class="text-left" width="570">
              Name
            </th>
            <th class="text-left">
              Medicine specification
            </th>
            <th class="text-left">
              Availability
            </th>
          </tr>
          </thead>
          <tbody>
          <tr>
          <tr
              v-for="m in medicines"
              :key="m"
          >
            <td>{{ m.name }}</td>
            <td><v-col cols="auto">
              <v-dialog
                  transition="dialog-top-transition"
                  max-width="600"
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                      color="primary"
                      small
                      v-bind="attrs"
                      v-on="on"
                  >Medicine specification</v-btn>
                </template>
                <template v-slot:default="dialog">
                  <v-card>
                    <v-toolbar
                        color="primary"
                        dark
                    >Medicine specification</v-toolbar>
                    <v-card-actions class="justify-end">
                      <v-btn
                          text
                          @click="dialog.value = false"
                      >Close</v-btn>
                    </v-card-actions>
                  </v-card>
                </template>
              </v-dialog>
            </v-col>
            </td>
            <td><v-col cols="auto">
              <v-dialog
                  transition="dialog-top-transition"
                  max-width="600"
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                      color="primary"
                      small
                      v-bind="attrs"
                      v-on="on"
                      v-on:click="findSubstituteMedicine(m)"
                  >Is medicine Available?</v-btn>
                </template>
                <template v-slot:default="dialog">
                  <v-card>
                    <v-toolbar
                        color="primary"
                        dark
                    >Is medicine available?</v-toolbar>
                      <h3 align="center">Browse substitute medicine:</h3>
                      <br>
                      <v-simple-table>
                        <template v-slot:default>
                          <tr>
                            <th class="text-center" width="250">
                              Name
                            </th>
                            <th class="text-center">
                             Choose
                            </th>
                          </tr>
                          <tbody>
                            <tr>
                              <tr
                                  v-for="sm in substituteMedicines"
                                  :key="sm"
                             >
                              <td align="center">{{ sm.name }}</td>

                              <td align="center">
                                <v-btn color="primary" elevation="2" small>Choose</v-btn>
                              </td>
                            </tr>
                          </tbody>
                        </template>
                      </v-simple-table>
                      <h4 align="center" style="margin-top:20px;">Duration of therapy (in days):</h4>
                      <v-text-field
                          type="number"
                          filled
                          style="margin-top:10px; font-size:14px;">
                      </v-text-field>
                      <br>
                      <v-btn
                          width="300"
                          text
                          @click="dialog.value = false"
                      >Close</v-btn>
                      <v-btn
                          width="300"
                          text
                          @click="dialog.value = false"
                      >Recommend</v-btn>
                  </v-card>
                </template>
              </v-dialog>
            </v-col>
            </td>
          </tr>
          </tbody>
        </template>
      </v-simple-table>
      <br>
      <br>
      <table>
        <tr>
          <td align="center" width="650">
            <v-btn
              color="primary"
              elevation="2"
              v-on:click="endExamination"
              large
            >End Examination</v-btn></td>
          <td align="center"><v-btn color="primary" elevation="2" large>Schedule New Examination</v-btn></td>
        </tr>
      </table>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  name: "ReportForExamination",
  data: function () {
    return {
      medicines: [],
      substituteMedicines: [],
      patient: null,
      mode: '',
      med: [],
      isActive: false,
      isPatientCome: false,
      patient_id: localStorage.getItem("patientId")
    }
  },
  mounted() {
    this.axios
        .get('http://localhost:8091/users/' + this.patient_id, {
            headers: {
             Authorization: 'Bearer ' + localStorage.getItem("token")
            }})
        .then(response => (this.patient = response.data,
            this.axios
                .put('http://localhost:8091/medicine/forAllergies', this.patient.allergy, {
                  headers: {
                    Authorization: 'Bearer ' + localStorage.getItem("token")
                  }
                 })
                .then(response => (this.medicines = response.data)
                )))
  },
  methods: {
    patientDidntCome: function() {
      this.isPatientCome = true
      this.isActive = true
      this.axios
        .post('http://localhost:8091/users/increasePenalty', this.patient, {
          headers: {
            Authorization: 'Bearer ' + localStorage.getItem("token")
          }})
          .then(
              window.location.href = "http://localhost:8080/homePageDermatologist"
          )
    },
    modeChange: function (){
      this.mode = 'BROWSE'
      this.isActive = true
    },
    endExamination: function(){
      window.location.href = "http://localhost:8080/homePageDermatologist"
    },
    findSubstituteMedicine: function (sm){

      this.med = sm

      const swa={
        oldMedicine: this.med,
        medicinesWithoutAllergy: this.medicines
      }

      this.axios
          .put('http://localhost:8091/medicine/substituteMedicine', swa, {
            headers: {
              Authorization: 'Bearer ' + localStorage.getItem("token")
            }
          })
          .then(response => (this.substituteMedicines = response.data))
    }
  }
}
</script>


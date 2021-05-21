<template>
  <div>
    <div style = "background-color: #E0E8F0;; overflow: hidden;">
    </div>
    <h2 style = "text-align:center">Schedule New Appointment</h2>
    <br>
    <h3 style = "text-align:center">Select Examination:</h3>
    <br>
    <v-simple-table>
      <template v-slot:default>
        <thead>
        <tr>
          <th class="text-left">
            Date and time:
          </th>
          <th class="text-left">
            Duration:
          </th>
          <th class="text-left">
            Schedule:
          </th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="a in allappointments" :key="a">
          <td>{{a.dateAndTime}}</td>
          <td>{{a.duration}}</td>
          <button style="color: darkblue" v-on:click = "chooseAppointmentDerm(a)">Schedule</button>
        </tr>
        </tbody>
      </template>
    </v-simple-table>
    <br>
    <br>
    <h3 style = "text-align:center" >Schedule New Term:</h3>
    <div id="scheduleNew" >
      <br>
      <div class="row justify-content-sm-center">
        <form style = "align:center" action="/action_page.php">
          <label for="dateandtime">Choose Date and Time:</label>
          <input type="datetime-local" id="dateandtime" name="dateandtime"  v-model="appointment.dateAndTime" required>
        </form>
      </div>
      <div class="row justify-content-sm-center">
        <div class="col-md-4">
          <template>
            <v-form>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="14" >
                  <v-text-field v-model="appointment.duration" label="Enter duration" filled required></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-form>
          </template> <label style="color:red">{{durationError}}</label>
          <template>
            <v-form>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="14" >
                  <v-text-field v-model="appointment.price" label="Enter price" filled required></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-form>
          </template> <label style="color:red">{{priceError}}</label>
          <template>
            <v-form>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="14">
                    <v-text-field v-model="appointment.points" label="Enter points" filled required></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-form>
          </template> <label style="color:red">{{pointsError}}</label>
          <template>
            <div class="text-center">
              <v-btn color="blue" dark v-on:click="scheduleAppointment(appointment)">SCHEDULE</v-btn>
              <v-bottom-sheet v-model="sheet">
                <v-sheet class="text-center" height="200px">
                  <v-btn class="mt-6" text color="red" @click="sheet = !sheet">close</v-btn>
                </v-sheet>
              </v-bottom-sheet>
            </div>
          </template>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ScheduleAppointment",
  data: () => ({
    allappointments: null,
    appointment: {},
    patient: null,
    dateError: null,
    durationError: null,
    priceError: null,
    pointsError: null
  }),
  mounted(){
    {
      this.axios
          .get('http://localhost:8090/application/appointments/allappointments')
          .then((resp) => (this.allappointments = resp.data))
    }
  },
  methods: {
    chooseAppointmentDerm: function(appointment){

      this.axios
          .post('http://localhost:8090/application/appointment/scheduledAppointment', appointment)
    },

    scheduleAppointment(appointment){

      if(appointment.dateAndTime == "" || appointment.dateAndTime == null){
        this.dateError = "This field must be filled";
      }

      if(appointment.duration == "" || appointment.duration == null){
        this.durationError = "This field must be filled";
      }
      if(appointment.price == "" || appointment.price == null){
        this.priceError = "This field must be filled";
      }
      if(appointment.points == "" || appointment.points == null){
        this.pointsError = "This field must be filled";
      }

      if(appointment.dateAndTime != "" && appointment.dateAndTime != undefined && appointment.dateAndTime != null
          && appointment.duration != "" && appointment.duration != undefined && appointment.duration != null
          && appointment.price != "" && appointment.price != undefined && appointment.price != null
          && appointment.points != "" && appointment.points != undefined && appointment.points != null)
      {
        this.axios
            .post("http://localhost:8090/application/appointments/scheduleAppointment", appointment)
            .then((resp) => (this.appointment = resp.data))
      }
    }

  }
}
</script>

<style scoped>
#scheduleNew{
  margin-left: 480px;
}
</style>
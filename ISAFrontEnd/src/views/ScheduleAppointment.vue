<template>
  <div>
    <div style = "background-color: #E0E8F0;; overflow: hidden;">
    </div>
    <h2 style = "text-align:center">Schedule New Appointment</h2>
    <br>
    <h3 style = "text-align:center">Select Examination:</h3>
    <br>
    <table style = "width: 100%; border-bottom: 1px solid #ddd;">
      <tr style = "border-bottom: 1px solid #ddd;">
        <td style = "border-bottom: 1px solid #ddd;">DATE AND TIME:</td>
        <td style = "border-bottom: 1px solid #ddd;">DATE AND TIME:</td>
        <td style = "border-bottom: 1px solid #ddd;">DURATION (min):</td>
      </tr>
      <tr style = "border-bottom: 1px solid #ddd;" v-for="a in allappointments" :key="a">
        <td style = "border-bottom: 1px solid #ddd;" >{{a.dateAndTime}}</td>
        <td style = "border-bottom: 1px solid #ddd;">{{a.duration}}</td>
        <button v-on:click = "chooseAppointmentDerm">Schedule</button>
      </tr>
    </table>
    <br>
    <h3 style = "text-align:center">Schedule New Term:</h3>
    <br>
    <div class = "modal-body " >
      <div class="container" >
        <div class="row justify-content-sm-center">
          <form style = "text-align:center" action="/action_page.php">
            <label for="dateandtime">Choose Date and Time:</label>
            <input type="datetime-local" id="dateandtime" name="dateandtime"  v-model="appointment.dateAndTime" required>
          </form>
        </div>
      </div>
      <div class="row justify-content-sm-center">
        <div class="col-md-4">
          <input class = "form-control" type = "text" placeholder = "Enter Duration" v-model="appointment.duration" required>
          <label style="color:red">{{durationError}}</label>
        </div>
      </div>
      <div class="row justify-content-sm-center">
        <div class="col-md-4">
          <input class = "form-control" type = "text" placeholder = "Enter Price" v-model="appointment.price" required>
          <label style="color:red">{{priceError}}</label>
        </div>
      </div>
      <div class="row justify-content-sm-center">
        <div class="col-md-4">
          <input class = "form-control" type = "text" placeholder = "Enter Points" v-model="appointment.points" required>
          <label style="color:red">{{pointsError}}</label>
        </div>
      </div>
      <div class="row justify-content-sm-center">
        <div class="row justify-content-sm-center" style="margin-top: 10px;">
          <div class="col-md-4">
            <button type = "button" class="btn btn-primary" v-on:click="scheduleAppointment(appointment)">Schedule</button>
          </div>
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
    this.axios
        .get('http://localhost:8090/application/appointments/allappointments')
        .then((resp) => (this.allappointments = resp.data));
  },
  methods: {
    chooseAppointmentDerm(){
      this.axios
          .post('http://localhost:8090/application/application/scheduledAppointment', this.appointmet, this.patient)
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
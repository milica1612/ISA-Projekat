<template>
 <div>
   <v-sheet
       tile
       height="54"
       class="d-flex"
   >
     <v-btn
         icon
         class="ma-2"
         @click="$refs.calendar.prev()"
     >
       <v-icon>mdi-chevron-left</v-icon>
     </v-btn>
     <v-select
         v-model="type"
         :items="types"
         dense
         outlined
         hide-details
         class="ma-2"
         label="type"
     ></v-select>
     <v-spacer></v-spacer>
     <v-btn
         icon
         class="ma-2"
         @click="$refs.calendar.next()"
     >
       <v-icon>mdi-chevron-right</v-icon>
     </v-btn>
   </v-sheet>
   <v-sheet height="600">
     <v-calendar
         :options="events"
         ref="calendar"
         v-model="value"
         :weekdays="weekday"
         :type="type"
         :events="events"
         :event-overlap-mode="mode"
         :event-overlap-threshold="30"
         :event-color="getEventColor"
         @change="getEvents">
   </v-calendar>
   </v-sheet>
 </div>
</template>

<script>
export default {
  name: "WorkSchedulePharmacist",
  data: function() {
    return {
      pharmacist: null,
      year : null,
      month : null,
      day : null,
      hours : null,
      minutes : null,
      minutesEnd: null,
      startTime: null,
      endTime: null,
      consultations: [],
      type: 'month',
      types: ['month', 'week', 'day'],
      mode: 'stack',
      weekday: [1, 2, 3, 4, 5, 6, 0],
      value: '',
      events: [],
      notYear: false,
      colors: ['blue', 'indigo', 'deep-purple', 'cyan', 'green', 'orange', 'grey darken-1'],
    }
  },
  mounted() {
    if(localStorage.getItem("userType") == "PHARMACIST"){
      this.axios
          .get('http://localhost:8091/users/' + localStorage.getItem("userId"), {
            headers: {
              Authorization: 'Bearer ' + localStorage.getItem("token")
            }
          })
          .then(response => (this.pharmacist = response.data));
    } else{
      window.location.href = "http://localhost:8080/logIn";
    }
  },
  methods: {
    getEvents: function ({start, end}) {
      //const evs ={}
      this.axios
          .get('http://localhost:8091/consultation/allForPharmacist/' + this.pharmacist.userId, {
            headers: {
              Authorization: 'Bearer ' + localStorage.getItem("token")
            }
          })
          .then( response => {
            this.consultations = response.data;
            const events = []
            const min = new Date(`${start.date}T00:00:00`)
            const max = new Date(`${end.date}T23:59:59`)


            for(let i = 0; i <= this.consultations.length; i++){

             /* this.year = new Date(this.consultations[i].dateAndTime).getFullYear()
              this.month = new Date(this.consultations[i].dateAndTime).getUTCMonth() + 1
              this.day = new Date(this.consultations[i].dateAndTime).getDate()
              this.hours = new Date(this.consultations[i].dateAndTime).getHours()
              this.minutes = new Date(this.consultations[i].dateAndTime).getMinutes()
              this.minutesEnd = new Date(this.consultations[i].dateAndTime).getMinutes() + 30
              this.seconds = new Date(this.consultations[i].dateAndTime).getSeconds()

              this.startTime = this.year + "-" + this.month + "-" + this.day +
                  " " + this.hours + ":" + this.minutes

              this.endTime = this.year + "-" + this.month + "-" + this.day +
                  " " + this.hours + ":" + this.minutesEnd
              let s = this.consultations[i].dateAndTime.getMilliseconds()
              let e = this.consultations[i].dateAndTime.getMilliseconds() + 30*60*1000
              this.startTime = new Date(s - (s % 900000))
              this.endTime = new Date(e - (e % 900000))

              const allDay = this.rnd(0, 3) === 0
              let ev ={
                name: "Consultation",
                start: this.startTime,
                end: this.endTime,
                color: this.colors[this.rnd(0, this.colors.length - 1)],
                timed: !allDay,
              }
              evs.push(ev);
            }
              this.events = evs;*/

              const allDay = this.rnd(0, 3) === 0
              const firstTimestamp = this.rnd(min.getTime(), max.getTime())
              const first = new Date(firstTimestamp - (firstTimestamp % 900000))
              const secondTimestamp = this.rnd(2, allDay ? 288 : 8) * 900000
              const second = new Date(first.getTime() + secondTimestamp)
              events.push({
                name: this.names[this.rnd(0, this.names.length - 1)],
                start: first,
                end: second,
                color: this.colors[this.rnd(0, this.colors.length - 1)],
                timed: !allDay,
              })
            }
            this.events = events
          });
    },
    getEventColor: function(event) {
      return event.color
    },
    rnd (a, b) {
      return Math.floor((b - a + 1) * Math.random()) + a
    },
  },
}
</script>

<style>

</style>
<template>
  <div id = "homePage">
    <div class = "container">
    <h2>{{this.pharmacyName}}</h2>
    <h2>Consultation</h2>
    <h3>{{"Date: " + this.date}}</h3>
    <h3>{{"Time: " + this.time}}</h3>
      <br>
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th>
              First Name
            </th>
            <th>
              Last Name
            </th>
            <th :class="sortedClass('rating')"
                @click="sortBy('rating')">
              Rating
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="d in sortedItems"
              :key="d"
          >
            <td>{{ d.firstName }}</td>
            <td>{{ d.lastName }}</td>
            <td>{{d.rating}}</td>
            <td>
              <v-btn
                  color="secondary"
                  elevation="3"
                  x-small
                  v-on:click = "scheduleConsultation(d)"
              >Schedule Consultation</v-btn>
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
  name: "ScheduleConsultationInPharmacy",
  data: function () {
    return {
      pharmacyName: localStorage.getItem("pharmacyName"),
      date: localStorage.getItem("date"),
      time: localStorage.getItem("time"),
      sort: {
        key: '',
        isAsc: false
      },
      requestBody:{
        pharmacyId: localStorage.getItem("pharmacyId"),
        date: this.date,
        time: this.time
      },
      pharmacists: []
    }
  },
  mounted() {
    this.axios
        .put('http://localhost:8091/workSchedule', this.requestBody,{
          headers: {
            Authorization: 'Bearer ' + localStorage.getItem("token")
          }
        })
        .then(response => (this.pharmacists = response.data));
  },
  methods:{
    sortedClass (key) {
      return this.sort.key === key ? `sorted ${this.sort.isAsc ? 'asc' : 'desc' }` : '';

    },
    sortBy (key) {
      this.sort.isAsc = this.sort.key === key ? !this.sort.isAsc : false;
      this.sort.key = key;
    },
    computed:{
      sortedItems () {
        const list = this.pharmacists.slice();  // ソート時でdataの順序を書き換えないため
        if (this.sort.key !="") {
          list.sort((a, b) => {
            a = a[this.sort.key]
            b = b[this.sort.key]

            return (a === b ? 0 : a > b ? 1 : -1) * (this.sort.isAsc ? 1 : -1)
          });
        }

        return list;
      }
    }
  }
}
</script>

<style scoped>

</style>
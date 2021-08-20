<template>
  <div id = "homePage">
    <div class = "container">
      <h3>Upcoming examinations</h3>
      <br>
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th>
              Date and Time
            </th>
            <th>
              Duration
            </th>
            <th>
              Dermatologist
            </th>
            <th :class="sortedClass('rating')"
                @click="sortBy('rating')">
              Dermatologist Rating
            </th>
            <th :class="sortedClass('price')"
                @click="sortBy('price')">
              Price
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="c in sortedItems"
              :key="c"
          >
            <td>{{c.dateAndTime}}</td>
            <td>{{ c.duration + " minutes"}}</td>
            <td>{{c.dermatologist.firstName + " " + c.dermatologist.lastName}}</td>
            <td>{{c.dermatologist.rating}}</td>
            <td>{{c.price + " rsd"}}</td>
            <td>
              <v-btn
                  color="secondary"
                  elevation="3"
                  x-small
                  v-on:click = "cancelExamination(c)"
              >Cancel examination</v-btn>
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
  name: "UpcomingVisits",
  data: function () {
    return {
      token: localStorage.getItem("token"),
      sort: {
        key: '',
        isAsc: false
      },
      examinations: []
    }
  },
  mounted() {
    {
      this.axios
          .get('http://localhost:8091/examination/getByPatientId/' + localStorage.getItem("userId"), {
            headers: {
              Authorization: 'Bearer ' + localStorage.getItem("token")
            }
          })
          .then(response => (this.examinations = response.data));

    }
  },
  methods: {
    sortedClass(key) {
      return this.sort.key === key ? `sorted ${this.sort.isAsc ? 'asc' : 'desc'}` : '';

    },
    sortBy(key) {
      this.sort.isAsc = this.sort.key === key ? !this.sort.isAsc : false;
      this.sort.key = key;
    },
  },
  computed:{
    sortedItems () {
      const list = this.examinations.slice();  // ソート時でdataの順序を書き換えないため
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
</script>

<style scoped>
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
</style>
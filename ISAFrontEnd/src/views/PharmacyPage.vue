<template>
<div>
  <h2>{{this.pharmacyName}}</h2>
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
        <th>
          Price
        </th>
      </tr>
      </thead>
      <tbody>
      <tr
          v-for="c in consultations"
          :key="c"
      >
        <td>{{c.dateAndTime}}</td>
        <td>{{ c.duration}}</td>
        <td>{{c.dermatologist.firstName}}</td>
        <td>{{c.price}}</td>
        <td>
          <v-btn
              color="secondary"
              elevation="3"
              x-small
          >Schedule</v-btn>
        </td>
      </tr>
      </tbody>
    </template>
  </v-simple-table>
</div>
</template>

<script>
export default {
  name: "PharmacyPage",
  data: function () {
    return {
      pharmacyId : {},
      pharmacyName : localStorage.getItem("pharmacyName"),
      consultations : [],
      sort: {
        key: '',
        isAsc: false
      }
      }
    },
mounted() {
  {
    this.pharmacyId = localStorage.getItem("pharmacy"),
    this.pharmacyName = localStorage.getItem("pharmacyName"),
        this.pharmacyName = localStorage.getItem("pharmacyName"),
        this.axios
            .get('http://localhost:8091/appointment/getByPharmacy/' + this.pharmacyId, {
              headers: {
                Authorization: 'Bearer ' + localStorage.getItem("token")
              }
            })
            .then(response => (this.consultations = response.data));
  }
},
  methods: {
    sortedClass (key) {
      return this.sort.key === key ? `sorted ${this.sort.isAsc ? 'asc' : 'desc' }` : '';

    },
    sortBy (key) {
      this.sort.isAsc = this.sort.key === key ? !this.sort.isAsc : false;
      this.sort.key = key;
    },
  },
  computed: {
    sortedItems () {
      const list = this.consultations.slice();  // ソート時でdataの順序を書き換えないため
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

</style>
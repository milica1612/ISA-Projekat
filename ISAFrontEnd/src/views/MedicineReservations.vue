<template>
  <div id = "homePage">
    <div class = "container">
      <h3 style = "margin:0 auto; text-align:center;">My Medicine Reservations</h3>
      <br>
      <v-simple-table>
        <template v-slot:default>
          <thead>
          <tr>
            <th>
              Medicine
            </th>
            <th>
              Pharmacy
            </th>
            <th>
              Date
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="r in reservations"
              :key="r"
          >
            <td>{{ r.medicineItem.medicine.name}}</td>
            <td>{{ r.pharmacy.name}}</td>
            <td>{{ r.date }}</td>
            <td>
              <v-btn
                  color="secondary"
                  elevation="3"
                  x-small>
                Cancel</v-btn>
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
  name: "MedicineReservations",
  data: function () {
    return {
      reservations: []
    }
  },
  mounted() {
    {
      this.axios
          .get('http://localhost:8091/reservation/getByPatientId/' + localStorage.getItem("userId"),
              {
                headers: {
                  Authorization: 'Bearer ' + localStorage.getItem("token")
                }})
          .then(r => (this.reservations = r.data))
    }
  },
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
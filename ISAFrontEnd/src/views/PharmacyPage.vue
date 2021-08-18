<template>
<div>
  <h2>{{this.pharmacyName}}</h2>
</div>
</template>

<script>
export default {
  name: "PharmacyPage",
  data: function () {
    return {
      pharmacyId : {},
      pharmacyName : localStorage.getItem("pharmacyName"),
      consultations : []
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
}
}

</script>

<style scoped>

</style>
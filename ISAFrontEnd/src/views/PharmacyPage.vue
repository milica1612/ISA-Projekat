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
      pharmacyName : localStorage.getItem("pharmacyName")
      }
    },
mounted() {
  {
    this.pharmacyId = localStorage.getItem("pharmacy"),
    this.pharmacyName = localStorage.getItem("pharmacyName")
  }
}
}

</script>

<style scoped>

</style>
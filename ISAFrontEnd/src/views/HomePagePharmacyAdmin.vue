<template>
    <div id="pharmacyAdminMenu">
      <a class="a_style" href="/pharmacyAdmin">My Profile</a>
      <a class="a_style" href="/myPharmacy">My Pharmacy</a>
      <a class="a_style" href="/searchDermatologist">Search and filter dermatologists</a>
      <a class="a_style" href="/searchPharmacist">Search and filter pharmacists</a>
      <a class="a_style" href="/promotion">Define a promotion</a>
    </div> 
</template>

<script>
export default {
    name: "HomePagePharmacyAdmin"
}
</script>

<style scoped>
#pharmacyAdminMenu {
    background-color: #E0E8F0; 
    overflow: hidden;
    opacity: 0.9;
}
.a_style {
   float: left; 
   color: black; 
   text-align:center; 
   padding: 14px 32px; 
   text-decoration:none; 
   font-size: 17px;
}
</style>

<template>
    <div>
        <h1 id="defineFreeTermWithDermatologistCaption">Define free term for examination with dermatologist who work in {{this.pharmacyName}} pharmacy</h1>
    <v-card>
    </v-card>
    </div>
</template>


<script>
export default{
    name: "DefineFreeTermWithDermatologist",
    data:() => ({
        pharmcayId: localStorage.getItem("pharmacyId"),
        pharmacyName: "",
    }),
    mounted() {
        this.initialize();
    },    
    methods: {
        initialize() {
            this.axios
        .get(
          "http://localhost:8091/pharmacy/" +
           this.pharmcayId,
          {
            headers: {
              Authorization: "Bearer " + localStorage.getItem("token"),
            },
          }
        )
        .then((resp) => {
          console.log(resp.data);
          this.pharmacy = resp.data;
          this.pharmacyName = this.pharmacy.name;
        });
        }
    },
}
</script>


<style scoped>
#defineFreeTermWithDermatologistCaption {
  margin-top: 2%;
  margin-bottom: 2%;
  color: rgb(2, 2, 117);
  text-align: center;
  font-weight: bold;
}
</style>
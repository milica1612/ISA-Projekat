<template>
    <div>
        <h1 id="pharmacyOrdersCaption">All pharmacy orders</h1>
    </div>
</template>


<script>
export default {
    name: "PharmacyOrders",
    data: () => ({

    }),
    mounted() {
        this.initialize();
    },
    methods: {
        initialize() {


        }
    }
}
</script>


<style scoped>
#pharmacyOrdersCaption {
    margin-top: 2%;
    margin-bottom: 2%;
    color: rgb(2, 2, 117);
    text-align: center;
    font-weight: bold;
}
</style>

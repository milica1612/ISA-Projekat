<template>
  <div>
    <h1 id="searchDermatologistsCaption">Search and filter dermatologists</h1>
    <div class="pt-1">
      <v-card
        width="40%"
        class="mx-auto mt-3"
        v-bind:style="{ opacity: opacity }"
      >
        <v-card-text>
          <v-form class="mx-auto mt-5 mb-5 mr-10 ml-10">
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="First name"
                v-model="searchFirstName"
                color="blue"
                type="text"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Last name"
                v-model="searchLastName"
                color="blue"
                type="text"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Enter min for raiting"
                v-model="minRaiting"
                color="blue"
                type="number"
                min="0"
                max="10"
              />
            </v-row>
            <v-row>
              <v-text-field
                class="ml-10 mr-10"
                label="Enter max for raiting"
                v-model="maxRaiting"
                color="blue"
                type="number"
                min="0"
                max="10"
              />
            </v-row>
          </v-form>
        </v-card-text>

        <v-card-actions class="justify-center">
          <v-btn
            v-on:click="searchDermatologist"
            color="info"
            width="260px"
            class="mt-2 mr-10 p-5 mb-5"
            x-medium
            >Search dermatologist</v-btn
          >
          <v-btn
            v-on:click="cancelSearch"
            color="info"
            width="260px"
            class="mt-2 ml-10 p-5 mb-5"
            x-medium
            >Cancel search</v-btn
          >
        </v-card-actions>

      </v-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchDermatologist",
  data: () => ({
    opacity: 0.9,
    searchFirstName: "",
    searchLastName: "",
    minRaiting: "",
    maxRaiting: "",
    dermatologist: null,
    dermatologistList: null,
    showList: false,
  }),
  computed: {},
  methods: {},
};
</script>

<style scoped>
#searchDermatologistsCaption {
  margin-left: 38%;
  margin-top: 2%;
  margin-bottom: 2%;
  color: darkblue;
}
</style>
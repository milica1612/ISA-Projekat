<template>
  <div>
    <table >
      <tr>
        <td><input type="text" v-model = "datas" placeholder="Enter name"></td>
        <td><button v-on:click = "searchPatient" style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">Search</button></td>
      </tr>
    </table>
    <v-simple-table>
      <template v-slot:default>
        <thead>
        <tr>
          <th class="text-left">
            Name
          </th>
          <th class="text-left">
            Rating
          </th>
          <th class="text-left">
            Address
          </th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="p in allpatients" :key="p">
          <td>{{ p.firstName }}</td>
          <td>{{ p.lastName }}</td>
          <li class="nav-item">
            <a class="nav-link" href="/">See profile</a>
          </li>
           </tr>
        </tbody>
      </template>
    </v-simple-table>
  </div>
</template>

<script>
export default {
  name: "UsersList",
  data: () => ({
      allpatients: null,
      mode: 'BROWSE',
      backup: [],
      datas: null,
      user: {}
  }),
  mounted() {
    {
      this.axios
          .get("http://localhost:8090/application/users/allpatients")
          .then((resp) => (this.allpatients = resp.data))
    }
  },
  methods: {
    searchPatient() {
      this.$http
          .post("http://localhost:8090/application/users/searchUser", this.datas)
          .then((resp) => (this.allpatients = resp.data))
    }
  }
};
</script>
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
            FirstName
          </th>
          <th class="text-left">
            LastName
          </th>
          <th class="text-left">
            SeeProfile
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

      if(localStorage.getItem("userType") == "DERMATOLOGIST"
        || localStorage.getItem("userType") == "PHARMACIST") {

        this.axios
            .get("http://localhost:8091/users/allpatients")
            .then((resp) => this.allpatients = resp.data)
        }
      else {
          window.location.href = "http://localhost:8080/logIn";
        }
  },
  methods: {
    searchPatient() {
      this.$http
          .post("http://localhost:8091/users/searchUser", this.datas)
          .then((resp) => (this.allpatients = resp.data))
    }
  }
};
</script>
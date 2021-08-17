<template>
  <div >
    <p class="center">
        {{ message }}
    </p>
  </div>
</template>

<script>
export default {
  name: "ConfirmRegistration",
  data: () => ({
    confirmationToken:"",
    message: ""
  }),
  mounted() {
    this.init();
  },
  methods: {
    init() {
      var href = window.location.href;
      var hPaths = [];
      hPaths=  href.split('/');
      this.confirmationToken = hPaths[4];
      alert(this.confirmationToken);
      
      this.$http
        .put("https://localhost:8091/auth/confirm_account/" + this.confirmationToken, {})
        .then((res) => {
          console.log(res);
          this.message = "You have successfully verified your account! \n You can log in on system!"
        })
        .catch((err) => {
          console.log(err);
          this.message = "Your token is invalid or expiried! Please, contact system admin!"
        });
    },
    redirectToLogIn() {
      window.location.href = "https://localhost:8080/login";
    },
  },
};
</script>

<style scoped>
.helloMessage {
  font-weight: bolder;
  font-size: 20px;
  height: 50px;
}

.center {
  margin-top: 20%;
  padding: 10px;
  text-align: center;
}

#certificateCard {
  margin-top: 5%;
  width: 70%;
  height: 760px;
  overflow-y: scroll;
}
</style>
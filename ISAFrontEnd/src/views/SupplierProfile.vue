<template>
  <v-card style="margin-top: 3%" width="30%" class="mx-auto">
    <v-card-title class="justify-center">
      <h1 class="display-1 mt-20">Edit Profile</h1>
    </v-card-title>
    <v-card-text>
      <v-form class="mx-auto ml-20 mr-20">
        <v-text-field
          label="First Name"
          v-model="this.user.firstName"
          :rules="[() => !!firstName || 'This field is required']"
          prepend-icon="mdi-account-circle"
          filled
        />
        <v-text-field
          label="Last Name"
          v-model="this.user.lastName"
          prepend-icon="mdi-account-circle"
          filled
        />
         <v-text-field
          label="Street Name"
          v-model="this.user.address.street"
          :rules="[() => !!street || 'This field is required']"
          prepend-icon="mdi-account-circle"
          filled
        />
         <v-text-field
          label="Street Number"
          v-model="this.user.address.streetNumber"
          :rules="[() => !!streetNumber || 'This field is required']"
          prepend-icon="mdi-account-circle"
          filled
        />
        <v-text-field
          label="City"
          v-model="this.user.address.city"
          :rules="[() => !!city || 'This field is required']"
          prepend-icon="mdi-account-circle"
          filled
        />
        <v-text-field
          label="Country"
          v-model="this.user.address.country"
          :rules="[() => !!city || 'This field is required']"
          prepend-icon="mdi-account-circle"
          filled
        />
        <v-text-field
          label="Phone Number"
          v-model="this.user.address.phoneNumber"
          :rules="[() => !!phoneNumber || 'This field is required']"
          prepend-icon="mdi-account-circle"
          filled
        />
        <v-text-field
          :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
          :type="showPassword ? 'text' : 'password'"
          label="Password"
          v-model="this.user.password"
          :rules="[() => !!password || 'This field is required']"
          prepend-icon="mdi-lock"
          @click:append="showPassword = !showPassword"
          filled
        />
      </v-form>
    </v-card-text>
    <div></div>
    <v-card-actions>
      <v-btn
        class="mx-auto mb-5; color:white"
        color="accent"
        elevation="2"
        x-large
        raised
        v-on:click="saveSupplier"
        >Edit</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
  export default {
    name: "SupplierProfile",
    data: function() {  
      return { 
          user: [],
          mode: "BROWSE"
        }
    },
    mounted() { 
        this.axios
            .get('http://localhost:8090/application/users/3')
            .then(r => (this.user = r.data)) 
    },
    methods: {
		editSupplier : function () {
			this.mode = "EDIT";			
		},
		saveSupplier : function () {
			this.mode = "BROWSE";
			this.axios
			.post("http://localhost:8090/application/users/update", this.user);
		}
	}
  }
</script>

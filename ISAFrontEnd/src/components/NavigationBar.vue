<template>
    <span>
        <v-navigation-drawer app temporary v-model="drawer" class="light-blue darken-2" dark disable-resize-watcher>
            <v-list>
                <template v-for="(item, index) in items">
                    <v-list-tile :key="index" >
                        <v-list-tile-content>
                            <v-card height="35px" class="ma-1 text-sm-button text-center">
                                <router-link class="router" :to="item.path">{{item.title}}</router-link>
                            </v-card>
                        </v-list-tile-content>
                    </v-list-tile>
                    <v-divider :key="`divider-${index}`"></v-divider>
                </template>
            </v-list>
        </v-navigation-drawer>
        <v-toolbar app dark class="light-blue darken-2">
            <v-app-bar-nav-icon class="hidden-md-and-up" @click="drawer = !drawer"></v-app-bar-nav-icon>
            <v-spacer class="hidden-md-and-up"></v-spacer>
            <v-btn flat class="hidden-sm-and-down ma-1" @click="drawer = !drawer">Menu</v-btn>
            <v-toolbar-title class="appTitlePos"><router-link class="appTitle" to="/browsePharmacies">{{appTitle}}</router-link></v-toolbar-title>
            <v-spacer class="hidden-sm-and-down"></v-spacer>
            <div v-if="!isLogged">
                <v-btn flat class="hidden-sm-and-down">
                  <router-link class="router" to="/logIn">Log in</router-link>
                </v-btn>
            </div>
            <div v-else>
                <v-btn flat class="hidden-sm-and-down" v-on:click="logOff">Log off</v-btn>
            </div>
            <div v-if="!isLogged">
                <v-btn flat class="hidden-sm-and-down ma-1">
                  <router-link class="router" to="/register">Register</router-link>
                </v-btn>
            </div>
        </v-toolbar>
    </span>
</template>

<script>
export default {
    name: 'NavigationBar',
    computed:{
        isLogged: function(){
            var token = localStorage.getItem("token");
            return token !== "";
        }
    },
    data() {
        return {
            appTitle: 'Pharmacy system',
            drawer: false,
            isUserLogged:false,
            userType : null,
            items: [
                { title: 'Home', path: '/' }
            ]
        }
    },
    mounted() {
        this.init();
    },
    methods:{
    init(){
        this.userType =localStorage.getItem('userType');
        console.log(this.userType);
        if (this.userType === "PATIENT"){   // USER-TYPE
            this.items = [
                { title: 'My profile', path: '/patient'},
                { title: 'Browse Pharmacies', path: '/browsePharmacies' },
                { title: 'Browse Medicine', path: '/browseMedicine' }
            ]
        } else if (this.userType === "SUPPLIER") {   //  USER-TYPE
            this.items = [
                { title: 'Offers', path: '/offers' },
                { title: 'My Profile', path: '/supplier' }
            ]
        } else if (this.userType == "SYS_ADMINISTRATOR") {   //  USER-TYPE
            this.items = [
                { title: 'My Profile', path: '/systemAdminProfile' },
                { title: 'Add System Admin', path: '/createSystemAdmin' },
                { title: 'Add Pharmacy Admin', path: '/createPhAdmin' },
                { title: 'Add Dermatologist', path: '/createDermatologist' },
                { title: 'Add Supplier', path: '/createSupplier' },
                { title: 'Add Pharmacy', path: '/createPharmacy' },
                { title: 'Medicines', path: '/' },
                { title: 'Complaints', path: '/' },
                { title: 'Loyalty Program', path: '/' }
            ]
        } else {   // NOT YET REGISTERED
            this.items = [
                { title: 'Browse Pharmacies', path: '/browsePharmacies' },
                { title: 'Browse Medicine', path: '/browseMedicine' }
            ]
        }
    },
      logOff() {
        localStorage.setItem("token", "");
        localStorage.setItem("userType", null);
        window.location.href = "http://localhost:8080/login";
      }
    }
}
</script>

<style scoped>
.appTitlePos {
    margin-left: 40%;
}

.appTitle {
    font-weight: bolder;
    font-size: 1.5em;
    height: 50px;
    text-decoration: none;
    color: white;
}

.router {
    text-decoration: none;
    color: white;
}
</style>
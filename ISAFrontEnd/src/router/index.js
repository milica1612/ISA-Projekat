import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/logIn',
        name: 'LogIn',
        component: () =>
            import ('../views/LogIn.vue')
    },
    {
        path: '/register',
        name: 'Register',
        component: () =>
            import ('../views/Register.vue')
    },
    {
        path: '/browsePharmacies',
        name: 'BrowsePharmacies',
        component: () =>
            import ('../views/BrowsePharmacies.vue')
    },
    {
        path: '/usersList',
        name: 'UsersList',
        component: () =>
            import ('../views/UsersList.vue')
    },
    {
        path: '/homePageDermatologist',
        name: 'HomePageDermatologist',
        component: () =>
            import ('../views/HomePageDermatologist.vue')
    },
    {
        path: '/homePagePharmacist',
        name: 'HomePagePharmacist',
        component: () =>
            import ('../views/HomePagePharmacist.vue')
    },
    {
        path: '/patient',
        name: 'Patient',
        component: () =>
            import ('../views/Patient.vue')
    },
    {
        path: '/offers',
        name: 'Offers',
        component: () =>
            import ('../views/Offers.vue')
    },
    {
        path: '/scheduleAppointment',
        name: 'ScheduleAppointment',
        component: () =>
            import ('../views/ScheduleAppointment.vue')
    },
    {
        path: '/editPatientInfo',
        name: 'EditPatientInfo',
        component: () =>
            import ('../views/EditPatientInfo.vue')
    },
    {
        path: '/supplier',
        name: 'Supplier',
        component: () =>
            import ('../views/Supplier.vue')
    },
    {
        path: '/editSupplierProfile',
        name: 'EditSupplierProfile',
        component: () =>
            import ('../views/EditSupplierProfile.vue')
    },
    {
        path: '/browseMedicine',
        name: 'BrowseMedicine',
        component: () =>
            import ('../views/BrowseMedicine.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
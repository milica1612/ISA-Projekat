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
        path: '/confirmRegistration/:id',
        name: 'ConfirmRegistration',
        component: () => import('../views/ConfirmRegistration.vue')
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
        path: '/pharmacyPage',
        name: 'PharmacyPage',
        component: () =>
            import ('../views/PharmacyPage.vue')
    },
    {
        path: '/homePagePatient',
        name: 'HomePagePatient',
        component: () =>
            import ('../views/HomePagePatient.vue')
    },
    {
        path: '/upcomingVisits',
        name: 'UpcomingVisits',
        component: () =>
            import ('../views/UpcomingVisits.vue')
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
        path: '/editDermatologistInfo',
        name: 'EditDermatologistInfo',
        component: () =>
            import ('../views/EditDermatologistInfo.vue')
    },
    {
        path: '/editPharmacistInfo',
        name: 'EditPharmacistInfo',
        component: () =>
            import ('../views/EditPharmacistInfo.vue')
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
    },
    {
        path: '/dermatologistProfile',
        name: 'DermatologistProfile',
        component: () =>
            import ('../views/DermatologistProfile.vue')
    },
    {
        path: '/pharmacistProfile',
        name: 'PharmacistProfile',
        component: () =>
            import ('../views/PharmacistProfile.vue')
    },
    {
        path: '/changePasswordFirstLogin',
        name: 'ChangePasswordFirstLogin',
        component: () =>
            import ('../views/ChangePasswordFirstLogin.vue')
    },
    {
        path: '/searchDermatologist',
        name: 'SearchDermatologist',
        component: () => 
            import ('../views/SearchDermatologist.vue')
    },
    {
        path: '/searchPharmacist',
        name: 'SearchPharmacist',
        component: () =>
            import ('../views/SearchPharmacist.vue')
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
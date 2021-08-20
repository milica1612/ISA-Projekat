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
        path: '/homePagePatient',
        name: 'HomePagePatient',
        component: () =>
            import ('../views/HomePagePatient.vue')
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
        path: '/reportForExamination',
        name: 'ReportForExamination',
        component: () =>
            import ('../views/ReportForExamination.vue')
    },
    {
        path: '/reportForConsultation',
        name: 'ReportForConsultation',
        component: () =>
            import ('../views/ReportForConsultation.vue')
    },
    {
        path: '/dermatologistPatientProfile',
        name: 'DermatologistPatientProfile',
        component: () =>
            import ('../views/DermatologistPatientProfile.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
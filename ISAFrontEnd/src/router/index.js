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
        path: '/homePagePharmacyAdmin',
        name: 'HomePagePharmacyAdmin',
        component: () =>
            import('../views/HomePagePharmacyAdmin.vue')
    },
    {
        path: '/pharmacyAdmin',
        name: 'PharmacyAdmin',
        component: () =>
            import('../views/PharmacyAdmin.vue')
    },
    {
        path: '/upcomingVisits',
        name: 'UpcomingVisits',
        component: () =>
            import ('../views/UpcomingVisits.vue')
    },
    {
        path: '/scheduleConsultation',
        name: 'ScheduleConsultation',
        component: () =>
            import ('../views/ScheduleConsultation.vue')
    },
    {
        path: '/scheduleConsultationInPharmacy',
        name: 'ScheduleConsultationInPharmacy',
        component: () =>
            import ('../views/ScheduleConsultationInPharmacy.vue')
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
        path: '/editPharmacyAdminInfo',
        name: 'EditPharmacyAdminInfo',
        component: () =>
            import('../views/EditPharmacyAdminInfo.vue')
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
        path: '/systemAdminProfile',
        name: 'SystemAdminProfile',
        component: () =>
            import ('../views/SystemAdminProfile.vue')
    },
    {
        path: '/createSystemAdmin',
        name: 'CreateSystemAdmin',
        component: () =>
            import ('../views/CreateSystemAdmin.vue')
    },
    {
        path: '/createSupplier',
        name: 'CreateSupplier',
        component: () =>
            import ('../views/CreateSupplier.vue')
    },
    {
        path: '/createPhAdmin',
        name: 'CreatePhAdmin',
        component: () =>
            import ('../views/CreatePhAdmin.vue')
    },
    {
        path: '/createDermatologist',
        name: 'CreateDermatologist',
        component: () =>
            import ('../views/CreateDermatologist.vue')
    },
    {
        path: '/createPharmacy',
        name: 'CreatePharmacy',
        component: () =>
            import ('../views/CreatePharmacy.vue')
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
    },
    {        
        path: '/medicineRegistration',
        name: 'MedicineRegistration',
        component: () =>
            import ('../views/MedicineRegistration.vue')
    },
    {
        path: '/changePharmacyAdminPassword',
        name: 'ChangePharmacyAdminPassword',
        component: () =>
            import ('../views/ChangePharmacyAdminPassword.vue')
    },
    {
        path: '/myPharmacy',
        name: 'MyPharmacy',
        component: () =>
            import('../views/MyPharmacy.vue')   
    },
    {
        path: '/promotion',
        name: 'Promotion',
        component: () =>
            import('../views/Promotion.vue')
    },
    {

        path: '/dispensingMedicinePharmacist',
        name: 'DispensingMedicinePharmacist',
        component: () =>
            import('../views/DispensingMedicinePharmacist.vue')
    },
    {
        path: '/scheduleExaminationDermatologist',
        name: 'ScheduleExaminationDermatologist',
        component: () =>
            import('../views/ScheduleExaminationDermatologist.vue')
    },
    {
        path: '/scheduleConsultationPharmacist',
        name: 'ScheduleConsultationPharmacist',
        component: () =>
            import('../views/ScheduleConsultationPharmacist.vue')
    },
    {
        path: '/requestsVacationPharmacists',
        name: 'RequestsVacationPharmacists',
        component: () =>
            import('../views/RequestsVacationPharmacists.vue')
    },
    {
        path: '/allVacationRequestsPharmacists',
        name: 'AllVacationRequestsPharmacists',
        component: () =>
            import('../views/AllVacationRequestsPharmacists.vue')
    },
    {
        path: '/requestsVacationDermatologists',
        name: 'RequestsVacationDermatologists',
        component: () =>
            import('../views/RequestsVacationDermatologists.vue')
    },
    {
        path: '/allVacationRequestsDermatologists',
        name: 'AllVacationRequestsDermatologists',
        component: () =>
            import('../views/AllVacationRequestsDermatologists.vue')
    },
    {
        path: '/pharmacyOrders',
        name: 'PharmacyOrders',
        component: () =>
            import('../views/PharmacyOrders.vue')
    }, 
    {
        path: '/medicinesInPharmacy',
        name: 'MedicinesInPharmacy',
        component: () =>
            import('../views/MedicinesInPharmacy.vue')
    },
    {
        path: '/makeAnOrder',
        name: 'MakeAnOrder',
        component: () =>
            import('../views/MakeAnOrder.vue')
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
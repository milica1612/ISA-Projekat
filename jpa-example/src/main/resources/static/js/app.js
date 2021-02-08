const employee = {template: '<employee></employee>'}
const sysAdmin = {template: '<sysAdmin></sysAdmin>'}
const register = {template: '<register></register>'}
const logIn = {template: '<logIn></logIn>'}
const supplier = {template: '<supplier></supplier>'}
const addMedicines = {template: '<addMedicines></addMedicines>'}
const patient = {template: '<patient></patient>'}


const router = new VueRouter({
	mode: 'hash',
	routes: [
		{path: '/employee', component: employee},
		{path: '/sysAdmin', component: sysAdmin},
		{path: '/register', component: register},
		{path: '/logIn', component: logIn},
		{path: '/supplier', component: supplier},
		{path: '/addMedicines', component: addMedicines},
		{path: '/patient', component: patient}
	]
});

var app = new Vue({
	router,
	el: '#routerMode'
});
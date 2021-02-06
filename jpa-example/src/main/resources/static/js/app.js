const employee = {template: '<employee></employee>'}
const allpatients = {template: '<allpatients></allpatients>'}

const router = new VueRouter({
	mode: 'hash',
	routes: [
		{path: '/employee', component: employee},
		{path: '/allpatients', component: allpatients}
	]
});

var app = new Vue({
	router,
	el: '#routerMode'
});
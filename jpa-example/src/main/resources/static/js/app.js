const employee = {template: '<employee></employee>'}

const router = new VueRouter({
	mode: 'hash',
	routes: [
		{path: '/employee', component: employee}
	]
});

var app = new Vue({
	router,
	el: '#routerMode'
});
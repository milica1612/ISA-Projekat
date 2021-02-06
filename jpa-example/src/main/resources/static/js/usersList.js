Vue.component("allpatients",{
	data: function () {
		    return {
				allpatients: null,
				mode: 'BROWSE',
				backup: []
			}				
}, 
	template: `
		<div>
			<table style = "margin: 0 auto; border: 1px solid black; width: 100%">
				<tr v-for="p in allpatients">
				<td>{{p.firstName}}</td>
				<td>{{p.lastName}}</td>
				</tr>		
			</table>
		</div>
		`,
	mounted() {
		axios
		.get('users/allpatients')
		.then(response => (this.allpatients = response.data));
	}
});
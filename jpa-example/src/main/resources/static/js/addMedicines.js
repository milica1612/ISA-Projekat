Vue.component("addMedicines", {
	data: function () {
		    return {
		    	medicine: null
		    }
	},
	template: `
	<div id = "medicines">
		<h3>Add new medicine</h3>
		<table>
			<tr>
				<th>Name:</th>
				<th><input type = "text"/></th>
			</tr>
			<tr>
				<th>Medicine Code:</th>
				<th><input type = "text"/></th>
			</tr>
			<tr>
				<th>Type:</th>
				<th><input type = "text"/></th>
			</tr>
		  </table>
	</div>
	`,
	mounted(){
		axios
	}
});
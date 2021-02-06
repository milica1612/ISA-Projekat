Vue.component("supplier", {
	data: function () {
		    return {
		    	supplier: null,
				mode: 'BROWSE',
				backup: []
		    }
	},
	template: `
	<div>
		<table style = "margin: 0 auto;">
		<tr><td><button style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:100%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">See All Offers</button></td>
		<td><button style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:250%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">Create Offer</button></td></tr>
		</table>
		
		<table style = "margin: 0 auto;">
		<tr><h1 style = "text-align: center;">Supplier Profile</h1></tr>
		<tr><th>First Name:</th><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.firstName"  v-bind:disabled = "mode != 'EDIT'"/></td></tr>
		<tr><th>Last Name:</th><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.lastName"  v-bind:disabled = "mode != 'EDIT'"/></td><tr>
		<tr><th>Phone Number:</th><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.phoneNumber"  v-bind:disabled = "mode != 'EDIT'"/></td><tr>
		<tr><th>Street:</td><th><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.address.street"  v-bind:disabled = "mode != 'EDIT'"/></td></tr>
		<tr><th>Street Number:</th><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.address.streetNumber"  v-bind:disabled = "mode != 'EDIT'"/></td></tr>
		<tr><th>City:</th><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.address.city"  v-bind:disabled = "mode != 'EDIT'"/></td></tr>
		<tr><th>Country:</th><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.address.country"  v-bind:disabled = "mode != 'EDIT'"/></td></tr>
		<tr><th>E-mail:</th><td>{{supplier.email}}</td><tr>
		<tr><th>Password:</th><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.password" v-bind:disabled = "mode != 'EDIT'"/></td><tr>
		<tr>
			<td><button v-on:click = "editSupplier" style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:100%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">Edit</button></td>
			<td><button v-on:click = "saveSupplier" style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:111%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'EDIT'">Save</button></td>
		</tr>	
	</table>
</div>
`,
	mounted(){
		axios
		.get('users/1')
		.then(response => (this.supplier = response.data));
	},
	methods: {
		editSupplier : function () {
			this.mode = "EDIT";
		},
		saveSupplier : function () {
			this.mode = "BROWSE";
			axios
			.post("/application/users/update", this.supplier);
		}
	}
});
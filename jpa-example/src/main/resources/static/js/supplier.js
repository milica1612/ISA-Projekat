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
	<div style = "margin-top: 10px;">
		<table>
		<tr><td><a href = "#/seeOffers" style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:150%; opacity: 0.9;" >Show All Offers</a></td>
		<td><a href = "#/showOrders" style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:300%; opacity: 0.9;" >Show New Orders</a></td>
		</tr>
		</table>
		
		<table style = "margin: 0 auto;">
		<tr><h1 style = "text-align: center;">Personal Data</h1></tr>
		<tr><td>First Name:</td><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.firstName"  v-bind:disabled = "mode != 'EDIT'"/></td></tr>
		<tr><td>Last Name:</td><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.lastName"  v-bind:disabled = "mode != 'EDIT'"/></td><tr>
		<tr><td>Phone Number:</td><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.phoneNumber"  v-bind:disabled = "mode != 'EDIT'"/></td><tr>
		<tr><td>Street:</td><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.address.street"  v-bind:disabled = "mode != 'EDIT'"/></td></tr>
		<tr><td>Street Number:</td><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.address.streetNumber"  v-bind:disabled = "mode != 'EDIT'"/></td></tr>
		<tr><td>City:</td><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.address.city"  v-bind:disabled = "mode != 'EDIT'"/></td></tr>
		<tr><td>Country:</td><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.address.country"  v-bind:disabled = "mode != 'EDIT'"/></td></tr>
		<tr><td>E-mail:</td><td>{{supplier.email}}</td><tr>
		<tr><td>Password:</td><td><input type = "text" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;" v-model= "supplier.password" v-bind:disabled = "mode != 'EDIT'"/></td><tr>
		<tr>
			<td><button v-on:click = "editSupplier" style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:100%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">Edit</button></td>
			<td><button v-on:click = "saveSupplier" style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:111%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'EDIT'">Save</button></td>
		</tr>	
	</table>
</div>
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
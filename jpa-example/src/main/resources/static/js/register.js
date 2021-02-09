Vue.component("register", {
	data: function () {
		    return {
		    	supplier: null,
				mode: 'BROWSE'
		    }
	},
	template: `
	<div>
		  <div>
		    <h1 style = "margin:0 auto; text-align:center; background-color:#f1f1f1;">CREATE {{supplier.userType}} ACCOUNT</h1>
		    <br>
		<table style = "margin:0 auto;">
		    <tr>
		    <th> <label style = "text-align:left;">Email</label></th>
		    <th> <input type="text" v-model = "supplier.email" placeholder="Enter Email"  style = "width: 355%; padding: 10px;border: none; background: #f1f1f1;" required></th>
		    </tr>
		    <tr>
		    <th><label><b>First Name</b></label></th>
		    <th> <input type="text" v-model = "supplier.firstName" placeholder="Enter First Name"  style = "width: 355%; padding: 10px;border: none; background: #f1f1f1;" required></th>
		    </tr>
		    <tr>
		    <th><label>Last Name</label></th>
		    <th><input type="text" v-model = "supplier.lastName" placeholder="Enter Last Name"  style = "width: 355%; padding: 10px; border: none; background: #f1f1f1;" required></th>
		    </tr>
		    <tr>
		    <th><label><b>Address</b></label></th>
		    <td><input type="text" v-model = "supplier.address.street" placeholder="Enter Street" style = "width: 70%; padding: 10px;  border: none; background: #f1f1f1;" required></td>
		    <td><input type="text" v-model = "supplier.address.streetNumber" placeholder="Enter Street Number" style = "width: 70%; padding: 10px;  border: none; background: #f1f1f1;" required></td>
		    <td><input type="text" v-model = "supplier.address.city" placeholder="Enter City" style = "width: 70%; padding: 10px;  border: none; background: #f1f1f1;" required></td>
		    <td><input type="text" v-model = "supplier.address.country" placeholder="Enter Country" style = "width: 48%; padding: 10px;  border: none; background: #f1f1f1;" required></td>
		    </tr>
		    <tr>
		    <th><label><b>Phone Number</b></label></th>
		    <th><input type="phoneNumber" v-model = "supplier.phoneNumber"  placeholder="Enter Phone Number"  style = "width: 355%; padding: 10px; border: none; background: #f1f1f1;" required></th>
		    </tr>
		    <tr>
		    <th><label><b>Password</b></label></th>
		    <th><input type="password" v-model = "supplier.password" placeholder="Enter Password"  style = "width: 355%; padding: 10px; border: none; background: #f1f1f1;" required></th>
		    </tr>
		    <tr>
		    <th><label><b>Repeat Password</b></label></th>
		    <th><input type="password" placeholder="Repeat Password"  style = "width: 355%; padding: 10px; border: none; background: #f1f1f1;" required></th>
		    </tr>
		   <tr>
		    <button type="submit" v-on:click = "saveSupplier" style = "background-color: SlateBlue;padding: 10px; border: none;cursor: pointer;width: 675%;opacity: 0.9;">Register</button>
		  </tr>
		    </table>
	</div>
	</div>
		`,
		mounted(){
			axios
			.get('users/new')
			.then(response => (this.supplier = response.data));
		},
		methods: {
			saveSupplier : function () {
				axios
				.post("/application/users/createSupplier", this.supplier);
			}	
		}
	});
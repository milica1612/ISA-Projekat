Vue.component("patient",{
	data: function(){
		return{
			mode: 'BROWSE',
			patient: null,
			backup: [],
			loyalty_card: null,
			allergies: []
	}
},
template:
	`
	<div id = "form-check-inline">
		<table>
		<tr>
		<th>Personal information</th>
		</tr>
		<tr>
		<th>Name</th>
		<td><input type = "text" v-model = "patient.firstName" v-bind:disabled = "mode =='BROWSE'"/></td>
		</tr>
		<tr>
		<th>Last Name</th>
		<td><input type = "text" v-model = "patient.lastName" v-bind:disabled = "mode =='BROWSE'"/></td>
		</tr>
		<tr>
		<th>Phone Number</th>
		<td><input type = "text" v-model = "patient.phoneNumber" v-bind:disabled = "mode =='BROWSE'"/></td>
		</tr>
		<tr>
		<th>Country</th>
		<td><input type = "text" v-model = "patient.address.country" v-bind:disabled = "mode =='BROWSE'"/></td>
		</tr>
		<tr>
		<th>City</th>
		<td><input type = "text" v-model = "patient.address.city" v-bind:disabled = "mode =='BROWSE'"/></td>
		</tr>
		<tr>
		<th>Street</th>
		<td><input type = "text" v-model = "patient.address.street" v-bind:disabled = "mode =='BROWSE'"/></td>
		</tr>
		<tr>
		<th>Home Number</th>
		<td><input type = "text" v-model = "patient.address.streetNumber" v-bind:disabled = "mode =='BROWSE'"/></td>
		</tr>
		<tr>
		<th>E-mail</th>
		<td>{{patient.email}}</td>
		</tr>
		<tr>
        <tr>
		<th>Password</th>
		<td><input type = "text" v-model = "patient.password" v-bind:disabled = "mode =='BROWSE'"/></td>
		</tr>
		<tr>
		<td><button type="button" v-on:click = "editInformation" type="button" v-bind:disabled ="mode !='BROWSE'">Edit</button>
		</td>
		<td><button  type="button" v-on:click = "saveInformation" v-bind:disabled = "mode =='BROWSE'" >Save</button>
		</td>
		</tr>
		</table>
		
		<table>
		<tr>
		<th>Loyalty card</th>
		</tr>
		<tr>
		<th>Loyalty Points</th>
		<td>{{this.loyalty_card.points}}</td>
		</tr>
		<tr>
		<th>Loyalty Category</th>
		<td>{{this.loyalty_card.loyaltyCategory}}</td>
		</tr>
		</table>
	</div>
	`,
	mounted(){
		axios
		.get('users/1')
		.then(response => (this.patient = response.data));
		axios
		.get('loyaltyCard/user/1')
		.then(response => (this.loyalty_card = response.data));
	},
	methods: {
	
	editInformation : function(event){
		this.mode = "EDIT";
		},
		
	saveInformation : function(event){
		this.mode = "BROWSE";
		
		axios
				.post("/application/users/update", this.patient);
		}
	}
});
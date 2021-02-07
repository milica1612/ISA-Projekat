Vue.component("allpatients",{
	data: function () {
		    return {
				allpatients: null,
				mode: 'BROWSE',
				backup: [],
				datas1 : '',
				datas2: '',
				selectedUser: {},
			}				
}, 
	template: `
		<div>
			<table>		
				<tr>
					<td><input type="text" v-model = "datas1" placeholder="Enter firstName"></td>
					<td><input type="text" v-model = "datas2" placeholder="Enter lastName"></td>	
					<td><button v-on:click = "searchPatient" style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">Search</button></td>				
				</tr>
			</table>		
			<table style = "width: 100%; border-bottom: 1px solid #ddd;">
				<tr style = "border-bottom: 1px solid #ddd;">
					<td style = "border-bottom: 1px solid #ddd;">IME:</td>
					<td style = "border-bottom: 1px solid #ddd;">PREZIME:</td>
				</tr>
				<tr style = "border-bottom: 1px solid #ddd;" v-for="p in allpatients" v-on:click="selectUser(p)" v-bind:class="{selected: selectedUser.firstName===p.firstName}">
					<td style = "border-bottom: 1px solid #ddd;" >{{p.firstName}}</td>
					<td style = "border-bottom: 1px solid #ddd;">{{p.lastName}}</td>
				</tr>
			</table>
		</div>
		`,
	mounted() {
		axios
		.get('users/allpatients')
		.then(response => (this.allpatients = response.data));
	},
	methods: {
		searchPatient : function () {
			axios
			.post("users/searchUser", this.datas1, this.datas2)
			.then(response => (this.allpatients = response.data));
		},
		selectUser : function(user){
			this.selectedUser = user;
		}
	}
});
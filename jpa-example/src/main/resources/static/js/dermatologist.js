Vue.component("employee",{
	data: function () {
		    return {
				employee: null  
			}				
}, 
template: `
	<div>
		<table>
		<tr><th>HOME PAGE FOR:   {{employee.userType}}</th></tr>
		<tr><td>FirstName:</td><td>{{employee.firstName}}</td></tr>
		<tr><td>LastName:</td><td>{{employee.lastName}}</td><tr>
		<tr><td>PhoneNumber:</td><td>{{employee.phoneNumber}}</td><tr>
		<tr><td>Street:</td><td>{{employee.address.street}}</td></tr>
		<tr><td>StreetNumber</td><td>{{employee.address.streetNumber}}</td></tr>
		<tr><td>City</td><td>{{employee.address.city}}</td></tr>
		<tr><td>Country</td><td>{{employee.address.country}}</td></tr>
		<tr><td>E-mail:</td><td>{{employee.email}}</td><tr>
		<tr><td>Password:</td><td>{{employee.password}}</td><tr>		
		</table>
	</div>
	`,
	mounted() {
		axios
		.get('users/1')
		.then(response => (this.employee = response.data));
	}
});
Vue.component("sysAdmin", {
	data: function () {
		    return {
		    	sysAdmin: null
		    }
	},
	template: `
	<div>
		<h1>System Administrator</h1>
				
		<div>
		<table>
			<tr>
			<th><button type="button" style="background-color:SlateBlue; border:none; padding: 15px 32px; font-size: 16px; display: inline-block;">Register Pharmacy</button></th>
			
			<th><a href = "#/registerPhAdmin" style="background-color:SlateBlue; border:none;  padding: 15px 32px; font-size: 16px; display: inline-block;">Register Pharmacy Administrator</a></th>
		    
		    <td><a href = "#/registerDerm"  style="background-color:SlateBlue; border:none;  padding: 15px 32px; font-size: 16px; display: inline-block;">Register Dermatologist</a></td>
		    
		    <th><a href = "#/register"  style="background-color:SlateBlue; border:none;  padding: 15px 32px; font-size: 16px; display: inline-block;">Register Supplier</a></th>
		    
			<th><button type="button" style="background-color:SlateBlue; border:none;  padding: 15px 32px; font-size: 16px; display: inline-block;">Add New Medicine</button></th>
		    
			<th><button type="button"  style="background-color:SlateBlue; border:none; padding: 15px 32px; font-size: 16px;display: inline-block; display: inline-block;">Answer On Complaint</button></th>
			
			<th><button type="button"  style="background-color:SlateBlue; border:none;  padding: 15px 32px; font-size: 16px; display: inline-block;">Loyalty Program</button></th>
			
			<th><button type="button"  style="background-color:SlateBlue; border:none;  padding: 15px 32px; font-size: 16px; display: inline-block;">Add New System Admin</button></th>
		    </tr>
		  </table>
		</div>
</div>
`,
	mounted(){
		axios
	}
});
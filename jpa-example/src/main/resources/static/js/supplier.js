Vue.component("supplier", {
	data: function () {
		    return {
		    	supplier: null
		    }
	},
	template: `
	<div id = "wrapper">
		<h1>Supplier</h1>
				
		<div id = "app" v-on:click="seen = !seen" class="control">
		<table>
			<tr>
			<th><button type="button" v-on:click="addMedicines" style="background-color:SlateBlue; border:none; padding: 15px 32px; font-size: 16px; display: inline-block;">Register Pharmacy</button></th>
			
			<th><button type="button"  style="background-color:SlateBlue; border:none;  padding: 15px 32px; font-size: 16px; display: inline-block;">Register Pharmacy Administrator</button></th>
		    
		    <th><button type="button"  style="background-color:SlateBlue; border:none;  padding: 15px 32px; font-size: 16px; display: inline-block;">Register Dermatologist</button></th>
		    
		    <th><button type="button"  style="background-color:SlateBlue; border:none;  padding: 15px 32px; font-size: 16px; display: inline-block;">Register Supplier</button></th>
		    
			<th><button type="button" v-on:click = "addMedicines" style="background-color:SlateBlue; border:none;  padding: 15px 32px; font-size: 16px; display: inline-block;">Add New Medicine</button></th>
		    
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
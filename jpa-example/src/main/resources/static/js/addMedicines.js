Vue.component("addMedicines", {
	data: function () {
		    return {
		    	medicine: null
		    }
	},
	template: `
	<div style = "margin-top: 10px;">
		<h2 style = "text-align:center;">Add New Medicine</h2>
		<table style = "margin: 0 auto;">
			<tr>
				<td>Name:</td>
				<td><input type = "text" v-model = "medicine.name" placeholder = "Name" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;"/></td>
			</tr>
			<tr>
				<td>Medicine Code:</td>
				<td><input type = "text" v-model = "medicine.medicineCode" placeholder = "Medicine Code" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;"/></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><input type = "text" v-model = "medicine.type" placeholder = "Type" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;"/></td>
			</tr>
		  </table>

			<h2 style = "text-align:center;">Medicine Specification</h2>
			<table style = "margin: 0 auto;">
				<tr>
					<td>Contraindication:</td>
					<td><input type = "text"  placeholder = "Contraindication" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;"/></td>
				</tr>
				<tr>
					<td>Ingridient:</td>
					<td><input type = "text" placeholder = "Ingridient" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;"/></td>
				</tr>
				<tr>
					<td>Dosage:</td>
					<td><input type = "text" v-model = "medicine.dosage" placeholder = "Dosage" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;"/></td>
				</tr>
				<tr>
				<td>Replace Medicine:</td>
				<td><input type = "text"  placeholder = "Replace Medicine" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;"/></td>
				</tr>
				<tr>
				<td>Loyalty Points:</td>
				<td><input type = "text" v-model = "medicine.loyaltyPoints" placeholder = "Loyalty Points" style = "width : 100%; padding: 10px; border: none; background: #f1f1f1;"/></td>
				</tr>
				<td>
				 <button v-on:click = "saveMedicine"  style = "background-color:SlateBlue; width: 111%; padding: 10px; border: none; cursor: pointer;" type="button">Save</button>
				</td>
			  </table>
    </div>
	`,
	mounted(){
		axios
		.get('medicine/newMedicine')
		.then(response => (this.medicine = response.data));
	},
	methods: {
		saveMedicine : function () {
			axios
			.post("/application/medicine/addMedicine", this.medicine);
		}	
	}
	
});
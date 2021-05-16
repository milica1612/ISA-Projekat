Vue.component("searchMedicine", {
	data: function () {
		    return {
		    	medicine: []
		    }
	},
	template: `
	<div id = "searchMedicine">	

			<h2>Search Medicine</h2>
			<br>
			<label for="searchPharmacies">Search Pharmacies:</label>
			<input type="search">
			<button type="submit">Search</button>
			<br>
			<label class = "filtrate">Filtrate:</label>
			<button type="submit">Rating</button>
			
			<div class = "container">
			<table class = "table">
				<tr style = "background-color: #60A0A0;">
					<td>Name</td>
					<td>Rating</td>
					<td>Address</td>
				</tr>
				<tr v-for="m in medicines">
					<td>{{m.name}}</td>
					<td>{{m.type}}</td>
				</tr>
			</table>
			</div>
		</div>

		`,
		mounted(){
		axios
	
	}
	});
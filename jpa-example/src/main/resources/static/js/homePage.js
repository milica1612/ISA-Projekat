Vue.component("homePage", {
	data: function () {
		    return {
		    	logged: false,
		    	pharmacies: []
		    }
	},
	template: `
	<div id = "homePage">	

			<h2>Pharmacies</h2>
			<a href = "#/searchMedicine">Show medicines</a>
			<br>
			<label for="searchPharmacies">Search Pharmacies:</label>
			<input type="search" id="searchPharmacies" name="searchPharmacies">
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
				<tr v-for="p in pharmacies">
					<td>{{p.name}}</td>
					<td>{{p.rating}}</td>
					<td>{{p.adress.street + " " + p.adress.streetNumber + ", " + p.adress.city + ", " + p.adress.country}}</td>
				</tr>
			</table>
			</div>
		</div>

		`,
		mounted(){
		axios
		.get('/application/pharmacy')
		.then(response => (this.pharmacies = response.data));
		
	}
	});
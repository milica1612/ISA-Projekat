Vue.component("homePage", {
	data: function () {
		    return {
		    	logged: false,
		    	pharmacies: [],
		    	searchField: ""
		    }
	},
	template: `
	<div id = "homePage">	

			<h2>Pharmacies</h2>
			<a href = "#/searchMedicine">Show medicines</a>
			<br>

			<label for="searchPharmacies">Search Pharmacies:</label>
			<input type="search" v-model = "searchField" id="searchPharmacies" name="searchPharmacies" required>
			<button type="submit" v-on:click = "searchPharmacies">Search</button>
			<br>
			<label class = "filtrate">Filtrate by rating:</label>
					  	
			<label for="vehicle1">5</label>
			<input type="checkbox">
			
		  	<label for="vehicle2">4</label>
		  	<input type="checkbox">
		  	
		  	<label for="vehicle3">3</label>
		  	<input type="checkbox">
		  	
		  	<label for="vehicle3">2</label>
		  	<input type="checkbox">
		  	
		  	<label for="vehicle3">1</label>
		  	<input type="checkbox">

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
		
		},
		methods: {
			searchPharmacies: function() {
				axios
				.get("/application/pharmacy/getByNameOrAddress/" + this.searchField)
				.then(response => (this.pharmacies = response.data));
				}
		}
	});
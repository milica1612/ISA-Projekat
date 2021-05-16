Vue.component("searchMedicine", {
	data: function () {
		    return {
		    	medicines: []
		    }
	},
	template: `
	<div id = "searchMedicine">	

			<h2>Search Medicine</h2>
			<br>
			<label>Search Medicines:</label>
			<input type="search">
			<button type="submit">Search</button>
			<br>
			<label class = "filtrate">Filtrate:</label>
			<button type="submit">Rating</button>
			
			<div class = "container">
			<table class = "table">
				<tr style = "background-color: #60A0A0;">
					<td>Name</td>
					<td>Type</td>
					<td>Rating</td>
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
		.get('/application/medicine')
		.then(response => (this.medicines = response.data));
	
	}
	});
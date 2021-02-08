Vue.component("seeOffers", {
	data: function () {
		    return {
		    	seeOffers: null,
		    	supplier: null,
				mode: 'BROWSE'	
		    }
	},
	template: `
	<div>
	<div>
	
	<h1 style = "text-align:center;">All Offers</h1>
		<table  style = "margin: 0 auto; background-color: #E0E8F0;">
		<tr>
		<h1>Filter:</h1>
		<td><button v-on:click = "filtrateOffersA" style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:100%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">Accepted</button></td>
		<td><button v-on:click = "filtrateOffersD" style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:100%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">Declined</button></td>
		<td><button v-on:click = "filtrateOffersW" style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:200%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">Waiting</button></td>
		</tr>
		<tr style = "border: 1px solid black; background-color: #60A0A0;">
		<td style = "border: 1px solid black;">Delivery Deadline</td>
		<td style = "border: 1px solid black;">Price</td>
		<td style = "border: 1px solid black;">Status</td>
		<td style = "border: 1px solid black;">Supplier First Name</td>
		<td style = "border: 1px solid black;">Supplier Last Name</td>
		</tr>
		<tr v-for = "o in seeOffers" style = "border: 1px solid black; background-color: #E0E8F0;">
				<td style = "border: 1px solid black;">{{o.deliveryDeadline}}</td>
				<td style = "border: 1px solid black;">{{o.price}}</td>
				<td style = "border: 1px solid black;">{{o.status}}</td>
				<td style = "border: 1px solid black;">{{o.supplier.firstName}}</td>
				<td style = "border: 1px solid black;">{{o.supplier.lastName}}</td>
			</tr>
		</table>
	</div>
	
</div>
`,
	mounted(){
		axios
		.get('offers/seeOffers/1')
		.then(response => (this.seeOffers = response.data));
	},
	methods: {
		filtrateOffersA: function(event){
			axios
			.get("offers/filtrate/ACCEPTED/1")
			.then(response => (this.seeOffers = response.data));
		},
		filtrateOffersD: function(event){
			axios
			.get("offers/filtrate/DECLINED/1")
			.then(response => (this.seeOffers = response.data));
		},
		filtrateOffersW: function(event){
			axios
			.get("offers/filtrate/WAITING/1")
			.then(response => (this.seeOffers = response.data));
		}
	}
});
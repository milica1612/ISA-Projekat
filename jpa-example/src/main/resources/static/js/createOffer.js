Vue.component("createOffer", {
	data: function () {
		    return {
		    	seeOffers: null,
				mode: 'BROWSE'		
		    }
	},
	template: `
	<div style = "padding: 40px;">
	<h1 style = "text-align:center;">All Offers</h1>
		<table style = "margin: 0 auto;">
		
		</table>
	
		<table style = "margin: 0 auto;">
		<tr>
		<td><button style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:100%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">Accepted</button></td>
		<td><button style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:100%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">Declined</button></td>
		<td><button style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:200%; opacity: 0.9;" type="button" v-bind:disabled = "mode != 'BROWSE'">Waiting</button></td>
		</tr>
		<tr style = "border: 1px solid black;">
		<td style = "border: 1px solid black;">Delivery Deadline</td>
		<td style = "border: 1px solid black;">Price</td>
		<td style = "border: 1px solid black;">Status</td>
		<td style = "border: 1px solid black;">Supplier First Name</td>
		<td style = "border: 1px solid black;">Supplier Last Name</td>
		</tr>
		<tr v-for = "o in seeOffers" style = "border: 1px solid black;">
				
				<td style = "border: 1px solid black;">{{o.deliveryDeadline}}</td>
				<td style = "border: 1px solid black;">{{o.price}}</td>
				<td style = "border: 1px solid black;">{{o.status}}</td>
				<td style = "border: 1px solid black;">{{o.supplier.firstName}}</td>
				<td style = "border: 1px solid black;">{{o.supplier.lastName}}</td>
			</tr>
		</table>
	</div>
`,
	mounted(){
		axios
		.get('offers/seeOffers')
		.then(response => (this.seeOffers = response.data));
	},
	method: {
		seeAllOffers: function(){
			axios
			.get('offers/seeOffers')
			.then(response => (this.seeOffers = response.data));
	}
	}
});
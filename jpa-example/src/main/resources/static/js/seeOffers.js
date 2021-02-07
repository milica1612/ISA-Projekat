Vue.component("seeOffers", {
	data: function () {
		    return {
		    	seeOffers: null,
		    	
				mode: 'BROWSE'	
		    }
	},
	template: `
	<div>
		<div style = "margin: 0 auto;">
			<div><button style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:100%;">Filter offers:</button></div>
			<br/>
			<div>
				<select style = "background-color:SlateBlue; padding: 10px; border: none; cursor: pointer; width:100%;">
					<option disabled selected value> Select Offer Type</option>
					<option value= "ACCEPTED">ACCEPTED</option>
					<option value= "DECLINED">DECLINED</option>
					<option value= "WAITING">WAITING</option>
				</select>
			</div>
		</div>	
	
	<div style = "margin-left: 50%; margin-bottom: 100%">
	<h1 style = "text-align:center;">All Offers</h1>
		<table >
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
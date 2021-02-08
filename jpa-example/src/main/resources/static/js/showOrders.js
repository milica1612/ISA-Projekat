Vue.component("showOrders", {
	data: function () {
		    return {
		    	showOrders: null,
				mode: 'BROWSE'		
		    }
	},
	template: `
	<div style = "padding: 40px;">
	<h1 style = "text-align:center;">All Orders</h1>
	
		<table style = "margin: 0 auto;">
		<tr style = "border: 1px solid black;background-color: #60A0A0;">
		<td style = "border: 1px solid black;">Offer deadline</td>
		<td style = "border: 1px solid black;">Status</td>
		<td style = "border: 1px solid black;">Pharmacy</td>

		</tr>
		<tr v-for = "o in showOrders" style = "border: 1px solid black;background-color: #E0E8F0;">				
				<td style = "border: 1px solid black;">{{o.offerDeadline}}</td>
				<td style = "border: 1px solid black;">{{o.orderStatus}}</td>
				<td style = "border: 1px solid black;">{{o.pharmacy.name}}</td>
			</tr>
		</table>
	</div>
`,
	mounted(){
		axios
		.get('orders/allOrders')
		.then(response => (this.showOrders = response.data));
	},
	method: {
		showOrders: function(){
			axios
			.get('orders/allOrders')
			.then(response => (this.showOrders = response.data));
	}
	}
});
Vue.component("showOrders", {
	data: function () {
		    return {
		    	showOrders: null,
				mode: 'BROWSE'		
		    }
	},
	template: `
	<div>
	<h1 style = "margin:0 auto; text-align:center; background-color:#f1f1f1;">All Orders</h1>
	<br>
	<br>
		<table style = "margin: 0 auto; width:100%; background-color: #E0E8F0;">
		<tr style = "background-color: #60A0A0;">
		<td style = "border: 1px solid black;">Offer deadline</td>
		<td style = "border: 1px solid black;">Status</td>
		<td style = "border: 1px solid black;">Pharmacy</td>

		</tr>
		<tr v-for = "o in showOrders" style = "background-color: #E0E8F0;">				
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
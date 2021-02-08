Vue.component("searchPharmacists", {
    data: function() {
            return {
                pharmacists: null,
            }
    }, 
    template: `
    <div>
        <h2>Search and filter pharmacists</h2>
        
        <table>		
            <tr>
                <td><input class = "input" type="text" placeholder="Enter first name"></td>
                <td><input class = "input" type="text" placeholder="Enter last name"></td>			
            </tr>
            <tr>
                <td>
                    <button class="button">Cancel search</button>
                </td>
                <td>
                    <button class="button">Search pharmacists</button>
                </td>
            </tr>
        </table>
        
		<h3>Pharmacists</h3>
        
        <table id="searchTable">
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Rating</th>
                <th>Pharmacy name</th>
            </tr>
            
            <tr v-for="p in pharmacists">
                <td>{{p.firstName}}</td>
                <td>{{p.lastName}}</td>
      			<td></td>
      			<td></td>
            </tr>
        </table>
    </div>
    `,
    mounted() {
        axios
        .get('users/pharmacists')
        .then(response => (this.pharmacists = response.data));
    },
    methods: {

    }
})
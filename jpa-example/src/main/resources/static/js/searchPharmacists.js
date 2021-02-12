Vue.component("searchPharmacists", {
    data: function() {
            return {
                pharmacists: null,
                pharmacistList: null,
                showList: false,
                searchFirstName: '',
                searchLastName: '',
            }
    }, 
    template: `
    <div>
        <h2>Search and filter pharmacists</h2>
        
        <table>		
            <tr>
               <td><input class = "input" type="text" v-model="searchFirstName"  placeholder="Enter first name"></td>
                <td><input class = "input" type="text" v-model="searchLastName"  placeholder="Enter last name"></td>	
            </tr>
            <tr>
                <td>
                     <button class="button" v-on:click="cancelSearch">Cancel search</button>
                </td>
                <td>
                    <button class="button" v-on:click="searchPharmacist">Search pharmacists</button>
                </td>
            </tr>
        </table>
        
		<h3>Pharmacists</h3>
        
        <table id="searchTable">
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Reiting of a pharmacist</th>
                <th>Pharmacy name</th>
            </tr>
            
            <tr v-bind:hidden="showList" v-for="p in pharmacists">
                <td>{{p.firstName}}</td>
                <td>{{p.lastName}}</td>
      			<td>{{p.reiting}}</td>
      			<td>{{p.pharmacyName}}</td>
            </tr>
                
            <tr v-bind:hidden="!showList" v-for="p in pharmacistList">
                <td>{{p.firstName}}</td>
                <td>{{p.lastName}}</td>
      			<td>{{p.reiting}}</td>
      			<td>{{p.pharmacyName}}</td>
            </tr>
        </table>
    </div>
    `,
    mounted() {
        axios
        .get('pharmacists/all')
        .then(response => (this.pharmacists = response.data));
    },
    methods: {
		searchPharmacist: function(){
		
		    if(this.searchFirstName != '' && this.searchLastName == ''){
		    	axios
    			.get("pharmacists/searchPharmacistsByFirstName/" + this.searchFirstName)
    			.then(response => {
    				this.pharmacistList = response.data;
    				this.showList = true;
    			}); 
		    }
		    else if(this.searchFirstName == '' && this.searchLastName != '')
		    {
		    	axios
    			.get("pharmacists/searchPharmacistsByLastName/" + this.searchLastName)
    			.then(response => {
    				this.pharmacistList = response.data;
    				this.showList = true;
    			}); 
		    }
    		else if(this.searchFirstName !='' && this.searchLastName != ''){
    			axios
    			.get("pharmacists/searchPharmacists/" + this.searchFirstName + "/" + this.searchLastName)
    			.then(response => {
    				this.pharmacistList = response.data;
    				this.showList = true;
    			});    		
    		}
    		else{
    			this.showList = false;
    		}	
    	},
    	cancelSearch: function(){
			this.showList = false;
			this.searchFirstName = '';
			this.searchLastName = '';
		}
    }
})
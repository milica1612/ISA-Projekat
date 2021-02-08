Vue.component("searchPharmacists", {
    data: function() {
            return {
                pharmacists: null,
                mode: 'BROWSE',
            }
    }, 
    template: 
    `
    <div>
        <h2>Search and filter pharmacists</h2>
        
        <table>		
            <tr>
                <td><input class = "input" type="text" v-model = "searchFirstName" name="fistName" placeholder="Enter first name"></td>
                <td><input class = "input" type="text" v-model = "searchLastName" name="lastName" placeholder="Enter last name"></td>			
            </tr>
            <tr>
                <td>
                    <button class="button" v-on:click="cancelSearch">Cancel search</button>
                </td>
                <td>
                    <button class="button" v-on:click="searchPharmacists">Search pharmacists</button>
                </td>
            </tr>
        </table>
    </div>
    `,
    mounted() {
        
    }
})
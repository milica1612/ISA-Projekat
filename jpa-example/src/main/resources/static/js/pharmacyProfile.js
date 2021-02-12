Vue.component("pharmacyProfile", {
    data: function() {
        return{
			name: '',
        	address: '',
			reiting: '',
			description: '',
			pharmacy: null,
			backup:[]
        }
    },
    template:`
    <div id="pharmacyProfile" class="container-fluid">
    	
		<h1>Pharmacy Profile</h1>

		<form>
			<div class="form-group">
				<label for="exampleFormControlInput1">Pharmacy Name</label>
				<input type="text" class="form-control" id="exampleFormControlInput1" disabled="true" v-model="name" name="name"/>
			
				<label for="exampleFormControlInput1">Pharmacy Address</label>
				<input type="text" class="form-control" id="exampleFormControlInput1" disabled="true" v-model="address" name="address"/>
				
				<label for="exampleFormControlInput1">Pharmacy Reiting</label>
				<input type="number" class="form-control" id="exampleFormControlInput1" disabled="true" v-model="reiting" name="reiting"/>
				
				<label for="exampleFormControlInput1">Pharmacy Description</label>
				<input type="text" class="form-control" id="exampleFormControlInput1" disabled="true" v-model="description" name="description"/>
			</div>
		</form>
    </div>
    `,
    mounted(){
        axios
		.get('pharmacy/getPharmacyById/1')
		.then(response => {
		if(response.data != null){
				this.pharmacy = response.data;
				this.name = response.data.name;
				this.address = response.data.address;
				this.reiting = response.data.reiting;
				this.description = response.data.description;
				this.backup = [this.name, this.address, this.reiting, this.description];
		}
		});
    },
    methods: {

    }
  
});
Vue.component("register", {
	data: function () {
		    return {
		    	register: null
		    }
	},
	template: `
		  <div class="container" style = "margin:0 auto;">
		    <h1 style = "margin:0 auto; text-align:center; background-color:#f1f1f1;">Create Account</h1>
		    
		    <br>
		<table style = "margin:0 auto;">
		    <tr>
		    <th> <label for="email" style = "text-align:left;">Email</label></th>
		    <th> <input type="text" placeholder="Enter Email" name="email" id="email" style = "width: 355%; padding: 10px;border: none; background: #f1f1f1;" required></th>
		    </tr>
		    <tr>
		    <th><label for="firstName"><b>First Name</b></label></th>
		    <th> <input type="text" placeholder="Enter First Name" name="firstName" id="firstName" style = "width: 355%; padding: 10px;border: none; background: #f1f1f1;" required/></th>
		    </tr>
		    <tr>
		    <th><label for="lastName">LastName</label></th>
		    <th><input type="text" placeholder="Enter Last Name" name="lastName" id="lastName" style = "width: 355%; padding: 10px; border: none; background: #f1f1f1;" required></th>
		    </tr>
		    <tr>
		    <th><label for="address"><b>Address</b></label></th>
		    <th><input type="text" placeholder="Enter Address" name="address" id="address" style = "width: 100%; padding: 10px;  border: none; background: #f1f1f1;" required></th>
		    
		    
		    <th><label for="city"><b>City</b></label></th>
		    <th><input type="text" placeholder="Enter City" name="address" id="address" style = "width: 100%; padding: 10px;  border: none; background: #f1f1f1;" required></th>
		    
		    
		    <th><label for="country"><b>Country</b></label></th>
		    <th><input type="text" placeholder="Enter Country" name="address" id="address" style = "width: 103%; padding: 10px;  border: none; background: #f1f1f1;" required></th>
		    </tr>
		    
		    <tr>
		    <th><label for="phoneNumer"><b>Phone Number</b></label></th>
		    <th><input type="phoneNumber" placeholder="Enter Phone Number" name="phoneNumber" id="phoneNumber" style = "width: 355%; padding: 10px; border: none; background: #f1f1f1;" required></th>
		    </tr>
		    
		    <tr>
		    <th><label for="psw"><b>Password</b></label></th>
		    <th><input type="password" placeholder="Enter Password" name="psw" id="psw" style = "width: 355%; padding: 10px; border: none; background: #f1f1f1;" required></th>
		    </tr>
		    <tr>
		    <th><label for="psw-repeat"><b>Repeat Password</b></label></th>
		    <th><input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" style = "width: 355%; padding: 10px; border: none; background: #f1f1f1;" required></th>
		    </tr>
		   <tr>
		    <button type="submit" class="registerbtn" style = "background-color: SlateBlue;padding: 10px; border: none;cursor: pointer;width: 672%;opacity: 0.9;">Register</button>
		  </tr>
		    </table>
		    </div>
		`,
		mounted(){
			axios
		}
	});
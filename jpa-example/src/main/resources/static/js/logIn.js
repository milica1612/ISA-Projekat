Vue.component("logIn", {
	data: function () {
		    return {
		    	logIn: null
		    }
	},
	template: `
		  <div class="container">
		    <h1 style = "margin:0 auto; text-align:center; background-color:#f1f1f1;">Sign In</h1>
		    <br>
		<table style = "margin:0 auto; padding: 20px;">
		    <tr>
		    <th> <label for="email">Email</label></th>
		    <th> <input type="text" placeholder="Enter Email" name="email" id="email" style = "width: 150%; padding: 10px;border: none; background: #f1f1f1;" required></th>
		    </tr>
		    <tr>
		    <th><label for="psw"><b>Password</b></label></th>
		    <th><input type="password" placeholder="Enter Password" name="psw" id="psw" style = "width: 150%; padding: 10px; border: none; background: #f1f1f1;" required></th>
		    </tr>
		   <tr>
		    <button type="submit" class="logInbtn" style = "background-color: SlateBlue;padding: 10px; border: none;cursor: pointer;width: 540%;opacity: 0.9;">Sign In</button>
		  </tr>
		    </table>
		    </div>
		`,
		mounted(){
			axios
		}
	});
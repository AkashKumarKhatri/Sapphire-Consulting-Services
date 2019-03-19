<!doctype html>
<html lang="en">
	<head>
	    <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <title>Registration Form</title>
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
	    <link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
	    <link rel="stylesheet" href="assets/libs/css/style.css">
	    <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
	     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <style>
		    html,
		    body {
		        height: 100%;
		    }
		
		    body {
		        display: -ms-flexbox;
		        display: flex;
		        -ms-flex-align: center;
		        align-items: center;
		        padding-top: 40px;
		        padding-bottom: 40px;
		    }
	    </style>
	    <script>
		    function resetFields() {
	    		$("#name").val("");
				$("#email").val("");
				$("#pass").val("");
				$("#contact").val("");
				$("#address").val("");
	    	}
	    	$(document).ready(function() {
	    		$("#registeBtn").click(function() {
    				$.ajax({
	    				url: "SuscriberServlet",
		    			method: "post",
		    			data: {
		    				name: $("#name").val(),
		    				email: $("#email").val(),
		    				password: $("#pass").val(),
		    				contact: $("#contact").val(),
		    				address: $("#address").val(),
		    				action: "add"
		    			},
		    			success: function(row){
		    				if(row > 0) {
		    					alert("Thanks; Please wait registration comfirmation");
		    					resetFields();
		    				}
		    				else
		    					alert("Please try again");
		    			} 
	    			});
	    		});
	    	});
	    </script>
	</head>
	<body>
	    <div class="splash-container">
	        <div class="card">
	            <div class="card-header">
	                <h3 class="mb-1">Registrations Form</h3>
	                <p>Please enter your user information.</p>
	            </div>
	            <div class="card-body">
	                <div class="form-group">
	                    <input class="form-control form-control-lg" type="text" id="name" required="" placeholder="Name" autocomplete="off">
	                </div>
	                <div class="form-group">
	                    <input class="form-control form-control-lg" type="email" id="email" required="" placeholder="E-mail" autocomplete="off">
	                </div>
	                <div class="form-group">
	                    <input class="form-control form-control-lg" id="pass" type="password" required="" placeholder="Password">
	                </div>
	                <div class="form-group">
	                    <input type="text" id="contact" class="form-control form-control-lg" required="" placeholder="Contact">
	                </div>
	                <div class="form-group">
	                    <input type="text" id="address" class="form-control form-control-lg" required="" placeholder="Address">
	                </div>
	                <div class="form-group pt-2">
	                    <button class="btn btn-block btn-primary" id="registeBtn">Register My Account</button>
	                </div>          
	            <div class="card-footer bg-white">
	                <p>Already member? <a href="login.jsp" class="text-secondary">Login Here.</a></p>
	            </div>
	        </div>
	    </div>
	</body>
</html>
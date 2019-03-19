<!doctype html>
<html lang="en">
 
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>
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
			$(document).ready(function() {
				$("#btnLogin").click(function() {
					if($("#agent").is(":checked")) {
						$.ajax({
							url: "LoginServlet",
							method: "post",
							data: {
								username: $("#username").val(),
								password: $("#pass").val(),
								type: "agent"
							},
							success: function(user) {
								if(user != null) {
									if(user.username == $("#username").val() && user.password == $("#pass").val()) {
										window.location = "index.jsp?param="+$("#username").val()+"&type=agent";
									}
				 				}
								else {
									alert("Username or Password incorrect");
								}
							}
						});
					}
					else {
						$.ajax({
							url: "LoginServlet",
							method: "post",
							data: {
								username: $("#username").val(),
								password: $("#pass").val(),
								type: "subscriber"
							},
							success: function(user) {
								if(user != null) {
									if(user.email == $("#username").val() && user.password == $("#pass").val()) {
										window.location = "index.jsp?param="+$("#username").val()+"&type=subs";
									}
				 				}
								else {
									alert("Username or Password incorrect");
								}
							}
						});
					}
				});
			});
		</script>
</head>

<body>
    <!-- ============================================================== -->
    <!-- login page  -->
    <!-- ============================================================== -->
    <div class="splash-container">
        <div class="card ">
            <div class="card-header text-center"><h3>Online Library Management System</h3><span class="splash-description">Please enter your user information.</span></div>
            <div class="card-body">
                    <div class="form-group">
                        <input class="form-control form-control-lg" id="username" type="text" placeholder="Username" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <input class="form-control form-control-lg" id="pass" type="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label class="custom-control custom-checkbox">
                            <input class="custom-control-input" id='agent' type="checkbox"><span class="custom-control-label">Login Agent</span>
                        </label>
                    </div>
                    <button type="submit" id="btnLogin" class="btn btn-primary btn-lg btn-block">Sign in</button>
            </div>
            <div class="card-footer bg-white p-0  ">
                <div class="card-footer-item card-footer-item-bordered">
                    <a href="registration.jsp" class="footer-link">Create An Account</a></div>
                <div class="card-footer-item card-footer-item-bordered">
                    <a href="#" class="footer-link">Forgot Password</a>
                </div>
            </div>
        </div>
    </div>
  
    <!-- ============================================================== -->
    <!-- end login page  -->
    <!-- ============================================================== -->
    <!-- Optional JavaScript -->
    <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
</body>
 
</html>
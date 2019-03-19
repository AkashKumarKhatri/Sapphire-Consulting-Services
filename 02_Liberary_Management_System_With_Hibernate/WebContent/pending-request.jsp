<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- Required meta tags -->
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
	    <link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
	    <link rel="stylesheet" href="assets/libs/css/style.css">
	    <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
	    <title>Book</title>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script>
		    function showPendingRequest(requests) {
	    		var count = 1;
	    		$("#requestTable tr td").remove();
	    		for(request in requests) {
	    			$("#requestTable").append("<tr><td>"+count+"</td><td>"+requests[request].name+"</td><td>"+requests[request].email+"</td><td>"+requests[request].password+"</td><td>"+requests[request].contact+"</td><td>"+requests[request].address+"</td><td><input id='qouta' type='number' class='form-control' placeholder='Quota'></td><td><button class='btn btn-dark btn-sm' onclick='approveRequest("+requests[request].suscriberId+")'>APPROVE</button></td><td><button class='btn btn-dark btn-sm' onclick='rejectRequest("+requests[request].suscriberId+")'>REJECT</button></td>");
	    			count++;
	    		}
	    	}
		    function rejectRequest(id) {
				$.ajax({
					url: "SuscriberServlet",
					method: "post",
					data: {
						subscriberId: id,
						//qouta: $("#qouta").val()
						action: "reject"
					},
					success: function (requests) {
						showPendingRequest(requests);	
					}
				});
			}
		    function approveRequest(id) {
		    	$.ajax({
					url: "SuscriberServlet",
					method: "post",
					data: {
						subscriberId: id,
						qouta: $("#qouta").val(),
						action: "accept"
					},
					success: function (requests) {
						showPendingRequest(requests);	
					}
				});
			}
		    $(document).ready(function(){
		    	$.get("SuscriberServlet",
	    				{
	    					refresh:"request"
	    				},
	    				function(requests){
	    					/* alert(requests); */
	    					showPendingRequest(requests)
	    				});
		    });
	    </script>
	</head>
	<body>
		<div class="dashboard-main-wrapper">
			<jsp:include page="header.jsp"></jsp:include>
			<jsp:include page="left-side-bar.jsp"></jsp:include>
			<div class="dashboard-wrapper">
				<div class="container-fluid">
					<div class="row">
						<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
							<div class="card">
								<h5 class="card-header">PENDING REQUESTS</h5>
								<div class="card-body">
									<div class="table-responsive">
										<table id="requestTable" class="table table-striped table-bordered first">
											<thead>
	                                            <tr>
	                                                <th>S.No</th>
	                                                <th>Name</th>
	                                                <th>Email</th>
	                                                <th>Password</th>
	                                                <th>Contact</th>
	                                                <th>Address</th>
	                                                <th>Quota</th>
	                                                <th colspan="2">Action</th>
	                                            </tr>
	                                        </thead>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					
				</div>
				<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
			</div>
		</div>	
	</body>
	<!-- Optional JavaScript -->
	    <!-- jquery 3.3.1 -->
	    <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
	    <!-- bootstap bundle js -->
	    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
	    <!-- slimscroll js -->
	    <script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
	    <!-- main js -->
	    <script src="assets/libs/js/main-js.js"></script>
</html>
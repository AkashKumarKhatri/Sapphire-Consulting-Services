<%@page import="com.lms.beans.BookReserved"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.dao.impl.BookReservedDAOImpl"%>
<%@page import="com.lms.dao.BookReservedDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
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
		    /* function showBannnedSubscribers(banneds) {
	    		var count = 1;
	    		$("#bannedTable tr td").remove();
	    		for(banned in banneds) {
	    			$("#bannedTable").append("<tr><td>"+count+"</td><td>"+banneds[banned].name+"</td><td>"+banneds[banned].Email+"</td><td>"+banneds[banned].password+"</td><td>"+banneds[banned].quota+"</td><td>"+banneds[banned].address+"</td><td><button class='btn btn-dark btn-sm' onclick='bannedSubscriber("+banneds[banned].suscriberId+")'>BANNED</button></td>");
	    			count++;
	    		}
	    	}*/
		    function bannedSubscriber(id) {
		    	$.ajax({
					url: "SuscriberServlet",
					method: "post",
					data: {
						subscriberId: id,
						action: "banned"
					},
					success: function (row) {
						if (row > 0) 
							location.reload();
						else
							alert("Not Banned");
					}
				});
			}
	    	/*
		    $(document).ready(function(){
		    	$.get("SuscriberServlet",
	    				{
	    					refresh:"request"
	    				},
	    				function(banneds){
	    					showBannnedSubscribers(banneds)
	    				});
		    }); */
	    </script>
	</head>
	<body>
		<% 
			BookReservedDAO reservedDAO = new BookReservedDAOImpl();
			List<BookReserved> list = reservedDAO.getBannedSubscriber();
		%>
		<div class="dashboard-main-wrapper">
			<jsp:include page="header.jsp"></jsp:include>
			<jsp:include page="left-side-bar.jsp"></jsp:include>
			<div class="dashboard-wrapper">
				<div class="container-fluid">
					<div class="row">
						<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
							<div class="card">
								<h5 class="card-header">BANNED SUBSCRIBER</h5>
								<div class="card-body">
									<div class="table-responsive">
										<table id="bannedTable" class="table table-striped table-bordered first">
											<thead>
	                                            <tr>
	                                                <th>S.No</th>
	                                                <th>Subscriber</th>
	                                                <th>Book Title</th>
	                                                <th>Reserved Date</th>
	                                                <th>Return Date</th>
	                                                <th>Warnings</th>
	                                                <th>Action</th>
	                                            </tr>
	                                            <%
	                                            	int count = 1;
	                                            	for (BookReserved reserved : list) { %>
	                                            		<tr>
	                                            			<td><%= count %></td>
	                                            			<td><%= reserved.getSuscriberBean().getName() %></td>
	                                            			<td><%= reserved.getBookBean().getTitle() %></td>
	                                            			<td><%= reserved.getReserveDate() %></td>
	                                            			<td><%= reserved.getReturnDate() %></td>
	                                            			<td><%= reserved.getWarnings() %></td>
	                                            			<td><button class='btn btn-dark btn-sm' onclick='bannedSubscriber(<%= reserved.getSuscriberBean().getSuscriberId()%>)'>BANNED</button></td>
	                                            		</tr>
	                                            <%	
	                                            		count++;
	                                            	}
	                                            %>
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
<!doctype html>
<%@page import="com.lms.beans.SuscriberBean"%>
<%@page import="com.lms.dao.impl.SuscriberDAOImpl"%>
<%@page import="com.lms.dao.SuscriberDAO"%>
<%@page import="com.lms.beans.BookBean"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.dao.impl.BookDAOImpl"%>
<%@page import="com.lms.dao.BookDAO"%>
<html lang="en">

	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet"
			href="assets/vendor/bootstrap/css/bootstrap.min.css">
		<link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
		<link rel="stylesheet" href="assets/libs/css/style.css">
		<link rel="stylesheet"
			href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
		<title>Dashboard</title>
		
		<script>
			function checkBookCopyAvailable(bookId) {
				//var copies = 1;
				$.ajax({
					type : "POST",
					url : "BookServlet",
					data : {
						id: bookId,
						action: "copy"
					},
					success : function(available) {
					 	return(available);
					}
				});
			}	
			
			function reserveBook(subsId, bookId) {
				$.ajax({
					type : "POST",
					url : "BookServlet",
					data : {
						id: bookId,
						action: "copy"
					},
					success : function(available) {
					 	if(available.quantity > 0) {
					 		$.ajax({
								type : "POST",
								url : "SuscriberServlet",
								data : {
									subscriberId: subsId,
									action: "qouta"
								},
								success : function(qoutas) {
									alert(qoutas.quota);
									if (qoutas.quota > 0) {
										$.ajax({
											type : "POST",
											url : "BookReservedServlet",
											data : {
												bId	: bookId,
												sId : subsId,
												action: "reserve"
											},
											success : function(reserve) {
												if (reserve > 0) {
													alert("Reserve");
												}
											}
										});
									}
									else {
										alert("Sorry You Have No remaining Qouta");
									}
								}
							});
					 	}
					 	else {
					 		alert("Copies Not available now please check out after some days");
					 	}
					}
				});
			}
			
			function checkSubscriberQuota(subsId) {
				var subsQouta;
				$.ajax({
					type : "POST",
					url : "SuscriberServlet",
					data : {
						subsubscriberId: subsId,
						action: "qouta"
					},
					success : function(qouta) {
						subsQouta = qouta;
					}
				});
				return subsQuota;
			}
		
		</script>
		
	</head>
	<body>
		<%
			if (request.getSession().getAttribute("user") == null) {
				session.setAttribute("user", request.getParameter("param"));
				session.setAttribute("type", request.getParameter("type"));
				if(request.getSession().getAttribute("type").equals("subs")) {
					SuscriberDAO suscriberDAO = new SuscriberDAOImpl();
					SuscriberBean suscriberBean = suscriberDAO.getSubsciberByName(request.getSession().getAttribute("user").toString());
					System.out.println("Hekko");
					session.setAttribute("id", suscriberBean.getSuscriberId());
				}
			}
		%>
		<% 
			BookDAO bookDAO = new BookDAOImpl();
			List<BookBean> listBooks = bookDAO.getAllBooks();
		%>
		<div class="dashboard-main-wrapper">
			<jsp:include page="header.jsp"></jsp:include>
			<jsp:include page="left-side-bar.jsp"></jsp:include>
			<div class="dashboard-wrapper">
				<div class="container-fluid dashboard-content">
					<div class="row">
						<%
							for(BookBean book : listBooks) { %>
								<div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
									<div class="card">
										<img class="card-img-top img-fluid" src="<%= book.getPicture() %>" alt="Card image cap">
											<div class="card-body">
												<h3 class="card-title"><%= book.getTitle() %></h3>
												<p class="card-text"><%= book.getContent() %></p>
											<%
												if(request.getSession().getAttribute("type").equals("agent")) {%>
													<a href="#" class="btn btn-primary">View</a>
												<%}
												else if (request.getSession().getAttribute("type").equals("subs")) {%>
													
													<button class='btn btn-primary' onclick='reserveBook(<%= request.getSession().getAttribute("id")%>,<%= book.getBookId() %>)'>RESERVE</button>
													<!-- <a href="#" id="reserve" class="btn btn-primary">Reserve</a> -->
												<%}
											%>
											</div>
									</div>
								</div>
						<% } %>
					</div>
				</div>
				<jsp:include page="footer.jsp"></jsp:include>
			</div>
		</div>
		<!-- ============================================================== -->
		<!-- end main wrapper  -->
		<!-- ============================================================== -->
		<!-- Optional JavaScript -->
		<!-- jquery 3.3.1 -->
		<script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
		<!-- bootstap bundle js -->
		<script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
		<!-- slimscroll js -->
		<script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
		<!-- main js -->
		<script src="assets/libs/js/main-js.js"></script>
	</body>
</html>
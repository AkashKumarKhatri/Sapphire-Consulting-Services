<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" /> -->
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
	    	
	    	function showBooks(books) {
	    		var count = 1;
	    		$("#bookTable tr td").remove();
	    		for(book in books) {
	    			$("#bookTable").append("<tr><td>"+count+"</td><td>"+books[book].title+"</td><td>"+books[book].author+"</td><td>"+books[book].content+"</td><td>"+books[book].quantity+"</td><td>"+books[book].borrow+"</td><td><button class='btn btn-dark btn-sm' onclick='editBook("+books[book].bookId+")'>EDIT</button></td><td><button class='btn btn-dark btn-sm' onclick='deleteBook("+books[book].bookId+")'>DELETE</button></td>");
	    			count++;
	    		}
	    	}
	    	
	    	function addBook(event) {
	    		//stop submit the form, we will post it manually.
				event.preventDefault();
	    		
				// Get form
				var form = $('#fileUploadForm')[0];
				
				// Create an FormData object 
				var data = new FormData(form);
				
				// If you want to add an extra field for the FormData
				data.append("title", $("#title").val());
				data.append("author", $("#author").val());
				data.append("content", $("#content").val());
				data.append("copies", $("#copies").val());
				data.append("borrow", $("#borrow").val());
				data.append("action", "add");
				
				// disabled the submit button
				$("#addBtn").prop("disabled", false);
				
				$.ajax({
					type : "POST",
					enctype : 'multipart/form-data',
					url : "BookServlet",
					data : data,
					processData : false,
					contentType : false,
					cache : false,
					timeout : 600000,
					success : function(books) {
						showBooks(books);
	    				resetFields();
					}
				});
			}
	    	
	    	function updateBook(event) {
	    		//stop submit the form, we will post it manually.
				event.preventDefault();
				// Get form
				var form = $('#fileUploadForm')[0];
				// Create an FormData object 
				var data = new FormData(form);
				
				// If you want to add an extra field for the FormData
				data.append("title", $("#title").val());
				data.append("author", $("#author").val());
				data.append("content", $("#content").val());
				data.append("copies", $("#copies").val());
				data.append("borrow", $("#borrow").val());
				data.append("picture", $("#uploadBook").val());
				data.append("id", $("#addBtn").val());
				data.append("action", "update")
				
				// disabled the submit button
				$("#addBtn").prop("disabled", false);
				
				$.ajax({
					type : "POST",
					enctype : 'multipart/form-data',
					url : "BookServlet",
					data : data,
					processData : false,
					contentType : false,
					cache : false,
					timeout : 600000,
					success : function(books) {
						showBooks(books);
	    				resetFields();
					}
				});
			}
	    	
	    	function resetFields() {
	    		$("#addBtn").html("ADD BOOK");
	    		$("#title").val("");
    			$("#author").val("");
    			$("#content").val("");
    			$("#copies").val("");
    			$("#author").val("");
    			$("#borrow").val("");
    			$("#uploadBook").val("");
	    	}
	    	
	    	function editBook(bookId) {
	    		/* // Get form
				var form = $('#fileUploadForm')[0];
				// Create an FormData object 
				var data = new FormData(form);
				// If you want to add an extra field for the FormData
				data.append("id", bookId);
				data.append("method", "getBookBean"); */
				
	    		$.post("BookServlet",{
	    			id: bookId,
	    			method:"getBookBean"
	    		}, 
	    		
	    		/* $.ajax({
					type : "POST",
					enctype : 'multipart/form-data',
					url : "BookServlet",
					data : data,
					processData : false,
					contentType : false,
					cache : false,
					timeout : 600000,
					success : function(bookBean) {
						$("#title").val(bookBean.title);
		    			$("#author").val(bookBean.author);
		    			$("#content").val(bookBean.content);
		    			$("#copies").val(bookBean.quantity);
		    			$("#author").val(bookBean.author);
		    			$("#borrow").val(bookBean.borrow);
		    			$("#uploadBook").val(bookBean.picture);
		    			$("#addBtn").html("UPDATE BOOK");
		    			$("#addBtn").val(bookId);
					}
				}); */
	    		
	    		function(bookBean){
	    			$("#title").val(bookBean.title);
	    			$("#author").val(bookBean.author);
	    			$("#content").val(bookBean.content);
	    			$("#copies").val(bookBean.quantity);
	    			$("#author").val(bookBean.author);
	    			$("#borrow").val(bookBean.borrow);
	    			/* alert(bookBean.picture);
	    			$("#uploadBook").val(bookBean.picture); */
	    			$("#addBtn").html("UPDATE BOOK");
	    			$("#addBtn").val(bookId);
	    		});
	    	}
	    	
	    	function deleteBook(bookId) {
	    		$.post("BookServlet", {
	    			id: bookId,
	    			action: "delete"
	    		},
	    		function(respone) {
	    			showBooks(respone);
	    		});
	    	}
	    	
	    	$(document).ready(function(){
	    		$.get("BookServlet",
	    				{
	    					refresh:"book"
	    				},
	    				function(books){
	    					showBooks(books);
	    				});
	    		
	    		$("#addBtn").click(function(event) {
	    			if ($("#addBtn").html() == "ADD BOOK") {
	    				addBook(event);
	    			}
	    			else if ($("#addBtn").html() == "UPDATE BOOK") {
	    				updateBook(event);
	    				/* $.ajax({
		    				url: "BookServlet",
			    			method: "post",
			    			data: {
			    				title: $("#title").val(),
			    				author: $("#author").val(),
			    				content: $("#content").val(),
			    				copies: $("#copies").val(),
			    				borrow: $("#borrow").val(),
			    				category: $("#category").val(),
			    				picture: $("#uploadBook").val(),
			    				id: $("#addBtn").val(),
			    				action: "update"
			    			},
			    			success: function(books){
			    				showBooks(books);
								resetFields();
			    			}
		    			});	 */
	    			}
	    		});
	    	});
	    </script>
	</head>
	<body>
	    <div class="dashboard-main-wrapper">
	    	<jsp:include page="header.jsp"></jsp:include>
	    	<jsp:include page="left-side-bar.jsp"></jsp:include>
	    	<div class="dashboard-wrapper">
	    	<div class="container-fluid ">
	    		<div class="row">
	    			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
	    				<div class="card">
	    					<h5 class="card-header">ADD BOOK</h5>
	    					<div class="card-body">
	    						<form id="fileUploadForm">
		    						<div class="form-group">
	                                    <label for="title" class="col-form-label">Title</label>
	                                    <input id="title" type="text" class="form-control">
	                                </div>
	                                <div class="form-group">
	                                    <label for="author" class="col-form-label">Author</label>
	                                    <input id="author" type="text" class="form-control">
	                                </div>
	                                <div class="form-group">
	                                    <label for="content" class="col-form-label">Content</label>
	                                    <input id="content" type="text" class="form-control">
	                                </div>
	                                <div class="form-group">
	                                    <label for="copies" class="col-form-label">Copies</label>
	                                    <input id="copies" type="number" class="form-control" placeholder="Number of Copies">
	                                </div>
	                                <div class="form-group">
	                                    <label for="borrow" class="col-form-label">Max Borrow</label>
	                                    <input id="borrow" type="number" class="form-control" placeholder="Max Borrow Period">
	                                </div>
	                                <!-- <div class="form-group">
	                                     <label for="input-select">Category</label>
	                                     <input id="category" type="text" class="form-control">
	                                 </div> -->
	                                 <div class="form-group">
	                                 	 <label for="file" class="col-form-label">Upload Book</label>
	                                     <input type="file" class="form-control" id="uploadBook" name="files" />
	                                 </div>
	                                 <div class="form-group">
	                                 	 <button type="submit" id="addBtn" class="btn btn-primary">ADD BOOK</button>
	                                 </div>
                                 </form>
	    					</div>
	    				</div>
	    			</div>
	    		</div>
	    		<div class="row">
	    			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
	    				<div class="card">
	    					<h5 class="card-header">BOOKS</h5>
	    					<div class="card-body">
	    						<div class="table-responsive">
	    							<table id="bookTable" class="table table-striped table-bordered first">
	    								<thead>
                                            <tr>
                                                <th>S.No</th>
                                                <th>Title</th>
                                                <th>Author</th>
                                                <th>Content</th>
                                                <th>Copies</th>
                                                <th>Max Borrow Period</th>
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
	    	<jsp:include page="footer.jsp"></jsp:include>
	    	</div>
	    </div>
		
		
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
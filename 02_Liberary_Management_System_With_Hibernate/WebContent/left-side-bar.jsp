<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
        <!-- ============================================================== -->
        <!-- left sidebar -->
        <!-- ============================================================== -->
        <div class="nav-left-sidebar sidebar-dark">
            <div class="menu-list">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="d-xl-none d-lg-none" href="#">Dashboard</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav flex-column">
                            <li class="nav-divider">Menu</li>
                            <li class="nav-item ">
                                <a class="nav-link active" href="index.jsp">Dashboard</a>
                            </li>
                            <%
                            	if (request.getSession().getAttribute("user") != null) {
                            		if (request.getSession().getAttribute("type").equals("agent")) { %>
			                            <li class="nav-item">
			                                <a class="nav-link" href="book.jsp">Books</a>
			                            </li>
			                            <li class="nav-item">
			                                <a class="nav-link" href="reserved_books.jsp">Reserved Book</a>
			                            </li>
			                   			<li class="nav-item">
			                                <a class="nav-link" href="pending-request.jsp">Pending Request</a>
			                            </li>			
			                            <li class="nav-item ">
			                                <a class="nav-link" href="warning.jsp">Warnings</a>
			                            </li>
			                            <li class="nav-item">
			                                <a class="nav-link" href="banned.jsp">Banned Subscriber</a>
			                            </li>
                            <% 		}
                            		else if (request.getSession().getAttribute("type").equals("subs")) { %>
                            			<li class="nav-item">
			                                <a class="nav-link" href="suscriber_reserved.jsp">My Reserved Books</a>
			                            </li>	
                            	<%	}
                            	}
                            %>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
	</body>
</html>
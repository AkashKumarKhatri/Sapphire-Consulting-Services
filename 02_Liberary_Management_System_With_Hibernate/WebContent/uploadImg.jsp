<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {

		$("#btnSubmit").click(function(event) {

			//stop submit the form, we will post it manually.
			event.preventDefault();

			// Get form
			var form = $('#fileUploadForm')[0];

			// Create an FormData object 
			var data = new FormData(form);

			// If you want to add an extra field for the FormData
			/* data.append("CustomField", "This is some extra data, testing"); */
			data.append("name", $("#name").val());
			data.append("middle", $("#middle").val());
			data.append("last", $("#last").val());

			// disabled the submit button
			$("#btnSubmit").prop("disabled", true);

			$.ajax({
				type : "POST",
				enctype : 'multipart/form-data',
				url : "UploadDemo",
				data : data,
				processData : false,
				contentType : false,
				cache : false,
				timeout : 600000,
				success : function(data) {

					$("#result").text(data);
					console.log("SUCCESS : ", data);
					$("#btnSubmit").prop("disabled", false);

				},
				error : function(e) {

					$("#result").text(e.responseText);
					console.log("ERROR : ", e);
					$("#btnSubmit").prop("disabled", false);

				}
			});

		});

	});
</script>
</head>
<body>
	<h1>jQuery Ajax submit Multipart form</h1>

	<form id="fileUploadForm">
		<input type="text" name="extraField" id="name" /><br />
		<input type="text" name="extraFiel" id="middle" /><br />
		<input type="text" name="extraFied" id="last" /><br />
		<!-- <br /> <input type="file" name="files" /><br /> -->
		<br /> <input type="file" name="files" /><br />
		<br /> <button type="submit" value="Submit" id="btnSubmit">Submit</button>
	</form>

	<h1>Ajax Post Result</h1>
	<span id="result"></span>
</body>
</html>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet" type="text/css" href="vendors/css/grid.css">
<link rel="stylesheet" type="text/css" href="vendors/css/normalize.css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i"
	rel="stylesheet">
</head>

<body>
	<header>
		<jsp:include page="includes/navLibrarian.html"></jsp:include>
	</header>
	<section class="section-home section-librarian-home">
		<div class="row home-box">
			<h2>Add Book Form</h2>
			<form action="issueBook" method="post">
				<div class="col span-1-of-3">
					<div class="row">
						<label for="callNo">Book CallNo</label>
					</div>
					<div class="row">
						<label for="studentId">Student ID</label>
					</div>
					<div class="row">
						<label for="studentName">Student Name</label>
					</div>
					<div class="row">
						<label for="studentMobile">Student Mobile</label>
					</div>
				</div>
				<div class="col span-2-of-3">
					<div class="row">
						<input type="text" name="callNo" id="callNo"
							placeholder="Book CallNo">
					</div>
					<div class="row">
						<input type="text" name="studentId" id="studentId"
							placeholder="Student ID">
					</div>
					<div class="row">
						<input type="text" name="studentName" id="studentName"
							placeholder="Student Name">
					</div>
					<div class="row">
						<input type="text" name="studentMobile" id="studentMobile"
							placeholder="Student Mobile">
					</div>
				</div>
				<div class="row button-row">
					<div class="row">
						<button type="submit" class="btn">Issue Book</button>
					</div>
				</div>
				<c:if test="${requestScope.issueBookMessage != null }">
					<div class="row message">
						<p>${requestScope.issueBookMessage }
					</div>
				</c:if>
			</form>
		</div>
	</section>

	<jsp:include page="includes/footer.html"></jsp:include>
</body>
</html>
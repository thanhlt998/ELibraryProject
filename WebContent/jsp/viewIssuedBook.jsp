<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<section class="section-view section-book-view">
		<h2>View all Books</h2>
		<div class="row">
			<table>
				<tr>
					<th>CallNo</th>
					<th>Student ID</th>
					<th>Student Name</th>
					<th>Student Mobile</th>
					<th>Issued Date</th>
					<th>Return Status</th>
				</tr>
				<c:if test="${requestScope.issuedBooks != null }">
					<c:forEach items="${requestScope.issuedBooks }" var="issuedBook">
						<tr>
							<td>${issuedBook.callNo }</td>
							<td>${issuedBook.studentId }</td>
							<td>${issuedBook.studentName }</td>
							<td>${issuedBook.studentMobile }</td>
							<td><fmt:formatDate value="${issuedBook.issuedDate }" pattern="yyyy-MM-dd"/></td>
							<td>${issuedBook.returnStatus }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</section>
	<jsp:include page="includes/footer.html"></jsp:include>
</body>
</html>
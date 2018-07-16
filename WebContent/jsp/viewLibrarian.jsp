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
		<jsp:include page="includes/navAdmin.html"></jsp:include>
	</header>
	<section class="section-view section-librarian-view">
		<h2>View all librarians</h2>
		<div class="row">
			<form action="deleteLibrarian" method="post">
				<table>
					<tr>
						<th></th>
						<th>ID</th>
						<th>Username</th>
						<th>Name</th>
						<th>Email</th>
						<th>Password</th>
						<th>Mobile</th>
					</tr>
					<c:if test="${requestScope.librarians != null}">
						<c:forEach items="${requestScope.librarians}" var="librarian">
							<tr>
								<td><input type="checkbox" name="id"
									value="${librarian.id }"></td>
								<td><a href="editLibrarianProfileForm?id=${librarian.id}">${librarian.id}</a></td>
								<td>${librarian.username}</td>
								<td>${librarian.name }</td>
								<td>${librarian.email }</td>
								<td>${librarian.password }</td>
								<td>${librarian.mobile }</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<div class="row button-row">
					<button type="submit" class="btn">Delete</button>
				</div>

				<c:if test="${requestScope.deleteLibrarianMessage != null }">
					<div class="row message">
						<p>${requestScope.deleteLibrarianMessage}</p>
					</div>
				</c:if>
			</form>
		</div>
	</section>

	<jsp:include page="includes/footer.html"></jsp:include>
</body>
</html>
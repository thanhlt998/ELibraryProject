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
	<section class="section-view section-book-view">
		<h2>View all Books</h2>
		<div class="row">
			<form action="deleteBook" method="post">
				<table>
					<tr>
						<th></th>
						<th>Callno</th>
						<th>Name</th>
						<th>Author</th>
						<th>Publisher</th>
						<th>Quantity</th>
						<th>Issued</th>
					</tr>
					<c:if test="${requestScope.books != null }">
						<c:forEach items="${requestScope.books }" var="book">
							<tr>
								<td><input type="checkbox" name="callNo"
									value="${book.callNo }"></td>
								<td><a href="editBookForm?callNo=${book.callNo }">${book.callNo }</a></td>
								<td>${book.name }</td>
								<td>${book.author }</td>
								<td>${book.publisher }</td>
								<td>${book.quantity }</td>
								<td>${book.issuedBook }</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<div class="row button-row">
					<button type="submit" class="btn" id="btn">Delete</button>
				</div>
				<c:if test="${requestScope.addBookMessage != null }">
					<div class="row message">
						<p>${requestScope.addBookMessage }</p>
					</div>
				</c:if>
			</form>
		</div>
	</section>
	<jsp:include page="includes/footer.html"></jsp:include>
</body>
</html>
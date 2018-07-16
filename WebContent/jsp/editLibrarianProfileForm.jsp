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
	<section class="section-home section-admin-home">
		<div class="row home-box">
			<h2>Edit Librarian Profile</h2>
			<form action="editLibrarianProfile" method="post">
				<div class="col span-1-of-3">
					<div class="row">Username</div>
					<div class="row">
						<label for="name">New Name</label>
					</div>
					<div class="row">
						<label for="email">New Email</label>
					</div>
					<div class="row">
						<label for="password">New Password</label>
					</div>
					<div class="row">
						<label for="mobileNumber">New Mobile Number</label>
					</div>
				</div>
				<div class="col span-2-of-3">
					<div class="row line-row">
						${librarian.username } <input type="hidden" name="id"
							value="${librarian.id }"> <input type="hidden"
							name="username" value="${librarian.username }">
					</div>
					<div class="row">
						<input type="text" name="name" id="name" placeholder="Name"
							value="${librarian.name }">
					</div>
					<div class="row">
						<input type="email" name="email" id="email" placeholder="Email"
							value="${librarian.email }">
					</div>
					<div class="row">
						<input type="password" name="password" id="password"
							placeholder="Password" value="${librarian.password }">
					</div>
					<div class="row">
						<input type="text" name="mobile" id="mobile"
							placeholder="Mobile Number" value="${librarian.mobile }">
					</div>
				</div>
				<div class="row button-row">
					<div class="row">
						<button type="submit" class="btn">Save Changes</button>
					</div>
					<c:if test="${requestScope.editLibrarianProfileMessage != null }">
						<div class="row message"><p>${requestScope.editLibrarianProfileMessage }</p></div>
					</c:if>
				</div>
			</form>
		</div>
	</section>

	<jsp:include page="includes/footer.html"></jsp:include>
</body>
</html>
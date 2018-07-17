<!DOCTYPE html>
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
		<jsp:include page="includes/navHome.html"></jsp:include>
	</header>

	<section class="section-login-form">
		<div class="row">
			<h2>Librarian Login</h2>
			<div class="form-box">
				<form action="librarianLogin" method="post">
					<label for="username">Username</label><br> <input type="text"
						name="username" id="username"><br> <label
						for="password">Password</label><br> <input type="password"
						name="password" id="password"><br>
					<div class="row button-row">
						<button type="submit" class="btn">Login</button>
					</div>
				</form>
			</div>
		</div>
	</section>
	<jsp:include page="includes/footer.html"></jsp:include>
</body>
</html>
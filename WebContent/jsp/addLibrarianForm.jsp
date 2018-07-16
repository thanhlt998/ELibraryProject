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
		<jsp:include page="includes/addLibrarianForm.jsp"></jsp:include>
		
	</section>
	
	<jsp:include page="includes/footer.html"></jsp:include>
</body>
</html>
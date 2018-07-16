<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css">
        <link rel="stylesheet" type="text/css" href="vendors/css/grid.css">
        <link rel="stylesheet" type="text/css" href="vendors/css/normalize.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i" rel="stylesheet">
    </head>
    
    <body>
        <header>
            <jsp:include page="includes/navHome.html"></jsp:include>
        </header>
        
        <section class="section-form">
            <div class="row">
                <div class="col span-1-of-2">
                    <div class="form-box">
                        <h2>Admin Login</h2>
                        <form action="adminLogin" method="post">
                            <label for="adminEmail">Email address</label><br>
                            <input type="email" name="adminEmail" id="adminEmail"><br>
                            <label for="adminPassword">Password</label><br>
                            <input type="password" name="adminPassword" id="adminPassword"><br>
                            <div class="row button-row"><button type="submit" class="btn">Login</button></div>
                        </form>
                    </div>
                </div>
                
                <div class="col span-1-of-2">
                    <div class="form-box">
                        <h2>Librarian Login</h2>
                        <form action="librarianLogin" method="post">
                            <label for="username">Username</label><br>
                            <input type="text" name="username" id="username"><br>
                            <label for="password">Password</label><br>
                            <input type="password" name="password" id="password"><br>
                            <div class="row button-row"><button type="submit" class="btn">Login</button></div>
                        </form>
                    </div>
                </div>
                
            </div>
        </section>
    	<jsp:include page="includes/footer.html"></jsp:include>
    </body>
</html>
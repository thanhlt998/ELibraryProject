
<div class="row home-box">
	<h2>Add Librarian Form</h2>
	<form action="addLibrarian" method="post">
		<div class="col span-1-of-3">
			<div class="row">
				<label for="username">Username</label>
			</div>
			<div class="row">
				<label for="name">Name</label>
			</div>
			<div class="row">
				<label for="email">Email Address</label>
			</div>
			<div class="row">
				<label for="password">Password</label>
			</div>
			<div class="row">
				<label for="mobileNumber">Mobile Number</label>
			</div>
		</div>
		<div class="col span-2-of-3">
			<div class="row">
				<input type="text" name="username" id="username"
					placeholder="Username" required="required">
			</div>
			<div class="row">
				<input type="text" name="name" id="name" placeholder="Name" required="required">
			</div>
			<div class="row">
				<input type="email" name="email" id="email" placeholder="Email" required="required">
			</div>
			<div class="row">
				<input type="password" name="password" id="password"
					placeholder="Password" required="required">
			</div>
			<div class="row">
				<input type="text" name="mobileNumber" id="mobileNumber"
					placeholder="Mobile Number" required="required">
			</div>
		</div>
		<div class="row button-row">
			<div class="row">
				<button type="submit" class="btn">Add</button>
			</div>
			<%if(request.getAttribute("addLibrarianMessage") != null) {%>
			<div class="row message">
				<p><%=request.getAttribute("addLibrarianMessage")%></p>
			</div>
			<%} %>
		</div>
	</form>
</div>

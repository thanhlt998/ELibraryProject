
<div class="row home-box">
	<h2>Add Book Form</h2>
	<form action="addBook" method="post">
		<div class="col span-1-of-3">
			<div class="row">
				<label for="callno">Callno</label>
			</div>
			<div class="row">
				<label for="name">Name</label>
			</div>
			<div class="row">
				<label for="author">Author</label>
			</div>
			<div class="row">
				<label for="publisher">Publisher</label>
			</div>
			<div class="row">
				<label for="quantity">Quantity</label>
			</div>
		</div>
		<div class="col span-2-of-3">
			<div class="row">
				<input type="text" name="callno" id="callno" placeholder="Callno" required="required">
			</div>
			<div class="row">
				<input type="text" name="name" id="name" placeholder="Name" required="required">
			</div>
			<div class="row">
				<input type="text" name="author" id="author" placeholder="Author" required="required">
			</div>
			<div class="row">
				<input type="text" name="publisher" id="publisher"
					placeholder="Publisher" required="required">
			</div>
			<div class="row">
				<input type="text" name="quantity" id="quantity"
					placeholder="Quantity" required="required">
			</div>
		</div>
		<div class="row button-row">
			<div class="row">
				<button type="submit" class="btn">Add Book</button>
			</div>
			<%if(request.getAttribute("addBookMessage") != null) {%>
			<div class="row message">
				<p><%=request.getAttribute("addBookMessage")%></p>
			</div>
			<%} %>
		</div>
	</form>
</div>

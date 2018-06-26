<%@include file="header.jsp"%>
		<form action="login" method="post">
			<p>
				<label>
					<b>Email Id</b>
				</label>
				<input type="text" placeholder="Enter Email Id" name="emailId"
					required>
			</p>
			<p>
				<label>
					<b>Password</b>
				</label>
				<input type="password" placeholder="Enter Password" name="password"
					required>
			</p>
			<p>
				<button type="submit">
					Login
				</button>
				<label>
					<input type="checkbox" checked="checked" name="rem" value="rem">
					Remember me
				</label>
				<a href="showforgot.htm">Forgot Password</a>
			</p>
		</form>
	<%@include file="footer.jsp"%>
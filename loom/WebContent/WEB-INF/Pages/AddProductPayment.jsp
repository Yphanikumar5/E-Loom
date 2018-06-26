<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<fmt:setLocale value="EN"/>
<fmt:bundle basename="com.my.ApplicationResources">

<html>
	<head>
		<title>
		<fmt:message key="lbl.addProductPayment"/>
		</title>
	
	</head>		
	<body>
	<form action="addProductPayment" method="post">
	
	
		<label>
		<fmt:message key="lbl.productType"/>
		</label>
		<input type="text" name="productType" id="productType">
		
		
		<label>
			<fmt:message key="lbl.amount"/>
		</label>
		<input type="text" name="amount" id="amount">
		
		
		<label>
			<fmt:message key="lbl.status"/>
		</label>
		<input type="text" name="status" id="status">
		
		<input type="submit" value="<fmt:message key='btn.addProductPayment'/>"/>
	</form>
	
	</body>


</html>
</fmt:bundle>
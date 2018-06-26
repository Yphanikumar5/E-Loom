<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<fmt:setLocale value="EN"/>
<fmt:bundle basename="com.my.ApplicationResources">

<html>
	<head>
		<title>
		<fmt:message key="lbl.addProductReturn"/>
		</title>
	
	</head>		
	<body>
	<form action="addProductReturn" method="post">
	
	
		<label>
		<fmt:message key="lbl.productId"/>
		</label>
		<input type="text" name="productId" id="productId">
		
		
		<label>
		<fmt:message key="lbl.customerId"/>
		</label>
		<input type="text" name="customerId" id="customerId">
		
		<label>
		<fmt:message key="lbl.salesId"/>
		</label>
		<input type="text" name="salesId" id="salesId">
		
		
		<label>
			<fmt:message key="lbl.quantity"/>
		</label>
		<input type="text" name="quantity" id="quantity">
		
		
		<label>
			<fmt:message key="lbl.status"/>
		</label>
		<input type="text" name="status" id="status">
		
		<input type="submit" value="<fmt:message key='btn.addProductReturn'/>"/>
	</form>
	
	</body>


</html>
</fmt:bundle>
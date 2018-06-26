<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<fmt:setLocale value="EN"/>
<fmt:bundle basename="com.my.ApplicationResources">

<html>
	<head>
		<title>
		<fmt:message key="lbl.addMerchantPayment"/>
		</title>
	
	</head>		
	<body>
	<form action="addMerchantPayment" method="post">
	
	
		<label>
		<fmt:message key="lbl.paymentId"/>
		</label>
		<input type="text" name="paymentId" id="paymentId">
		
		
		<label>
			<fmt:message key="lbl.amount"/>
		</label>
		<input type="text" name="amount" id="amount">
		
		
		<label>
			<fmt:message key="lbl.status"/>
		</label>
		<input type="text" name="status" id="status">
		
		
		<input type="submit" value="<fmt:message key='btn.addMerchantPayment'/>"/>
	</form>
	
	</body>


</html>
</fmt:bundle>
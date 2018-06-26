<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="adminheader.jsp" %>

<fmt:setLocale value="EN"/>
<fmt:bundle basename="com.my.ApplicationResources">

<form action="addCustomerPayment" method="post">

<label>
	<fmt:message key="lbl.customerId"/>
</label>
<input type="text" name="customerId" id="customerId">

<label>
	<fmt:message key="lbl.amount"/>
</label>
<input type="text" name="amount" id="amount">


<input type="submit" value=<fmt:message key='btn.addCustomerPayment'/>/>
</form>


</fmt:bundle>
<%@include file="adminfooter.jsp" %>

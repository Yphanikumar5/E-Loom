<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="adminheader.jsp" %>


<fmt:bundle basename="com.my.ApplicationResources">

		<form action="addMerchant" method="post">
		
			<label>
				<fmt:message key="lbl.customerName"/>
			</label>
			<input type="text" name="merchantName" id="merchantName">
		
			
			<label>
				<fmt:message key="lbl.merchantPhoto"/>
			</label>
			<input type="text" name="merchantPhoto" id="merchantPhoto">	
			
			<label>
				<fmt:message key="lbl.address"/>
			</label>
			<input type="text" name="address" id="address">	
			
			
			<label>
				<fmt:message key="lbl.mobileNumber"/>
			</label>
			<input type="text" name="mobileNumber" id="mobileNumber">	
			
			
			<label>
				<fmt:message key="lbl.accountNumber"/>
			</label>
			<input type="text" name="accountNumber" id="accountNumber">	
			
			<label>
				<fmt:message key="lbl.ifscCode"/>
			</label>
			<input type="text" name="ifscCode" id="ifscCode">	
			
			<label>
				<fmt:message key="lbl.bankName"/>
			</label>
			<input type="text" name="bankName" id="bankName">	
			
			
			<label>
				<fmt:message key="lbl.status"/>
			</label>
			<input type="text" name="status" id="status">	
			
			
			
			
			
			<input type="submit" value="<fmt:message key='btn.addMerchant'/>"/>	
		
		</form>
	
	
</fmt:bundle>

<%@include file="adminfooter.jsp" %>

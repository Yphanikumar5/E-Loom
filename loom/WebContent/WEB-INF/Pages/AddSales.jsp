<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="adminheader.jsp" %>
<script type="text/javascript" src="js/ajax/jquery.min.js">
 		 </script>
 		 
 <script type="text/javascript">
	$(document).ready(function() {
	
	
	$('#customerId').blur(
		function(event) {
		
			var customerId = $('#customerId').val();
			
			if(customerId=="")
			{
				
				return false;
			}
			
			var data = 'cid='
					+ encodeURIComponent(customerId);
					
			$.ajax({
				url : "checkcustomer.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
					$("#customerName").val(response.customerName);
					$("#address").val(response.address);
					$("#mobileNumber").val(response.mobileNumber);
				
				},
				error : function(xhr, status, error) {
					alert("error");
				}
			});
			return false;
		});
	
	
	});
	</script>

<fmt:setLocale value="EN"/>
<fmt:bundle basename="com.my.ApplicationResources">

	<form action="addSales" method="post">
	
	
		<label>
		<fmt:message key="lbl.productId"/>
		</label>
		<input type="text" name="productId" id="productId">
		
		
		<label>
		<fmt:message key="lbl.customerId"/>
		</label>
		<input type="text" name="customerId" id="customerId">
		
		<label>
		<fmt:message key="lbl.price"/>
		</label>
		<input type="text" name="price" id="price">
		
		
		<label>
			<fmt:message key="lbl.quantity"/>
		</label>
		<input type="text" name="quantity" id="quantity">
		
		
		<label>
			<fmt:message key="lbl.status"/>
		</label>
		<input type="text" name="status" id="status">
		
		<input type="submit" value="<fmt:message key='btn.addSales'/>"/>
	</form>
	
</fmt:bundle>

<%@include file="adminfooter.jsp" %>

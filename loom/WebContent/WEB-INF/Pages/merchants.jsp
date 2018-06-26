<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="adminheader.jsp" %>


<fieldset>
	<table>
		<tr>
			<td>
			SNo
			</td>
			<td>
			Merchant Name
			</td>
			<td>
			Merchant Photo
			</td>
			<td>
			Address
			</td>
			<td>
			Mobile Number
			</td>
			<td>
			Aadhar Number
			</td>
			<td>
			Account Number
			</td>
			<td>
			IFSC Code
			</td>
			<td>
			Bank Name
			</td>
			
			<td>
			Status
			</td>
			<td>
			CreatedOn
			</td>
			
		
		</tr>
		
		<c:forEach items="${requestScope.merchants}" var="merchant" varStatus="st">
		<tr>
			<td>
				${st.count }
			</td>
			<td>
				${merchant.merchantName }
			</td>
			<td>
				${merchant.merchantPhoto }
			</td>
			<td>
				${merchant.address }
			</td>
			<td>
				${merchant.mobileNumber }
			</td>
			<td>
				${merchant.aadharNumber }
			</td>
			<td>
				${merchant.accountNumber }
			</td>
			<td>
				${merchant.ifscCode }
			</td>
			<td>
				${merchant.bankName }
			</td>
			
			<td>
				${merchant.status }
			</td>
			<td>
				${merchant.createdOn }
			</td>
		
		
		</tr>
		
		
		</c:forEach>
	
	
	
	</table>
	
	
	
	
	

</fieldset>
<%@include file="adminfooter.jsp" %>

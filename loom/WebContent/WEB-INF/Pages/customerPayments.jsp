<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="adminheader.jsp" %>

<fieldset>

	<table>
		<tr>
			<td>
			SNo
			</td>
			<td>
			Amount
			</td>
			<td>
			Status
			</td>
			<td>
			CreatedOn
			</td>
			
		</tr>
		<c:forEach items="${requestScope.customerPayments}" var="customerPayment" varStatus="st">
			<tr>
				<td>
				${st.count }
				</td>
				
				<td>
				${customerPayment.amount }
				</td>
				<td>
				${customerPayment.status }
				</td>
				<td>
				${customerPayment.createdOn }
				</td>
				
			</tr>
		
		
		</c:forEach>
		
	
	
	</table>




</fieldset>
<%@include file="adminfooter.jsp" %>

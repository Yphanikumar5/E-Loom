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
		<c:forEach items="${requestScope.merchantPayments}" var="merchantPayment" varStatus="st">
			<tr>
				<td>
				${st.count }
				</td>
				
				<td>
				${merchantPayment.amount }
				</td>
				<td>
				${merchantPayment.status }
				</td>
				<td>
				${merchantPayment.createdOn }
				</td>
				
			</tr>
		
		
		</c:forEach>
		
	
	
	</table>




</fieldset>
<%@include file="adminfooter.jsp" %>

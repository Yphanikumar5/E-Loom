<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<fieldset>

	<table>
		<tr>
			<td>
			SNo
			</td>
			<td>
			Quantity
			</td>
			<td>
			Status
			</td>
			<td>
			CreatedOn
			</td>
			
		</tr>
		<c:forEach items="${requestScope.productReturns}" var="productReturn" varStatus="st">
			<tr>
				<td>
				${st.count }
				</td>
				
				<td>
				${productReturn.quantity }
				</td>
				<td>
				${productReturn.status }
				</td>
				<td>
				${productReturn.createdOn }
				</td>
				
			</tr>
		
		
		</c:forEach>
		
	
	
	</table>




</fieldset>
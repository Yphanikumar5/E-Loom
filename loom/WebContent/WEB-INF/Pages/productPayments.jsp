<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<fieldset>

	<table>
		<tr>
			<td>
			SNo
			</td>
			<td>
			ProductType
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
		<c:forEach items="${requestScope.productPayments}" var="productPayment" varStatus="st">
			<tr>
				<td>
				${st.count }
				</td>
				<td>
				${productPayment.productType }
				</td>
				<td>
				${productPayment.amount }
				</td>
				<td>
				${productPayment.status }
				</td>
				<td>
				${productPayment.createdOn }
				</td>
				
			</tr>
		
		
		</c:forEach>
		
	
	
	</table>




</fieldset>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<style>
.ctextbox {
	background-color: #C1C1C1;
}

.btn-lableinfo {
	color: #fff;
	background-color: #5B9BD5;
	border-color: #5B9BD5;
}

.lbl-lableinfo {
	color: #fff;
	background-color: #5B9BD5;
	border-color: #5B9BD5;
}

.btn-titlelableinfo {
	color: #292424;
	background-color: #F0AD4E;
	border-color: #F0AD4E;
	padding: 6px 35px;
}

.table-bordered {
	border: 1px solid #28137B;
}

.table-bordered>tfoot>tr>td {
	border: 1px solid #ddd;
}

tr {
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
}

.table-striped>tbody>tr:nth-child(odd)>td,.table-striped>tbody>tr:nth-child(odd)>th
	{
	background-color: #CFDEEA;
}

.table-striped>tbody>tr:nth-child(even)>td,.table-striped>tbody>tr:nth-child(even)>th
	{
	background-color: rgb(232, 241, 249);;
}

.table-bordered>tbody>tr>td,.table-bordered>tbody>tr>th,.table-bordered>tfoot>tr>td,.table-bordered>tfoot>tr>th,.table-bordered>thead>tr>td,.table-bordered>thead>tr>th
	{
	border: 2px solid #FFF;
}
</style>



<%@include file="adminheader.jsp"%>

<!-- row  -->
<div class="row">


	<div class="col-xs-8 col-md-8" align="center">
		<div class="form-group">
			<button type="button"
				class="btn btn-lableinfo btn-pressure btn-sensitive">
				&nbsp;&nbsp;&nbsp; Customers&nbsp;&nbsp;&nbsp;
			</button>
		</div>

	</div>

</div>
<!-- end row -->
<c:if test="${requestScope.customers ne null}">
	<!-- row  -->
	<div class="row">
		<div class="col-md-9">
			<div id="no-more-tables">
				<table
					class="col-md-9 table-bordered table-striped table-condensed cf">

					<tr>
						<td>
							SNo
						</td>
						<td>
							Customer Name
						</td>
						<td>
							Customer Photo
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
							Status
						</td>
						<td>
							CreatedOn
						</td>


					</tr>

					<c:forEach items="${requestScope.customers}" var="customer"
						varStatus="st">
						<tr>
							<td>
								${st.count }
							</td>
							<td>
								${customer.customerName }
							</td>
							<td>
								${customer.customerPhoto }
							</td>
							<td>
								${customer.address }
							</td>
							<td>
								${customer.mobileNumber }
							</td>
							<td>
								${customer.aadharNumber }
							</td>
							
							<td>
								${customer.status }
							</td>
							<td>
								${customer.createdOn }
							</td>


						</tr>


					</c:forEach>



				</table>





			</div>
		</div>
	</div>
	<!-- end row  -->
</c:if>
<%@include file="adminfooter.jsp"%>






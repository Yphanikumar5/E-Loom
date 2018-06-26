<br><%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="adminheader.jsp"%>


<fmt:bundle basename="${sessionScope.lan }">

	<form action="updatecustomer.htm" method="post">
		<c:forEach>
			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.customerName" />
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="customerName" id="customerName"
							value="${requestScope.customer.customerName }">
					</div>

				</div>

			</div>
			<!-- end row -->

			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.customerPhoto" />
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="customerPhoto" id="customerPhoto"
							value="${requestScope.customer.customerPhoto }">
					</div>

				</div>

			</div>
			<!-- end row -->

			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						Customer Type
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="customerType" id="customerType"
							value="${requestScope.customer.customerType }">
					</div>

				</div>

			</div>
			<!-- end row -->

			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.address" />
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="address" id="address"
							value="${requestScope.customer.address }">
					</div>

				</div>

			</div>
			<!-- end row -->


			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.mobileNumber" />
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="mobileNumber" id="mobileNumber"
							value="${requestScope.customer.mobileNumber }">
					</div>

				</div>

			</div>
			<!-- end row -->
			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.aadharNumber" />
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="aadharNumber" id="aadharNumber"
							value="${requestScope.customer.aadharNumber }">
					</div>

				</div>

			</div>
			<!-- end row -->
			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.status" />
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="status" id="status"
							value="${requestScope.customer.status }">

					</div>

				</div>

			</div>
			<!-- end row -->



			<input type="submit" value="update" />
			<input type="hidden" value="${requestScope.customer.customerId }"
				name="customerId" />
		</c:forEach>
	</form>


</fmt:bundle>

<%@include file="adminfooter.jsp"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="adminheader.jsp"%>


<fmt:setLocale value="EN" />
<fmt:bundle basename="com.my.ApplicationResources">

	<form action="updateproduct.htm" method="post">
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Employee
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<select name="empId">
						<option value="">
							Select Employee
						</option>
						<c:forEach items="${emps}" var="emp">
							<option value="${emp.empId}">
								${emp.empname }|${emp.empType} |${emp.mobileNumber }
							</option>
					</select>
				</div>

			</div>

		</div>
		<!-- end row -->

		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.productType" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="productType" id="productType"
						value="${requestScope.product.productType }">

				</div>

			</div>

		</div>
		<!-- end row -->


		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.productName" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="productName" id="productName"
						value="${requestScope.product.productName }">
				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.price" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="price" id="price"
						value="${requestScope.product.price }">
				</div>

			</div>

		</div>
		<!-- end row -->

		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.quantity" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="quantity" id="quantity"
						value="${requestScope.product.quantity }">
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
						value="${requestScope.product.status }">
				</div>

			</div>

		</div>
		<!-- end row -->
		<input type="submit" value="update" />
		<input type="hidden" value="${requestScope.product.productId }"
			name="productId">

		</c:forEach>
	</form>

</fmt:bundle>

<%@include file="adminfooter.jsp"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="adminheader.jsp"%>

<fmt:bundle basename="${sessionScope.lan }">

	<form action="addCustomer" method="post">

		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.customerName" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="customerName" id="customerName">
				</div>

			</div>

		</div>
		<!-- end row -->

		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.customerPhoto" />
					</fmt:message>
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="customerPhoto" id="customerPhoto">
				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.address" />
					</fmt:message>
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="address" id="address">
				</div>

			</div>

		</div>
		<!-- end row -->

		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.mobileNumber" />
					</fmt:message>
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="mobileNumber" id="mobileNumber">
				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.aadharNumber" />
					</fmt:message>
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="aadharNumber" id="aadharNumber">
				</div>

			</div>

		</div>
		<!-- end row -->

		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.status" />
					</fmt:message>
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="status" id="status">

				</div>

			</div>

		</div>
		<!-- end row -->



		<input type="submit" value="<fmt:message key='btn.addCustomer'/>" />

	</form>


</fmt:bundle>
<br>
<%@include file="adminfooter.jsp"%>


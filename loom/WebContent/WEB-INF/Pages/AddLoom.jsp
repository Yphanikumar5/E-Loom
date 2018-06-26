<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="adminheader.jsp"%>


<fmt:setLocale value="EN" />
<fmt:bundle basename="${sessionScope.lan }">

	<form action="addloom.htm" method="post">

		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.loomNo" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="loomNo" id="loomNo">
				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.loomAddress" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="loomAddress" id="loomAddress">
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
					<input type="text" name="status" id="status">
				</div>

			</div>

		</div>
		<!-- end row -->

		<input type="submit" value="<fmt:message key='btn.addLoom'/>" />
	</form>


</fmt:bundle>
<%@include file="adminfooter.jsp"%>

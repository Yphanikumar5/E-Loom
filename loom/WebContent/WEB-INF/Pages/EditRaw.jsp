<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="adminheader.jsp"%>


<fmt:setLocale value="EN" />
<fmt:bundle basename="com.my.ApplicationResources">

	<form action="updateraw.htm" method="post">

		<c:forEach>

			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.materialName" />
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="materialName" id="materialName"
							value="${requestScope.raw.materialName }">
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
							value="${requestScope.raw.price }">
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
							value="${requestScope.raw.status }">
					</div>

				</div>

			</div>
			<!-- end row -->
			<input type="submit" value="update" />
			<input type="hidden" value="${requestScope.raw.rawId }" name="rawId">

		</c:forEach>
	</form>

</fmt:bundle>

<%@include file="adminfooter.jsp"%>

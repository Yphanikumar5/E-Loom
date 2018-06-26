<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="adminheader.jsp"%>


<fmt:setLocale value="EN" />
<fmt:bundle basename="${sessionScope.lan }">

	<form action="addLoomRaw.htm" method="post">


		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Loom
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<select name="loomId">
						<option value="">
							Select loom
						</option>
						<c:forEach items="${looms}" var="loom">
							<option value="${loom.loomId}">
								${loom.loomNo }|${loom.loomAddress }
							</option>
						</c:forEach>
					</select>
				</div>

			</div>

		</div>
		<!-- end row -->


		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Raw
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<select name="rawId">
						<option value="">
							Select Raw
						</option>
						<c:forEach items="${raws}" var="raw">
							<option value="${raw.rawId }">
								${raw.materialName }|${raw.price}
						</c:forEach>

					</select>

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
					<input type="text" name="quantity" id="quantity">
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

		<input type="submit" value="<fmt:message key='btn.addLoomRaw'/>" />
	</form>


</fmt:bundle>


<%@include file="adminfooter.jsp"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="adminheader.jsp"%>
 <script type="text/javascript" src="js/ajax/jquery.min.js">
 		 </script>
 		 
 <script type="text/javascript">
	$(document).ready(function() {
		
	$('#empId').change(
		function(event) {
		
			var empId = $('#empId').val();
			
				
			if(empId=="")
			{
				
				return false;
			}
			
			var data = 'empId='
					+ encodeURIComponent(empId);
					
			$.ajax({
				url : "getempamount.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				  
					$("#balanceAmount").val(response.balanceAmount);
					$("#paidAmount").val(response.paidAmount);
					$("#totalAmount").val(response.totalAmount);
				
				},
				error : function(xhr, status, error) {
					alert("error");
				}
			});
			return false;
		});
	
	
	});
	</script>

<fmt:setLocale value="EN" />
<fmt:bundle basename="${sessionScope.lan }">


	<form action="addadvance.htm" method="post">


		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Employee
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<select name="empId" id="empId">
						<option value="">
							select Employee
						</option>
						<c:forEach items="${requestScope.emps}" var="emp">
							<option value="${emp.empId }">
								${emp.empName } ${emp.empType }
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
					Total Amount
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="totalAmount" id="totalAmount" readonly="readonly">
				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Paid Amount
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="paidAmount" id="paidAmount" readonly="readonly">
				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Due Amount
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="balanceAmount" id="balanceAmount" readonly="readonly">
				</div>

			</div>

		</div>
		<!-- end row -->
		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.amount" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="amount" id="amount">
				</div>

			</div>

		</div>
		<!-- end row -->
		
		<input type="submit" value="<fmt:message key='btn.addAdvance'/>" />
	</form>


</fmt:bundle>
<%@include file="adminfooter.jsp"%>


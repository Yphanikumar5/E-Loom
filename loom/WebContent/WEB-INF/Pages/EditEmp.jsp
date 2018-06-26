<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="adminheader.jsp"%>

<fmt:bundle basename="com.my.ApplicationResources">

	<form action="updateemp.htm" method="post">

	
			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.empType" />
						
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
					<select name="empType">
						<option value="${requestScope.emp.empType }">${requestScope.emp.empType }</option>
						<option value="weaver">
							Weaver
						</option>
						<option value="mechanic">
							Mechanic
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
						<fmt:message key="lbl.empName" />
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="empName" id="empName"
							value="${requestScope.emp.empName }">

					</div>

				</div>

			</div>
			<!-- end row -->
			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.photo" />
						
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						
								<input type="hidden" name="photo" id="photo" value="${requestScope.emp.photo }">
						
						<label class="cabinet"> 
		<input type="file" id="image" name="image"  class="file">
 	</label>
	<img alt="" src="${requestScope.emp.photo }" id="iproductimage" height="90" width="90"><br>
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
							value="${requestScope.emp.address }">
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
							value="${requestScope.emp.mobileNumber }">
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
							value="${requestScope.emp.aadharNumber }">
					</div>

				</div>

			</div>
			<!-- end row -->
			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.accountNumber" />
						
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="accountNumber" id="accountNumber"
							value="${requestScope.emp.accountNumber }">
					</div>

				</div>

			</div>
			<!-- end row -->
			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.ifscCode" />
						
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="ifscCode" id="ifscCode"
							value="${requestScope.emp.ifscCode }">
					</div>

				</div>

			</div>
			<!-- end row -->
			<!-- row  -->
			<div class="row">

				<div class="col-xs-5 col-md-2" align="right">
					<label for="concept" class="col-md-2 control-label-left">
						<fmt:message key="lbl.bankName" />
						
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="bankName" id="bankName"
							value="${requestScope.emp.bankName }">
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
						
							
							<select name="status">
						<option value="${requestScope.emp.status }">${requestScope.emp.status }</option>
						<option value="Active">
							Active
						</option>
						<option value="Deactive">
							Deactive
						</option>
					</select>
							
							
							

					</div>

				</div>

			</div>
			<!-- end row -->

	

		<input type="submit" value="update" />
		<input type="hidden" value="${requestScope.emp.empId }" name="empId">

	</form>


</fmt:bundle>

<%@include file="adminfooter.jsp"%>
<script>
$(document).ready(function(){


  $("#image").on('change',prepareLoad1);
  var files;
  function prepareLoad1(event)
  {
	  
      console.log(' event fired'+event.target.files[0].name);
     
      files=event.target.files;
     // alert(files);
      processFileUpload1();
      
  }
  function processFileUpload1()
  {
      console.log("fileupload clicked");
      var oMyForm = new FormData();
     
      oMyForm.append("file", files[0]);
     
     $
        .ajax({
            url : "${pageContext.request.contextPath}/fileupload",
            data : oMyForm,
            type : "POST",
            enctype: 'multipart/form-data',
            processData: false, 
            contentType:false,
            success : function(result) {
            	
            	$("#photo").val(result);
            	$("#iproductimage").attr("src",result);
          
            },
            error : function(result){
                alert('error'+JSON.stringify(result));
            }
        });
  }
});
</script>

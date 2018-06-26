<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="adminheader.jsp"%>


<fmt:bundle basename="${sessionScope.lan }">
	<div>

		<form action="addemp.htm" method="post">
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
						<input type="text" name="empName" id="empName">
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
						<input type="hidden" name="photo" id="photo">
						
						<label class="cabinet"> 
		<input type="file" id="image" name="image"  class="file"	 required>
 	</label>
	<img alt="" src="" id="iproductimage" height="90" width="90"><br>
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
						<fmt:message key="lbl.accountNumber" />
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="text" name="accountNumber" id="accountNumber">
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
						<input type="text" name="ifscCode" id="ifscCode">
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
						<input type="text" name="bankName" id="bankName">
					</div>

				</div>

			</div>
			<!-- end row -->

		




			<input type="submit" value="<fmt:message key='btn.addEmp'/>" />

		</form>
	</div>

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

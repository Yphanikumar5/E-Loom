<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="adminheader.jsp"%>
 <script type="text/javascript" src="js/ajax/jquery.min.js">
 		 </script>
 		 
 <script type="text/javascript">
	$(document).ready(function() {
	
	
	$('#customerId').blur(
		function(event) {
		
			var customerId = $('#customerId').val();
			
			if(customerId=="")
			{
				
				return false;
			}
			
			var data = 'cid='
					+ encodeURIComponent(customerId);
					
			$.ajax({
				url : "checkcustomer.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
					$("#customerName").val(response.customerName);
					$("#address").val(response.address);
					$("#mobileNumber").val(response.mobileNumber);
				
				},
				error : function(xhr, status, error) {
					alert("error");
				}
			});
			return false;
		});
	
	
	});
	</script>

<fmt:bundle basename="${sessionScope.lan }">

<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Product Type
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<select name="bproductType" id="bproductType">
						<option value="silk">
							Silk Saree
						</option>
						<option value="cotton">
							Cotton Saree
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
					<fmt:message key="lbl.quantity" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="bquantity" id="bquantity">
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
					<input type="text" name="bprice" id="bprice">
				</div>

			</div>

		</div>
		<!-- end row -->

		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.discount" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="bdiscount" id="bdiscount">
				</div>

			</div>

		</div>
		<!-- end row -->
		 <!-- row  -->
   <div class="row">
   
   <div class="col-xs-5 col-md-2" align="right">
    
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
      
<button type="button" class="btn btn-success btn-bold" id="addOrder" >Place  Order</button> 
                             
         </div>
                          
    </div>
                    
   </div>
   <!-- end row -->
	<form action="addbill.htm" method="post">
	
   
   <div id="divOrder" style="display:none">
   
<!-- row  -->
<div class="row">
        <div class="col-md-9">
   <div id="no-more-tables">
  
			<table
				class="col-md-9 table-bordered table-striped table-condensed cf">
				<thead class="cf">
					<tr>

						<th class="lbl-lableinfo" align="center">
							Item
						</th>
						
						<th class="lbl-lableinfo">
							 Price
						</th>
						<th class="lbl-lableinfo">
							Discount
						</th>
						<th class="lbl-lableinfo">
							Final Price
						</th>
						<th class="lbl-lableinfo">
							Quantity
						</th>
						<th class="lbl-lableinfo">
							Total Cost
						</th>
						<th class="lbl-lableinfo">
							
						</th>

					</tr>
				</thead>
				<tbody id="tb">


				</tbody>
			</table>
			
		</div>
		</div>
	
</div>
<!-- end row  -->
   
   <!-- row  -->
 
   <div class="row" >
   
   <div class="col-xs-5 col-md-2" align="right">
    Total Cost
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
             <input type="text" class="btn  btn-bold" id="txtTotalCost" value="0"  readonly="readonly">            
         </div>
                          
    </div>
                    
   </div>
   
   <!-- end row -->
  

		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					Select Customer
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="radio" name="customerType" value="existingcustomer"
						checked>
					Existing Customer
					<br>
					<input type="radio" name="customerType" value="newcustomer">
					New Customer
					<br>
				</div>

			</div>

		</div>
		<!-- end row -->


		<!-- row  -->
		<div class="row">

			<div class="col-xs-5 col-md-2" align="right">
				<label for="concept" class="col-md-2 control-label-left">
					<fmt:message key="lbl.customerId" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="customerId" id="customerId">
				</div>

			</div>

		</div>
		<!-- end row -->

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
						<fmt:message key="lbl.photo" />
					</label>
				</div>
				<div class="col-xs-5 col-md-6">
					<div class="form-group">
						<input type="hidden" name="customerPhoto" id="customerPhoto">
						
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
					Customer Type
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<select name="customers">
						<option value="permanentcustomer">
							Permanent Customer
						</option>
						<option value="temporarycustomer">
							Temporary Customer
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
					<fmt:message key="lbl.totalAmount" />
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
					<fmt:message key="lbl.paidAmount" />
				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<input type="text" name="paidAmount" id="paidAmount">
				</div>

			</div>

		</div>
		<!-- end row -->

 
 	<input type="submit" value="Add Bill" class="btn btn-success btn-bold" />
   </div>
	

		
	
	</form>



</fmt:bundle>
<br>

<%@include file="adminfooter.jsp"%>
<script type="text/javascript">
			$(document).ready(function(){
			
			
		
	
			
				
				$('#addOrder').click(
					function(event) {
					$('#divOrder').css("display", "block"); 
					var bproductType=$("#bproductType").val();
					var bquantity=$("#bquantity").val();
					var bprice=$("#bprice").val();
				
					
					var bdiscount=$("#bdiscount").val();
					
					
					var disAmout=bprice*bdiscount/100;
					
					var finalPrice=bprice-disAmout;
					
					var totalPrice=finalPrice*bquantity;
				
					var tcost=parseFloat($("#txtTotalCost").val())+parseFloat(totalPrice);
					
				$("#txtTotalCost").val(tcost);
				$("#totalAmount").val(tcost);
				
			
					var tbodyRows=$("#tb > tr").length;
					var isNotExist=true;
					var tableRow;
			
					for(var index=0;index<tbodyRows;index++)
					{
						
						 tableRow=$("#tb").find('tr').eq(index);
						 
						var tbproductType=tableRow.find('td').eq(0).text();
						
					
						if(bproductType==tbproductType)
						{
							
							bquantity=parseInt(bquantity)+parseInt(tableRow.find('td').eq(4).text());
							totalPrice=parseFloat(totalPrice)+parseFloat(tableRow.find('td').eq(5).text());
							isNotExist=false;
							break;
							
						}
						
						
					}
					var appendTxt = "<td>"+bproductType+"</td><td>"+bprice+"</td><td>"+bdiscount+"</td><td>"+finalPrice+"</td><td>"+bquantity+"</td><td>"+totalPrice+"</td> <td><a  onclick='deleteRow(this)'>delete</a><input type='hidden' name='productType' value='"+bproductType+"'  id='productType'/><input type='hidden' name='quantity' value='"+bquantity+"' id=quantity'/> <input type='hidden' name='price' id='price' value='"+bprice+"'/><input type='hidden' name='discount' id='discount' value='"+bdiscount+"'/></td>";
					
					if(isNotExist)
					{
						$("#tb").append("<tr>"+appendTxt+"</tr>");	
					}
					else
					{
						
						 tableRow.html(appendTxt);
					}		
				});  
				
				     
			});
			function deleteRow(obj)
			{
				var trow=$(obj).parent().parent();
				
				var amount=trow.find('td').eq(5).text();
				
				var tcost=parseFloat($("#txtTotalCost").val())-parseFloat(amount);
				$("#txtTotalCost").val(tcost);
				
				
				
				trow.remove();
				var rows=$("#tb > tr").length;
				if(rows>0)
				{
				
					$('#divOrder').css("display", "block"); 
				}
				else
				{
					
					$('#divOrder').css("display", "none"); 
				}
				
				
			}
			
			
    
   
		</script>
		
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
            	
            	$("#customerPhoto").val(result);
            	$("#iproductimage").attr("src",result);
          
            },
            error : function(result){
                alert('error'+JSON.stringify(result));
            }
        });
  }
});
</script>
		

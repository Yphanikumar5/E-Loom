<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="adminheader.jsp"%>

<fmt:setLocale value="EN" />
<fmt:bundle basename="${sessionScope.lan }">

<script type="text/javascript" src="js/ajax/jquery.min.js">
 		 </script>
 		 
 <script type="text/javascript">
	$(document).ready(function() {
	
	
	$('#billId').blur(
		function(event) {
		
			var billId = $('#billId').val();
			$('#divPay').css("display", "none"); 
			$("#tb").html("");
			$("#tbp").html("");
		
			if(billId=="")
			{
				
				return false;
			}
			
			var data = 'billId='
					+ encodeURIComponent(billId);
					
			$.ajax({
				url : "checkbill.htm",
				data : data,
				contentType: 'application/json',
   				mimeType: 'application/json',
				
				type : "GET",
 
				success : function(response) {
				
					$("#customerName").val(response.customerName);
					$("#address").val(response.address);
					$("#mobileNumber").val(response.mobileNumber);
					$("#customerPhoto").val(response.customerPhoto);
					$("#aadharNumber").val(response.aadharNumber);
					$("#icustomerPhoto").attr("src",response.customerPhoto);
					$("#customerId").val(response.customerId);
					var totCost=0;
					$.each(response.sales, function(i, sale) {
						
						var quantity=sale.quantity;
						var productType=sale.productType;
						var price=sale.price;
						var discount=sale.discount/100;
						var fp=price-discount;
						var tp=fp*quantity;
						totCost=totCost+tp;
					
						var appendTxt = "<td>"+productType+"</td><td>"+price+"</td><td>"+discount+"</td><td>"+fp+"</td><td>"+quantity+"</td><td>"+tp+"</td>";
					
						$("#tb").append("<tr>"+appendTxt+"</tr>");	
						  
					});
				$("#txtTotalCost").val(totCost);
				  
			
				  var paid=0;
				$.each(response.payments, function(i, pm) {
					
					var cdate=pm.createdOn;
					var paidAmount=pm.paidAmount;
					var date = new Date(cdate);
					paid=paid+paidAmount;
				
					var appendTxt = "<td>"+date+"</td><td>"+paidAmount+"</td>";
				
					$("#tbp").append("<tr>"+appendTxt+"</tr>");	
					  
				});
			
				var due=totCost-paid;
				$("#txtPaidAmount").val(paid);
				$("#txtDueAmount").val(due);
				if(due>0)
					{
					$('#divPay').css("display", "block"); 
					}
				
				
					
				},
				error : function(xhr, status, error) {
					alert("error");
				}
			});
			return false;
		});
	
	
	});
	</script>

<form action="addduepayment.htm" method="post">
	<!-- row  -->
	<div class="row">

		<div class="col-xs-5 col-md-2" align="right">
			<label for="concept" class="col-md-2 control-label-left">
				Bill Id
			</label>
		</div>
		<div class="col-xs-5 col-md-6">
			<div class="form-group">
				<input type="text" name="billId" id="billId">
				<input type="hidden" name="customerId" id="customerId">
				
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
					<fmt:message key="lbl.customerPhoto" />

				</label>
			</div>
			<div class="col-xs-5 col-md-6">
				<div class="form-group">
					<img  id="icustomerPhoto" height="70" width="70">
					<input type="hidden" name="customerPhoto" id="customerPhoto">
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
					<input type="text" name="address" id="address" readonly="readonly">

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
					<input type="text" name="mobileNumber" id="mobileNumber" readonly="readonly">
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
					<input type="text" name="aadharNumber" id="aadharNumber" readonly="readonly">
				</div>

			</div>

		</div>
		<!-- end row -->
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
<div>Payment History</div>
<!-- row  -->
<div class="row">
        <div class="col-md-9">
   <div id="no-more-tables">
  
			<table
				class="col-md-9 table-bordered table-striped table-condensed cf">
				<thead class="cf">
					<tr>

						<th class="lbl-lableinfo" align="center">
							Paid Date
						</th>
						
						<th class="lbl-lableinfo">
							Amount
						</th>
						
						

					</tr>
				</thead>
				<tbody id="tbp">


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
 
   <div class="row" >
   
   <div class="col-xs-5 col-md-2" align="right">
    Paid Amount
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
             <input type="text" class="btn  btn-bold" id="txtPaidAmount" value="0"  readonly="readonly">            
         </div>
                          
    </div>
   
                    
   </div>
   
   <!-- end row -->
    <!-- row  -->
 
   <div class="row" >
   
   <div class="col-xs-5 col-md-2" align="right">
    Due Amount
   </div>
   <div class="col-xs-5 col-md-6">
        <div class="form-group">
             <input type="text" class="btn  btn-bold" id="txtDueAmount" value="0"  readonly="readonly">            
         </div>
                          
    </div>
                    
   </div>
   
   <!-- end row -->
     <div id="divPay" style="display:none">
      Paid <input type="number"  id="payAmount" name="payAmount" >
     	<input type="submit" value="Add Amount" class="btn btn-success btn-bold" />
     </div>
   
   
	
</form>
</fmt:bundle>


<%@include file="adminfooter.jsp"%>

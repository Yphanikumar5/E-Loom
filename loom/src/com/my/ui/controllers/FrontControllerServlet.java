package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.service.AdminService;
import com.my.service.AdvanceService;
import com.my.service.BillService;
import com.my.service.CustomerPaymentService;
import com.my.service.CustomerService;
import com.my.service.EmpService;
import com.my.service.LoomEmpService;
import com.my.service.LoomRawService;
import com.my.service.LoomService;
import com.my.service.ProductService;
import com.my.service.RawService;
import com.my.service.SalesService;
import com.my.service.impl.AdminServiceImpl;
import com.my.service.impl.AdvanceServiceImpl;
import com.my.service.impl.BillServiceImpl;
import com.my.service.impl.CustomerPaymentServiceImpl;
import com.my.service.impl.CustomerServiceImpl;
import com.my.service.impl.EmpServiceImpl;
import com.my.service.impl.LoomEmpServiceImpl;
import com.my.service.impl.LoomRawServiceImpl;
import com.my.service.impl.LoomServiceImpl;
import com.my.service.impl.ProductServiceImpl;
import com.my.service.impl.RawServiceImpl;
import com.my.service.impl.SalesServiceImpl;
import com.my.ui.forms.AddAdvanceForm;
import com.my.ui.forms.AddBillForm;
import com.my.ui.forms.AddCustomerPaymentForm;
import com.my.ui.forms.AddEmpForm;
import com.my.ui.forms.AddLoomEmpForm;
import com.my.ui.forms.AddLoomForm;
import com.my.ui.forms.AddLoomRawForm;
import com.my.ui.forms.AddProductForm;
import com.my.ui.forms.AddRawForm;
import com.sun.org.apache.xml.internal.utils.RawCharacterHandler;

public class FrontControllerServlet extends HttpServlet {
	private EmpService empService;
	private LoomService loomService;
	private LoomEmpService loomEmpService;
	private AdvanceService advanceService;
	private ProductService productService;
	private RawService rawService;
	private LoomRawService loomRawService;
	private CustomerService customerService;
	private BillService billService;
	private SalesService salesService;
	private AdminService adminService;
	private CustomerPaymentService customerPaymentService;

	public void init() throws ServletException {
		empService = new EmpServiceImpl();
		loomService = new LoomServiceImpl();
		loomEmpService = new LoomEmpServiceImpl();
		advanceService = new AdvanceServiceImpl();
		productService = new ProductServiceImpl();
		rawService = new RawServiceImpl();
		loomRawService = new LoomRawServiceImpl();
		customerService = new CustomerServiceImpl();
		billService = new BillServiceImpl();
		salesService = new SalesServiceImpl();
		customerPaymentService = new CustomerPaymentServiceImpl();
		adminService=new AdminServiceImpl();

	}

	public void destroy() {
		empService = null;
		loomService = null;
		loomEmpService = null;
		advanceService = null;
		productService = null;
		rawService = null;
		loomRawService = null;
		customerService = null;
		billService = null;
		salesService = null;
		customerPaymentService = null;
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		
		// start Emps
		if (path.equalsIgnoreCase("/emps.htm")) {
			EmpsController empsController = new EmpsController(empService);
			empsController.handleRequest(request, response);
		}
		if (path.equalsIgnoreCase("/adminhome.htm")) {
			AdminHomeController adminHomeController = new AdminHomeController();
			adminHomeController.handleRequest(request, response);
		}


		// End Emps

		// Show addemp started
		else if (path.equalsIgnoreCase("/showaddemp.htm")) {
			ShowAddEmpControllerServlet showAddEmpControllerServlet = new ShowAddEmpControllerServlet();
			showAddEmpControllerServlet.doGet(request, response);
		}
		else if (path.equalsIgnoreCase("/showforgot.htm")) {
			ShowForgotPasswordController slc = new ShowForgotPasswordController();
			slc.handleRequest(request, response);
		} 

		// show addemp ended

		// start looms
		else if (path.equalsIgnoreCase("/showaddloom.htm")) {
			ShowAddLoomControllerServlet showAddLoomControllerServlet = new ShowAddLoomControllerServlet();
			showAddLoomControllerServlet.handleRequest(request, response);
		} else if (path.equalsIgnoreCase("/looms.htm")) {
			LoomsController loomsController = new LoomsController(loomService);
			loomsController.handleRequest(request, response);
		}

		// end looms

		// Allot Loomemp started
		else if (path.equalsIgnoreCase("/showallotloom.htm")) {
			ShowAllotLoomController showAllotLoomController = new ShowAllotLoomController(
					empService, loomService);
			showAllotLoomController.handleRequest(request, response);
		} else if (path.equalsIgnoreCase("/allotedlooms.htm")) {
			AllotedLoomsController allotedLoomsController = new AllotedLoomsController(
					loomEmpService);
			allotedLoomsController.handleRequest(request, response);
		}

		// Allot Loomemp ended

		// Advance started
		else if (path.equalsIgnoreCase("/showaddadvance.htm")) {
			ShowEmpAdvanceController showEmpAdvanceController = new ShowEmpAdvanceController(
					empService);
			showEmpAdvanceController.handleRequest(request, response);
		} else if (path.equalsIgnoreCase("/advancess.htm")) {
			AdvancesController advancesController = new AdvancesController(
					advanceService);
			advancesController.handleRequest(request, response);
		}
		else if (path.equalsIgnoreCase("/getempamount.htm")) {
			GetEmpAmountController advancesController = new GetEmpAmountController(
					advanceService);
			advancesController.handleRequest(request, response);
		}
		


		// Advance ended

		// productts started
		else if (path.equalsIgnoreCase("/showaddproduct.htm")) {
			ShowAddProductController showAddProductController = new ShowAddProductController(
					productService, empService);
			showAddProductController.handleRequest(request, response);
		}

		else if (path.equalsIgnoreCase("/products.htm")) {
			ProductsController productsController = new ProductsController(
					productService);
			productsController.handleRequest(request, response);
		}

		// products ended

		// raw started
		else if (path.equalsIgnoreCase("/showaddraw.htm")) {
			ShowAddRawController showAddRawController = new ShowAddRawController(
					rawService);
			showAddRawController.handleRequest(request, response);
		}

		else if (path.equalsIgnoreCase("/raws.htm")) {
			RawsController rawsController = new RawsController(rawService);
			rawsController.handleRequest(request, response);
		}

		// raw ended

		// allot raw start
		else if (path.equalsIgnoreCase("/showallotraw.htm")) {
			ShowAllotRawsController showAllotRawsController = new ShowAllotRawsController(
					loomService, rawService);
			showAllotRawsController.handleRequest(request, response);
		} else if (path.equalsIgnoreCase("/allotedraws.htm")) {
			AllotedRawsController allotedRawsController = new AllotedRawsController(
					loomRawService);
			allotedRawsController.handleRequest(request, response);

		}

		// allot raw end

		// start add bill
		else if (path.equalsIgnoreCase("/showaddbill.htm")) {
			ShowAddBillController showAddBillController = new ShowAddBillController(
					billService);
			showAddBillController.handleRequest(request, response);
		}

		// end add bill

		// get billdetails start
		if (path.equalsIgnoreCase("/getbill.htm")) {
			GetBillDetailsController getBillDetailsController = new GetBillDetailsController(
					billService);
			getBillDetailsController.handleRequest(request, response);
		}

		// get billdetails end

		// show bill start
		if (path.equalsIgnoreCase("/showbill.htm")) {
			ShowBillController showBillController = new ShowBillController();
			showBillController.handleRequest(request, response);
		}
		// show bill end

		// EditEmp start
		else if (path.equalsIgnoreCase("/editemp.htm")) {
			EditEmpController editEmpController = new EditEmpController(
					empService);
			editEmpController.handleRequest(request, response);
		}

		// Edit emp end

		// edit Customer start
		else if (path.equalsIgnoreCase("/editcustomer.htm")) {
			EditCustomerController editCustomerController = new EditCustomerController(
					customerService);
			editCustomerController.handleRequest(request, response);
		}

		else if (path.equalsIgnoreCase("/customers.htm")) {
			CustomersController customersController = new CustomersController(
					customerService);
			customersController.handleRequest(request, response);
		}

		// edit customer end

		// Edit Loom Start
		else if (path.equalsIgnoreCase("/editloom.htm")) {
			EditLoomController editLoomController = new EditLoomController(
					loomService);
			editLoomController.handleRequest(request, response);
		}

		// Edit Loom End

		// Edit product start
		else if (path.equalsIgnoreCase("/editproduct.htm")) {
			EditProductController editProductController = new EditProductController(
					productService);
			editProductController.handleRequest(request, response);
		}
		// Edit product end

		// Edit Raw Start
		else if (path.equalsIgnoreCase("/editraw.htm")) {
			EditRawController editRawController = new EditRawController(
					rawService);
			editRawController.handleRequest(request, response);
		}

		// Edit raw End
		else if (path.equalsIgnoreCase("/signout.htm")) {
			SignOutController signOutController = new SignOutController();
			signOutController.handleRequest(request, response);

		}

		else if (path.equalsIgnoreCase("/checkcustomer.htm")) {
			GetCustomerController getCustomerController=new GetCustomerController(customerService);
			getCustomerController.handleRequest(request, response);

		}
		else if (path.equalsIgnoreCase("/checkbill.htm")) {
			GetBillDetailsController getBillDetailsController=new GetBillDetailsController(billService);
			getBillDetailsController.handleRequest(request, response);

		}
		else if(path.equalsIgnoreCase("/getempamount"))
		{
			GetEmpAmountController getEmpAmountController=new GetEmpAmountController(advanceService);
			getEmpAmountController.handleRequest(request, response);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		// start addemp
		if (path.equalsIgnoreCase("/addemp.htm")) {
			String empType = request.getParameter("empType");
			String empName = request.getParameter("empName");
			String photo = request.getParameter("photo");
			String address = request.getParameter("address");
			String mobileNumber = request.getParameter("mobileNumber");
			String aadharNumber = request.getParameter("aadharNumber");
			String accountNumber = request.getParameter("accountNumber");
			String ifscCode = request.getParameter("ifscCode");
			String bankName = request.getParameter("bankName");
			String status = request.getParameter("status");

			AddEmpForm addEmpForm = new AddEmpForm();

			if (request.getParameter("empId") != null
					&& !request.getParameter("empId").trim().equalsIgnoreCase(
							""))
				addEmpForm.setEmpId(new Integer(request.getParameter("empId")));

			addEmpForm.setEmpType(empType);
			addEmpForm.setEmpName(empName);
			addEmpForm.setPhoto(photo);
			addEmpForm.setMobileNumber(mobileNumber);
			addEmpForm.setAadharNumber(aadharNumber);
			addEmpForm.setAccountNumber(accountNumber);
			addEmpForm.setIfscCode(ifscCode);
			addEmpForm.setBankName(bankName);
			addEmpForm.setAddress(address);
			addEmpForm.setStatus(status);

			AddEmpFormController addEmpFormController = new AddEmpFormController(
					empService);
			addEmpFormController.execute(request, response, addEmpForm);
		}
		// end addemp
		else // start updateemp
			if (path.equalsIgnoreCase("/updateemp.htm")) {
				String empType = request.getParameter("empType");
				String empName = request.getParameter("empName");
				String photo = request.getParameter("photo");
				String address = request.getParameter("address");
				String mobileNumber = request.getParameter("mobileNumber");
				String aadharNumber = request.getParameter("aadharNumber");
				String accountNumber = request.getParameter("accountNumber");
				String ifscCode = request.getParameter("ifscCode");
				String bankName = request.getParameter("bankName");
				String status = request.getParameter("status");

				AddEmpForm addEmpForm = new AddEmpForm();

				if (request.getParameter("empId") != null
						&& !request.getParameter("empId").trim().equalsIgnoreCase(
								""))
					addEmpForm.setEmpId(new Integer(request.getParameter("empId")));

				addEmpForm.setEmpType(empType);
				addEmpForm.setEmpName(empName);
				addEmpForm.setPhoto(photo);
				addEmpForm.setMobileNumber(mobileNumber);
				addEmpForm.setAadharNumber(aadharNumber);
				addEmpForm.setAccountNumber(accountNumber);
				addEmpForm.setIfscCode(ifscCode);
				addEmpForm.setBankName(bankName);
				addEmpForm.setAddress(address);
				addEmpForm.setStatus(status);

				UpdateEmpFormController addEmpFormController = new UpdateEmpFormController(
						empService);
				addEmpFormController.execute(request, response, addEmpForm);
			}
			// end updateemp
		else if(path.equalsIgnoreCase("/addduepayment.htm"))
		{
			CustomerDuePaymentController customerDuePaymentController=new CustomerDuePaymentController(customerPaymentService);
			customerDuePaymentController.handleRequest(request, response);
		}
		// start addloom
		else if (path.equalsIgnoreCase("/addloom.htm")) {
			String loomNo = request.getParameter("loomNo");
			String loomAddress = request.getParameter("loomAddress");
			String status = request.getParameter("status");
			AddLoomForm addLoomForm = new AddLoomForm();

			if (request.getParameter("loomId") != null
					&& !request.getParameter("loomId").trim().equalsIgnoreCase(
							""))
				addLoomForm.setLoomId(new Integer(request
						.getParameter("loomId")));
			addLoomForm.setLoomNo(loomNo);
			addLoomForm.setLoomAddress(loomAddress);
			addLoomForm.setStatus(status);
			AddLoomFormController addLoomFormController = new AddLoomFormController(
					loomService);
			addLoomFormController.execute(request, response, addLoomForm);

		}
		// end addloom

		// start addAdvance
		else if (path.equalsIgnoreCase("/addadvance.htm")) {
			Integer empId = new Integer(request.getParameter("empId"));
			Double amount = new Double(request.getParameter("amount"));
		//	String status = request.getParameter("status");
			AddAdvanceForm addAdvanceForm = new AddAdvanceForm();
			if (request.getParameter("advId") != null
					&& !request.getParameter("advId").trim().equalsIgnoreCase(
							""))
				addAdvanceForm.setAdvId(new Integer(request
						.getParameter("advId")));

			addAdvanceForm.setEmpId(empId);
			addAdvanceForm.setAmount(amount);
			addAdvanceForm.setStatus("Paid");
			AddAdvanceFormController addAdvanceFormController = new AddAdvanceFormController(
					advanceService);
			addAdvanceFormController.execute(request, response, addAdvanceForm);
		}

		// End addAdvance

		// start addproduct
		else if (path.equalsIgnoreCase("/addproduct.htm")) {
			// Integer productId=new Integer(request.getParameter("productId"));
			Integer empId = new Integer(request.getParameter("empId"));
			String productType = request.getParameter("productType");
			Double price = new Double(request.getParameter("price"));
			String productName = request.getParameter("productName");
			Double quantity = new Double(request.getParameter("quantity"));
			String status = request.getParameter("status");
			AddProductForm addProductForm = new AddProductForm();
			if (request.getParameter("productId") != null
					&& !request.getParameter("productId").trim()
							.equalsIgnoreCase(""))
				addProductForm.setProductId(new Integer(request
						.getParameter("productId")));

			addProductForm.setEmpId(empId);
			addProductForm.setProductType(productType);
			addProductForm.setPrice(price);
			addProductForm.setProductName(productName);
			addProductForm.setQuantity(quantity);
			addProductForm.setStatus(status);
			AddProductFormController addProductFormController = new AddProductFormController(
					productService);
			addProductFormController.execute(request, response, addProductForm);
		}
		// end addproduct

		// start addraw
		else if (path.equalsIgnoreCase("/addraw.htm")) {
			// Integer rawId=new Integer(request.getParameter("rawId"));
			String materialName = request.getParameter("materialName");
			Double price = new Double(request.getParameter("price"));
			String status = request.getParameter("status");
			AddRawForm addRawForm = new AddRawForm();
			if (request.getParameter("rawId") != null
					&& !request.getParameter("rawId").trim().equalsIgnoreCase(
							""))
				addRawForm.setRawId(new Integer(request.getParameter("rawId")));

			addRawForm.setMaterialName(materialName);
			addRawForm.setPrice(price);
			addRawForm.setStatus(status);

			AddRawFormController addRawFormController = new AddRawFormController(
					rawService);
			addRawFormController.execute(request, response, addRawForm);
		}

		// end addraw
		else if (path.equalsIgnoreCase("/forgot.htm")) {
			ForgotFormController forgotFormController=new ForgotFormController(adminService);
			forgotFormController.handleRequest(request, response);
			
		}

		// start add loomemp
		else if (path.equalsIgnoreCase("/addloomemp.htm")) {

			Integer empId = new Integer(request.getParameter("empId"));
			Integer loomId = new Integer(request.getParameter("loomId"));
			String status = request.getParameter("status");

			AddLoomEmpForm addLoomEmpForm = new AddLoomEmpForm();
			if (request.getParameter("loomEmpId") != null
					&& !request.getParameter("loomEmpId").trim()
							.equalsIgnoreCase(""))
				addLoomEmpForm.setLoomEmpId(new Integer(request
						.getParameter("loomEmpId")));
			addLoomEmpForm.setEmpId(empId);
			addLoomEmpForm.setLoomId(loomId);
			addLoomEmpForm.setStatus(status);
			AddLoomEmpFormController addLoomEmpFormController = new AddLoomEmpFormController(
					loomEmpService);
			addLoomEmpFormController.execute(request, response, addLoomEmpForm);
		}

		// end add loomemp

		// start add loomraw
		else if (path.equalsIgnoreCase("/addloomraw.htm")) {
			Integer loomId = new Integer(request.getParameter("loomId"));
			Integer rawId = new Integer(request.getParameter("rawId"));
			Double quantity = new Double(request.getParameter("quantity"));
			String status = request.getParameter("status");

			AddLoomRawForm addLoomRawForm = new AddLoomRawForm();
			if (request.getParameter("loomRawId") != null
					&& !request.getParameter("loomRawId").trim()
							.equalsIgnoreCase(""))
				addLoomRawForm.setLoomRawId(new Integer(request
						.getParameter("loomRawId")));
			addLoomRawForm.setLoomId(loomId);
			addLoomRawForm.setRawId(rawId);
			addLoomRawForm.setQuantity(quantity);
			addLoomRawForm.setStatus(status);
			AddLoomRawFormController addLoomRawFormController = new AddLoomRawFormController(
					loomRawService);
			addLoomRawFormController.execute(request, response, addLoomRawForm);
		}

		// end add loomraw

		// start add bill
		else if (path.equalsIgnoreCase("/addbill.htm")) {

			String customerName = request.getParameter("customerName");
			String customerPhoto = request.getParameter("customerPhoto");
			String customerType = request.getParameter("customerType");
			String address = request.getParameter("address");
			String mobileNumber = request.getParameter("mobileNumber");
			String aadharNumber = request.getParameter("aadharNumber");
			String[] productType = request.getParameterValues("productType");
			
			Double paidAmount = new Double(request.getParameter("paidAmount"));
			// Integer salesId=new Integer(request.getParameter("salesId"));
			// Integer customerPayId=new
			// Integer(request.getParameter("customerPayId"));

			AddBillForm addBillForm = new AddBillForm();
			if (request.getParameter("customerId") != null
					&& !request.getParameter("customerId").trim()
							.equalsIgnoreCase(""))
				addBillForm.setCustomerId(new Integer(request
						.getParameter("customerId")));
			addBillForm.setCustomerName(customerName);
			addBillForm.setCustomerPhoto(customerPhoto);
			addBillForm.setCustomerType(customerType);
			addBillForm.setAddress(address);
			addBillForm.setMobileNumber(mobileNumber);
			addBillForm.setAadharNumber(aadharNumber);
			
			addBillForm.setProductType(productType);
			String[] quantity =request.getParameterValues("quantity");
			String[]  price =request.getParameterValues("price");
			String[]  discount = request.getParameterValues("discount");
			if(productType!=null)
			{
				Integer[] q=new Integer[productType.length];
				Double[] p=new Double[productType.length];
				Double[] d=new Double[productType.length];
				for(int index=0;index<productType.length;index++)
				{
					q[index]=new Integer(quantity[index]);
					p[index]=new Double(price[index]);
					d[index]=new Double(discount[index]);
				}
				
				for(int index=0;index<productType.length;index++)
				{
					
				}
				addBillForm.setQuantity(q);
				addBillForm.setPrice(p);
				addBillForm.setDiscount(d);
			}
			
			addBillForm.setPaidAmount(paidAmount);
			AddBillFormController addBillFormController = new AddBillFormController(
					customerService, billService, salesService,
					customerPaymentService);
			addBillFormController.execute(request, response, addBillForm);

		}

		// end add bill

		// start add customer payment
		else if (path.equalsIgnoreCase("/billpayment.htm")) {
			Integer customerId = new Integer(request.getParameter("customerId"));
			Integer billId = new Integer(request.getParameter("billId"));
			Double paidAmount = new Double(request.getParameter("paidAmount"));

			AddCustomerPaymentForm addCustomerPaymentForm = new AddCustomerPaymentForm();
			if (request.getParameter("customerPayId") != null
					&& !request.getParameter("customerPayId").trim()
							.equalsIgnoreCase(""))
				addCustomerPaymentForm.setCustomerPayId(new Integer(request
						.getParameter("customerPayId")));
			addCustomerPaymentForm.setCustomerId(customerId);
			addCustomerPaymentForm.setBillId(billId);
			addCustomerPaymentForm.setPaidAmount(paidAmount);
			AddCustomerPaymentFormController addCustomerPaymentFormController = new AddCustomerPaymentFormController(
					customerPaymentService);
			addCustomerPaymentFormController.execute(request, response,
					addCustomerPaymentForm);
		}

		// end add customer payment

	}

}

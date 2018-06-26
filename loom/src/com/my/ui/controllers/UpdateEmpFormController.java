package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.dao.EmpDAO;
import com.my.dao.model.AdminTL;
import com.my.dao.model.EmpTL;
import com.my.service.EmpService;
import com.my.service.dto.AdminDTO;
import com.my.service.dto.EmpDTO;
import com.my.ui.forms.AddEmpForm;

public class UpdateEmpFormController extends AbstractFormController{
	
	private EmpService empService;
	
public UpdateEmpFormController(EmpService empService)
{
	this.empService=empService;
}

@Override
public void execute(HttpServletRequest request, HttpServletResponse response,
		Object command) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	AddEmpForm addEmpForm=(AddEmpForm)command;
	
	EmpDTO empDTO=new EmpDTO();
	empDTO.setEmpId(addEmpForm.getEmpId());
	empDTO.setEmpType(addEmpForm.getEmpType());
	empDTO.setEmpName(addEmpForm.getEmpName());
	empDTO.setPhoto(addEmpForm.getPhoto());
	empDTO.setMobileNumber(addEmpForm.getMobileNumber());
	empDTO.setAadharNumber(addEmpForm.getAadharNumber());
	empDTO.setAccountNumber(addEmpForm.getAccountNumber());
	empDTO.setIfscCode(addEmpForm.getIfscCode());
	empDTO.setBankName(addEmpForm.getBankName());
	empDTO.setAddress(addEmpForm.getAddress());
	empDTO.setStatus(addEmpForm.getStatus());
	empDTO.setCreatedOn(new java.util.Date());
	HttpSession session=request.getSession(false);
	AdminDTO admin=(AdminDTO)session.getAttribute("admin");
	empDTO.setCreatedBy(admin.getAdminId());
	
	empService.modify(empDTO);
	response.sendRedirect("emps.htm");
	
	
}

}

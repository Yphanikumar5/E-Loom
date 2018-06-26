package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.service.LoomEmpService;
import com.my.service.dto.AdminDTO;
import com.my.service.dto.LoomEmpDTO;
import com.my.ui.forms.AddLoomEmpForm;

public class AddLoomEmpFormController extends AbstractFormController{
	
	private LoomEmpService loomEmpService;
	
	public AddLoomEmpFormController(LoomEmpService loomEmpService) {
		this.loomEmpService=loomEmpService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		AddLoomEmpForm addLoomEmpForm=(AddLoomEmpForm)command;
		
		LoomEmpDTO loomEmpDTO=new LoomEmpDTO();
		loomEmpDTO.setLoomEmpId(addLoomEmpForm.getLoomEmpId());
		loomEmpDTO.setEmpId(addLoomEmpForm.getEmpId());
		loomEmpDTO.setLoomId(addLoomEmpForm.getLoomId());
		loomEmpDTO.setStatus(addLoomEmpForm.getStatus());
		loomEmpDTO.setCreatedOn(new java.util.Date());
		HttpSession session=request.getSession(false);
		AdminDTO admin=(AdminDTO)session.getAttribute("admin");
		loomEmpDTO.setCreatedBy(admin.getAdminId());
		loomEmpService.saveLoomEmp(loomEmpDTO);
		
		response.sendRedirect("allotedlooms.htm");
		
		
		
		// TODO Auto-generated method stub
		
	}

}

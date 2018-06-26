package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.dao.LoomDAO;
import com.my.dao.model.AdminTL;
import com.my.dao.model.LoomTL;

import com.my.service.LoomService;
import com.my.service.dto.AdminDTO;
import com.my.service.dto.LoomDTO;
import com.my.ui.forms.AddLoomForm;

public class AddLoomFormController extends AbstractFormController{
	private LoomService loomService;
	public AddLoomFormController(LoomService loomService) {
		this.loomService=loomService;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddLoomForm addLoomForm=(AddLoomForm)command;
		LoomDTO loomDTO=new LoomDTO();
		
		loomDTO.setLoomId(addLoomForm.getLoomId());
		loomDTO.setLoomNo(addLoomForm.getLoomNo());
		loomDTO.setLoomAddress(addLoomForm.getLoomAddress());
		loomDTO.setStatus("Active");
		loomDTO.setCreatedOn(new java.util.Date());
		HttpSession session=request.getSession(false);
		AdminDTO admin=(AdminDTO)session.getAttribute("admin");
		loomDTO.setCreatedBy(admin.getAdminId());
		loomService.saveLoom(loomDTO);
		response.sendRedirect("looms.htm");
		
		
	}

}

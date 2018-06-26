package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.dao.LoomRawDAO;
import com.my.dao.model.LoomRawTL;
import com.my.service.LoomRawService;
import com.my.service.dto.AdminDTO;
import com.my.service.dto.LoomRawDTO;
import com.my.ui.forms.AddLoomRawForm;

public class AddLoomRawFormController extends AbstractFormController{

	private LoomRawService loomRawService;
	public AddLoomRawFormController(LoomRawService loomRawService) {
		this.loomRawService=loomRawService;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddLoomRawForm addLoomRawForm=(AddLoomRawForm)command;
		
		LoomRawDTO loomRawDTO=new LoomRawDTO();
		loomRawDTO.setLoomRawId(addLoomRawForm.getLoomRawId());
		loomRawDTO.setLoomId(addLoomRawForm.getLoomId());
		loomRawDTO.setRawId(addLoomRawForm.getRawId());
		loomRawDTO.setQuantity(addLoomRawForm.getQuantity());
		loomRawDTO.setStatus(addLoomRawForm.getStatus());
		loomRawDTO.setCreatedOn(new java.util.Date());
		HttpSession session=request.getSession(false);
		AdminDTO admin=(AdminDTO)session.getAttribute("admin");
		loomRawDTO.setCreatedBy(admin.getAdminId());
		loomRawService.saveLoomRaw(loomRawDTO);
		
		response.sendRedirect("allotedraws.htm");
		
	}
	 
}

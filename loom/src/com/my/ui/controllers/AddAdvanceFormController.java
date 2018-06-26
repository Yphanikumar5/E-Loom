package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.dao.AdvanceDAO;

import com.my.service.AdvanceService;
import com.my.service.dto.AdminDTO;
import com.my.service.dto.AdvanceDTO;
import com.my.ui.forms.AddAdvanceForm;

public class AddAdvanceFormController extends AbstractFormController{
		private AdvanceService advanceService;
		public AddAdvanceFormController(AdvanceService advanceService)
		{
			this.advanceService=advanceService;
		}
	
	
	
	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddAdvanceForm addAdvanceForm=(AddAdvanceForm)command;
		
		
		AdvanceDTO advanceDTO=new AdvanceDTO();
		advanceDTO.setAdvId(addAdvanceForm.getAdvId());
		advanceDTO.setEmpId(addAdvanceForm.getEmpId());
		advanceDTO.setAmount(addAdvanceForm.getAmount());
		advanceDTO.setStatus("Active");
		advanceDTO.setCreatedOn(new java.util.Date());
		HttpSession session=request.getSession(false);
		AdminDTO admin=(AdminDTO)session.getAttribute("admin");
		advanceDTO.setCreatedBy(admin.getAdminId());
		advanceService.saveAdvance(advanceDTO);
		response.sendRedirect("advancess.htm");
		
		
	}

}

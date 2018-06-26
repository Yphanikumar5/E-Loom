package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.dao.RawDAO;
import com.my.dao.model.RawTL;
import com.my.service.RawService;
import com.my.service.dto.AdminDTO;
import com.my.service.dto.RawDTO;
import com.my.ui.forms.AddRawForm;

public class AddRawFormController extends AbstractFormController{
	
	private RawService rawService;
	
	public AddRawFormController(RawService rawService) {
		this.rawService=rawService;
		
	}

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response, Object command)
			throws ServletException, IOException {
		AddRawForm addRawForm=(AddRawForm)command;
		
		RawDTO rawDTO=new RawDTO();
		
		//rawTL.setMerchantId(addRawForm.getMerchantId());
	//	rawTL.setQuantity(addRawForm.getQuantity());
		rawDTO.setRawId(addRawForm.getRawId());
		rawDTO.setMaterialName(addRawForm.getMaterialName());
		rawDTO.setPrice(addRawForm.getPrice());
		rawDTO.setStatus(addRawForm.getStatus());
		rawDTO.setCreatedOn(new java.util.Date());
		HttpSession session=request.getSession(false);
		AdminDTO admin=(AdminDTO)session.getAttribute("admin");
		rawDTO.setCreatedBy(admin.getAdminId());
		rawService.saveRaw(rawDTO);
		
	response.sendRedirect("raws.htm");
		
		// TODO Auto-generated method stub
		
	}

}

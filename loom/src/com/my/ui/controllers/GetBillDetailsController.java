package com.my.ui.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.my.service.BillService;
import com.my.ui.Controller;

public class GetBillDetailsController implements Controller{

	private BillService billService;
	public GetBillDetailsController(BillService billService)
	{
	this.billService=billService;
	}
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String billId=request.getParameter("billId");
		Map<String, Object> bill=billService.loadBillSetails(new Integer(billId));
		
		String result="{\"msg\":\"fail\"}";
		if(bill!=null)
		{
			ObjectMapper objectMapper=new ObjectMapper();
			result=objectMapper.writeValueAsString(bill);
		}
		System.out.println(result);
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
	}

}

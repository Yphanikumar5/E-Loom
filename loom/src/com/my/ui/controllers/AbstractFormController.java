package com.my.ui.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractFormController {
	public abstract void execute(HttpServletRequest request,HttpServletResponse response,Object command) throws ServletException,IOException;
	{
		
	}

}

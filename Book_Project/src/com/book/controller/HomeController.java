package com.book.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController
{

	@Autowired
	private SqlSession SqlSession;

	@RequestMapping(value = "/main.action", method ={ RequestMethod.GET, RequestMethod.POST })
	public String showMain(Model model, HttpServletRequest request)
	{

		ITestDAO dao = SqlSession.getMapper(ITestDAO.class);

		String name = dao.getName();

		model.addAttribute("name", name);
		

		return "/Main.jsp";
	}
}
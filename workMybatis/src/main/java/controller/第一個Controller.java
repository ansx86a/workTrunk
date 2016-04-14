package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class 第一個Controller {

	@Autowired
	private 第一個Service service;

	@RequestMapping(value = "/test001.mvc", method = RequestMethod.GET)
	public String test1(HttpServletRequest request, HttpServletResponse response) {
		service.最簡單的select();
		request.setAttribute("test", "最簡單的select");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}
	@RequestMapping(value = "/test002.mvc", method = RequestMethod.GET)
	public String test2(HttpServletRequest request, HttpServletResponse response) {
		service.最簡單的insert();
		request.setAttribute("test", "最簡單的insert");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}
	
	@RequestMapping(value = "/test003.mvc", method = RequestMethod.GET)
	public String test3(HttpServletRequest request, HttpServletResponse response) {
		service.從annotation做select();
		request.setAttribute("test", "從annotation做select");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}
	
	@RequestMapping(value = "/test004.mvc", method = RequestMethod.GET)
	public String test4(HttpServletRequest request, HttpServletResponse response) {
		service.最簡單的sqlMap例子1();
		request.setAttribute("test", "最簡單的sqlMap例子1");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

}

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tool.Utils;

@Controller
public class 第一個Controller {

	@Autowired
	private 第一個Service service;

	@RequestMapping(value = "/test001.mvc", method = RequestMethod.GET)
	public String test1(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.最簡單的select();
		request.setAttribute("test", "最簡單的select");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/test002.mvc", method = RequestMethod.GET)
	public String test2(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.最簡單的insert();
		request.setAttribute("test", "最簡單的insert");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/test003.mvc", method = RequestMethod.GET)
	public String test3(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.從annotation做select();
		request.setAttribute("test", "從annotation做select");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/test004.mvc", method = RequestMethod.GET)
	public String test4(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.最簡單的sqlMap例子1();
		request.setAttribute("test", "最簡單的sqlMap例子1");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/test005.mvc", method = RequestMethod.GET)
	public String test5(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.最常用的一種select_map例子();
		request.setAttribute("test", "最常用的一種select_map例子");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/test006.mvc", method = RequestMethod.GET)
	public String test6(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.最常用的一種select_map例子map參數();
		request.setAttribute("test", "最常用的一種select_map例子map參數");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/test007.mvc", method = RequestMethod.GET)
	public String test7(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.最常用的一種select_map例子map參數2();
		request.setAttribute("test", "最常用的一種select_map例子map參數2");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/test008.mvc", method = RequestMethod.GET)
	public String test8(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.最常用的一種select_map例子map參數3();
		request.setAttribute("test", "最常用的一種select_map例子map參數3");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/test009.mvc", method = RequestMethod.GET)
	public String test9(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.最常用的一種select_map例子class參數();
		request.setAttribute("test", "最常用的一種select_map例子class參數");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/test010.mvc", method = RequestMethod.GET)
	public String test10(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.對result物件多做一層mapping();
		request.setAttribute("test", "對result物件多做一層mapping");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/test011.mvc", method = RequestMethod.GET)
	public String test11(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.對join的物件做result的mapping();
		request.setAttribute("test", "對join的物件做result的mapping");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/test012.mvc", method = RequestMethod.GET)
	public String test12(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.對join的物件做result的直接mapping();
		request.setAttribute("test", "對join的物件做result的直接mapping");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}
}

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tool.Utils;

@Controller
public class 第二個Controller {
	@Autowired
	private 第二個Service service;

	@RequestMapping(value = "/test021.mvc", method = RequestMethod.GET)
	public String test021(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.caseWhen的應用();
		request.setAttribute("test", "caseWhen的應用");
		System.out.println("myTest");
		return "/jsp/test2.jsp";
	}

	@RequestMapping(value = "/test022.mvc", method = RequestMethod.GET)
	public String test022(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.動態sqlIf();
		request.setAttribute("test", "動態sqlIf");
		System.out.println("myTest");
		return "/jsp/test2.jsp";
	}

	@RequestMapping(value = "/test023.mvc", method = RequestMethod.GET)
	public String test023(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.動態sqlCaseWhen();
		request.setAttribute("test", "動態sqlCaseWhen");
		System.out.println("myTest");
		return "/jsp/test2.jsp";
	}

	@RequestMapping(value = "/test024.mvc", method = RequestMethod.GET)
	public String test024(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.動態sqlIf去化where1等於1();
		request.setAttribute("test", "動態sqlIf去化where1等於1");
		System.out.println("myTest");
		return "/jsp/test2.jsp";
	}

	@RequestMapping(value = "/test025.mvc", method = RequestMethod.GET)
	public String test025(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.動態sqlIf去化結尾的逗號();
		request.setAttribute("test", "動態sqlIf去化結尾的逗號");
		System.out.println("myTest");
		return "/jsp/test2.jsp";
	}

	@RequestMapping(value = "/test026.mvc", method = RequestMethod.GET)
	public String test026(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.動態sqlIf內部參數組合Class();
		request.setAttribute("test", "動態sqlIf內部參數組合Class");
		System.out.println("myTest");
		return "/jsp/test2.jsp";
	}

	@RequestMapping(value = "/test027.mvc", method = RequestMethod.GET)
	public String test027(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.動態sqlIf內部參數組合Map();
		request.setAttribute("test", "動態sqlIf內部參數組合Map");
		System.out.println("myTest");
		return "/jsp/test2.jsp";
	}

	@RequestMapping(value = "/test028.mvc", method = RequestMethod.GET)
	public String test028(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.動態sqlForEachMap();
		request.setAttribute("test", "動態sqlForEachMap");
		System.out.println("myTest");
		return "/jsp/test2.jsp";
	}

	@RequestMapping(value = "/test029.mvc", method = RequestMethod.GET)
	public String test029(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.動態sqlForEachClass();
		request.setAttribute("test", "動態sqlForEachClass");
		System.out.println("myTest");
		return "/jsp/test2.jsp";
	}

	@RequestMapping(value = "/test030.mvc", method = RequestMethod.GET)
	public String test030(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.多種db支援1();
		request.setAttribute("test", "多種db支援1");
		System.out.println("myTest");
		return "/jsp/test2.jsp";
	}

	@RequestMapping(value = "/test031.mvc", method = RequestMethod.GET)
	public String test031(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		service.多種db支援2();
		request.setAttribute("test", "多種db支援2");
		System.out.println("myTest");
		return "/jsp/test2.jsp";
	}

	@RequestMapping(value = "/test032.mvc", method = RequestMethod.GET)
	public String test032(HttpServletRequest request, HttpServletResponse response) {
		Utils.setRequest(request);
		try {
			service.測試交易();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "/jsp/test2.jsp";
	}
}

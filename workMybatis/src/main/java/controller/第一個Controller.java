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
		request.setAttribute("test", "這是測試001");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

}

package controller;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
public class UnitTestController {
	@RequestMapping(value = "/test.mvc", method = RequestMethod.GET)
	public String myTest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("test", "這是測試");
		System.out.println("myTest");
		return "/jsp/test.jsp";
	}

	@RequestMapping(value = "/unitTest1.mvc", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String unitTest1(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
		request.getParameterMap().forEach((k, v) -> {
			System.out.println(k + "->" + Arrays.toString(v));
		});

		request.setAttribute("test", "這是測試");
		System.out.println("myTest");
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter wr = mapper.writer();
		HashMap map = new HashMap();
		map.put("name", "中文名字");
		map.put("age", 35);
		System.out.println(wr.writeValueAsString(map));

		return wr.writeValueAsString(map);
	}
}

package controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import db.SqlDao;

@Controller
public class ExController {

	@RequestMapping(value = "/ex001.mvc", method = RequestMethod.GET)
	public String test1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap map = new HashMap();
		List<HashMap> list = SqlDao.get().撈取ex資料(map);
		Comparator<HashMap> c = (x, y) -> {
			return (int) y.get("exid") - (int) x.get("exid");// 大的在上面
		};
		list = list.stream().filter(o -> (int) o.get("looked") == 0).collect(Collectors.toList());
		list.sort(c);
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter wr = mapper.writer();
		String s = wr.writeValueAsString(list);
		request.setAttribute("test", s);
		request.setAttribute("count", list.size());
		return "/jsp/ex.jsp";
	}

	@RequestMapping(value = "/ex002.mvc", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String test2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String exid = request.getParameter("exid");
		String action = request.getParameter("action");
		HashMap map = new HashMap();
		map.put("exid", exid);
		map.put("looked", action);
		SqlDao.get().更新ex資料(map);
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter wr = mapper.writer();
		String s = wr.writeValueAsString(map);
		return s;
	}

}

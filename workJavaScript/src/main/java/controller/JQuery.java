package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class JQuery {

	public static void main(String[] args) {

	}

	// , method = RequestMethod.GET
	// produces = "application/json;charset=utf-8"
	@RequestMapping(value = "/jquery001.mvc", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String index(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		HashMap<String, Object> map = new HashMap<String, Object>(request.getParameterMap());
		if (map.size() == 0) {
			map.put("nodata", "notGood");
		}
		Gson gson = new Gson();
		String result = gson.toJson(map);
		System.out.println("post為空，但get時有queryString:" + request.getQueryString());
		System.out.println(result);
		Thread.sleep(100);
		return result;
	}

	/**
	 * 另外包成json的callback，重點是要把callback捉出來，再寫成javascript call function的方式傳字串回去就可以了 <br>
	 * 前端會把回傳的文字當成javascript執行<br>
	 * (這樣就可以做到安全性攻擊了，好妙<ex:寫ajax一直玩jsonp回傳資料>)
	 * @param request
	 * @param response
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping(value = "/jquery002.mvc", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String json(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "myname");
		map.put("age", "myage");
		String callBack = request.getParameter("callback");
		String result = callBack + "(%s);alert('server端的javascript');";
		Gson gson = new Gson();
		result = String.format(result, gson.toJson(map));
		System.out.println("jsonp:" + result);
		System.out.println("post為空，但get時有queryString:" + request.getQueryString());
		return result;
	}

	
	
	
}

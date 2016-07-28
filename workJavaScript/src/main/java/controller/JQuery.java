package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class JQuery {

	public static void main(String[] args) {

	}

	// produces = "application/json;charset=utf-8"
	@RequestMapping(value = "/jquery001.mvc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String index(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> map = new HashMap<String, Object>(request.getParameterMap());
		if (map.size() == 0) {
			map.put("nodata", "notGood");
		}
		Gson gson = new Gson();
		String result = gson.toJson(map);
		System.out.println(result);
		return result;
	}

}

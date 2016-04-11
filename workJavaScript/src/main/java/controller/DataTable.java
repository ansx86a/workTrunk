package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class DataTable {

	@RequestMapping(value = "/dataTable001.mvc", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index");
		return "dataTable/601應用.jsp";
	}

	@RequestMapping(value = "/dataTable002.mvc", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String test002(HttpServletRequest request, HttpServletResponse response, String jsonData) throws Exception {
		Gson gson = new Gson();
		System.out.println("goto 002");
		int d = new Date().getSeconds();
		System.out.println("jsonData=" + jsonData);
		DataTableForm form = gson.fromJson(jsonData, DataTableForm.class);
		System.out.println("form =" + form);

		ArrayList<DataTableResult> list = new ArrayList<>();
		for (int i = 0; i < 65; i++) {
			list.add(new DataTableResult(d + "name" + i, d + "data1-" + i, d + "data2-" + i, d + "data3-" + i));
		}
		HashMap map = new HashMap();
		map.put("abc", list);
		String result = gson.toJson(map);
		System.out.println(result);
		return result;
	}

	@RequestMapping(value = "/dataTable003.mvc", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String test003(HttpServletRequest request, HttpServletResponse response, String jsonData) throws Exception {
		// 因為是測試非同步，就直接回傳test2，但是要delay一下時間
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return test002(request, response, jsonData);
	}

	public static void main(String[] args) {
		DataTableForm df = new DataTableForm();
		Gson gson = new Gson();
		String s = gson.toJson(df, DataTableForm.class);
		System.out.println(s);
	}

	public static class DataTableForm {
		String txt1;
		String txt2;
		String[] txt3;
		boolean cb;
		String rad;

		public String getTxt1() {
			return txt1;
		}

		public void setTxt1(String txt1) {
			this.txt1 = txt1;
		}

		public String getTxt2() {
			return txt2;
		}

		public void setTxt2(String txt2) {
			this.txt2 = txt2;
		}

		public String[] getTxt3() {
			return txt3;
		}

		public void setTxt3(String[] txt3) {
			this.txt3 = txt3;
		}

		public boolean isCb() {
			return cb;
		}

		public void setCb(boolean cb) {
			this.cb = cb;
		}

		public String getRad() {
			return rad;
		}

		public void setRad(String rad) {
			this.rad = rad;
		}

		@Override
		public String toString() {
			return "DataTableForm [txt1=" + txt1 + ", txt2=" + txt2 + ", txt3=" + Arrays.toString(txt3) + ", cb=" + cb
					+ ", rad=" + rad + "]";
		}

	}

	public static class DataTableResult {
		String name;
		String data1;
		String data2;
		String data3;

		public DataTableResult() {

		}

		public DataTableResult(String name, String data1, String data2, String data3) {
			this.name = name;
			this.data1 = data1;
			this.data2 = data2;
			this.data3 = data3;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getData1() {
			return data1;
		}

		public void setData1(String data1) {
			this.data1 = data1;
		}

		public String getData2() {
			return data2;
		}

		public void setData2(String data2) {
			this.data2 = data2;
		}

		public String getData3() {
			return data3;
		}

		public void setData3(String data3) {
			this.data3 = data3;
		}

	}
}

package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Customer;
import model.input.MyInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tool.Utils;
import dao.CustomerMapperExt;

@Service
public class 第二個Service {

	@Autowired
	private CustomerMapperExt customerMapperExt;

	public void caseWhen的應用() {

		List<HashMap> list = customerMapperExt.caseWhen的應用();
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		Utils.getRequest().setAttribute("test2", list.get(0) + "<br>" + list.get(1) + "<br>" + list.get(2) + "<br>");
	}

	public void 動態sqlIf() {
		Customer c = new Customer();
		c.setCustomerid("ALFKI");
		List<HashMap> list = customerMapperExt.動態sqlIf(c);
		System.out.println(list.get(0));
		Customer c2 = new Customer();
		c2.setCompanyname("公司2");
		List<HashMap> list2 = customerMapperExt.動態sqlIf(c2);
		System.out.println(list2.get(0));
		Utils.getRequest().setAttribute("test2", list.get(0) + "<br>" + list2.get(0));
	}

	public void 動態sqlCaseWhen() {
		Customer c = new Customer();
		c.setCustomerid("ALFKI");
		// other
		List<HashMap> list3 = customerMapperExt.動態sqlCaseWhen(c);
		System.out.println(list3.get(0));
		// 不能用=，會被當成運算符號
		c.setFax("equal");
		List<HashMap> list = customerMapperExt.動態sqlCaseWhen(c);
		System.out.println(list.get(0));
		Customer c2 = new Customer();
		c2.setCustomerid("ANAT_");
		// 不能設%，會被當做運算符號
		c2.setFax("百分比");
		List<HashMap> list2 = customerMapperExt.動態sqlCaseWhen(c2);
		System.out.println(list2.get(0));
		Utils.getRequest().setAttribute("test2", list.get(0) + "<br>" + list2.get(0) + "<br>" + list3.get(0));
	}

	public void 動態sqlIf去化where1等於1() {
		Customer c = new Customer();
		c.setCustomerid("ALFKI");
		List<HashMap> list = customerMapperExt.動態sqlIf去化where1等於1(c);
		System.out.println(list.get(0));
		Customer c2 = new Customer();
		c2.setCompanyname("公司2");
		List<HashMap> list2 = customerMapperExt.動態sqlIf去化where1等於1(c2);
		System.out.println(list2.get(0));
		Utils.getRequest().setAttribute("test2", list.get(0) + "<br>" + list2.get(0));
	}

	public void 動態sqlIf去化結尾的逗號() {
		Customer c = new Customer();
		c.setCustomerid("ALFKI");
		String newAddress = "address" + System.currentTimeMillis() % 1000;
		c.setAddress(newAddress);
		System.out.println(newAddress);
		int result = customerMapperExt.動態sqlIf去化結尾的逗號(c);
		System.out.println(result);
		Utils.getRequest().setAttribute("test2", result);
	}

	public void 動態sqlIf內部參數組合Class() {
		Customer c = new Customer();
		c.setCustomerid("ANAT");
		List<HashMap> list = customerMapperExt.動態sqlIf內部參數組合Class(c);
		System.out.println(list.get(0));
		Utils.getRequest().setAttribute("test2", list.get(0));
	}

	public void 動態sqlIf內部參數組合Map() {
		HashMap c = new HashMap();
		c.put("customerid", "ALFK");
		List<HashMap> list = customerMapperExt.動態sqlIf內部參數組合Map(c);
		System.out.println(list.get(0));
		Utils.getRequest().setAttribute("test2", list.get(0));
	}

	public void 動態sqlForEachMap() {
		HashMap c = new HashMap();
		ArrayList<String> list = new ArrayList<>();
		list.add("ALFKI");
		list.add("ANATR");
		c.put("一堆id資料list", list);

		List<HashMap> list2 = customerMapperExt.動態sqlForEachMap(c);
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		Utils.getRequest().setAttribute("test2", "" + list2.get(0) + "\r\n" + list2.get(1));
	}

	public void 動態sqlForEachClass() {
		MyInput c = new MyInput();
		ArrayList<String> list = new ArrayList<>();
		list.add("ALFKI");
		list.add("ANATR");
		c.setList1(list);
		List<HashMap> list2 = customerMapperExt.動態sqlForEachClass(c);
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		Utils.getRequest().setAttribute("test2", "" + list2.get(0) + "\r\n" + list2.get(1));
	}

	public void 多種db支援1() {
		int result = customerMapperExt.多種db支援1();
		System.out.println(result);
		Utils.getRequest().setAttribute("test2", result);
	}

	public void 多種db支援2() {
		int result = customerMapperExt.多種db支援2();
		System.out.println(result);
		Utils.getRequest().setAttribute("test2", result);
	}

	 @Transactional(readOnly = false, rollbackFor = Exception.class)
	public void 測試交易() {
		// 以下是一個update的交易，會update地扯
		動態sqlIf去化結尾的逗號();
		if (System.currentTimeMillis() % 2 == 0) {
			System.out.println("exception");
			Utils.getRequest().setAttribute("test2", "交易失敗");
			throw new RuntimeException("這裡故意錯誤測試rollback");
		} else {
			System.out.println("ok");
			Utils.getRequest().setAttribute("test2", "交易ok");
		}
	}

}

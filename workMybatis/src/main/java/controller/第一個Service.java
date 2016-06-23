package controller;

import java.util.HashMap;
import java.util.List;

import model.Customer;
import model.Employee;
import model.Supplier;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tool.ThreadLocalUtils;
import dao.CustomerMapperExt;
import dao.SupplierMapperExt;

@Service
public class 第一個Service {
	@Autowired
	private CustomerMapperExt customerMapperExt;
	@Autowired
	private SupplierMapperExt supplierMapperExt;

	public void 最簡單的select() {
		System.out.println(customerMapperExt);
		Customer c = customerMapperExt.selectByPrimaryKey("ALFKI");
		System.out.println(c);
		ThreadLocalUtils.getRequest().setAttribute("test2", c);
	}

	public void 最簡單的insert() {
		Supplier sp = new Supplier();
		sp.setCompanyname("test公司名");
		sp.setHomepage("<html>this is my homePage</html>");
		supplierMapperExt.insert(sp);
		int pk = sp.getSupplierid();
		System.out.println(pk);
		ThreadLocalUtils.getRequest().setAttribute("test2", pk);
	}

	public void 從annotation做select() {
		Customer c = customerMapperExt.selectByPrimaryKeyAnnotation("ALFKI");
		System.out.println(ToStringBuilder.reflectionToString(c));
		HashMap map = customerMapperExt.selectByPrimaryKeyAnnotationMap("ALFKI");
		System.out.println(map);
		ThreadLocalUtils.getRequest().setAttribute("test2", map);
	}

	public void 取出customer筆數() {
		Integer count = customerMapperExt.取出customer筆數();
		System.out.println(count);
		ThreadLocalUtils.getRequest().setAttribute("test2", count);
	}

	public void 最常用的一種select_map例子() {
		// HashMap map = customerMapperExt.最常用的一種select_map例子("ALFKI");
		List<HashMap> list = customerMapperExt.最常用的一種select_map例子("ALFKI");
		System.out.println(list.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0));
	}

	public void 最常用的一種select_map例子map參數() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("customerid", "ALFKI");
		map.put("companyName", "公司1");
		List<HashMap> list = customerMapperExt.最常用的一種select_map例子map參數(map);
		System.out.println(list.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0));
	}

	public void 最常用的一種select_map例子map參數2() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("customerid", "ALFKI");
		map.put("companyName", "公司1");
		List<HashMap> list = customerMapperExt.最常用的一種select_map例子map參數2(map);
		System.out.println(list.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0));
	}

	public void 最常用的一種select_map例子map參數3() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("customerid", "ALFKI");
		map.put("companyName", "公司1");
		List<HashMap> list = customerMapperExt.最常用的一種select_map例子map參數3(map);
		System.out.println(list.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0));
	}

	public void 最常用的一種select_map例子class參數() {
		Customer customer = new Customer();
		customer.setCustomerid("ALFKI");
		customer.setCompanyname("公司1");
		List<HashMap> list = customerMapperExt.最常用的一種select_map例子class參數(customer);
		System.out.println(list.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0));
	}

	public void 對result物件多做一層mapping() {
		Customer customer = new Customer();
		customer.setCustomerid("ALFKI");
		customer.setCompanyname("公司1");
		List<Employee> list = customerMapperExt.對result物件多做一層mapping(customer);
		String s = ToStringBuilder.reflectionToString(list.get(0));
		System.out.println(s);
		ThreadLocalUtils.getRequest().setAttribute("test2", s);
	}

	public void 對join的物件做result的mapping() {
		List<HashMap<String, Object>> list = customerMapperExt.對join的物件做result的mapping();
		System.out.println(list.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0));
	}
	
	public void 對join的物件做result的直接mapping() {
		List<HashMap<String, Object>> list = customerMapperExt.對join的物件做result的直接mapping();
		System.out.println(list.get(0));
		ThreadLocalUtils.getRequest().setAttribute("test2", list.get(0));
	}
}

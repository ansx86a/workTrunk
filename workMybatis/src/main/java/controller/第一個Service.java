package controller;

import java.util.HashMap;

import model.Customer;
import model.Supplier;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		System.out.println(customerMapperExt.selectByPrimaryKey("ALFKI"));
	}

	public void 最簡單的insert() {
		Supplier sp = new Supplier();
		sp.setCompanyname("test公司名");
		sp.setHomepage("<html>this is my homePage</html>");
		supplierMapperExt.insert(sp);
		int pk = sp.getSupplierid();
		System.out.println(pk);
	}

	public void 從annotation做select() {
		Customer c = customerMapperExt.selectByPrimaryKeyAnnotation("ALFKI");
		System.out.println(ToStringBuilder.reflectionToString(c));
		HashMap map = customerMapperExt.selectByPrimaryKeyAnnotationMap("ALFKI");
		System.out.println(map);
	}

	public void 最簡單的sqlMap例子1() {
		Integer count = customerMapperExt.取出customer筆數();
		System.out.println(count);
	}

}

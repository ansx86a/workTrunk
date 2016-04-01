package controller;

import model.Supplier;

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

}

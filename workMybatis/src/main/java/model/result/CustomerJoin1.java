package model.result;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import model.Order;

public class CustomerJoin1 {
	private String customerid;
	private String companyname;
	private String contactname;

	private List<Order> 訂單列表;

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public List<Order> get訂單列表() {
		return 訂單列表;
	}

	public void set訂單列表(List<Order> 訂單列表) {
		this.訂單列表 = 訂單列表;
	}

	@Override
	public String toString() {
		String s = "CustomerJoin1 [customerid=" + customerid + ", companyname=" + companyname + ", contactname="
				+ contactname + ", 訂單列表=" + 訂單列表 + "]" + 訂單列表.size();
		for (Order o : 訂單列表) {
			s += ToStringBuilder.reflectionToString(o);
		}
		System.out.println(ToStringBuilder.reflectionToString(訂單列表));

		return s;
	}

}

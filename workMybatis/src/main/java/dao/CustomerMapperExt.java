package dao;

import java.util.HashMap;

import model.Customer;

import org.apache.ibatis.annotations.Select;

public interface CustomerMapperExt extends CustomerMapper {

	@Select("select * from customers where customerId = #{customerid}")
	Customer selectByPrimaryKeyAnnotation(String customerid);

	@Select("select * from customers where customerId = #{customerid}")
	HashMap<String, Object> selectByPrimaryKeyAnnotationMap(String customerid);

	Integer 取出customer筆數();
}
package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Customer;
import model.Employee;

import org.apache.ibatis.annotations.Select;

public interface CustomerMapperExt extends CustomerMapper {

	@Select("select * from customers where customerId = #{customerid}")
	Customer selectByPrimaryKeyAnnotation(String customerid);

	@Select("select * from customers where customerId = #{customerid}")
	HashMap<String, Object> selectByPrimaryKeyAnnotationMap(String customerid);

	Integer 取出customer筆數();

	List<HashMap> 最常用的一種select_map例子(String custId);

	List<HashMap> 最常用的一種select_map例子map參數(Map map);

	List<HashMap> 最常用的一種select_map例子map參數2(Map map);

	List<HashMap> 最常用的一種select_map例子map參數3(Map map);

	List<HashMap> 最常用的一種select_map例子class參數(Customer customer);

	List<Employee> 對result物件多做一層mapping(Customer customer);

	List<HashMap<String, Object>> 對join的物件做result的mapping();

	List<HashMap<String, Object>> 對join的物件做result的直接mapping();
}
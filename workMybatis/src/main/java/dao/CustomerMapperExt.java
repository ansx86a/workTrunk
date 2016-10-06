package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Customer;
import model.Employee;
import model.input.MyInput;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

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

	/**
	 * 以下為第二個service的應用
	 */
	List<HashMap> caseWhen的應用();

	List<HashMap> 動態sqlIf(Customer c);

	List<HashMap> 動態sqlCaseWhen(Customer c);

	List<HashMap> 動態sqlIf去化where1等於1(Customer c);

	int 動態sqlIf去化結尾的逗號(Customer c);

	List<HashMap> 動態sqlIf內部參數組合Class(Customer c);

	List<HashMap> 動態sqlIf內部參數組合Map(HashMap c);

	List<HashMap> 動態sqlForEachMap(HashMap c);

	List<HashMap> 動態sqlForEachClass(MyInput c);

	int 多種db支援1();

	int 多種db支援2();

	List<HashMap> 預存程序帶參數的Select(HashMap c);

	List<HashMap> 邏輯分頁(RowBounds rowBounds, HashMap c);

//	List<HashMap> 物理分頁(PageBounds pageBound, HashMap c);

}
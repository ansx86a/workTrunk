package j2seTest;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import model.Customer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 經驗証是有threadSafe<br>
 * 驗証的點有兩個<br>
 * 第一個是由threadId去改變動態sql的參數<br>
 * 當最後mapping出來的參數數目不同的話，就不為threadSafe<br>
 * 第二個是由產出的sql的問號數目是不是等同參數的數目<br>
 * 就算萬一沒有thradSafe，只要弄到工具物件並同步化即可
 * 
 * @author ai
 *
 */
public class 測試SQL抽出有沒有執行緒安全 extends Thread {

	static SqlSessionFactory sqlSessionFactory;
	static MappedStatement ms;
	static boolean running = true;

	public static void main(String[] args) throws Exception {
		init();
		ms = sqlSessionFactory.getConfiguration().getMappedStatement("JustSqlCommand.updateByPrimaryKeySelective");
		for (int i = 0; i < 10000; i++) {
			new 測試SQL抽出有沒有執行緒安全().start();
		}
	}

	public static void init() throws Exception {
		String resource = "j2seTest/SQL語法抽出.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				if (running) {
					run2();
					Thread.sleep(100);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			running = false;
		}
	}

	public void run2() throws Exception {
		long id = Thread.currentThread().getId();
		ArrayList<Object> param = new ArrayList<>();
		ArrayList<Object> result = new ArrayList<>();

		Customer customer = new Customer();
		customer.setCustomerid("custId" + id);
		if (id % 5 == 0) {
			customer.setAddress("addr" + id);
			result.add("addr" + id);
		}
		if (id % 2 == 0) {
			customer.setCity("city" + id);
			result.add("city" + id);
		}
		if (id % 10 == 0) {
			customer.setFax("fax" + id);
			result.add("fax" + id);
		}
		result.add("custId" + id);
		BoundSql bs = ms.getBoundSql(customer);
		for (ParameterMapping pm : bs.getParameterMappings()) {
			param.add(BeanUtils.getProperty(customer, pm.getProperty()));
		}
		String resultStr = bs.getSql().replaceAll("(\n)([ \\t]+(\n))+", "\n");
		resultStr += param.toString();
		System.out.println(resultStr + id);
		int count = StringUtils.countMatches(resultStr, "?");
		if (count != param.size()) {
			throw new RuntimeException(count + "\r\n" + param.size());
		}

		if (!result.toString().equals(param.toString())) {
			throw new RuntimeException(result.toString() + "\r\n" + param.toString());
		}

	}

}

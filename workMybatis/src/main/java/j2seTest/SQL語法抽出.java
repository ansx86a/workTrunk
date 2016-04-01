package j2seTest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.jsp.jstl.core.Config;

import model.Customer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.scripting.xmltags.DynamicSqlSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SQL語法抽出 {

	SqlSessionFactory sqlSessionFactory;

	public static void main(String[] args) throws Exception {
		SQL語法抽出 sql抽出 = new SQL語法抽出();
		sql抽出.init();
		// 直接語法押出，不用改原始碼
		測試一: {
			ArrayList<Object> list = new ArrayList<>();
			String sql = sql抽出.產生jdbcSql語法by問號配beanUtils(list);
			sql = sql.replaceAll("(\n)([ \\t]+(\n))+", "\n");
			System.out.println(sql);
			System.out.println(list);
			System.out.println("=======================");
		}
		sql抽出.產生templateForhHsql的例子();
		System.out.println("========================");
		sql抽出.改寫原始碼取得最初始轉好的template並轉成命名sql參數();
	}

	public void init() throws Exception {
		String resource = "j2seTest/SQL語法抽出.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 還蠻適合配jdbcTemplate的，
	 * @throws Exception
	 */
	public String 產生jdbcSql語法by問號配beanUtils(List<Object> param) throws Exception {
		MappedStatement ms = sqlSessionFactory.getConfiguration().getMappedStatement(
				"JustSqlCommand.updateByPrimaryKeySelective");
		// 由物件產生sql，
		Customer customer = new Customer();
		customer.setCustomerid("custId");
		customer.setCity("city");
		customer.setAddress("addr");
		customer.setFax("fax");
		BoundSql bs = ms.getBoundSql(customer);
		for (ParameterMapping pm : bs.getParameterMappings()) {
			param.add(BeanUtils.getProperty(customer, pm.getProperty()));
		}
		return bs.getSql();
	}

	/**
	 * 只是把hql移到xml寫而已，等同取sql而已
	 */
	public void 產生templateForhHsql的例子() {
		MappedStatement ms = sqlSessionFactory.getConfiguration().getMappedStatement(
				"JustSqlCommand.updateByPrimaryKeySelective2");
		HashMap<String, Object> map = new HashMap<>();
		map.put("customerid", "id1111");
		map.put("city", "city2222");
		map.put("address", "addr3333");
		BoundSql bs = ms.getBoundSql(map);
		String sql = bs.getSql();
		sql = sql.replaceAll("(\n)([ \\t]+(\n))+", "\n");
		System.out.println(sql);
		// 以下參照hibernate應用，把map的值都放進去，沒有list的話用utils來foreach轉成map就可以了？？可行？？
		// Query query = getCurrentSession().createSQLQuery(sql.toString());
		// query.setParameter("keyword", "%" + keyword + "%");
		// query.setParameterList("typeList", typeList);
		// 自已發現這兩個應用更好，如果沒有list的話，有list不曉得
		// Query setProperties(Object bean) ; or Query setProperties(Map bean)

		// finally
		// query.list() or query.executeUpdate();
	}

	public String 改寫原始碼取得最初始轉好的template並轉成命名sql參數() {
		MappedStatement ms = sqlSessionFactory.getConfiguration().getMappedStatement(
				"JustSqlCommand.updateByPrimaryKeySelective");
		Customer customer = new Customer();
		customer.setCustomerid("custId");
		customer.setCity("city");
		customer.setAddress("addr");
		customer.setFax("fax");
		DynamicSqlSource dss = (DynamicSqlSource) ms.getSqlSource();
		DynamicContext context = new DynamicContext(dss.getConfiguration(), customer);
		dss.getRootSqlNode().apply(context);
		String sql = context.getSql();
		sql = sql.replaceAll("(\n)([ \\t]+(\n))+", "\n");
		System.out.println(sql);
		// 用正規表示式來替換成一般的sql
		sql = sql.replaceAll("\\Q#{\\E", ":");
		sql = sql.replaceAll(",jdbcType=(\\w)*}", " ");
		sql = sql.replaceAll("(\n)([ \\t]+(\n))+", "\n");
		System.out.println(sql);
		return sql;
	}

}

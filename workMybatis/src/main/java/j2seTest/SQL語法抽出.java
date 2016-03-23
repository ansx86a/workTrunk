package j2seTest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Config;

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
				"JustSqlCommand.updateByPrimaryKeySelective2");
		// 由物件產生sql，
		Config config = new Config();
		config.setName("name111");
		config.setType("type222");
		BoundSql bs = ms.getBoundSql(config);
		for (ParameterMapping pm : bs.getParameterMappings()) {
			param.add(BeanUtils.getProperty(config, pm.getProperty()));
		}
		return bs.getSql();
	}

	/**
	 * 只是把hql移到xml寫而已，等同取sql而已
	 */
	public void 產生templateForhHsql的例子() {
		MappedStatement ms = sqlSessionFactory.getConfiguration().getMappedStatement(
				"JustSqlCommand.updateByPrimaryKeySelective3");
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "name333");
		map.put("type", "type444");
		BoundSql bs = ms.getBoundSql(map);
		System.out.println(bs.getSql());
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
				"JustSqlCommand.updateByPrimaryKeySelective2");
		Config config = new Config();
		config.setName("name111");
		config.setType("type222");
		DynamicSqlSource dss = (DynamicSqlSource) ms.getSqlSource();
		DynamicContext context = new DynamicContext(dss.getConfiguration(), config);
		dss.getRootSqlNode().apply(context);
		String sql = context.getSql();
		System.out.println(sql);
		// 用正規表示式來替換成一般的sql
		sql = sql.replaceAll("\\Q#{\\E", ":");
		sql = sql.replaceAll(",jdbcType=(\\w)*}", " ");
		System.out.println(sql);
		return sql;
	}

}

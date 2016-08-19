package j2seTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import model.Customer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tool.Utils;

/**
 * 純粹的batis的mapping實作，給hsql和jdbc使用
 * @author ai
 *
 */
public class BatisSqlTool {
	private SqlSessionFactory sqlSessionFactory;
	public static ThreadLocal paramListLocal = new ThreadLocal();

	/**
	 * 空白建構子
	 */
	public BatisSqlTool() {

	}

	/**
	 * 含初始化的建構子
	 * @param inputStream
	 */
	public BatisSqlTool(InputStream inputStream) {
		init(inputStream);
	}

	public static void main(String[] args) throws Exception {
		BatisSqlTool sqlTool = new BatisSqlTool();
		File resourceFile = Utils.getResourceFromRoot("j2seTest/SQL語法抽出.xml");
		sqlTool.init(new FileInputStream(resourceFile));

		String sqlId = "JustSqlCommand.updateByPrimaryKeySelective";
		System.out.println(sqlTool.getJdbcSql(sqlId));
		System.out.println("param=" + sqlTool.getJdbcParam());
		System.out.println("==========================");

		Customer customer = new Customer();
		customer.setCustomerid("custId客戶id");
		customer.setCity("city城市");
		customer.setAddress("addr地扯");
		customer.setFax("fax傳真");
		System.out.println(sqlTool.getJdbcSql(sqlId, customer));
		System.out.println("param=" + sqlTool.getJdbcParam());
		System.out.println("==========================");
		sqlId = "JustSqlCommand.updateByPrimaryKeySelective2";
		System.out.println(sqlTool.getNamingSql(sqlId));
		System.out.println("==========================");
		System.out.println(sqlTool.getNamingSql(sqlId, customer));
	}

	/**
	 * 初始化
	 * @param inputStream
	 */
	public void init(InputStream inputStream) {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public String getJdbcSql(String sqlId) throws Exception {
		return getJdbcSql(sqlId, null, false);
	}

	public String getJdbcSql(String sqlId, Object paramObject) throws Exception {
		return getJdbcSql(sqlId, paramObject, false);
	}

	public String getJdbcSql(String sqlId, Object paramObject, boolean isNaming) throws Exception {
		MappedStatement ms = sqlSessionFactory.getConfiguration().getMappedStatement(sqlId);
		BoundSql bs = ms.getBoundSql(paramObject);
		String sql = bs.getSql();
		sql = sql.replaceAll("(\n)([ \\t]+(\n))+", "\n");
		if (isNaming) {
			return sql;
		}
		// jdbc paramList參數處理
		ArrayList<Object> paramList = new ArrayList<>();
		paramListLocal.set(paramList);

		if (paramObject != null) {
			for (ParameterMapping pm : bs.getParameterMappings()) {
				paramList.add(BeanUtils.getProperty(paramObject, pm.getProperty()));
			}
		}
		return sql;
	}

	/**
	 * 取回上一次呼叫getJdbcSql所產生的paramList
	 * @return
	 */
	public ArrayList<Object> getJdbcParam() {
		return (ArrayList<Object>) paramListLocal.get();
	}

	public String getNamingSql(String sqlId) throws Exception {
		return getJdbcSql(sqlId, null, true);
	}

	public String getNamingSql(String sqlId, Object paramObject) throws Exception {
		return getJdbcSql(sqlId, paramObject, true);
	}

}

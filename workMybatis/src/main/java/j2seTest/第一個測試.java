package j2seTest;

import java.io.IOException;
import java.io.InputStream;

import model.Config;
import model.ConfigExample;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.ConfigMapperExt;

/**
 * 測試有沒有把mybatis串起來
 * @author ai
 *
 */
public class 第一個測試 {

	SqlSessionFactory sqlSessionFactory;

	public static void main(String[] args) throws Exception {
		第一個測試 t1 = new 第一個測試();
		t1.init();
		t1.測試第一個查詢();

	}

	public void init() throws IOException {
		String resource = "j2seTest/第一個測試.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// sqlSessionFactory 這邊會自動關掉inputStream
		// sqlSessionFactory只要一個instance就夠了
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public void 測試第一個查詢() {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			/**
			 * 因為sqlmap會去找interface，每次gen出來的東西都可以直接用蓋的<br>
			 * 所以用了一個new interface去承繼，這裡是放非gen出來的程式碼<br>
			 * 如果用本來的interface當namespace，gen出來的dao程式直接蓋過去可能會把自已寫的dao蓋掉
			 */
			ConfigMapperExt mapper = session.getMapper(ConfigMapperExt.class);
			Config config = mapper.selectByPrimaryKey(1);
			String configStr = ToStringBuilder.reflectionToString(config);
			System.out.println(configStr);
			session.close();
		} catch (Exception ex) {
			if (session != null) {
				session.close();
			}
			throw ex;
		}
	}

	public void 測試第一個example查詢() {
		// 待補完

	}

}

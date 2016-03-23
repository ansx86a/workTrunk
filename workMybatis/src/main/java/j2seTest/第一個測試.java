package j2seTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import model.Config;

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
		// t1.測試第一個查詢();//舊版的寫法
		// t1.測試第一個查詢java7();//更乾淨的寫法
		t1.測試annotation查詢();// 此例還不需要加入ext的sqlmap.xml就可以用了
		t1.測試第一個example查詢();// 跨資料庫使用，因為example是用捲出來的
	}

	public void init() throws IOException {
		String resource = "j2seTest/第一個測試.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// sqlSessionFactory 這邊會自動關掉inputStream
		// sqlSessionFactory只要一個instance就夠了
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public void 測試第一個查詢() {
		SqlSession session = sqlSessionFactory.openSession();
		// 這裡的寫法只是要最後可以close session而已
		try {
			if (true) {// 把這裡改成true，可以看到finally確實有被執行
				int a = 100 / 0;
			}
			/**
			 * 因為sqlmap會去找interface，每次gen出來的東西都可以直接用蓋的<br>
			 * 所以用了一個new interface去承繼，這裡是放非gen出來的程式碼<br>
			 * 如果用本來的interface當namespace，gen出來的dao程式直接蓋過去可能會把自已寫的dao蓋掉
			 */
			ConfigMapperExt mapper = session.getMapper(ConfigMapperExt.class);
			Config config = mapper.selectByPrimaryKey(1);
			String configStr = ToStringBuilder.reflectionToString(config);
			System.out.println(configStr);
		} catch (Exception ex) {
			System.out.println("ex=" + ex);
			throw ex;
		} finally {
			System.out.println("willclose");
			session.close();
			session.close();
			System.out.println("closed");
		}
	}

	public void 測試第一個查詢java7() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			ConfigMapperExt mapper = session.getMapper(ConfigMapperExt.class);
			Config config = mapper.selectByPrimaryKey(1);
			String configStr = ToStringBuilder.reflectionToString(config);
			System.out.println(configStr);
		}
	}

	/**
	 * 此例證明resultMapping純看returnType而定
	 */
	public void 測試annotation查詢() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			ConfigMapperExt mapper = session.getMapper(ConfigMapperExt.class);
			Config config = mapper.selectByPrimaryKeyAnnotation(1);
			String configStr = ToStringBuilder.reflectionToString(config);
			System.out.println(configStr);
			HashMap<String, Object> map = mapper.selectByPrimaryKeyAnnotationMap(1);
			System.out.println(map);
		}
	}

	public void 測試第一個example查詢() {
		// 待補完

	}

}

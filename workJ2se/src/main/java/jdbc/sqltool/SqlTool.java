package jdbc.sqltool;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class SqlTool {

	private File rootFile;
	private Properties prop = new Properties();
	private String jdbcString = "";
	private boolean printColumn = false;
	private String splitChar = "\t";
	private String resultEncode = "ms950";
	private String sqlFileEncode = "ms950";

	public static void main(String[] arg) {
		System.out.println("start...");
		try {
			new SqlTool().run();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("end...");
	}

	public void run() throws Exception {
		init();
		readConfig();
		readFile();
	}

	public void init() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		URL location = SqlTool.class.getProtectionDomain().getCodeSource().getLocation();
		rootFile = new File(location.toURI());
		if (!rootFile.toString().endsWith("classes")) {
			rootFile = rootFile.getParentFile();
		}else{
			rootFile = new File(rootFile,"jdbc/sqltool");
		}
		System.out.println(rootFile.getAbsolutePath());
	}

	public void readConfig() throws Exception {
		File configFile = new File(rootFile, "config.properties");
		prop.load(new FileInputStream(configFile));
		jdbcString = String.format("jdbc:sqlserver://%s;DatabaseName=%s", prop.getProperty("ip"),
				prop.getProperty("databaseName"));
		// 初始化分隔字串
		if (prop.getProperty("selectResultSplitChar") != null && prop.getProperty("selectResultSplitChar").length() > 0) {
			splitChar = prop.getProperty("selectResultSplitChar");
		}
		if (StringUtils.equals("1", prop.getProperty("selectResultDisplayColumn"))) {
			printColumn = true;
		}
		if (StringUtils.isNotBlank(prop.getProperty("selectResultEncode"))) {
			resultEncode = prop.getProperty("selectResultEncode");
		}
		if (StringUtils.isNotBlank(prop.getProperty("sqlFileEncode"))) {
			sqlFileEncode = prop.getProperty("sqlFileEncode");
		}
	}

	public void readFile() throws Exception {
		for (File f : rootFile.listFiles()) {
			if (f.isDirectory()) {
				continue;
			}
			// 讀取檔案執行sql
			if (StringUtils.endsWithIgnoreCase(f.getName(), ".sql")) {
				List<String> sqlList = FileUtils.readLines(f, sqlFileEncode);
				if (sqlList.size() > 0) {
					exeSql(sqlList, f);
				}
			}
		}
	}

	public void exeSql(List<String> sqlList, File f) throws Exception {
		Connection conn = DriverManager.getConnection(jdbcString, prop.getProperty("username"),
				prop.getProperty("password"));
		ArrayList<String> resultList = new ArrayList<String>();
		// 一個檔只print 一次title
		boolean isPrintTitled = false;
		try {
			for (String s : sqlList) {
				s = StringUtils.trimToEmpty(s);
				if (s.length() <= 10) {
					continue;
				}
				Statement st = conn.createStatement();
				if (!StringUtils.startsWithIgnoreCase(s, "select")) {
					// 非select
					System.out.println("execute " + s.split(" ")[0]);
					st.executeUpdate(s);
				} else {
					System.out.println("execute " + s.split(" ")[0]);
					ResultSet rs = st.executeQuery(s);
					ResultSetMetaData metaData = rs.getMetaData();
					String title = "";
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						title += metaData.getColumnName(i);
						if (i < metaData.getColumnCount()) {
							title += splitChar;
						}
					}
					while (rs.next()) {
						String row = "";
						for (int i = 1; i <= metaData.getColumnCount(); i++) {
							row += rs.getObject(i);
							if (i < metaData.getColumnCount()) {
								row += splitChar;
							}
						}
						resultList.add(row);
					}
					if (resultList.size() > 0 && printColumn && !isPrintTitled) {
						resultList.add(0, title);
						isPrintTitled = true;
					}
					rs.close();
				}
				st.close();
			}
		} finally {
			conn.close();
		}
		if (resultList.size() > 0) {
			String newName = (f.getName().replaceAll("\\.[sS][qQ][lL]$", ".txt"));
			File resultFile = new File(rootFile, newName);
			StringBuffer sb = new StringBuffer("");
			for (String s : resultList) {
				sb.append("\r\n").append(s);
			}
			FileUtils.write(resultFile, sb.toString().replaceFirst("\r\n", ""), resultEncode);
		}
	}
}
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

public class DbUtils {

	public static Pair<List<String>, List<Map<String, Object>>> getFrom(String sql, DataSource ds) throws SQLException {
		List<String> columns = new ArrayList<>();
		List<Map<String, Object>> datasList = new ArrayList<>();
		try (Connection cs = ds.getConnection();
				PreparedStatement s1 = cs.prepareStatement(sql);
				ResultSet rs = s1.executeQuery()) {
			ResultSetMetaData meta = rs.getMetaData();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				columns.add(meta.getColumnName(i));
			}
			while (rs.next()) {
				Map<String, Object> dataMap = new HashMap<>();
				for (String s : columns) {
					dataMap.put(sql, rs.getObject(s));
				}
				datasList.add(dataMap);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return Pair.of(columns, datasList);
	}

	public static void writeTo(Pair<List<String>, List<Map<String, Object>>> pair, String sql, DataSource ds)
			throws SQLException {
		List<String> columns = pair.getLeft();
		List<String> valueList = new ArrayList<>();
		for (int i = 0; i < columns.size(); i++) {
			valueList.add("?");
		}
		String keys = StringUtils.join(columns, ",");
		String values = StringUtils.join(valueList, ",");
		String insertSql = sql + String.format("  (%s) values (%s)", keys, values);
		System.out.println(insertSql);
		if (CollectionUtils.isEmpty(pair.getRight())) {
			System.out.println("空的不執行新增");
			return;
		}
		for (Map<String, Object> map : pair.getRight()) {
			try (Connection cs = ds.getConnection(); PreparedStatement s1 = cs.prepareStatement(insertSql)) {
				for (int i = 0; i < columns.size(); i++) {
					s1.setObject(i + 1, map.get(columns.get(i)));
				}
				s1.execute();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
			}
		}
	}

}

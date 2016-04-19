package spring.jdbcForTaskRunable;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SsisMock {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Scheduled(cron = "0/10 * * * * ?")
	public void job() {
		// System.out.println("123-" + new Date());
		try {
			System.out.println("run");
			run();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void run() {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO [ANZ_WORKFLOW].[dbo].[temp_action]");
		sql.append(" SELECT *");
		sql.append(" FROM   [ANZ_TW_DB].[dbo].[temp_action]");

		int count = jdbcTemplate.update(sql.toString());
		if (count > 0) {
			System.out.println(new Date());
			System.out.println("ssis update temp_action count = " + count);
			// 有insert 資料進去就做delete
			sql = new StringBuffer();
			sql.append("delete from [ANZ_TW_DB].[dbo].[temp_action]");
			count = jdbcTemplate.update(sql.toString());
			if (count > 0) {
				System.out.println("ssis delete temp_action count = " + count);
			}
		}
		sql = new StringBuffer();
		sql.append("INSERT INTO [ANZ_WORKFLOW].[dbo].[temp_cc_photo]");
		sql.append(" SELECT *");
		sql.append(" FROM   [ANZ_TW_DB].[dbo].[temp_cc_photo]");
		count = jdbcTemplate.update(sql.toString());
		if (count > 0) {
			System.out.println(new Date());
			System.out.println("ssis update temp_cc_photo count = " + count);
			// 有insert 資料進去就做delete
			sql = new StringBuffer();
			sql.append("delete from [ANZ_TW_DB].[dbo].[temp_cc_photo]");
			count = jdbcTemplate.update(sql.toString());
			if (count > 0) {
				System.out.println("ssis delete temp_cc_photo count = " + count);
			}
		}
		sql = new StringBuffer();
		sql.append("INSERT INTO [ANZ_WORKFLOW].[dbo].[temp_ccs_photo]");
		sql.append(" SELECT *");
		sql.append(" FROM   [ANZ_TW_DB].[dbo].[temp_ccs_photo]");
		count = jdbcTemplate.update(sql.toString());
		if (count > 0) {
			System.out.println(new Date());
			System.out.println("ssis update temp_ccs_photo count = " + count);
			sql = new StringBuffer();
			sql.append("delete from [ANZ_TW_DB].[dbo].[temp_ccs_photo]");
			count = jdbcTemplate.update(sql.toString());
			if (count > 0) {
				System.out.println("ssis delete temp_ccs_photo count = " + count);
			}
		}
		sql = new StringBuffer();
		sql.append("INSERT INTO [ANZ_WORKFLOW].[dbo].[temp_cusdata]");
		sql.append(" SELECT *");
		sql.append(" FROM   [ANZ_TW_DB].[dbo].[temp_cusdata]");
		count = jdbcTemplate.update(sql.toString());
		if (count > 0) {
			System.out.println(new Date());
			System.out.println("ssis update temp_cusdata count = " + count);
			sql = new StringBuffer();
			sql.append("delete from [ANZ_TW_DB].[dbo].[temp_cusdata]");
			count = jdbcTemplate.update(sql.toString());
			if (count > 0) {
				System.out.println("ssis delete temp_cusdata count = " + count);
			}
		}
		sql = new StringBuffer();
		sql.append("INSERT INTO [ANZ_WORKFLOW].[dbo].[temp_sa_photo]");
		sql.append(" SELECT *");
		sql.append(" FROM   [ANZ_TW_DB].[dbo].[temp_sa_photo]");
		count = jdbcTemplate.update(sql.toString());
		if (count > 0) {
			System.out.println(new Date());
			System.out.println("ssis update temp_sa_photo count = " + count);
			sql = new StringBuffer();
			sql.append("delete from [ANZ_TW_DB].[dbo].[temp_sa_photo]");
			count = jdbcTemplate.update(sql.toString());
			if (count > 0) {
				System.out.println("ssis delete temp_sa_photo count = " + count);
			}
		}
	}
}

package qualapps.survey.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	public synchronized long getNextVal (String tblName) {
		if (tblName != null) {
			return getTbl(tblName);
		} else {
			return 0;
		}
	}
	
	private long getTbl (String tblName) {
		long keyValue = 0;
		String keyName = null;
		if (tblName != null) {
			String keyTbl = "select key_name from key_generator where key_name = ?";
			try{
				keyName = jdbcTemplate.queryForObject(keyTbl, new Object[]{tblName}, String.class);
			} catch (Exception e) {
				// Could not find table name in key_generator table, need to insert one
			}
			
			if (keyName != null) {
				if (keyName.length() > 0) {
					keyValue = jdbcTemplate.queryForObject("select key_value from key_generator where key_name = ?", new Object[]{tblName}, Long.class);
					String updSql = "update key_generator set key_value = ? where key_name = ?";
					keyValue = keyValue + 1;
					jdbcTemplate.update(updSql, keyValue, tblName);
				}
			} else {
				String insSql = "insert into key_generator (key_name, key_value) values (?, ?)";
				jdbcTemplate.update(insSql, tblName, 0);
				return getTbl(tblName);
			}
		}
		return keyValue;
	}


}

package mysql.dao;

import java.util.List;
import java.util.Map;

public interface Tstrfv2Dao {
	public List<Map<String, Object>> findALL(String sql);
	public void execute(String sql);
}

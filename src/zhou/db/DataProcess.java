package zhou.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import zhou.db.DataAccess;

public class DataProcess {
	DataAccess dataAccess;
	
	public DataProcess(String dbName) {
		dataAccess = new DataAccess(dbName);
	}
	//关闭连接
	public void closeConnect() {
		dataAccess.colseConnect();
	}
	//登录验证
	public boolean CheckAdmin(String adminName,String password) {
		if (password == null) {
			password = "null";
		}
		Object[] parameter = new Object[] {adminName,password};

		ResultSet resultSet = dataAccess.DatabaseOperations("call AdminCheck(?,?)", parameter);
		try {
			//没有输入密码时验证管理员是否存在
			if (password == "null") {
				while (resultSet.next()) {
					if (resultSet.getString(1).equals("1")) {
						return true;
					}
					return false;
				}
			}
			//验证管理员信息
			else {
				while (resultSet.next()) {
					if (resultSet.getString(1) != null) {
						return true;
					}
				}
				return false;
			}
			
			resultSet.close();
			closeConnect();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}

package zhou.db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.lang.Exception;

public class DataAccess {
	private String user = "root";				//用户名
	private String password = "2018";			//用户密码
	private boolean isConnection = false;		//是否已连接
	private Connection connDB = null;			//Connection对象
	private String ErrorStr = null;				//错误信息
	
	
	//连接数据库
	public DataAccess(String DBName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
			connDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"?useSSL=false", user, password);//连接数据库
			if (connDB != null) {
				isConnection = true;
				//System.out.println("connect");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//判断是否已经连接
	public boolean isConnection() {
		return isConnection;
	}
	//数据库操作
	public ResultSet DatabaseOperations(String SQLStatement, Object[] parameter)
	{
		try {
			ErrorStr = null;
			PreparedStatement pStatement = connDB.prepareStatement(SQLStatement);//创建Statement
			//设置参数
			if (parameter != null) {
				for (int i = 0; i < parameter.length; i++) {
					pStatement.setString(i+1, (String)parameter[i]);
				}
			}
			boolean result = pStatement.execute();//执行SQL语句
			//System.out.println("execute");
			if (result == true) {
				return pStatement.getResultSet();//返回结果集
			}
		} catch (Exception e) {
			ErrorStr = e.getMessage();
		}
		return null;
	}
	//获取错误信息
	public String getErrorStr() {
		return ErrorStr;
	}
	
	//关闭连接
	public void colseConnect() {
		if (connDB != null) {
			try {
				connDB.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//	//测试
//	public static void main(String[] args) {
//		DataAccess dataAccess = new DataAccess("ascentWeb");
//		ResultSet set =  dataAccess.DatabaseOperations("select * from user",null);
//		//set.next();
//		try {
//			while (set.next()) {
//				System.out.println(set.getString("username"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		dataAccess.colseConnect();
//	}
}

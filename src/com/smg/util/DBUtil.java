package com.smg.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * <p>Title: DBUtil</p>
 * <p>Description: 数据库链接工具类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年7月2日 下午12:42:32
 * @version 1.0
 */
public class DBUtil {
	private static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/man?useUnicode=true&characterEncoding=utf8", "root", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	/*public static void main(String[] args) {
		Connection connection2 = DBUtil.getConnection();
		System.out.println(connection2);
	}*/
}

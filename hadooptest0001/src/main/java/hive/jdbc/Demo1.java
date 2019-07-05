package hive.jdbc;

import java.sql.*;

public class Demo1 {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		Connection con = DriverManager.getConnection("jdbc:hive2://172.16.1.240:10000/default", "root", "root");
		Statement stmt = con.createStatement();

		String sql = "show tables";
		System.out.println("Running: " + sql);
		ResultSet res = stmt.executeQuery(sql);
		if (res.next()) {
			System.out.println(res.getString(1));
		}

		// describe table
		sql = "describe teacherexternal";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1) + "\t" + res.getString(2));
		}


		sql = "select * from teacherexternal";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(String.valueOf(res.getObject(1)) + "\t" + res.getString(2)+ "\t" + res.getInt(3)+ "\t" + res.getString(4));
		}

		sql = "select count(1) from teacherexternal";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1));
		}
	}
}














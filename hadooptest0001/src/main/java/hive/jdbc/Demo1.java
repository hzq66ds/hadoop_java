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
		Connection con = DriverManager.getConnection("jdbc:hive2://hadoopmaster:10000/default", "root", "root");


		String sql = "show tables";
		System.out.println("Running: " + sql);
		Statement stmt3 = con.createStatement();
		ResultSet res = stmt3.executeQuery(sql);
		while (res.next()) {
			System.out.println("-------表："+res.getString(1));
			// describe table
			String tablename = res.getString(1);
			sql = "describe "+tablename;
			System.out.println("Running: " + sql);
			Statement stmt2 = con.createStatement();
			ResultSet res1 = stmt2.executeQuery(sql);
			while (res1.next()) {
				System.out.println(res1.getString(1) + "\t" + res1.getString(2));
			}


			sql = "select * from "+tablename;
			System.out.println("Running: " + sql);
			Statement stmt1 = con.createStatement();
			ResultSet res2 = stmt1.executeQuery(sql);
			while (res2.next()) {
				ResultSetMetaData rsmd = res2.getMetaData() ;
				int columnCount = rsmd.getColumnCount();
				StringBuffer buffer = new StringBuffer();
				for (int i=1;i<=columnCount;i++){
					buffer.append(res2.getObject(i)).append("\t");
				}
				System.out.println(buffer.toString());
			}

			sql = "select count(1) from "+tablename;
			System.out.println("Running: " + sql);
			Statement stmt = con.createStatement();
			ResultSet res3 = stmt.executeQuery(sql);
			while (res3.next()) {
				System.out.println(res3.getString(1));
			}
		}
	}
}














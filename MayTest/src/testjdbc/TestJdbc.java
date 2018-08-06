package testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbc {
	public static void main(String[] args) {
		//声明connect对象
		Connection con;
		//驱动程序名
		String driver = "com.mysql.cj.jdbc.Driver";
		//URL指向要访问的数据库
		String url = "jdbc:mysql://localhost:3306/mouse?userUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
		//用户名和密码
		String root = "root";
		String password = "root";
		//遍历查询结果集
		try {
			//加载驱动程序
			Class.forName(driver);
			//1.getConnection()方法，连接mysql数据库
			con = DriverManager.getConnection(url, root, password);
			if(!con.isClosed())
				System.out.println("Succeed connecting to the Database!");
			//2。创建statement对象，用于执行数据库sql语句
			Statement statement = con.createStatement();
			String sql = "select * from user";
			//3.ResultSet类，用来存放获取的结果集
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------------------");
			System.out.println("执行结果如下：");
			System.out.println("-----------------------");
			System.out.println("姓名、性别");
			System.out.println("-----------------------");
			
			String name = null;
			String sex = null;
			while(rs.next()) {
				name = rs.getString("name");
				sex = rs.getString("sex");
				System.out.println(name+"、"+sex);
			}
			rs.close();
			con.close();
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
}

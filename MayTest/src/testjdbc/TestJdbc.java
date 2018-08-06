package testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbc {
	public static void main(String[] args) {
		//����connect����
		Connection con;
		//����������
		String driver = "com.mysql.cj.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ�
		String url = "jdbc:mysql://localhost:3306/mouse?userUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
		//�û���������
		String root = "root";
		String password = "root";
		//������ѯ�����
		try {
			//������������
			Class.forName(driver);
			//1.getConnection()����������mysql���ݿ�
			con = DriverManager.getConnection(url, root, password);
			if(!con.isClosed())
				System.out.println("Succeed connecting to the Database!");
			//2������statement��������ִ�����ݿ�sql���
			Statement statement = con.createStatement();
			String sql = "select * from user";
			//3.ResultSet�࣬������Ż�ȡ�Ľ����
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------------------");
			System.out.println("ִ�н�����£�");
			System.out.println("-----------------------");
			System.out.println("�������Ա�");
			System.out.println("-----------------------");
			
			String name = null;
			String sex = null;
			while(rs.next()) {
				name = rs.getString("name");
				sex = rs.getString("sex");
				System.out.println(name+"��"+sex);
			}
			rs.close();
			con.close();
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
}

package fileknowledge;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class TestProperties {
	private static String param1;
	private static String param2;
	
	/**
	 * static块 类加载的时候执行
	 */
	static{
		Properties prop = new Properties();
		//第一种方式（要具体的所在类）
//		InputStream in = TestProperties.class.getClassLoader().getResourceAsStream("test.properties");
		//第二种方式
//		InputStream in = Object.class.getClassLoader().getResourceAsStream("/test.properties");
		
		try {
			//自己增加，后面查看前两种方法为何不可以？经初步估计是而我年间路径问题
			//读取文件方式
			// 读取文件内容 (输入流)
			File file = new File("D:\\workspace\\MayTest\\src\\fileknowledge", "test.properties");
			FileInputStream out = new FileInputStream(file);
			InputStreamReader in = new InputStreamReader(out);
			
			
			prop.load(in);
			param1 = prop.getProperty("name1").trim();
			param2 = prop.getProperty("name2").trim();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 私有构造方法
	 */
	private TestProperties() {
	}
	
	public static String getParam1() {
		return param1;
	}
	
	public static String getParam2() {
		return param2;
	}
	
	public static void main(String[] args) {
		System.out.println(TestProperties.getParam1());
		System.out.println(TestProperties.getParam2());
		System.out.println(TestProperties.getPackagePath());
	}
	
	/**
	 * 获取当前类所在包
	 */
	public static File getPackagePath() {
		File file = new File(TestProperties.class.getResource("").getPath());
		return file;
	}
	
}

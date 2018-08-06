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
	 * static�� ����ص�ʱ��ִ��
	 */
	static{
		Properties prop = new Properties();
		//��һ�ַ�ʽ��Ҫ����������ࣩ
//		InputStream in = TestProperties.class.getClassLoader().getResourceAsStream("test.properties");
		//�ڶ��ַ�ʽ
//		InputStream in = Object.class.getClassLoader().getResourceAsStream("/test.properties");
		
		try {
			//�Լ����ӣ�����鿴ǰ���ַ���Ϊ�β����ԣ������������Ƕ������·������
			//��ȡ�ļ���ʽ
			// ��ȡ�ļ����� (������)
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
	 * ˽�й��췽��
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
	 * ��ȡ��ǰ�����ڰ�
	 */
	public static File getPackagePath() {
		File file = new File(TestProperties.class.getResource("").getPath());
		return file;
	}
	
}

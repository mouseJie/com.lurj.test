package fileknowledge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.google.gson.Gson;

import fileknowledge.data.TestData;

public class TestInputOutFile {
	public static void main(String[] args) {
		try{
			//写入txt文件的内容
			TestData data = new TestData();
			data.setName("罗志祥");
			data.setGrade("三年二班");
			data.setBirthPlace("台北省");
			data.setBirthY(1995);
			data.setBirthM(8);
			
			//记录时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String currentDate = sdf.format(Calendar.getInstance().getTime());
			data.setSignDate(currentDate);
			
			String filePath = "D:\\workspace\\MayTest\\src\\fileknowledge\\buildtxt\\TestTxt.txt";
			FileOutputStream fos = new FileOutputStream(filePath);
			String json = new Gson().toJson(data);
			fos.write(json.getBytes());
			fos.close();
			
			//读取文件
//			File file = new File(filePath);
//			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
//			BufferedReader br = new BufferedReader(reader);
//			String line = "";
//			line = br.readLine();
//			while(line!=null) {
//				line = br.readLine();
//			}
////			JsonObject jo = new JsonObject().getAsJsonObject(line);
//			TestData readData = new Gson().fromJson(line, TestData.class);
//			if(null!=readData) {
//				System.out.print("读取txt文件成功！");
//			}
			FileInputStream inputStream = new FileInputStream(filePath);
			InputStreamReader isr = new InputStreamReader(inputStream);
			int ch = 0;
			String s = "";
			while ((ch = isr.read()) != -1) {
				System.out.print((char) ch);
				s = s+(char)ch;
			}
			isr.close();
			System.out.print("\n"+s);
			TestData readData = new Gson().fromJson(s, TestData.class);
			if (null != readData) {
				System.out.print("读取\""+readData.getName()+"\"txt文件成功！");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

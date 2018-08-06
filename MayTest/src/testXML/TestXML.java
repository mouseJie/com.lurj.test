package testXML;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.io.SAXReader;

public class TestXML {
	
	public void readXMLDemo() throws Exception{
		SAXReader reader = new SAXReader();
		reader.read(new File("src/testXML/car.xml"));
	}
	
	public static void main(String[] args) {
		String str = "<?xml version=\"1.0\" encoding=\"GBK\"?><Resp><TxCode>ZZCX01</TxCode><TraceNo>20180524ZZCXFX00100000001</TraceNo><UnitCode>882714406205</UnitCode><UnitName>上海市奉贤区行政服务管理办公室</UnitName><PriAccount>124907684205</PriAccount><PriName>曹晨</PriName><IdCardNum>310226198802071112</IdCardNum><BranchName>奉贤支行</BranchName><LastPayMonth>201803</LastPayMonth><MonthPay>1132.00</MonthPay><Surplus>58079.43</Surplus><TotalPay>58079.43</TotalPay><TotalDraw>0.00</TotalDraw><OpenDate>20110728</OpenDate><CloseDate>00000000</CloseDate><HjState>0</HjState><LastTxDate>20180317</LastTxDate><RetCode>0000</RetCode><RetMsg>交易成功</RetMsg></Resp>";
		try {
			byte[] gbkBytes = str.getBytes("GBK");
//			byte[] utfbytes = str.getBytes("utf-8");
			System.out.println("gbk编码字节长度为："+gbkBytes.length);
			System.out.println("utf-8编码字节长度为："+str.length());
			
			//计数方法一
			int count = 0;
			String regEx = "[\u4e00-\u9fa5]";
	        Pattern p = Pattern.compile(regEx);
	        Matcher m = p.matcher(str);
	        while(m.find())
	        {
	            count ++;
	        }
	        System.out.println("计数方法一：该字符串中包含中文个数为："+count);
	        
	        //计数方法二（将找到的中文字符全部换成两个字符，然后减去原来的字符串长度就是中文字符个数）
	        count = 0;
	        String term = str.replaceAll(regEx, "aa");
	        count = term.length()-str.length();
	        System.out.println("计数方法二：该字符串中包含中文个数为："+count);
	        
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

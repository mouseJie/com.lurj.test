package testXML;

import java.io.UnsupportedEncodingException;

public class TestValueFormat {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "<?xml version=\"1.0\" encoding=\"GBK\"?><Resp><TxCode>ZZCX01</TxCode><TraceNo>20180524ZZCXFX00100000001</TraceNo><UnitCode>882714406205</UnitCode><UnitName>上海市奉贤区行政服务管理办公室</UnitName><PriAccount>124907684205</PriAccount><PriName>曹晨</PriName><IdCardNum>310226198802071112</IdCardNum><BranchName>奉贤支行</BranchName><LastPayMonth>201803</LastPayMonth><MonthPay>1132.00</MonthPay><Surplus>58079.43</Surplus><TotalPay>58079.43</TotalPay><TotalDraw>0.00</TotalDraw><OpenDate>20110728</OpenDate><CloseDate>00000000</CloseDate><HjState>0</HjState><LastTxDate>20180317</LastTxDate><RetCode>0000</RetCode><RetMsg>交易成功</RetMsg></Resp>";
		String length = packLength(str.length());
		System.out.println(length);
		
		String str1 = "<?xml version=\"1.0\" encoding=\"GBK\"?><Req><AcctType>1</AcctType><IdCardNum>310226198802071112</IdCardNum><OrgaCode>ZZCXFX001</OrgaCode><PassWord>SPFMC0507</PassWord><PriName>曹晨</PriName><SysCode>ZZCX</SysCode><TraceNo>20180524ZZCXFX00100000001</TraceNo><TxCode>ZZCX01</TxCode></Req>";
		System.out.println(packLength(str1.length()));
		System.out.println(packLength(str1.getBytes("GBK").length));
	}
	
	/**
	 * 0---0000
	 * @param x
	 * @return
	 */
	public static String packLength(int x){
		String xs=String.valueOf(x);
		String [] ss = {"0000","000","00","0"};
		xs = ss[xs.length()] + xs;
		return xs;
	}
}

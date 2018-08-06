package testXML;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

public class TestResolveXML {
	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"GBK\"?><Resp><TxCode>ZZCX02</TxCode><TraceNo>20180527ZZCXFX00100000002</TraceNo><PriName>姓名1</PriName><PriAccount>209001001785</PriAccount><LastTxDate>20180317</LastTxDate><RetCode>0000</RetCode><RetMsg>交易成功</RetMsg><Ret_record><Record_info><TxDate>20170921</TxDate><Summary>F02</Summary><Reason>汇缴漏缴</Reason><PayMonth>201704</PayMonth><Amount>624.0</Amount><Surplus>624.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info><Record_info><TxDate>20170921</TxDate><Summary>F02</Summary><Reason>汇缴漏缴</Reason><PayMonth>201701</PayMonth><Amount>624.0</Amount><Surplus>1248.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info><Record_info><TxDate>20170921</TxDate><Summary>F02</Summary><Reason>汇缴漏缴</Reason><PayMonth>201703</PayMonth><Amount>624.0</Amount><Surplus>1872.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info><Record_info><TxDate>20170921</TxDate><Summary>F02</Summary><Reason>汇缴漏缴</Reason><PayMonth>201702</PayMonth><Amount>624.0</Amount><Surplus>2496.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info><Record_info><TxDate>20170921</TxDate><Summary>F02</Summary><Reason>汇缴漏缴</Reason><PayMonth>201705</PayMonth><Amount>624.0</Amount><Surplus>3120.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info><Record_info><TxDate>20170921</TxDate><Summary>F02</Summary><Reason>汇缴漏缴</Reason><PayMonth>201706</PayMonth><Amount>624.0</Amount><Surplus>3744.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info><Record_info><TxDate>20170921</TxDate><Summary>F01</Summary><Reason></Reason><PayMonth>201709</PayMonth><Amount>652.0</Amount><Surplus>4396.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info><Record_info><TxDate>20170928</TxDate><Summary>F02</Summary><Reason>汇缴漏缴</Reason><PayMonth>201708</PayMonth><Amount>652.0</Amount><Surplus>5048.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info><Record_info><TxDate>20170928</TxDate><Summary>F02</Summary><Reason>汇缴漏缴</Reason><PayMonth>201707</PayMonth><Amount>652.0</Amount><Surplus>5700.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info><Record_info><TxDate>20171019</TxDate><Summary>F01</Summary><Reason></Reason><PayMonth>201710</PayMonth><Amount>652.0</Amount><Surplus>6352.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info><Record_info><TxDate>20171114</TxDate><Summary>F01</Summary><Reason></Reason><PayMonth>201711</PayMonth><Amount>652.0</Amount><Surplus>7004.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info><Record_info><TxDate>20171214</TxDate><Summary>F01</Summary><Reason></Reason><PayMonth>201712</PayMonth><Amount>652.0</Amount><Surplus>7656.0</Surplus><BankInt>0.0</BankInt><UnitCode>209881537072</UnitCode><UnitName>中国科学院上海生命科学研究院</UnitName></Record_info></Ret_record></Resp>";
		System.out.println(xml);
		try {
			//第一种
			Document dom=DocumentHelper.parseText(xml);
			Element root=dom.getRootElement();  
	        String RetCode = root.element("RetCode").getText(); 
	        String RetMsg = root.element("RetMsg").getText();
	        Element info = root.element("Ret_record");
	        List<Element> list = info.elements() ;
	        for(Element item : list) {
	        	System.out.println(item.element("TxDate").getName()+item.element("TxDate").getText()
	        			+" "+item.element("Summary").getName()+item.element("Summary").getText()
	        			+" "+item.element("Reason").getName()+item.element("Reason").getText()
	        			+" "+item.element("PayMonth").getName()+item.element("PayMonth").getText()
	        			+" "+item.element("Amount").getName()+item.element("Amount").getText()
	        			+" "+item.element("Surplus").getName()+item.element("Surplus").getText()
	        			+" "+item.element("BankInt").getName()+item.element("BankInt").getText()
	        			+" "+item.element("UnitCode").getName()+item.element("BankInt").getText()
	        			+" "+item.element("UnitName").getName()+item.element("BankInt").getText()
	        			);
	        
	        }
//	        <TxDate>交易日期</TxDate>
//	        <Summary>摘要代码</Summary>
//	        <Reason>业务发生原因</Reason>
//	        <PayMonth>汇缴月份</PayMonth>
//	        <Amount>发生金额</Amount>
//	        <Surplus>余额</Surplus>
//	        <BankInt>银行利息</BankInt>
//	        <UnitCode>单位账号</UnitCode>
//	        <UnitName>单位名称</UnitName>
			
//			//第二种
//			Document document=DocumentHelper.parseText(xml);
//			//获取文档根节点
//			Element root = document.getRootElement();
//			//输出根标签的名字
//			System.out.println(root.getName());
//
//			//获取根节点下面的所有子节点（不包过子节点的子节点）
//	        List<Element> list = root.elements() ;
//	        //遍历List的方法
//	        for (Element e:list){
//	            System.out.println(e.getName());
//	        }
//	        
//	      //获得指定节点下面的子节点
//	        Element contactElem = root.element("Ret_record");//首先要知道自己要操作的节点。 
//	        List<Element> contactList = contactElem.elements();
//	        for (Element e:contactList){
//	            System.out.println(e.getName());
//	        }
//	        
//	      //调用下面获取子节点的递归函数。
//	        getChildNodes(root);
//	        
//	        
//	        //获得当前标签下指定名称的第一个子标签
//	        Element conElem = root.element("TraceNo");
//	        System.out.println(conElem.getText());
//	        
//	        
//	        //获得更深层次的标签（一层一层的获取）
//	        Element nameElem = root.element("Ret_record").element("Reason");
//	        System.out.println(nameElem.getText());
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	 //递归查询节点函数,输出节点名称
    private static void  getChildNodes(Element elem){
        System.out.println(elem.getName());
        Iterator<Node> it=    elem.nodeIterator();
        while (it.hasNext()){
            Node node = it.next();
            if (node instanceof Element){
                Element e1 = (Element)node;
                getChildNodes(e1);
                }
            
            }
        }
}

package hb.test.jetty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.xml.sax.SAXException;

public class SimpleServerStart {

	public static void main(String[] args) {
		
		
		try {
			// 服务器的监听端口
	        Server server = new Server(8080);
	         
	        // 关联一个已经存在的上下文
	        WebAppContext context = new WebAppContext();
	         
	        // 设置描述符位置
	        context.setDescriptor("./web/WEB-INF/web.xml");
	         
	        // 设置Web内容上下文路径
	        context.setResourceBase("./web");
	         
	        // 设置上下文路径
	        context.setContextPath("/myproject");
	        context.setParentLoaderPriority(true);
	  
	        server.setHandler(context);
	  
	        // 启动
	        server.start();
	        server.join();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

package hb.test.jetty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.xml.sax.SAXException;

public class SimpleServerConfig {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//创建一个默认服务器对象
			Server server = new Server();
//			server.setHandler(new DefaultHandler());
			//初始化server对象的属性，这些属性全部来至于xmlconfig文件的配置，有点类似于spring通过配置文件获取对象
			XmlConfiguration config = new XmlConfiguration(new FileInputStream("./jetty/etc/jetty.xml"));
			
			config.configure(server);
			//给创建的server服务器配置处理的handler对象，可以通过xmlconfig配置，也可以手动配置，下面代码是手动配置完成的
			ContextHandlerCollection handler = new ContextHandlerCollection();
			//创建一个webapp对象
			WebAppContext webapp = new WebAppContext();
			//一定要有反斜杠，表示当前工程的上下文
			webapp.setContextPath("/myjetty");
			webapp.setDefaultsDescriptor("./jetty/etc/webdefault.xml");

			webapp.setResourceBase("./web");
			webapp.setDescriptor("./web/WEB-INF/web.xml");

			handler.addHandler(webapp);

			server.setHandler(handler);
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

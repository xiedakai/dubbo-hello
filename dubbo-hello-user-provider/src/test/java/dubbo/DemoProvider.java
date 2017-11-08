package dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;

public class DemoProvider {
	public static void main(String[] args) throws IOException {

		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath*:META-INF/spring/spring-context.xml");
			context.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("服务器已启动...");
		System.in.read();
		synchronized (DemoProvider.class) {
			while (true) {
				try {
					System.out.println("11111");
					DemoProvider.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
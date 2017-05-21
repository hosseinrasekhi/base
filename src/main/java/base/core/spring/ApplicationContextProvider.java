package base.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextProvider {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("base/core/spring/all.xml"); 
	
	public static ApplicationContext getApplicationContext(){
		return ac;
	}

}

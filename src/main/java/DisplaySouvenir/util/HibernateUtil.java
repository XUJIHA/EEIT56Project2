package DisplaySouvenir.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory factory = createSessionFactory();
	
	private static SessionFactory createSessionFactory() {
		//讀取設定黨
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//建立連線池
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		return factory;
				
	}
	
	public static SessionFactory getSessionFactory() {
		
		return factory;
	}
	
	public static void closeSessionFactory() {
		if(factory != null) {
			factory.close();
		}
	}
	
	
	
	
	

}

package roomtype.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class SessionFactoryListener
 *
 */
@WebListener
public class SessionFactoryListener implements ServletContextListener {

    public SessionFactoryListener() {
    }

//    public void contextDestroyed(ServletContextEvent sce)  { 
//    	HibernateUtil.getSessionFactory();
//        System.out.println("SessionFactory closed!!!");
//    }
//
//    public void contextInitialized(ServletContextEvent sce)  { 
//         HibernateUtil.getSessionFactory();
//         System.out.println("Create SessionFactory!!!");
//    }
	
}

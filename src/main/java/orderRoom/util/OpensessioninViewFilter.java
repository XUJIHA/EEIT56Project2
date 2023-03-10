package orderRoom.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@WebFilter(urlPatterns = "/FYIDS")
public class OpensessioninViewFilter extends HttpFilter implements Filter {

	private Session session;
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			SessionFactory factory=HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			System.out.println("Begin Transaction");
			chain.doFilter(request, response);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Rollback!!!");
			e.printStackTrace();
		}finally {
			System.out.println("Session close!!");
		}
		
	}

	
}

package orderRoom.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import orderRoom.dao.OrderDao;
import orderRoom.model.OrderBean;
import orderRoom.model.OrderDetailsBean;
import orderRoom.service.OrderService;
import orderRoom.util.HibernateUtil;


@WebServlet("/orderRoom/ShowOrderDetailsServlet")
public class ShowOrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.getCurrentSession();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService service=new OrderService();

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String orderid = request.getParameter("orderid");
		int id=Integer.parseInt(orderid);
		System.out.println(orderid);
//		OrderDao orderDao = new OrderDao(session);
		
		OrderBean orderbean = service.findByIdforOrder(id);
		OrderDetailsBean orderdetailsbean = service.findByIdforDetails(id);
		
		//System.out.println(orderbean.getUsername()+orderdetailsbean.getUseremail());
		request.setAttribute("orderbean", orderbean);
		request.setAttribute("orderdetailsbean", orderdetailsbean);

		RequestDispatcher rd = request.getRequestDispatcher("/orderRoom/UpdateOrder.jsp");
		rd.forward(request, response);
//			RequestDispatcher rd = request.getRequestDispatcher("/orderRoom/UpdateOrder.jsp");
//			rd.forward(request, response);
		return;
	}

}

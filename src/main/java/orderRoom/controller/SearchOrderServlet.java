package orderRoom.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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


@WebServlet("/orderRoom/SearchOrderServlet")
public class SearchOrderServlet extends HttpServlet {
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
//		OrderDao orderDao = new OrderDao(session);
		List<OrderBean> orderbean = service.searchOrder();
		

		OrderBean ob = null;
		for (OrderBean b : orderbean) {
			ob = b;
		}
		Date orderd = ob.getOrderdate();
		Date checkin = ob.getCheckindate();
		Date checkout = ob.getCheckoutdate();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String orderdd = sdf.format(orderd);
		String checkinn = sdf.format(checkin);
		String checkoutt = sdf.format(checkout);

		request.setAttribute("orderdate", orderdd);
		request.setAttribute("checkindate", checkinn);
		request.setAttribute("checkoutdate", checkoutt);
		request.setAttribute("orderbean", orderbean);
		RequestDispatcher rd = request.getRequestDispatcher("/orderRoom/OrderList.jsp");
		rd.forward(request, response);
		return;

	}

}

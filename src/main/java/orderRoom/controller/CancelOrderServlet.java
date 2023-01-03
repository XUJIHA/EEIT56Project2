package orderRoom.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


@WebServlet("/orderRoom/CancelOrderServlet")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.getCurrentSession();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String orderidstr = request.getParameter("orderid");
		int orderid = Integer.parseInt(orderidstr.trim());

		OrderService service = new OrderService();

		service.CancelOrder(orderid);
		RequestDispatcher rd = request.getRequestDispatcher("/orderRoom/CancelOrderSuccess.jsp");
		rd.forward(request, response);
		return;
	}

}

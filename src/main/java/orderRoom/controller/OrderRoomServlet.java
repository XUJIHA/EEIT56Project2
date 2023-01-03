package orderRoom.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import orderRoom.model.test;
import orderRoom.service.OrderService;
import orderRoom.util.HibernateUtil;
import roomtype.model.RoomsBean;


@WebServlet("/orderRoom/OrderRoomServlet")
public class OrderRoomServlet extends HttpServlet {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.getCurrentSession();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		RoomsBean rb = test.getTestBean();

		String username = request.getParameter("username");
		String checkindate = request.getParameter("checkindate");
		String checkoutdate = request.getParameter("checkoutdate");

		// String roomname = request.getParameter("roomname");
		String roomname = rb.getName();
		// String roompriceStr = request.getParameter("roomprice");
		int roomprice = rb.getPrice();

		String useremail = request.getParameter("useremail");
		String userphone = request.getParameter("userphone");
		String adultsStr = request.getParameter("adults");
		String childrenStr = request.getParameter("children");
		String company = request.getParameter("company");
		String notes = request.getParameter("notes");

		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			OrderService service=new OrderService();
			
			int adults = 0;
			int children = 0;

			if (adultsStr == null || adultsStr.trim().length() == 0) {
				adultsStr = "0";
			} else {
				adults = Integer.parseInt(adultsStr);
			}
			if (childrenStr == null || childrenStr.trim().length() == 0) {
				childrenStr = "0";
			} else {
				children = Integer.parseInt(childrenStr);
			}

			Date orderdate = new Date();
			Date utilcheckindate = sdf.parse(checkindate);
			Date utilcheckoutdate = sdf.parse(checkoutdate);
			
			java.sql.Date sqlorderdate = new java.sql.Date(orderdate.getTime());
			java.sql.Date sqlcheckindate = new java.sql.Date(utilcheckindate.getTime());
			java.sql.Date sqlcheckoutdate = new java.sql.Date(utilcheckoutdate.getTime());

			// Integer roomprice = Integer.parseInt(roompriceStr);

			
			OrderBean ob = new OrderBean();
			ob.setUsername(username);
			ob.setOrderdate(sqlorderdate);
			ob.setCheckindate(sqlcheckindate);
			ob.setCheckoutdate(sqlcheckoutdate);
			ob.setRoomname(roomname);
			ob.setRoomprice(roomprice);
			ob.setCanceltag(null);
//			session.save(ob);
			service.InsertOrder(ob);
			
			OrderDetailsBean odb = new OrderDetailsBean();
			odb.setUseremail(useremail);
			odb.setUserphone(userphone);
			odb.setAdults(adults);
			odb.setChildren(children);
			odb.setCompany(company);
			odb.setNotes(notes);
//			session.save(odb);
			service.InsertOrderDetails(odb);

			// 寫入資料庫
			
			
			Date checkin = ob.getCheckindate();
			Date checkout = ob.getCheckoutdate();
			String checkinn = sdf.format(checkin);
			String checkoutt = sdf.format(checkout);

			request.setAttribute("orderbean", ob);
			request.setAttribute("orderdetailsbean", odb);
			request.setAttribute("checkindate", checkinn);
			request.setAttribute("checkoutdate", checkoutt);

			RequestDispatcher rd = request.getRequestDispatcher("/orderRoom/ThanksForOrdering.jsp");
			rd.forward(request, response);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

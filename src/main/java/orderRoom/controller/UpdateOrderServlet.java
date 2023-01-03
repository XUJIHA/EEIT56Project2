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


@WebServlet("/orderRoom/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
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
		String roomname = request.getParameter("roomname");
		String roompriceStr = request.getParameter("roomprice");
		String username = request.getParameter("username");
		String checkindate = request.getParameter("checkindate");
		String checkoutdate = request.getParameter("checkoutdate");

		String useremail = request.getParameter("useremail");
		String userphone = request.getParameter("userphone");
		String company = request.getParameter("company");
		String adultsStr = request.getParameter("adults");
		String childrenStr = request.getParameter("children");
		String notes = request.getParameter("notes");
		System.out.println(orderidstr+"----------------------------------------");
		System.out.println(checkindate+"----------------------------------------");
		System.out.println(checkoutdate+"----------------------------------------");
		System.out.println(username+"----------------------------------------");
		
		OrderService service = new OrderService();
		OrderBean orderbean = null;
		OrderDetailsBean orderdetailsbean = null;

//		if (cmd.equalsIgnoreCase("DEL")) {
////			service.CancelOrder(orderid);
//			RequestDispatcher rd = request.getRequestDispatcher("/orderRoom/CancelOrderSuccess.jsp");
//			rd.forward(request, response);
//			return;
//		}

			int adults = 0;
			int children = 0;
			int roomprice = 0;
			
			if (adultsStr == null || adultsStr.trim().length() == 0) {
				adultsStr = "0";
			}
			adults = Integer.parseInt(adultsStr);

			if (childrenStr == null || childrenStr.trim().length() == 0) {
				childrenStr = "0";
			}
			children = Integer.parseInt(childrenStr);
			if (roompriceStr == null || roompriceStr.trim().length() == 0) {
				roompriceStr = "0";
			}
			roomprice = Integer.parseInt(roompriceStr);
			try {
				Date utilcheckindate = sdf.parse(checkindate);
				Date utilcheckoutdate = sdf.parse(checkoutdate);
				java.sql.Date sqlcheckoutdate = new java.sql.Date(utilcheckoutdate.getTime());
				java.sql.Date sqlcheckindate = new java.sql.Date(utilcheckindate.getTime());
				OrderBean ob = new OrderBean();
				ob.setUsername(username);
				ob.setCheckindate(sqlcheckindate);
				ob.setCheckoutdate(sqlcheckoutdate);
				ob.setRoomname(roomname);
				ob.setRoomprice(roomprice);

				OrderDetailsBean odb = new OrderDetailsBean();
				odb.setUseremail(useremail);
				odb.setUserphone(userphone);
				odb.setAdults(adults);
				odb.setChildren(children);
				odb.setCompany(company);
				odb.setNotes(notes);

				// 寫入資料庫

				service.modifyOrder(orderid, ob);
				service.modifyOrderDetails(orderid, odb);

				orderbean = service.findByIdforOrder(orderid);
				orderdetailsbean = service.findByIdforDetails(orderid);

				Date checkin = orderbean.getCheckindate();
				Date checkout = orderbean.getCheckoutdate();
				String checkinn = sdf.format(checkin);
				String checkoutt = sdf.format(checkout);

				request.setAttribute("orderbean", orderbean);
				request.setAttribute("orderdetailsbean", orderdetailsbean);
				request.setAttribute("checkindate", checkinn);
				request.setAttribute("checkoutdate", checkoutt);
				RequestDispatcher rd = request.getRequestDispatcher("/orderRoom/UpdateOrderSuccess.jsp");
				rd.forward(request, response);
				return;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

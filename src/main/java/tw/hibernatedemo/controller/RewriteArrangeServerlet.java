package tw.hibernatedemo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.dao.RestaurantDaoImpl;
import tw.hibernatedemo.model.Arrange;

@WebServlet("/RewriteArrangeServerlet")
public class RewriteArrangeServerlet extends HttpServlet{
	private static final long serivlversionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		RestaurantDaoImpl dao = new RestaurantDaoImpl();
		System.out.println(123);
		
		String name = req.getParameter("arrangename");
		String phone = req.getParameter("arrangephone");
		
		String day = req.getParameter("day");
		String eattime = req.getParameter("eattime");
		
		String error = "不能輸入空白";
		if (req.getParameter("arrangenumber") == "") {
			req.setAttribute("nullError", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteArrange.jsp");
			rd.forward(req, resp);
			return;}
			if (req.getParameter("arrangename") == "") {
			req.setAttribute("nullError2", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteArrange.jsp");
			rd.forward(req, resp);
			return;
		}		if (req.getParameter("arrangephone") == "") {
			req.setAttribute("nullError3", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteArrange.jsp");
			rd.forward(req, resp);
			return;
		}		if (req.getParameter("people") == "") {
			req.setAttribute("nullError4", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteArrange.jsp");
			rd.forward(req, resp);
			return;
		}		if (req.getParameter("day") == "") {
			req.setAttribute("nullError5", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteArrange.jsp");
			rd.forward(req, resp);
			return;
		}			
		int id = Integer.parseInt(req.getParameter("arrangenumber"));
		RestaurantDaoImpl check = new RestaurantDaoImpl();
		boolean checkRes = check.checkArr(id);
		if (checkRes==true) {
			req.setAttribute("nullError9", "編號不存在");
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteArrange.jsp");
			rd.forward(req, resp);
			return;
		}
		
//		if (req.getParameter("restaurantid") == "") {
//			req.setAttribute("nullError6", error);
//			RequestDispatcher rd = req.getRequestDispatcher("/RewriteArrange.jsp");
//			rd.forward(req, resp);
//			return;
//		}
		int number = Integer.parseInt(req.getParameter("arrangenumber"));
		int people = Integer.parseInt(req.getParameter("people"));
		int restaurantid = Integer.parseInt(req.getParameter("restaurantid"));
		Arrange ArrBean = new Arrange(number,name, phone, people, day, eattime, restaurantid);
		dao.RewriteArrange(ArrBean);
		req.setAttribute("success", 1);
		RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteArrange.jsp");
		rd.forward(req, resp);
//		BaseDAO daoCheck = new BaseDAO();
//		int check2 = Integer.parseInt(req.getParameter("arrangenumber"));
//		try {
//			List<Arrbean> checkList = daoCheck.SearchArrange(req.getParameter("arrangenumber"));
//			// List<Resbean> checkList2 =
//			// daoCheck.CheckRes(req.getParameter("restaurantid"));
//			// System.out.println(checkList);
//			// System.out.println(checkList2);
//			for (Arrbean b : checkList) {
//				if (b.getNumber() == check2) {
//					try {
//						dao.RewriteArrange(number, name, phone, people, day, eattime, restaurantid);
//						RequestDispatcher rd = req.getRequestDispatcher("/RewriteArrangeAns.jsp");
//						rd.forward(req, resp);
//						return;
//						
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			req.setAttribute("nullError9", "沒有存在的編號");
//			RequestDispatcher rd = req.getRequestDispatcher("/RewriteArrange.jsp");
//			rd.forward(req, resp);
//			return;
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

	}
	}



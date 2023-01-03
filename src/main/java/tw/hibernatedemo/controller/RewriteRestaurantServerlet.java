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
import tw.hibernatedemo.model.Restaurant;

@WebServlet("/RewriteRestaurantServerlet")
public class RewriteRestaurantServerlet extends HttpServlet {
	private static final long serivlversionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		RestaurantDaoImpl dao = new RestaurantDaoImpl();
//		System.out.println(123);
		
		String name = req.getParameter("restaurantname");
		String des = req.getParameter("restaurantdes");
		String type = req.getParameter("restauranttype");
		String address = req.getParameter("restaurantaddress");
		String phone = req.getParameter("restaurantphone");
		String error = "不能輸入空白";
		if (req.getParameter("restaurantid") == "") {
			req.setAttribute("nullError", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}if (req.getParameter("restaurantname") == "") {
			req.setAttribute("nullError2", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}if (req.getParameter("restaurantdes") == "") {
			req.setAttribute("nullError3", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}if (req.getParameter("restauranttype") == "") {
			req.setAttribute("nullError4", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}if (req.getParameter("restaurantprice") == "") {
			req.setAttribute("nullError5", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}if (req.getParameter("restaurantaddress") == "") {
			req.setAttribute("nullError6", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}if (req.getParameter("restaurantphone") == "") {
			req.setAttribute("nullError7", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}if (req.getParameter("restaurantseat") == "") {
			req.setAttribute("nullError8", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}
		int id = Integer.parseInt(req.getParameter("restaurantid"));
		RestaurantDaoImpl check = new RestaurantDaoImpl();
		boolean checkRes = check.checkRes(id);
		if (checkRes==true) {
			req.setAttribute("nullError9", "編號不存在");
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}
		
//		int id = Integer.parseInt(req.getParameter("restaurantid"));
		int price = Integer.parseInt(req.getParameter("restaurantprice"));
		int seat = Integer.parseInt(req.getParameter("restaurantseat"));
		
		Restaurant resBean = new Restaurant(id, name, des, type, price, address, phone, seat);
		dao.RewriteRestaurant(resBean);
		req.setAttribute("success", 1);
		RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteRestaurant.jsp");
		rd.forward(req, resp);
		
		
//		BaseDAO daoCheck = new BaseDAO();
//		int check2 = Integer.parseInt(req.getParameter("restaurantid"));
		
//		try {
//			List<Resbean> checkList = daoCheck.SearchRes(req.getParameter("restaurantid"));
//			// List<Resbean> checkList2 =
//			// daoCheck.CheckRes(req.getParameter("restaurantid"));
//			// System.out.println(checkList);
//			// System.out.println(checkList2);
//			for (Resbean b : checkList) {
//				if (b.getRestaurantid() == check2) {
//					try {
//						dao.RewriteRestaurant(id, name, des, type, price, address, phone, seat);
//						
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					return;
//				}
//			}
//			req.setAttribute("nullError9", "沒有存在的編號");
//			RequestDispatcher rd = req.getRequestDispatcher("/RewriteRestaurant.jsp");
//			rd.forward(req, resp);
//			return;
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}


	}
}
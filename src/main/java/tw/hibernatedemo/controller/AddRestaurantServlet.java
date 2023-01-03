package tw.hibernatedemo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Blob;
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

@WebServlet("/AddRestaurantServlet")
public class AddRestaurantServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		RestaurantDaoImpl dao = new RestaurantDaoImpl();
//		System.out.println("testid:--------" + req.getParameter("restaurantid"));
		String name = req.getParameter("restaurantname");
		String des = req.getParameter("restaurantdes");
		String type = req.getParameter("restauranttype");
		String address = req.getParameter("restaurantaddress");
		String phone = req.getParameter("restaurantphone");
		String error = "不能輸入空白";
//		if (req.getParameter("restaurantid").equals("")/* ||req.getParameter("restaurantid") == null */) {
//			req.setAttribute("nullError", error);
//			RequestDispatcher rd = req.getRequestDispatcher("/AddRestaurant.jsp");
//			rd.forward(req, resp);
//			return;
//		}
//		int id = Integer.parseInt(req.getParameter("restaurantid"));
//		int check = Integer.parseInt(req.getParameter("restaurantid"));
		if (req.getParameter("restaurantname") == "") {
			req.setAttribute("nullError2", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}
		if (req.getParameter("restaurantdes") == "") {
			req.setAttribute("nullError3", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}
		if (req.getParameter("restauranttype") == "") {
			req.setAttribute("nullError4", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}
		if (req.getParameter("restaurantprice") == "") {
			req.setAttribute("nullError5", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}
		int price = Integer.parseInt(req.getParameter("restaurantprice"));
		if (req.getParameter("restaurantaddress") == "") {
			req.setAttribute("nullError6", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}
		if (req.getParameter("restaurantphone") == "") {
			req.setAttribute("nullError7", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}
		if (req.getParameter("restaurantseat") == "") {
			req.setAttribute("nullError8", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddRestaurant.jsp");
			rd.forward(req, resp);
			return;
		}
		int seat = Integer.parseInt(req.getParameter("restaurantseat"));

//		BaseDAO daoCheck = new BaseDAO();
//		int check2 = Integer.parseInt(req.getParameter("restaurantid"));
//		try {
//			List<Resbean> checkList = daoCheck.SearchRes(req.getParameter("restaurantid"));
		// List<Resbean> checkList2 =
		// daoCheck.CheckRes(req.getParameter("restaurantid"));
		// System.out.println(checkList);
		// System.out.println(checkList2);
//			for (Resbean b : checkList) {
//				if (b.getRestaurantid() == check2) {
//					req.setAttribute("nullError9", "已有存在的編號");
//					RequestDispatcher rd = req.getRequestDispatcher("/AddRestaurant.jsp");
//					rd.forward(req, resp);
//					return;
//				}
//			}
		Restaurant resBean = new Restaurant(name, des, type, price, address, phone, seat);
		dao.AddRestautant(resBean);
		req.setAttribute("success", 1);
		RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddRestaurant.jsp");
		rd.forward(req, resp);
		return;

	}
}

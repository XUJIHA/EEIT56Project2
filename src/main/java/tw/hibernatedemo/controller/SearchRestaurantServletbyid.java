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

//用ID找餐廳
@WebServlet("/SearchRestaurantServletbyid")
public class SearchRestaurantServletbyid extends HttpServlet {
	private static final long serivlversionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String resturantId = req.getParameter("restaurantid");
		RestaurantDaoImpl res1 = new RestaurantDaoImpl();
		String error = "不能輸入空白";
		if (req.getParameter("restaurantid") == "") {
			req.setAttribute("nullError2", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/Search.jsp");
			rd.forward(req, resp);
			return;
		}
		int id = Integer.parseInt(resturantId);
		List<Restaurant> list =  res1.SearchRestaurant(id);
		req.setAttribute("resturant", list);
		System.out.println(list);
//		for (Restaurant restaurant : list) {
//			System.out.println(restaurant.getRestaurantname());
//		}
		RequestDispatcher rd = req.getRequestDispatcher("/jsp01/SearchbyidAns.jsp");
		rd.forward(req, resp);
//		BaseDAO daoCheck = new BaseDAO();
//		try {
//			List<Resbean> checkList = daoCheck.SearchRes(req.getParameter("restaurantid"));
//			// List<Resbean> checkList2 =
//			// daoCheck.CheckRes(req.getParameter("restaurantid"));
//			// System.out.println(checkList);
//			// System.out.println(checkList2);
//			for (Resbean b : checkList) {
//				if (b.getRestaurantid() == check2) {
//					int int00 = Integer.parseInt(resturantId);
//					List<Resbean> list = dao.SearchResname(int00);
//					return;
//				}
//			}
//					req.setAttribute("nullError9", "沒有存在的編號");
//					RequestDispatcher rd = req.getRequestDispatcher("/Search.jsp");
//					rd.forward(req, resp);
//					return;
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}


	}
}

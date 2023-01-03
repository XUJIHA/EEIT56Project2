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
//用種類找餐廳
@WebServlet("/searchRestype")
public class SearchRestaurantServletbytype extends HttpServlet {
	private static final long serivlversionUID=1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String resturanttype = req.getParameter("resturanttype");
		System.out.println(resturanttype);
		RestaurantDaoImpl res1 = new RestaurantDaoImpl();
		 String error = "不能輸入空白";
			if (req.getParameter("resturanttype") == "") {
				req.setAttribute("nullError3", error);
				RequestDispatcher rd = req.getRequestDispatcher("/jsp01/Search.jsp");
				rd.forward(req, resp);
				return;
			}
		  
		List<Restaurant> list =  res1.SearchResType(resturanttype);
		req.setAttribute("resturant", list);
		RequestDispatcher rd = req.getRequestDispatcher("/jsp01/SearchbyidAns.jsp");
		rd.forward(req, resp);
		return;}
}
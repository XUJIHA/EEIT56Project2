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
@WebServlet("/SearchRestaurantServerlet")
public class SearchRestaurantServerlet extends HttpServlet{
	private static final long serivlversionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	doPost(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		System.out.println(123);
		RestaurantDaoImpl res1 = new RestaurantDaoImpl();
		
//		String s00 = req.getParameter("1");
		List<Restaurant> list =  res1.selectAll();
		req.setAttribute("resturant", list);
		RequestDispatcher rd =  req.getRequestDispatcher("/jsp01/SearchbyidAns.jsp");
		rd.forward(req, resp);
	}
}

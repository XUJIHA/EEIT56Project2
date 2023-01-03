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
@WebServlet("/SearchArrange")
public class SearchArrangeServlet extends HttpServlet{
 private static final long serivlversionUID = 1L;
 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 req.setCharacterEncoding("UTF-8");
		System.out.println(123);
		RestaurantDaoImpl dao = new RestaurantDaoImpl();
		List<Arrange> list = dao.selectArrange();
//			String s00 = req.getParameter("1");
//			List<Arrbean> list = dao.SearchArrange(s00);
		req.setAttribute("arrange", list);
		RequestDispatcher rd =  req.getRequestDispatcher("/jsp01/SearchArrangeAns.jsp");
		rd.forward(req, resp);
 }
}

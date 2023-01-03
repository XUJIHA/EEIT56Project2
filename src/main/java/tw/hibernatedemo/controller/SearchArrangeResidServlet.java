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

@WebServlet("/SearchArrangeResidServlet")
public class SearchArrangeResidServlet extends HttpServlet {
	private static final long serivlversionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String resturantId = req.getParameter("restaurantid");
		System.out.println(resturantId);
		RestaurantDaoImpl dao = new RestaurantDaoImpl();
		String error = "不能輸入空白";
		if (req.getParameter("restaurantid") == "") {
			req.setAttribute("nullError3", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/SearchArrange.jsp");
			rd.forward(req, resp);
			return;
		}
		int int00 = Integer.parseInt(resturantId);
		List<Arrange> list = dao.selectArrangeResid(int00);;
		req.setAttribute("arrange", list);
		RequestDispatcher rd = req.getRequestDispatcher("/jsp01/SearchArrangeAns.jsp");
		rd.forward(req, resp);
		return;

	}
}

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
import tw.hibernatedemo.model.Restaurant;

@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serivlversionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		RestaurantDaoImpl dao = new RestaurantDaoImpl();
		String id = req.getParameter("id");
		System.out.println(id);

		if (id.equals("1")) {
			List<Restaurant> list = dao.selectAll();
			req.setAttribute("resturant", list);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddRestaurant.jsp");
			rd.forward(req, resp);

		} else if (id.equals("2")) {
			List<Restaurant> list = dao.selectAll();
			req.setAttribute("resturant", list);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/DeleteRes.jsp");
			rd.forward(req, resp);

		} else if (id.equals("3")) {
			List<Restaurant> list = dao.selectAll();
			req.setAttribute("resturant", list);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteRestaurant.jsp");
			rd.forward(req, resp);

		} else if (id.equals("4")) {
			List<Restaurant> list = dao.selectAll();
			req.setAttribute("resturant", list);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/Search.jsp");
			rd.forward(req, resp);

		} else if (id.equals("5")) {
			List<Arrange> list = dao.selectArrange();
			req.setAttribute("arrange", list);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddArrange.jsp");
			rd.forward(req, resp);

		} else if (id.equals("6")) {
			List<Arrange> list = dao.selectArrange();
			req.setAttribute("arrange", list);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/DeleteArrange.jsp");
			rd.forward(req, resp);

		} else if (id.equals("7")) {
			List<Arrange> list = dao.selectArrange();
			req.setAttribute("arrange", list);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/RewriteArrange.jsp");
			rd.forward(req, resp);

		} else {
			List<Arrange> list = dao.selectArrange();
			req.setAttribute("arrange", list);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/SearchArrange.jsp");
			rd.forward(req, resp);

		}
	}
}

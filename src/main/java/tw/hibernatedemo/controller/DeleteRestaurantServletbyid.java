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

@WebServlet("/DeleteRestaurantServletbyid")
public class DeleteRestaurantServletbyid extends HttpServlet {
	private static final long serivlversionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		RestaurantDaoImpl dao = new RestaurantDaoImpl();
		RestaurantDaoImpl check = new RestaurantDaoImpl();
		RestaurantDaoImpl arr = new RestaurantDaoImpl();
		
		String error = "不能輸入空白";
		String inputId = req.getParameter("restaurantid");
		if (req.getParameter("restaurantid") == "") {
			req.setAttribute("nullError1", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/DeleteRes.jsp");
			rd.forward(req, resp);
			return;
		}
		
		int id = Integer.parseInt(inputId);
		boolean checkRes = check.checkRes(id);
		if (checkRes==true) {
			req.setAttribute("nullError9", "編號不存在");
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/DeleteRes.jsp");
			rd.forward(req, resp);
			return;
		}
		
		int id3 = Integer.parseInt(inputId);
		boolean checkResult = arr.checkArrangeResid(id3);
		if(checkResult==true) {
			req.setAttribute("nullError10", "此餐廳底下尚有訂單");
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/DeleteRes.jsp");
			rd.forward(req, resp);
			return;
			
		}

		dao.DeleteRestaurant(id);
		req.setAttribute("success", 1);
		RequestDispatcher rd = req.getRequestDispatcher("/jsp01/DeleteRes.jsp");
		rd.forward(req, resp);
		
//		try {
//			List<Resbean> beans = daoCheck.SearchRes(g);
//			for (Resbean b : beans) {
//				if (b.getRestaurantid() == id) {
//					int row = daoCheck.DeleteResid(id);
//					System.out.println(row);
//					RequestDispatcher rd = req.getRequestDispatcher("/DeleteResAns.jsp");
//					rd.forward(req, resp);
//					return;
//				}
//			}
//			req.setAttribute("nullError9", "編號不存在");
//			RequestDispatcher rd = req.getRequestDispatcher("/DeleteRes.jsp");
//			rd.forward(req, resp);
//			return;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}

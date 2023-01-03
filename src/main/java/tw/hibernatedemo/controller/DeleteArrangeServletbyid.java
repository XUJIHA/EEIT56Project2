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

@WebServlet("/DeleteArrangeServletbyid")
public class DeleteArrangeServletbyid extends HttpServlet {
	private static final long serivlversionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		RestaurantDaoImpl dao = new RestaurantDaoImpl();
		String error = "不能輸入空白";
		if (req.getParameter("arrangenumber") == "") {
			req.setAttribute("nullError", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/DeleteArrange.jsp");
			rd.forward(req, resp);
			return;
		}
		int id = Integer.parseInt(req.getParameter("arrangenumber"));
		RestaurantDaoImpl check = new RestaurantDaoImpl();
		boolean checkRes = check.checkArr(id);
		if (checkRes==true) {
			req.setAttribute("nullError9", "編號不存在");
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/DeleteRes.jsp");
			rd.forward(req, resp);
			return;
		}
		dao.DeleteArrange(id);
		req.setAttribute("success", 1);
		RequestDispatcher rd = req.getRequestDispatcher("/jsp01/DeleteArrange.jsp");
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
//					String arrangenumber = req.getParameter("arrangenumber");
//					int int00 = Integer.parseInt(arrangenumber);
//					try {
//						dao.DeleteArrange(int00);
//						RequestDispatcher rd = req.getRequestDispatcher("/DeleteArrangeAns.jsp");
//						rd.forward(req, resp);
//						return;
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			req.setAttribute("nullError9", "沒有存在的編號");
//			RequestDispatcher rd = req.getRequestDispatcher("/DeleteArrange.jsp");
//			rd.forward(req, resp);
//			return;
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}
}

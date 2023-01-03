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

@WebServlet("/AddArrangeServlet")

public class AddArrangeServlet extends HttpServlet {
	private static final long serivlversionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		RestaurantDaoImpl dao = new RestaurantDaoImpl();
		RestaurantDaoImpl arr = new RestaurantDaoImpl();
//		String numStr = req.getParameter("arrangenumber");
//		System.out.println(numStr);
		String name = req.getParameter("arrangename");
		String phone = req.getParameter("arrangephone");
		String day = req.getParameter("arrangeday");
		String eattime = req.getParameter("eattime");
		String error = "不能輸入空白";
//		if (numStr == "") {
//			req.setAttribute("nullError", error);
//			RequestDispatcher rd = req.getRequestDispatcher("/AddArrange.jsp");
//			rd.forward(req, resp);
//			return;
//		}
//		String inputId = req.getParameter("restaurantid");
//		int id = Integer.parseInt(inputId);
//		RestaurantDao check = new RestaurantDao();
//		boolean checkRes = check.checkArr(id);
//		if (checkRes==true) {
//			req.setAttribute("nullError9", "編號不存在");
//			RequestDispatcher rd = req.getRequestDispatcher("/DeleteRes.jsp");
//			rd.forward(req, resp);
//			return;
//		}
		
		if (req.getParameter("arrangename") == "") {
			req.setAttribute("nullError2", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddArrange.jsp");
			rd.forward(req, resp);
			return;
		}
		if (req.getParameter("arrangephone") == "") {
			req.setAttribute("nullError3", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddArrange.jsp");
			rd.forward(req, resp);
			return;
		}
		if (req.getParameter("arrangepeople") == "") {
			req.setAttribute("nullError4", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddArrange.jsp");
			rd.forward(req, resp);
			return;
		}
		if (req.getParameter("arrangeday") == "") {
			req.setAttribute("nullError5", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddArrange.jsp");
			rd.forward(req, resp);
			return;
		}

		if (req.getParameter("restaurantid") == "") {
			req.setAttribute("nullError7", error);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddArrange.jsp");
			rd.forward(req, resp);
			return;
		}
		int check = Integer.parseInt(req.getParameter("restaurantid"));

		boolean checkResult = arr.checkRes(check);
		
		if (checkResult==true) {
			req.setAttribute("nullError10", "沒有這家餐廳");
			RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddArrange.jsp");
			rd.forward(req, resp);
			return;
		}
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
//					req.setAttribute("nullError9", "已存在的編號");
//					RequestDispatcher rd = req.getRequestDispatcher("/AddArrange.jsp");
//					rd.forward(req, resp);
//					return;
//				}
//			}
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

//		int number = Integer.parseInt(numStr);
		int people = Integer.parseInt(req.getParameter("arrangepeople"));
		int resid = Integer.parseInt(req.getParameter("restaurantid"));
		System.out.println(resid);
		Arrange ArrBean = new Arrange( name, phone, people, day, eattime, resid);
//		dao2.selectAll();
		dao.AddArrange(ArrBean);
		req.setAttribute("success", 1);
		RequestDispatcher rd = req.getRequestDispatcher("/jsp01/AddRestaurant.jsp");
		rd.forward(req, resp);
		return;

	}
}

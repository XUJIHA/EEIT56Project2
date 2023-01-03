package orderRoom.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderRoom.model.test;
import roomtype.model.RoomsBean;


@WebServlet("/orderRoom/CheckRoomServlet")
public class CheckRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
//		String roomId = request.getParameter("roomId");
//		System.out.println(roomId);
//		String errormsg = "roomId為空!請重新訂購";
//		if (roomId == null || roomId.length() == 0) {
//			request.setAttribute("Error", errormsg);
//			RequestDispatcher rd = request.getRequestDispatcher("/RoomDetails.jsp");
//			rd.forward(request, response);
//		} else {

//			RoomDao roomDao = new RoomDao();			
//			try {
//				List<RoomsBean> roombeans = roomDao.findById(roomId);
//				RoomsBean roombean = null;
//				for (RoomsBean b : roombeans) {
//					roombean = b;
//				}
		RoomsBean roombean = new RoomsBean();
		roombean = test.getTestBean();
		request.setAttribute("roombean", roombean);
		RequestDispatcher rd = request.getRequestDispatcher("/orderRoom/CheckRoomInfo.jsp");
		rd.forward(request, response);
		return;

//			}
//		catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}

	}
}

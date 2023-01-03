package roomtype.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roomtype.service.RoomTypeService;
import roomtype.service.impl.RoomTypeServiceImpl;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String roomId = request.getParameter("roomId");
		RoomTypeService roomTypeService = new RoomTypeServiceImpl();
		int row = 0;
		row = roomTypeService.deleteById(roomId);
//		request.setAttribute("row", row);
//		RequestDispatcher rd = request.getRequestDispatcher("/SearchServletM");
//		rd.forward(request, response);
	}

}

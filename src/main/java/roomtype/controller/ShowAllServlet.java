package roomtype.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roomtype.model.RoomsBean;
import roomtype.service.RoomTypeService;
import roomtype.service.impl.RoomTypeServiceImpl;

@WebServlet("/ShowAllServlet")
public class ShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		RoomTypeService roomTypeService = new RoomTypeServiceImpl();
		List<RoomsBean> beans = roomTypeService.findAll();
		request.setAttribute("beans", beans);
		RequestDispatcher rd = request.getRequestDispatcher("/roomType/Rooms.jsp");
		rd.forward(request, response);

	}

}

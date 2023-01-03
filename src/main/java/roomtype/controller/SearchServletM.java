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

@WebServlet("/SearchServletM")
public class SearchServletM extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String input = request.getParameter("selection");
		List<RoomsBean> beans = null;
		RoomTypeService roomTypeService = new RoomTypeServiceImpl();
		if (input.equals("none") || input.equals("")) {
			beans = roomTypeService.findAll();
			request.setAttribute("beans", beans);
			RequestDispatcher rd = request.getRequestDispatcher("/roomType/ManageRoom.jsp");
			rd.forward(request, response);
			return;
		}
		int capacity = Integer.parseInt(request.getParameter("selection"));
		beans = roomTypeService.findByCapacity(capacity);
		request.setAttribute("beans", beans);
		request.setAttribute("selection", input);
		RequestDispatcher rd = request.getRequestDispatcher("/roomType/ManageRoom.jsp");
		rd.forward(request, response);

	}

}

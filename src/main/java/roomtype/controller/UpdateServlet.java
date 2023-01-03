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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
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
		System.out.println(roomId);
		RoomsBean bean = null;
		RoomTypeService roomTypeService = new RoomTypeServiceImpl();
		List<RoomsBean> beans = roomTypeService.findById(roomId);
		for (RoomsBean b : beans) {
			bean = b;
		}
		String[] equipments = bean.getEquipment().split(" ");
		for (int i = 0; i < equipments.length; i++) {
			if (equipments[i].length() == 0) {
				String key = "e" + i;
				int e = 0;
				request.setAttribute(key, e);
			} else {
				String key = "e" + i;
				int e = 1;
				request.setAttribute(key, e);
			}
		}
		request.setAttribute("equipments", equipments);
		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/roomType/UpdateRoom.jsp");
		rd.forward(request, response);
	}
}

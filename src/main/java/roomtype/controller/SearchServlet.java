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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String inputCapacity = request.getParameter("selection");
		String inputMinPrice = request.getParameter("minPrice");
		String inputMaxPrice = request.getParameter("maxPrice");
		String inputStatus = request.getParameter("cbStatus");
		RoomTypeService roomTypeService = new RoomTypeServiceImpl();
		if (inputStatus == null) {
			if (inputMinPrice.equals("")) {
				inputMinPrice = "0";
			}
			if (inputMaxPrice.equals("")) {
				inputMaxPrice = "99999999";
			}
			int minPrice = Integer.parseInt(inputMinPrice);
			int maxPrice = Integer.parseInt(inputMaxPrice);
			List<RoomsBean> beans = null;
			int capacity = 0;
			if (inputCapacity.equals("none")) {
				beans = roomTypeService.findByPriceRange(minPrice, maxPrice);
				request.setAttribute("beans", beans);
				RequestDispatcher rd = request.getRequestDispatcher("/roomType/Rooms.jsp");
				rd.forward(request, response);
				return;
			} else {
				capacity = Integer.parseInt(inputCapacity);
			}
			beans = roomTypeService.findByCapacityAndPriceRange(capacity, minPrice, maxPrice);
			request.setAttribute("beans", beans);
			RequestDispatcher rd = request.getRequestDispatcher("/roomType/Rooms.jsp");
			rd.forward(request, response);
			return;
		} else {
			if (inputMinPrice.equals("")) {
				inputMinPrice = "0";
			}
			if (inputMaxPrice.equals("")) {
				inputMaxPrice = "99999999";
			}
			int minPrice = Integer.parseInt(inputMinPrice);
			int maxPrice = Integer.parseInt(inputMaxPrice);
			int status = Integer.parseInt(inputStatus);
			List<RoomsBean> beans = null;
			int capacity = 0;
			if (inputCapacity.equals("none")) {
				beans = roomTypeService.findByStatusAndPriceRange(status, minPrice, maxPrice);
				request.setAttribute("beans", beans);
				RequestDispatcher rd = request.getRequestDispatcher("/roomType/Rooms.jsp");
				rd.forward(request, response);
				return;
			} else {
				capacity = Integer.parseInt(inputCapacity);
				beans = roomTypeService.findByCapacityAndStatusAndPriceRange(capacity, status, minPrice, maxPrice);
			}
			request.setAttribute("beans", beans);
			RequestDispatcher rd = request.getRequestDispatcher("/roomType/Rooms.jsp");
			rd.forward(request, response);
		}
	}

}

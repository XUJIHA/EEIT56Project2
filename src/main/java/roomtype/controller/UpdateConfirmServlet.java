package roomtype.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import roomtype.model.RoomsBean;
import roomtype.service.RoomTypeService;
import roomtype.service.impl.RoomTypeServiceImpl;

@MultipartConfig()
@WebServlet("/UpdateConfirmServlet")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int row = 0;
		RoomsBean bean = null;
		try {
			String roomId = request.getParameter("roomId");
			String name = request.getParameter("name");
			int status = Integer.parseInt(request.getParameter("status"));
			int capacity = Integer.parseInt(request.getParameter("capacity"));
			int bed = Integer.parseInt(request.getParameter("bed"));
			double size = Double.parseDouble(request.getParameter("size"));
			int price = Integer.parseInt(request.getParameter("price"));
			Part part = request.getPart("img");
			String description = request.getParameter("description");
			String equipment1 = request.getParameter("cbEquipment1");
			if (equipment1 == null) {
				equipment1 = "";
			}
			String equipment2 = request.getParameter("cbEquipment2");
			if (equipment2 == null) {
				equipment2 = "";
			}
			String equipment3 = request.getParameter("cbEquipment3");
			if (equipment3 == null) {
				equipment3 = "";
			}
			String equipment4 = request.getParameter("cbEquipment4");
			if (equipment4 == null) {
				equipment4 = "";
			}
			String equipment5 = request.getParameter("cbEquipment5");
			if (equipment5 == null) {
				equipment5 = "";
			}
			String equipment6 = request.getParameter("cbEquipment6");
			if (equipment6 == null) {
				equipment6 = "";
			}
			String equipment7 = request.getParameter("cbEquipment7");
			if (equipment7 == null) {
				equipment7 = "";
			}
			String equipment8 = request.getParameter("cbEquipment8");
			if (equipment8 == null) {
				equipment8 = "";
			}
			String equipment = String.format("%s %s %s %s %s %s %s %s", equipment1, equipment2, equipment3, equipment4,
					equipment5, equipment6, equipment7, equipment8);
			
			RoomTypeService roomTypeService = new RoomTypeServiceImpl();
			
			Blob img = null;
			if (part.getSize() != 0) {
				InputStream is = part.getInputStream();
				byte[] bytes = is.readAllBytes();
				img = new SerialBlob(bytes);
			} else {
				List<RoomsBean> beans = roomTypeService.findById(roomId);
				for (RoomsBean b : beans) {
					img = b.getImg();
				}
			}
			row = roomTypeService.updateFormById(roomId, name, status, capacity, bed, size, price, img, description,
					equipment);
			List<RoomsBean> beans = roomTypeService.findById(roomId);
			for (RoomsBean b : beans) {
				bean = b;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
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
		request.setAttribute("row", row);
		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/roomType/UpdateRoom.jsp");
		rd.forward(request, response);
	}

}

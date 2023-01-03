package roomtype.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import roomtype.service.RoomTypeService;
import roomtype.service.impl.RoomTypeServiceImpl;

@MultipartConfig()
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
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
		
		String roomId = request.getParameter("roomId").trim();
		System.out.println(roomId);
		String inputCapacity = request.getParameter("capacity").trim();
		System.out.println("inputCapacity"+inputCapacity);
		if (roomId.equals("")) {
			request.setAttribute("idNull", "必填欄位不可空白!!");
		}
		if (inputCapacity.equals("")) {
			request.setAttribute("capacityNull", "必填欄位不可空白!!");
			
		}
		if (roomId.equals("") || inputCapacity.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("/roomType/InsertRoom.jsp");
			rd.forward(request, response);
			return;
		}
		String name = request.getParameter("name").trim();
		if (name.equals("")) {
			name = "未命名客房";
		}
		int status = Integer.parseInt(request.getParameter("status"));
		int capacity = Integer.parseInt(inputCapacity);
		String inputBed = request.getParameter("bed");
		if (inputBed.equals("")) {
			inputBed = "0";
		}
		int bed = Integer.parseInt(inputBed);
		String inputSize = request.getParameter("size");
		if (inputSize.equals("")) {
			inputSize = "0.0";
		}
		double size = Double.parseDouble(inputSize);
		String inputPrice = request.getParameter("price");
		if (inputPrice.equals("")) {
			inputPrice = "0";
		}
		int price = Integer.parseInt(inputPrice);

		try {
			Part part = request.getPart("img");
			InputStream is = part.getInputStream();
			byte[] b = is.readAllBytes();
			Blob img = new SerialBlob(b);

			String description = request.getParameter("description");
			String equipment1 = request.getParameter("cbEquipment1");
			if (equipment1==null) {
				equipment1 = "";
			}
			String equipment2 = request.getParameter("cbEquipment2");
			if (equipment2==null) {
				equipment2 = "";
			}
			String equipment3 = request.getParameter("cbEquipment3");
			if (equipment3==null) {
				equipment3 = "";
			}
			String equipment4 = request.getParameter("cbEquipment4");
			if (equipment4==null) {
				equipment4 = "";
			}
			String equipment5 = request.getParameter("cbEquipment5");
			if (equipment5==null) {
				equipment5 = "";
			}
			String equipment6 = request.getParameter("cbEquipment6");
			if (equipment6==null) {
				equipment6 = "";
			}
			String equipment7 = request.getParameter("cbEquipment7");
			if (equipment7==null) {
				equipment7 = "";
			}
			String equipment8 = request.getParameter("cbEquipment8");
			if (equipment8==null) {
				equipment8 = "";
			}
			String equipment = String.format("%s %s %s %s %s %s %s %s", 
								equipment1, equipment2, equipment3,equipment4,equipment5,equipment6,equipment7,equipment8);
			RoomTypeService roomTypeService = new RoomTypeServiceImpl();
			row = roomTypeService.insertRoomType(roomId, name, status, capacity, bed, size, price, img, description, equipment);
			System.out.println("row"+row);
		} catch (SQLException e) {
			e.printStackTrace();
			String pkError = e.getMessage();
			if (pkError.contains("PRIMARY KEY 條件約束")) {
				String pkErrorStr = "編號" + roomId + "已被使用";
				request.setAttribute("pkError", pkErrorStr);
				RequestDispatcher rd = request.getRequestDispatcher("/roomType/InsertRoom.jsp");
				rd.forward(request, response);
				return;
			}
		}
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("/roomType/InsertRoom.jsp");
		rd.forward(request, response);
	}
}

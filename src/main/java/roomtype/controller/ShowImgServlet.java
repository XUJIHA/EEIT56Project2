package roomtype.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roomtype.model.RoomsBean;
import roomtype.service.RoomTypeService;
import roomtype.service.impl.RoomTypeServiceImpl;

@WebServlet("/ShowImgServlet")
public class ShowImgServlet extends HttpServlet {
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
		List<RoomsBean> beans;
		try {
			beans = roomTypeService.findById(roomId);
			RoomsBean bean = null;
			for (RoomsBean b : beans) {
				bean = b;
			}
			Blob blob = bean.getImg();
			InputStream is = blob.getBinaryStream();
			OutputStream os = response.getOutputStream();
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
				os.flush();
			}
			os.close();
			is.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

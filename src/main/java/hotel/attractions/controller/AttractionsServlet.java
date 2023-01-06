package hotel.attractions.controller;
//package attractions.controller;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;
//import javax.sql.rowset.serial.SerialBlob;
//
//import attractions.model.AttractionsBean;
//import attractions.service.AttractionsService;
//@WebServlet("/attractionsServlet")
//@MultipartConfig
//public class AttractionsServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Map<String,String> errorMessage = new HashMap<>();
//		request.setAttribute("ErrorMsg", errorMessage);
//		
//		HttpSession session = request.getSession();
//		// 設定輸入資料的編碼
//		request.setCharacterEncoding("UTF-8");
//		String name = request.getParameter("name");
//		if (name == null || name.trim().length() == 0) {
//			errorMessage.put("name","景點名稱必須輸入");
//		}
//		String address = request.getParameter("address");
//		if (address == null || address.trim().length() == 0) {
//			errorMessage.put("address","地址必須輸入");
//		}
//		String serviceHour = request.getParameter("serviceHour");
//		String serviceHour2 = request.getParameter("serviceHour2");
//		if ((serviceHour == null || serviceHour.trim().length() == 0)||(serviceHour2 == null || serviceHour2.trim().length() == 0)) {
//			errorMessage.put("serviceHour","營業時間必須輸入");
//		}
//		String introduction = request.getParameter("introduction");
//		if (introduction == null || introduction.trim().length() == 0) {
//			errorMessage.put("introduction","介紹必須輸入");
//		}
//		String phone = request.getParameter("phone");
//		if (phone.trim().length() < 7|| phone.trim().length() == 0) {
//			errorMessage.put("phone","電話格式錯誤");
//		}
//		Part file1 = request.getPart("file1");
//		String fileName = file1.getSubmittedFileName();
//		//System.out.println("fileName "+fileName);
//		InputStream is = file1.getInputStream();
//		long size = file1.getSize();
//		byte[] b = new byte[(int) size];
//		SerialBlob sb = null;
//		is.read(b);
//		try {
//			sb = new SerialBlob(b);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
////		String fileName = file1.toString();
//		// 如果有錯誤，呼叫view元件，送回錯誤訊息
//		if (!errorMessage.isEmpty()) {
//			RequestDispatcher rd = request.getRequestDispatcher("/attractions/AddAttractionsForm.jsp");
//			rd.forward(request, response);
//			return;
//		}
//		// AttractionsBean 扮演封裝輸入資料的角色
//		AttractionsBean ab = new AttractionsBean(name, address, serviceHour, serviceHour2, introduction, phone, sb, fileName);
//		try {
//			AttractionsService attractionsService = new AttractionsService();
//			attractionsService.save(ab);
//			session.setAttribute("attractionsBean", ab);
//			String contextPath = request.getContextPath();
//			response.sendRedirect(response.encodeRedirectURL(contextPath + "/showAttractionsServlet"));
//			return;
//		} catch (Exception e) {
//			e.printStackTrace();
//			RequestDispatcher rd = request.getRequestDispatcher("/attractions/AddAttractionsForm.jsp");
//			rd.forward(request, response);
//			return;
//		}
//	}
//
//}

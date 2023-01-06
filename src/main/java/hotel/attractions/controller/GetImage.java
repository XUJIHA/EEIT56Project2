package hotel.attractions.controller;
//package attractions.controller;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.sql.Blob;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import attractions.model.AttractionsBean;
//import attractions.service.AttractionsService;
//@WebServlet("/getImage")
//@MultipartConfig
//public class GetImage extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		//
//		OutputStream os = null;
//		InputStream is = null;
//		String fileName = null;
//		String mimeType = null;
//		Blob blob = null;
//	    try {
//	    	String id = request.getParameter("id");
//	    	AttractionsService attractionsService = new AttractionsService();
//			int nId = 0;
//			try {
//				nId = Integer.parseInt(id);
//			} catch(NumberFormatException ex) {
//				;
//			}
//			AttractionsBean bean = attractionsService.findById(nId);
//			if (bean != null) {
//				blob = bean.getImage1();
//				if (blob != null) {
//					is = blob.getBinaryStream();
//				}
//				fileName = bean.getFileName();
////				System.out.println("fileName "+fileName);
//			}
//			// 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)	
//			if (is == null) {
//				fileName = "Noimage.png" ; 
//				is = getServletContext().getResourceAsStream(
//						"/img/" + fileName);
//				System.out.println("is "+is);
//			}
//				// 由圖片檔的檔名來得到檔案的MIME型態
//				mimeType = getServletContext().getMimeType(fileName);
//				// 設定輸出資料的MIME型態
//				response.setContentType(mimeType);
//				// 取得能寫出非文字資料的OutputStream物件
//				os = response.getOutputStream();
//				int len = 0;
//				byte[] bytes = new byte[8192];
//				while ((len = is.read(bytes)) != -1) {
//					os.write(bytes, 0, len);
//				}
////				System.out.println("image ok ");
//	    } catch (Exception e) {
//	    	e.printStackTrace();;
//	    }finally{
//			if (is != null) is.close();
//			if (os != null) os.close();
//			
//		}
////
//	}
//}

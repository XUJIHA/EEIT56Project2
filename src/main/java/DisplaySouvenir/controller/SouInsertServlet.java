package DisplaySouvenir.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DisplaySouvenir.model.souvenirBean;
import DisplaySouvenir.service.souvenirService;
import DisplaySouvenir.service.impl.souvenirServiceImpl;
import DisplaySouvenir.util.GlobalService;


@WebServlet("/giftMaintain/SouInsert.do")

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
		* 1024 * 500 * 5)

public class SouInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(SouInsertServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.info("新增伴手禮功能之Controller: 開始");
		Map<String, String> errorMsgs = new HashMap<String, String>();
		Map<String, String> successMsgs = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		request.setAttribute("ErrMsg", errorMsgs);
		session.setAttribute("successMsg", successMsgs);

		try {	
			String souvenir_no ="";	
			String souvenir_name ="";	
			String fileName = "";
			String souvenir_des = "";
//			String priceStr = "";
			String price = "";
			double souvenir_price = 0;
			String souvenir_num = "";
			long sizeInBytes = 0;
			
			InputStream is = null;
			
			Collection<Part> parts = request.getParts();

			//GlobalService.exploreParts(parts, request);
			if (parts != null) { // 如果這是一個上傳資料的表單
				for (Part p : parts) {
					String fldName = p.getName();
					String value = request.getParameter(fldName);
					if (p.getContentType() == null) {   // 表示 p 為一般欄位而非上傳的表單
						// 根據欄位名稱來讀取欄位的內容，然後存入適當的變數內
						if (fldName.equals("souvenir_name")) {
							souvenir_name = value;
							if (value == null || souvenir_name.trim().length() == 0) {
								errorMsgs.put("errsouvenir_name", "必須輸入伴手禮名");
							} else {
								request.setAttribute("souvenir_name", souvenir_name);
							}
						} else if (fldName.equals("souvenir_no")) {
							souvenir_no = value;
							;
							if (souvenir_no == null || souvenir_no.trim().length() == 0) {
								errorMsgs.put("errSouvenir_no", "必須輸入伴手禮號");
							} else {
								request.setAttribute("souvenir_no", souvenir_no);
							}
						} else if (fldName.equals("souvenir_des")) {
							souvenir_des = value;
							if (souvenir_des == null || souvenir_des.trim().length() == 0) {
								errorMsgs.put("errSouvenir_des", "必須輸入介紹");
							} else {
								request.setAttribute("author", souvenir_des);
							}
						} else if (fldName.equals("souvenir_price")) {
							price = value;
							price = price.trim();
							if (price == null || price.trim().length() == 0) {
								errorMsgs.put("errSouvenir_price", "必須輸入價格");
							} else {
								try {
									souvenir_price = Double.parseDouble(price);
								} catch (NumberFormatException e) {
									errorMsgs.put("errPrice", "價格必須是數值");
								}
							}
							request.setAttribute("souvenir_price", price);
						}else if (fldName.equals("souvenir_num")) {
							souvenir_num = value;
							;
							if (souvenir_num == null || souvenir_num.trim().length() == 0) {
								errorMsgs.put("errSouvenir_num", "必須輸入伴手禮數量");
							}
							request.setAttribute("souvenir_num", souvenir_num);
						}

					} else {  // 表示此份資料是上傳的檔案
						fileName = GlobalService.getFileName(p); // 由變數 p 中取出檔案名稱
						if (fileName != null && fileName.trim().length() > 0) {
							fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
//							mimeType = getServletContext().getMimeType(fileName);
							
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						} else {
							errorMsgs.put("errPicture", "必須挑選圖片檔");
						}
					}
				}
			} else {
				errorMsgs.put("errTitle", "此表單不是上傳檔案的表單");
			}
			// 如果輸入資料有錯誤
			if (!errorMsgs.isEmpty()) {
				// 轉交給原輸入資料的網頁來顯示錯誤訊息
				System.out.println("新增失敗");
				log.info("新增伴手禮功能之Controller: 轉交給原輸入資料的網頁來顯示錯誤訊息");
				RequestDispatcher rd = request.getRequestDispatcher("/Gift/SouInsert.jsp");
				rd.forward(request, response);
				return;
			}
			
//			int SOUN = Integer.parseInt(souvenir_num);
//			int SNO =Integer.parseInt(souvenir_no);
			// 將上傳的檔案轉換為 Blob 物件
			Blob blob = GlobalService.fileToBlob(is, sizeInBytes);
			souvenirService sService = new souvenirServiceImpl();
//			souvenirBean bb = new souvenirBean(null, title, author, price, 1.0, fileName, bookNo, 
//										blob, cId, category, mimeType);
			souvenirBean bb = new souvenirBean(souvenir_no, souvenir_name, blob,fileName, souvenir_des, 
					souvenir_price, souvenir_num);
			
			System.out.println(bb.toString());
			
			
					
			sService.save(bb);
			log.info("新增伴手禮功能之Controller: 資料新增成功, souvenirBean=" + bb);
			successMsgs.put("success", "資料新增成功");
            // 新增成功，通知瀏覽器對新網址發出請求
//			int lastPage = new souvenirServiceImpl().getTotalPages();
			RequestDispatcher rd = request.getRequestDispatcher("/giftMaintain/DisplayPageProducts");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace(); 
			errorMsgs.put("Exception", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/Gift/Insert.jsp");
			rd.forward(request, response);
		}
	}

	public String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	// 本方法於主控台印出 parts 內的重要資訊，純粹為觀察用，沒有功能上的用途。
	public void exploreParts(Collection<Part> parts, HttpServletRequest req) {
		try {
			for (Part part : parts) {
				String name = part.getName();
				String contentType = part.getContentType();
				String value = "";
				long size = part.getSize(); // 上傳資料的大小，即上傳資料的位元組數
				try (InputStream is = part.getInputStream();) {
					if (contentType != null) { // 表示該part為檔案
						// 取出上傳檔案的檔名
						String filename = getFileName(part);
						// 將上傳的檔案寫入到location屬性所指定的資料夾
						part.write(filename);
					} else { // 表示該part為一般的欄位
						// 將上傳的欄位資料寫入到location屬性所指定的資料夾，檔名為"part_"+ name
						part.write("part_" + name);
						value = req.getParameter(name);
					}
					System.out.printf("%-15s %-15s %8d  %-20s \n", name, contentType, size, value);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
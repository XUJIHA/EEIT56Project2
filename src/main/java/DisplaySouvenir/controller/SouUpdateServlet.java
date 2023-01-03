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

@WebServlet("/giftMaintain/SouUpdate.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
// 更新書籍資料，邏輯上與新增書籍資料類似
public class SouUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(SouUpdateServlet.class);
	
	souvenirBean bb ;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (!session.isNew())  {
			bb = (souvenirBean) session.getAttribute("bean");
		} else {
			bb = new souvenirBean();
		}
		String pageNo = "1";
		Map<String, String> errorMsgs = new HashMap<String, String>();
		Map<String, String> successMsgs = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("ErrMsg", errorMsgs);
		session.setAttribute("successMsg", successMsgs);
		try {
			String souvenir_no ="";	
			String souvenir_name ="";	
			String fileName = "";
			String souvenir_des = "";
			double souvenir_price = 0;
			String price = "";
			String souvenir_num = "";
			long sizeInBytes = 0;
			
			InputStream is = null;
			Collection<Part> parts = request.getParts();
			
			if (parts != null) {   // 如果這是一個上傳資料的表單				
				for (Part p : parts) {
					String fldName = p.getName();
					String value = request.getParameter(fldName);
					if (p.getContentType() == null) {
						if (fldName.equals("souvenir_name")) {
							souvenir_name = value;
							bb.setSouvenir_name(souvenir_name);
							if (value == null || souvenir_name.trim().length() == 0) {
								errorMsgs.put("errSouvenir_name", "必須輸入伴手禮名");
							} else {
								request.setAttribute("souvenir_name", souvenir_name);
							}
						} else if (fldName.equals("souvenir_des")) {
							souvenir_des = value;
							bb.setSouvenir_des(souvenir_des);
							if (souvenir_des == null || souvenir_des.trim().length() == 0) {
								errorMsgs.put("errSouvenir_des", "必須輸入介紹");
							} else {
								request.setAttribute("souvenir_des", souvenir_des);
							}
						} else if (fldName.equals("souvenir_price")) {
							price = value;
							price = price.trim();
//							price.parse
							souvenir_price=Double.parseDouble(price);
							bb.setSouvenir_price(souvenir_price);
							if (price == null
									|| price.trim().length() == 0) {
								errorMsgs.put("errSouvenir_price", "必須輸入價格");
							} else {
								try {
									souvenir_price = Double.parseDouble(price);
								} catch (NumberFormatException e) {
									errorMsgs.put("errSouvenir_price", "價格必須是數值");
								}
							}
							request.setAttribute("souvenir_price", price);
						} else if (fldName.equals("souvenir_no")) {
							souvenir_no = value;
							bb.setSouvenir_no(souvenir_no);
							if (souvenir_no == null || souvenir_no.trim().length() == 0) {
								errorMsgs.put("errBookNo", "必須輸入伴手禮號");
							} else {
								request.setAttribute("souvenir_no", souvenir_no);
							}
						} else if (fldName.equals("pageNo")){
							pageNo = value;
						}else if (fldName.equals("souvenir_num")) {
							souvenir_num = value;
							bb.setSouvenir_num(souvenir_num);
							if (souvenir_num == null
									|| souvenir_num.trim().length() == 0) {
								errorMsgs.put("errSouvenir_num", "必須輸入伴手禮數量");
							}else {
								request.setAttribute("errSouvenir_num", souvenir_num);
							}
						} 
					} else {
						fileName = GlobalService.getFileName(p); // 由變數 p 中取出檔案名稱
						if (fileName != null && fileName.trim().length() > 0) {
							fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
//							mimeType = getServletContext().getMimeType(fileName);
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						} else {
							sizeInBytes = -1;
						}
					} 
				}
			} else {
				errorMsgs.put("errTitle", "此表單不是上傳檔案的表單");
			}
			if (!errorMsgs.isEmpty()) {
			   RequestDispatcher rd = request.getRequestDispatcher("/Gift/SouUpdate.jsp");
			   rd.forward(request, response);
			   return;
			} 
			
			souvenirService souvenirBean = new souvenirServiceImpl();
			
//			int SNUM = Integer.parseInt(souvenir_num);
//			int SNO =Integer.parseInt(souvenir_no);
			
			Blob blob = null;
			if (sizeInBytes != -1){
				blob = GlobalService.fileToBlob(is, sizeInBytes);
			}
			System.out.println("bb=="+bb);
			souvenirBean newBean = new souvenirBean(bb.getSouvenir_id(),souvenir_no,souvenir_name,
					blob,fileName,souvenir_des,souvenir_price,souvenir_num );	
			souvenirBean.updateSouvenir(newBean, sizeInBytes);
//			souvenirBean.updateSouvenir(bb.getSouvenir_id(),souvenir_no,souvenir_name,
//					blob,fileName,souvenir_des,souvenir_price,souvenir_num);
			///giftMaintain/DisplayPageProducts
			RequestDispatcher rd = request.getRequestDispatcher("/giftMaintain/DisplayPageProducts" );
			rd.forward(request, response);
			/*
			 souvenirDao dao= new souvenirDaoImpl_Jdbc();
		List<souvenirBean> beans = dao.findByAll();
		request.setAttribute("beans", beans);
		RequestDispatcher rd = request.getRequestDispatcher("/_20_productMaintain/SouMaintainList.jsp");
		rd.forward(request, response);
			 */
//			log.info("更新書籍之Controller, 成功，newBean=" + newBean);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			errorMsgs.put("errDBMessage", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/Gift/SouUpdate.jsp");
			rd.forward(request, response);
		}
	}

}

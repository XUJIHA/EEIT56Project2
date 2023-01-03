package DisplaySouvenir.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DisplaySouvenir.model.souvenirBean;
import DisplaySouvenir.service.souvenirService;
import DisplaySouvenir.service.impl.souvenirServiceImpl;

@WebServlet("/_00_init/getSouImage")
public class RetrieveSouImageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(RetrieveSouImageServlet.class);
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		OutputStream os = null;
		InputStream is = null;
		String fileName = null;
		String mimeType = null;
		Blob blob = null;
		try {
			// 讀取瀏覽器傳送來的主鍵
			String id = request.getParameter("id");//souvenir_id
			// 讀取瀏覽器傳送來的type，以分辨要處理哪個表格
			souvenirService souvenirService = new souvenirServiceImpl();
			int nId = 0;
			try {
				nId = Integer.parseInt(id);
			} catch(NumberFormatException ex) {
				;
			}
//			souvenirBean bean = souvenirService.
//			souvenirBean bean = _03_listBooks.service.souvenirService.findById(nId);
			souvenirBean bean = souvenirService.findById(nId);
			System.out.println(bean);
			if (bean != null) {
			
				blob = ((souvenirBean) bean).getSouvenir_pic();
				if (blob != null) {
					is = blob.getBinaryStream();
				}
				fileName = ((souvenirBean) bean).getFileName();
//				System.out.println(fileName);
			}
			// 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)	
			if (is == null) {
				fileName = "Cat-Photog-Feat-256x256.jpg" ; 
				is = getServletContext().getResourceAsStream(
						"/images/" + fileName);
			}
			
			// 由圖片檔的檔名來得到檔案的MIME型態
			mimeType = getServletContext().getMimeType(fileName);
			// 設定輸出資料的MIME型態
			response.setContentType(mimeType);
			// 取得能寫出非文字資料的OutputStream物件
			os = response.getOutputStream();	
			// 由InputStream讀取位元組，然後由OutputStream寫出
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
			}
			log.info("送出souvenir圖片, id=" + id);
		} catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("util.RetrieveSouImageServlet#doGet()發生SQLException: " + ex.getMessage());
		} finally{
			if (is != null) is.close();
			if (os != null) os.close();
			
		}
	}
}

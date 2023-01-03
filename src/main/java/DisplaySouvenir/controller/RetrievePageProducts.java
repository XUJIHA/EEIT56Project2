package DisplaySouvenir.controller;
import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DisplaySouvenir.model.souvenirBean;
import DisplaySouvenir.service.souvenirService;
import DisplaySouvenir.service.impl.souvenirServiceImpl;




@WebServlet("/_03_listBooks/DisplayPageProducts")
// 本控制器負責進行必要的前置作業，以便程式能讀取某一頁的商品資料
public class RetrievePageProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(RetrievePageProducts.class);
	
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先取出session物件
		log.info("讀取一頁商品資料之Controller: 開始");
		HttpSession session = request.getSession(true);

		String pageNoStr = request.getParameter("pageNo");
		if (pageNoStr == null) {
			pageNo = 1;
		} else {
			try {
				pageNo = Integer.parseInt(pageNoStr.trim());
			} catch (NumberFormatException e) {
				pageNo = 1;
			}
		}
		log.info("讀取一頁商品資料之Controller: pageNo=" + pageNo );
		souvenirService souService = new souvenirServiceImpl(); 
		
		request.setAttribute("baBean", souService);
		// bookService.getPageBooks()方法開始讀取一頁的書籍資料
		// 讀取一頁的書籍資料，經由參數告訴service現在要讀哪一頁
//		Map<Integer, souvenirBean> souvMap = souService.getPageBooks(pageNo);
		session.setAttribute("pageNo", String.valueOf(pageNo));
		request.setAttribute("totalPages", souService.getTotalPages());
		// 將讀到的一頁資料放入request物件內，成為它的屬性物件
		session.setAttribute("products_DPP", souService);
//		log.info("bookMap=" + souvMap);
		// 使用Cookie來儲存目前讀取的網頁編號，Cookie的名稱為memberId + "pageNo"
		// -----------------------
		Cookie pnCookie = new Cookie( "pageNo", String.valueOf(pageNo));
	    // 設定Cookie的存活期為30天
		pnCookie.setMaxAge(30 * 24 * 60 * 60);
	    // 設定Cookie的路徑為 Context Path		
		pnCookie.setPath(request.getContextPath());
		// 將Cookie加入回應物件內
		response.addCookie(pnCookie);
		// -----------------------
		// 交由listBooks.jsp來顯示某頁的書籍資料，同時準備『第一頁』、
		// 『前一頁』、『下一頁』、『最末頁』等資料
		RequestDispatcher rd = request.getRequestDispatcher("/_03_listBooks/listBooks.jsp");
		rd.forward(request, response);
		return;
	}
}

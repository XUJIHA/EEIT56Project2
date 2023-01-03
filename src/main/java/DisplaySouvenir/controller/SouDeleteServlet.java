package DisplaySouvenir.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DisplaySouvenir.service.souvenirService;
import DisplaySouvenir.service.impl.souvenirServiceImpl;

// 依照書籍的書號來刪除一本書籍的紀錄。本控制器會呼叫 BookService介面的deleteBook()方法來完成。
@WebServlet("/giftMaintain/SouDelete.do")
public class SouDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(SouDeleteServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("刪除伴手禮功能之Controller: 開始");
		
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		String sId = request.getParameter("souvenir_id");
		String sNo = request.getParameter("souvenir_no");
		int souId = Integer.parseInt(sId);
		souvenirService bookService = new souvenirServiceImpl();
		try {
			bookService.deleteById(souId);
			session.setAttribute("SouDeleteMsg", "伴手禮(" + sNo + ")刪除成功");
			log.info("刪除伴手禮功能之Controller，伴手禮(" + sNo + ")刪除成功");
		} catch(Exception ex) {
			session.setAttribute("SouDeleteMsg", "伴手禮" + sNo + ")刪除失敗");
			log.info("刪除伴手禮功能之Controller，伴手禮(" + sNo + ")刪除失敗，ex=" + ex);
		}
		response.sendRedirect(response.encodeRedirectURL(contextPath 
				         + "/giftMaintain/DisplayPageProducts"));
		return;
	}
}

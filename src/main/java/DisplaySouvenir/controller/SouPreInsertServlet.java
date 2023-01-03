package DisplaySouvenir.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DisplaySouvenir.service.souvenirService;
import DisplaySouvenir.service.impl.souvenirServiceImpl;

@WebServlet("/giftMaintain/SouPreInsertServlet.do")
public class SouPreInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(SouPreInsertServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 本類別負責讀取資料庫內Book表格內某一頁的紀錄，並能新增紀錄、修改紀錄、刪除記錄等
				souvenirService souService = new souvenirServiceImpl();

				request.setAttribute("souvenirBean", souService);
//				RequestDispatcher rd = request.getRequestDispatcher("/_20_productMaintain/SouInsert.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("/Gift/Insert.jsp");
				rd.forward(request, response);
				return;
	}
}

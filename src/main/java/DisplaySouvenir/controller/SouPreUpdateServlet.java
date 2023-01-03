package DisplaySouvenir.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DisplaySouvenir.model.souvenirBean;
import DisplaySouvenir.service.souvenirService;
import DisplaySouvenir.service.impl.souvenirServiceImpl;


@WebServlet("/giftMaintain/SouPreUpdate.do")
public class SouPreUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger log = LoggerFactory.getLogger(SouPreUpdateServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		log.info("更新伴手禮之前置作業之Controller, 開始");
		
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession(true);
		int souId = 0;
		String strSOUId = request.getParameter("SOUID");
		
		if (strSOUId != null) {
			souId = Integer.parseInt(strSOUId);
		}
//		System.out.println("souId="+souId);
		souvenirService souvenirService = new souvenirServiceImpl();
		souvenirBean bean = (souvenirBean) souvenirService.findById(souId);
		session.setAttribute("bean", bean);

		RequestDispatcher rd = request.getRequestDispatcher("/Gift/update.jsp");
		rd.forward(request, response);
		return;
	}
}



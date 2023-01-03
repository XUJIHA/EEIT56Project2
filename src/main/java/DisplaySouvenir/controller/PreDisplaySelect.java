package DisplaySouvenir.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DisplaySouvenir.model.souvenirBean;
import DisplaySouvenir.service.souvenirService;
import DisplaySouvenir.service.impl.souvenirServiceImpl;


@WebServlet("/_20_productMaintain/PreDisplaySelect.do")
public class PreDisplaySelect {
	private static final long serialVersionUID = 1L;
    
	private static Logger log = LoggerFactory.getLogger(SouPreUpdateServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		log.info("更新伴手禮之前置作業之Controller, 開始");
		
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession(true);
//		HttpSession session = request.getSession(false);
		
//		if (session == null) {
//		     response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.jsp"));
//		     return;
//		}
		int souId = 0;
		String strSOUId = request.getParameter("SOUID");
		
		if (strSOUId != null) {
			souId = Integer.parseInt(strSOUId);
		}
		
		souvenirService souvenirService = new souvenirServiceImpl();
		souvenirBean bean = (souvenirBean) souvenirService.findById(souId);
		session.setAttribute("bean", bean);

		RequestDispatcher rd = request.getRequestDispatcher("/Gift/giftDetail.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}

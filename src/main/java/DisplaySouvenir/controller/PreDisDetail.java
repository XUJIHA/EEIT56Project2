package DisplaySouvenir.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/PreDisDetail")
public class PreDisDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(PreDisDetail.class);
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
log.info("更新伴手禮之前置作業之Controller, 開始");
		
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession(true);
//		HttpSession session = request.getSession(false);
		
//		if (session == null) {
//		     response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.jsp"));
//		     return;
//		}
		int souId = 0;
		String strSOUId = request.getParameter("id");
		System.out.println("strSOUId"+strSOUId);
		if (strSOUId != null) {
//			int souId = String.valueOf(strSOUId).intValue();
			souId = Integer.parseInt(strSOUId.toString());
//			souId = ((String)strSOUId).value();
		}
		souvenirService souvenirService = new souvenirServiceImpl();
		souvenirBean bean = (souvenirBean) souvenirService.findById(souId);
//		souvenirBean bean = (souvenirBean) souvenirService.findById(souId);
		session.setAttribute("bean", bean);
		System.out.println("id"+souId);
		RequestDispatcher rd = request.getRequestDispatcher("/Gift/giftDetail.jsp");
		rd.forward(request, response);
		return ;
	}

}

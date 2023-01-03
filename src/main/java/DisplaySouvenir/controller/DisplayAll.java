package DisplaySouvenir.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DisplaySouvenir.dao.souvenirDao;
import DisplaySouvenir.dao.impl.souvenirDaoImpl_Jdbc;
import DisplaySouvenir.model.souvenirBean;
import DisplaySouvenir.service.souvenirService;
import DisplaySouvenir.service.impl.souvenirServiceImpl;

@WebServlet("/giftMaintain/DisplayAll")
public class DisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	private static Logger log = LoggerFactory.getLogger(DisplayAll.class);
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		souvenirService dao= new souvenirServiceImpl();
		List<souvenirBean> beans = dao.findByAll();
//		System.out.println(beans.toString());
		request.setAttribute("beans", beans);
		RequestDispatcher rd = request.getRequestDispatcher("/Gift/gift.jsp");
		rd.forward(request, response);
		return;
	}
}
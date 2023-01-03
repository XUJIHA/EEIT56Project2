package DisplaySouvenir.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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


@WebServlet("/giftMaintain/DisplayPageProducts")
public class DisplayMaintainProducts extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 souvenirService souService = new souvenirServiceImpl();
		request.setAttribute("baBean", souService);
		//
		Map<Integer, souvenirBean> SouMap = .getPageBooks(pageNo);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("totalPages", souService.getTotalPages());
		request.setAttribute("products_DPP", SouMap);
		RequestDispatcher rd = request.getRequestDispatcher("/_20_productMaintain/maintain.jsp");
		rd.forward(request, response);
		 */
		souvenirService souService= new souvenirServiceImpl();
		List<souvenirBean> beans = souService.findByAll();
		request.setAttribute("beans", beans);
		RequestDispatcher rd = request.getRequestDispatcher("/Gift/maintain.jsp");
		rd.forward(request, response);;
		
		
		return;
	}
}
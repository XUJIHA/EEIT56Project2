package hotel.attractions.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.attractions.model.AttractionsBean;
import hotel.attractions.service.AttractionsService;

@WebServlet("/showAttractionsServlet")
public class ShowAttractionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AttractionsService attractionsService = new AttractionsService();
		List<AttractionsBean> attractions =  attractionsService.findAll();
		request.setAttribute("attractionsBean", attractions);
		RequestDispatcher rd = request.getRequestDispatcher("/attractions/AttractionsList.jsp");//AttractionsList
		rd.forward(request, response);
		return;
	}

}

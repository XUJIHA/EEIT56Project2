package attractions.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attractions.model.AttractionsBean;
import attractions.service.AttractionService;

@WebServlet("/showAttractionsServlet")
public class ShowAttractionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AttractionService attractionService = new AttractionService();
		List<AttractionsBean> attractions =  attractionService.findAll();
		request.setAttribute("attractionsBean", attractions);
		RequestDispatcher rd = request.getRequestDispatcher("/attractions/AttractionsList.jsp");//AttractionsList
		rd.forward(request, response);
		return;
	}

}

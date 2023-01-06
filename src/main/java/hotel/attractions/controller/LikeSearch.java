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

@WebServlet("/likeSearch")
public class LikeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("search");
		AttractionsService attractionsService = new AttractionsService();
		List<AttractionsBean> attractions =  attractionsService.likeSearch(search);
		request.setAttribute("attractionsBean", attractions);
		RequestDispatcher rd = request.getRequestDispatcher("/attractions/AttractionsList.jsp");
		rd.forward(request, response);
		return;
	}

}

package attractions.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attractions.model.AttractionsBean;
import attractions.service.AttractionService;

@WebServlet("/edit")
public class GetId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AttractionService attractionService = new AttractionService();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			AttractionsBean ab = attractionService.findById(id);
			request.setAttribute("attractionsBean", ab);
			RequestDispatcher rd = request.getRequestDispatcher("/attractions/EditAttractions.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

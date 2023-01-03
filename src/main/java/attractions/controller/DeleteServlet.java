package attractions.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import attractions.service.AttractionService;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AttractionService attractionService = new AttractionService();
		int id = Integer.parseInt(request.getParameter("id"));
		attractionService.deleteById(id);
//		String contextPath = request.getContextPath();
//		response.sendRedirect(response.encodeRedirectURL(contextPath + "/showAttractionsServlet"));
//		response.getWriter().write("");
//		return;
	}

}

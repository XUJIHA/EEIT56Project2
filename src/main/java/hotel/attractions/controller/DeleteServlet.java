package hotel.attractions.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.attractions.service.AttractionsService;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AttractionsService attractionsService = new AttractionsService();
		int id = Integer.parseInt(request.getParameter("id"));
		attractionsService.deleteById(id);
//		String contextPath = request.getContextPath();
//		response.sendRedirect(response.encodeRedirectURL(contextPath + "/showAttractionsServlet"));
//		response.getWriter().write("");
//		return;
	}

}

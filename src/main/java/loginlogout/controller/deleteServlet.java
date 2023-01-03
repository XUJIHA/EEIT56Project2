package loginlogout.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginlogout.service.LoginService;
import loginlogout.service.impl.LoginServiceImpl;





@WebServlet("/loginlogout/controller/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginService loginService = new LoginServiceImpl();
		int userno=Integer.valueOf(request.getParameter("USER_ID"));
		loginService.deleteById(userno);
//		RequestDispatcher rd = request.getRequestDispatcher("/loginlogout/controller/searchAllServlet");
//		rd.forward(request, response);
//		return;

	}
}

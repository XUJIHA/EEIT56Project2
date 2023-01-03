package loginlogout.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginlogout.service.LoginService;
import loginlogout.service.impl.LoginServiceImpl;



@WebServlet("/loginlogout/controller/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		LoginService loginService = new LoginServiceImpl();
		
		int USER_ID = Integer.parseInt(request.getParameter("USER_ID"));
		String USER_NAME = request.getParameter("USER_NAME");
		String USER_PASSWORD = request.getParameter("USER_PASSWORD");
		String USER_IDENTITY = request.getParameter("USER_IDENTITY");
		String USER_EMAIL = request.getParameter("USER_EMAIL");
		String USER_PHONE = request.getParameter("USER_PHONE");
		String USER_BIRTHDAY = request.getParameter("USER_BIRTHDAY");
		String USER_REGISTRATION = request.getParameter("USER_REGISTRATION");
		loginService.updatehotel(USER_ID,USER_NAME,USER_PASSWORD,USER_IDENTITY,USER_EMAIL,USER_PHONE,USER_BIRTHDAY,USER_REGISTRATION);
//			request.setAttribute("classList", hotelBean);
//		request.getRequestDispatcher("/loginlogout/controller/searchAllServlet").forward(request, response);
//		return;

	}

}

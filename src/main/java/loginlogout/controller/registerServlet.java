package loginlogout.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginlogout.service.LoginService;
import loginlogout.service.impl.LoginServiceImpl;
@MultipartConfig()
@WebServlet("/loginlogout/controller/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String USER_NAME = request.getParameter("USER_NAME");
		String USER_PASSWORD = request.getParameter("USER_PASSWORD");
		String USER_EMAIL = request.getParameter("USER_EMAIL");
		String USER_PHONE = request.getParameter("USER_PHONE");
		String USER_IDENTITY = request.getParameter("USER_IDENTITY");
		String USER_BIRTHDAY = request.getParameter("USER_BIRTHDAY");
		String USER_REGISTRATION = request.getParameter("USER_REGISTRATION");
		LoginService loginService = new LoginServiceImpl();
		loginService.addhotel(USER_NAME,USER_PASSWORD,USER_EMAIL,USER_PHONE,USER_IDENTITY,USER_BIRTHDAY,USER_REGISTRATION);
		String successMsg = "註冊成功!! 請登入";
		request.setAttribute("successMsg", successMsg);
		request.getRequestDispatcher("/LoginLogout/login.jsp").forward(request, response);
	}
}
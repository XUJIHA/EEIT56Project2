package loginlogout.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginlogout.model.hotelBean;
import loginlogout.service.LoginService;
import loginlogout.service.impl.LoginServiceImpl;

@MultipartConfig
@WebServlet("/loginlogout/controller/findByIdServlet")
public class findByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginService loginService = new LoginServiceImpl();
		int userno = 0;
		userno=Integer.parseInt(request.getParameter("USER_ID"));
		List<hotelBean> hotelBean=loginService.findById(userno);
		request.setAttribute("classList", hotelBean);
		request.getRequestDispatcher("/LoginLogout/update.jsp").forward(request, response);
		return;

	}
	

	}

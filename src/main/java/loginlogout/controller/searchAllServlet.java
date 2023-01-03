package loginlogout.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginlogout.model.hotelBean;
import loginlogout.service.LoginService;
import loginlogout.service.impl.LoginServiceImpl;


@WebServlet("/loginlogout/controller/searchAllServlet")
public class searchAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginService loginService = new LoginServiceImpl();
		List<hotelBean> classlist = loginService.selecthotel();
		request.setAttribute("classList", classlist);
		RequestDispatcher rd = request.getRequestDispatcher("/LoginLogout/select.jsp");
		rd.forward(request, response);
		return;

	}
}

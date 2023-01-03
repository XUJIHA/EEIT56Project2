package loginlogout.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;


@WebServlet("/loginlogout/controller/LogoutServlet")
public  class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    	HttpSession session = request.getSession(false);// 防止建立Session
		if (session == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		int logOutStatus = 1;
		request.setAttribute("logOutStatus", logOutStatus);
		session.removeAttribute("USER_EMAIL");
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
   
   
        this.doGet(request,response);
    }
}
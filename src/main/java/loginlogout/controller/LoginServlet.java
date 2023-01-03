package loginlogout.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import loginlogout.model.hotelBean;
import loginlogout.service.LoginService;
import loginlogout.service.impl.LoginServiceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		request.setAttribute("errorMsgMap", errorMsgMap);

		HttpSession httpsession = request.getSession();
		
		//防止非法登入    得到session
        HttpSession httpSession=request.getSession(true);
        //修改session的存在時間為20s
        httpSession.setMaxInactiveInterval(20);
        httpSession.setAttribute("pass","ok");
		
		// uname,pwd
		
		String USER_EMAIL = request.getParameter("USER_EMAIL");
		String USER_PASSWORD = request.getParameter("USER_PASSWORD");

		LoginService loginService = new LoginServiceImpl();

		hotelBean temphb;
		temphb = loginService.loginhotel(USER_EMAIL, USER_PASSWORD);
		 //得到提交的驗證碼
        String code = request.getParameter("code");
        System.out.println(code);
        //獲取session驗證碼
        HttpSession session = request.getSession();
        String randStr = (String) session.getAttribute("randStr");
        response.setCharacterEncoding("UTF8");
		
		if (temphb != null) {
			
			 if(code.equals(randStr)) {
                 String keep = request.getParameter("keep");
                 //勾選了兩週內免登陸選項
                 if (keep != null) {

                     //建立cookie
                     Cookie cookie1 = new Cookie("USER_EMAIL", USER_EMAIL);
                     Cookie cookie2 = new Cookie("USER_PASSWORD", USER_PASSWORD);
                     //設定關聯路徑
                     cookie1.setPath(request.getContextPath());
                     cookie2.setPath(request.getContextPath());
                     //設定cookie的消亡時間  兩週
                     cookie1.setMaxAge(2 * 7 * 24 * 60 * 60);
                     cookie1.setMaxAge(2 * 7 * 24 * 60 * 60);
                     //把cookie資訊寫給瀏覽器
                     response.addCookie(cookie1);
                     response.addCookie(cookie2);
                 }
                 httpsession.setAttribute("login", temphb);
			 }

		} else {
			errorMsgMap.put("LoginError", "帳密錯誤，請重新輸入");
		}

		if (errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/LoginLogout/alreadyindex.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/LoginLogout/login.jsp");
			rd.forward(request, response);
		}

	}

}
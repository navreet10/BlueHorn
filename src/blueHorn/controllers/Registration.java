package blueHorn.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blueHorn.customTools.DBUtil;
import blueHorn.customTools.MD5Util;
import blueHorn.dao.RegisterDao;
import blueHorn.models.Bhuser;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDao dao = new RegisterDao();

    /**
     * Default constructor. 
     */
    public Registration() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String userEmail= request.getParameter("email");
			String pwd= request.getParameter("password");
			String userName= request.getParameter("name");
			String motto= request.getParameter("motto");
			String hash = MD5Util.md5Hex(userEmail);
			String url = DBUtil.getGrUrl(hash);

			
			Bhuser user = new Bhuser();
			user.setUseremail(userEmail);
			user.setUserpassword(pwd);
			user.setUsername(userName);
			user.setMotto(motto);
			user.setJoindate(new Date());
			user.setUrl(url);
			Bhuser user1 = dao.addUser(user);
			
			if (user1 == null ) {
				request.setAttribute("message", "Something went wrong. Please try again.");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("gUrl", user.getUrl()+20);
				session.setAttribute("gBigUrl", user.getUrl()+200);
				session.setAttribute("user", user);
				request.setAttribute("userName", user.getUsername());
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
		} catch (NullPointerException e) {
			request.setAttribute("message", "Something went wrong. Please try again.");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}

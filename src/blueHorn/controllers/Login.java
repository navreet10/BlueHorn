package blueHorn.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import blueHorn.dao.LoginDao;
import blueHorn.models.Bhuser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao dao = new LoginDao();

    /**
     * Default constructor. 
     */
    public Login() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String userEmail= request.getParameter("email");
			String pwd= request.getParameter("password");
			Bhuser user = dao.getUserByEmail(userEmail);
			
			if (user == null || !dao.isValidUser(user,pwd)) {
				request.setAttribute("message", "Credentials are wrong!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				request.setAttribute("userName", user.getUsername());
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
		} catch (NullPointerException e) {
			request.setAttribute("message", "Credentials are wrong!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}

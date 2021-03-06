package blueHorn.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import blueHorn.models.Bhuser;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Profile() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			request.setAttribute("pwd", user.getUserpassword());
			request.setAttribute("motto", user.getMotto());
			request.setAttribute("email", user.getUseremail());
			request.setAttribute("name", user.getUsername());
			request.getRequestDispatcher("userProfile.jsp").forward(request, response);

		} catch (NullPointerException e) {			
			request.setAttribute("message", "Something Went Wrong!!");
			request.getRequestDispatcher("userProfile.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "Something Went Wrong!!");
			request.getRequestDispatcher("userProfile.jsp").forward(request, response);
		}
	}

}

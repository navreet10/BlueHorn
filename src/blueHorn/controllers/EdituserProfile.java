package blueHorn.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueHorn.dao.BhuserDao;
import blueHorn.models.Bhuser;

/**
 * Servlet implementation class EdituserProfile
 */
@WebServlet("/EditUserProfile")
public class EdituserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EdituserProfile() {
        super();
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
			String pwd = (String) request.getParameter("newPassword");
			String motto = (String) request.getParameter("newMotto");
			String email = (String) request.getParameter("newEmail");
			String name = (String) request.getParameter("newName");
			
			if (motto!=null)
				user.setMotto(motto);
			if (email!=null)
				user.setUseremail(email);
			if (name!=null)
				user.setUsername(name);
			if (pwd!=null)
				user.setUserpassword(pwd);
			BhuserDao.update(user);
			request.setAttribute("message", "Updates successful!!");
			request.getSession().setAttribute("user", user);
			request.setAttribute("pwd", user.getUserpassword());
			request.setAttribute("motto", user.getMotto());
			request.setAttribute("email", user.getUseremail());
			request.setAttribute("name", user.getUsername());
			request.getSession().setAttribute("user",user);
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

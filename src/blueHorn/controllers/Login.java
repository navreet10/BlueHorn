package blueHorn.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blueHorn.customTools.DBUtil;
import blueHorn.customTools.MD5Util;
import blueHorn.dao.BhpostDao;
import blueHorn.dao.LoginDao;
import blueHorn.models.Bhpost;
import blueHorn.models.Bhuser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Home")
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
			String hash = MD5Util.md5Hex(userEmail);
			String url = DBUtil.getGrUrl(20,hash);
			String urlBig = DBUtil.getGrUrl(200,hash);
			
			if (user == null || !dao.isValidUser(user,pwd)) {
				request.setAttribute("message", "Credentials are wrong!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				List<Bhpost> posts= BhpostDao.postsofUser(userEmail);							
				session.setAttribute("user", user);
				session.setAttribute("gUrl", url);
				session.setAttribute("gBigUrl", urlBig);
				request.setAttribute("posts", posts);				
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

	private String getTable(List<Bhuser> table) {
		StringBuilder html= new StringBuilder();
		html.append("<table border =\"1\">");
		html.append("<tr>");
		
		html.append("<td>");
		html.append("User ID");
		html.append("</td>");
		
		html.append("<td>");
		html.append("User Name");
		html.append("</td>");
		
		html.append("<td>");
		html.append("User Email");
		html.append("</td>");

		
		html.append("<td>");
		html.append("Motto");
		html.append("</td>");
		
		html.append("</tr>");
		for (int i= 0; i < table.size(); i++) {
			Bhuser user = table.get(i);
			html.append("<tr>");
			html.append("<td>");
			html.append(user.getBhuserid());
			html.append("</td>");
			
			html.append("<td>");
			html.append(user.getUsername());
			html.append("</td>");
			
			html.append("<td>");
			html.append(user.getUseremail());
			html.append("</td>");
			
			html.append("<td>");
			html.append(user.getMotto());
			html.append("</td>");
			html.append("</tr>");
		}
		html.append("</table>");
		return html.toString();
	}

}

package blueHorn.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueHorn.dao.BhpostDao;
import blueHorn.models.Bhpost;
import blueHorn.models.Bhuser;

/**
 * Servlet implementation class Home
 */
@WebServlet("/HomePosts")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Home() {
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
			String post= request.getParameter("post");
			//System.out.println(pwd);
			Bhpost bhPost = new Bhpost();
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			bhPost.setBhuser(user);
			bhPost.setPostdate(new Date());
			bhPost.setPosttext(post);
			BhpostDao.insert(bhPost);
		
				List<Bhpost> posts= BhpostDao.postsofUser(user.getUseremail());
				request.setAttribute("posts", posts);			
				request.setAttribute("userName", user.getUsername());
				request.getRequestDispatcher("home.jsp").forward(request, response);
			
			
		} catch (NullPointerException e) {
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			List<Bhpost> posts= BhpostDao.postsofUser(user.getUseremail());
			request.setAttribute("posts", posts);			
			request.setAttribute("userName", user.getUsername());
			request.setAttribute("message", "Post failed wrong!!");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} catch (Exception e) {
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			List<Bhpost> posts= BhpostDao.postsofUser(user.getUseremail());
			request.setAttribute("posts", posts);			
			request.setAttribute("userName", user.getUsername());
			request.setAttribute("message", "Post failed wrong!!");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} 
	}

}

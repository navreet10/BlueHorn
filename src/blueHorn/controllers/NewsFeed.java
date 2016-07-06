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
 * Servlet implementation class NewsFeed
 */
@WebServlet("/NewsFeed")
public class NewsFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public NewsFeed() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String post = request.getParameter("post");
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			// System.out.println(pwd);
			if (post !=null) {
				Bhpost bhPost = new Bhpost();
				
				bhPost.setBhuser(user);
				bhPost.setPostdate(new Date());
				bhPost.setPosttext(post);
				BhpostDao.insert(bhPost);
			}			
			List<Bhpost> posts = BhpostDao.getAllPosts();// postsofUser(user.getUseremail());
			request.setAttribute("posts", posts);
			request.setAttribute("userName", user.getUsername());
			request.getRequestDispatcher("newsFeed.jsp").forward(request, response);

		} catch (NullPointerException e) {
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			List<Bhpost> posts = BhpostDao.postsofUser(user.getUseremail());
			request.setAttribute("posts", posts);
			request.setAttribute("userName", user.getUsername());
			request.setAttribute("message", "Post failed wrong!!");
			request.getRequestDispatcher("newsFeed.jsp").forward(request, response);
		} catch (Exception e) {
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			List<Bhpost> posts = BhpostDao.postsofUser(user.getUseremail());
			request.setAttribute("posts", posts);
			request.setAttribute("userName", user.getUsername());
			request.setAttribute("message", "Post failed wrong!!");
			request.getRequestDispatcher("newsFeed.jsp").forward(request, response);
		}
	}

}

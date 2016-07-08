package blueHorn.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueHorn.dao.BhpostDao;
import blueHorn.models.Bhpost;
import blueHorn.models.BhpostComments;
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
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			String post = request.getParameter("post");
			if (post != null && post != "") {
				Bhpost bhPost = new Bhpost();				
				bhPost.setBhuser(user);
				bhPost.setPostdate(new Date());
				bhPost.setPosttext(post);
				BhpostDao.insert(bhPost);
			}			
			List<BhpostComments> posts = new ArrayList<BhpostComments>();
			List<Bhpost> postsMain = null;
			postsMain = BhpostDao.postsofUser(user.getUseremail());
				
			for (Bhpost p: postsMain) {
				BhpostComments postCom = new BhpostComments();
				List<Bhpost> res = BhpostDao.getComments(p);
				postCom.setMainPost(p);
				postCom.setComments(res);
				if (res !=null){
					posts.add(postCom);
				}					
			}
			request.setAttribute("postsHome", posts);
			request.setAttribute("userName", user.getUsername());
			request.getRequestDispatcher("home.jsp").forward(request, response);

		} catch (NullPointerException e) {
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			List<BhpostComments> posts = new ArrayList<BhpostComments>();
			List<Bhpost> postsMain = null;
			postsMain = BhpostDao.postsofUser(user.getUseremail());
				
			for (Bhpost p: postsMain) {
				BhpostComments postCom = new BhpostComments();
				List<Bhpost> res = BhpostDao.getComments(p);
				postCom.setMainPost(p);
				postCom.setComments(res);
				if (res !=null){
					posts.add(postCom);
				}					
			}
			request.setAttribute("postsHome", posts);
			request.setAttribute("userName", user.getUsername());
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} catch (Exception e) {
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			List<BhpostComments> posts = new ArrayList<BhpostComments>();
			List<Bhpost> postsMain = null;
			postsMain = BhpostDao.postsofUser(user.getUseremail());
				
			for (Bhpost p: postsMain) {
				BhpostComments postCom = new BhpostComments();
				List<Bhpost> res = BhpostDao.getComments(p);
				postCom.setMainPost(p);
				postCom.setComments(res);
				if (res !=null){
					posts.add(postCom);
				}					
			}
			request.setAttribute("postsHome", posts);
			request.setAttribute("userName", user.getUsername());
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}

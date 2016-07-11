package blueHorn.controllers;

import java.io.IOException;
import java.math.BigDecimal;
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
			if (post !=null && post != "") {
				Bhpost bhPost = new Bhpost();
				
				bhPost.setBhuser(user);
				bhPost.setPostdate(new Date());
				bhPost.setPosttext(post);
				bhPost.setParentid(new BigDecimal(-1));
				bhPost.setLikes(new BigDecimal(0));
				BhpostDao.insert(bhPost);
			}			
			List<BhpostComments> posts = new ArrayList<BhpostComments>();
			List<Bhpost> postsMain = null;
			postsMain = BhpostDao.getAllPosts();
				
			for (Bhpost p: postsMain) {
				BhpostComments postCom = new BhpostComments();
				List<Bhpost> res = BhpostDao.getComments(p);
				postCom.setMainPost(p);
				postCom.setComments(res);
				if (res !=null){
					posts.add(postCom);
				}					
			}
			request.setAttribute("postsNews", posts);
			request.setAttribute("userName", user.getUsername());
			request.getRequestDispatcher("newsFeed.jsp").forward(request, response);

		} catch (NullPointerException e) {
			List<BhpostComments> posts = new ArrayList<BhpostComments>();
			List<Bhpost> postsMain = null;
			postsMain = BhpostDao.getAllPosts();
				
			for (Bhpost p: postsMain) {
				BhpostComments postCom = new BhpostComments();
				List<Bhpost> res = BhpostDao.getComments(p);
				postCom.setMainPost(p);
				postCom.setComments(res);
				if (res !=null){
					posts.add(postCom);
				}					
			}
			request.setAttribute("postsNews", posts);
			request.getRequestDispatcher("newsFeed.jsp").forward(request, response);
		} catch (Exception e) {
			List<BhpostComments> posts = new ArrayList<BhpostComments>();
			List<Bhpost> postsMain = null;
			postsMain = BhpostDao.getAllPosts();
				
			for (Bhpost p: postsMain) {
				BhpostComments postCom = new BhpostComments();
				List<Bhpost> res = BhpostDao.getComments(p);
				postCom.setMainPost(p);
				postCom.setComments(res);
				if (res !=null){
					posts.add(postCom);
				}					
			}
			request.setAttribute("postsNews", posts);
			request.getRequestDispatcher("newsFeed.jsp").forward(request, response);
		}
	}

}

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
import javax.servlet.http.HttpSession;

import blueHorn.dao.BhpostDao;
import blueHorn.models.Bhpost;
import blueHorn.models.BhpostComments;
import blueHorn.models.Bhuser;

/**
 * Servlet implementation class Reply
 */
@WebServlet("/Reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idPost = request.getParameter("idPost");
		try {	
			
			String postId = idPost.substring(12);
			String posttext = request.getParameter("posttext");
			Bhuser user = (Bhuser)session.getAttribute("user");
			Bhpost post = new Bhpost();
			post.setBhuser(user);
			post.setParentid(new BigDecimal(postId));
			post.setPostdate(new Date());
			post.setPosttext(posttext);
			post.setLikes(new BigDecimal(0));
			BhpostDao.insert(post);
			List<BhpostComments> posts = new ArrayList<BhpostComments>();
			List<Bhpost> postsMain = null;
			if (idPost.contains("home")) {
				postsMain = BhpostDao.postsofUser(user.getUseremail());				
				
			} else {
				postsMain = BhpostDao.getAllPosts();
			}
			for (Bhpost p: postsMain) {
				BhpostComments postCom = new BhpostComments();
				List<Bhpost> res = BhpostDao.getComments(p);
				postCom.setMainPost(p);
				postCom.setComments(res);
				if (res !=null){
					posts.add(postCom);
				}					
			}
			if (idPost.contains("home")) {
				session.setAttribute("postsHome", posts);
			} else {
				session.setAttribute("postsNews", posts);
			}

		} catch (NullPointerException e) {
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			List<BhpostComments> posts = new ArrayList<BhpostComments>();
			List<Bhpost> postsMain = null;
			if (idPost.contains("home")) {
				postsMain = BhpostDao.postsofUser(user.getUseremail());
				
				
			} else {
				postsMain = BhpostDao.getAllPosts();
			}
			for (Bhpost p: postsMain) {
				BhpostComments postCom = new BhpostComments();
				List<Bhpost> res = BhpostDao.getComments(p);
				postCom.setMainPost(p);
				postCom.setComments(res);
				if (res !=null){
					posts.add(postCom);
				}					
			}
			if (idPost.contains("home")) {
				session.setAttribute("postsHome", posts);
			} else {
				session.setAttribute("postsNews", posts);
			}
			
		} catch (Exception e) {
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			List<BhpostComments> posts = new ArrayList<BhpostComments>();
			List<Bhpost> postsMain = null;
			if (idPost.contains("home")) {
				postsMain = BhpostDao.postsofUser(user.getUseremail());
				
				
			} else {
				postsMain = BhpostDao.getAllPosts();
			}
			for (Bhpost p: postsMain) {
				BhpostComments postCom = new BhpostComments();
				List<Bhpost> res = BhpostDao.getComments(p);
				postCom.setMainPost(p);
				postCom.setComments(res);
				if (res !=null){
					posts.add(postCom);
				}					
			}
			if (idPost.contains("home")) {
				session.setAttribute("postsHome", posts);
			} else {
				session.setAttribute("postsNews", posts);
			}
		}
	}

}

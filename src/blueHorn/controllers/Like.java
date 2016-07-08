package blueHorn.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
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
 * Servlet implementation class Like
 */
@WebServlet("/Like")
public class Like extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Like() {
        super();
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
		System.out.println("in");
		try {	
			
			String postId = idPost.substring(8);
			Bhuser user = (Bhuser)session.getAttribute("user");
			Bhpost post = BhpostDao.getPost(Long.parseLong(postId));
			post.setLikes(post.getLikes().add(new BigDecimal(1)));
			BhpostDao.update(post);
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
			session.setAttribute("postsHome", posts);

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
			session.setAttribute("postsHome", posts);
			
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
			session.setAttribute("postsHome", posts);
		}
	}

}

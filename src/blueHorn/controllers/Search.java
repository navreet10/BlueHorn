package blueHorn.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import blueHorn.dao.BhpostDao;
import blueHorn.models.Bhpost;
import blueHorn.models.Bhuser;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
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
		HttpSession session = request.getSession();
		try {			
			System.out.println("in Search");
			String search = request.getParameter("search");
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			List<Bhpost> posts = BhpostDao.searchPosts(search);
			session.setAttribute("postsSearch", posts);
			session.setAttribute("userName", user.getUsername());
			if (posts.size() ==0) {
				session.setAttribute("messageSearch", "No Records!!");
			} else {
				session.setAttribute("messageSearch", "Search Results!!");
			}
			

		} catch (NullPointerException e) {
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			session.setAttribute("userName", user.getUsername());
			session.setAttribute("messageSearch", "Something went wrong!!");
			
		} catch (Exception e) {
			Bhuser user = (Bhuser) request.getSession().getAttribute("user");
			session.setAttribute("userName", user.getUsername());
			session.setAttribute("messageSearch", "Something went wrong!!");
		}
	}

}

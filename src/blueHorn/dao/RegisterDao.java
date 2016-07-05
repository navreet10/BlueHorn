package blueHorn.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import blueHorn.customTools.DBUtil;
import blueHorn.models.Bhuser;

public class RegisterDao {

	public Bhuser addUser(String userEmail, String pwd, String userName, String motto) {
		
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		Bhuser user1 = null;
		try {
		em.getTransaction().begin();

		Bhuser user = new Bhuser();
		user.setUsername(userName);
		user.setUserpassword(pwd);
		user.setMotto(motto);
		user.setUseremail(userEmail);

		em.persist(user);

		em.getTransaction().commit();
		
		LoginDao dao = new LoginDao();
		user1 = dao.getUserByEmail(userEmail);
			
		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user1;
	}

}

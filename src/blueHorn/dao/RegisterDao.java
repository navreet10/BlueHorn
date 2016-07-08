package blueHorn.dao;



import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import blueHorn.customTools.DBUtil;
import blueHorn.models.Bhuser;

public class RegisterDao {

	public Bhuser addUser(Bhuser user) {
		
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		Bhuser user1 = null;
		try {
		em.getTransaction().begin();	
		em.persist(user);
		em.getTransaction().commit();		
		LoginDao dao = new LoginDao();
		user1 = dao.getUserByEmail(user.getUseremail());
			
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

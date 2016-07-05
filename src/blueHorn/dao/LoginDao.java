package blueHorn.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import blueHorn.customTools.DBUtil;
import blueHorn.models.Bhuser;

public class LoginDao {

	public Bhuser getUserByEmail(String userEmail) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		TypedQuery<Bhuser> query= em.createQuery("SELECT b FROM Bhuser b where b.useremail = :email", Bhuser.class);
		query.setParameter("email", userEmail);
		Bhuser user = null;
		try {
			user = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
		
	}

	public boolean isValidUser(Bhuser user, String pwd) {		
		return user.getUserpassword().equals(pwd);
	}

}

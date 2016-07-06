package blueHorn.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import blueHorn.customTools.DBUtil;
import blueHorn.models.Bhuser;

public class BhuserDao {
	 public static void update(Bhuser user) {
	        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
	        EntityTransaction trans = em.getTransaction();
	        try {
	            trans.begin();
	            em.merge(user);
	            trans.commit();
	        } catch (Exception e) {
	            trans.rollback();
	        } finally {
	            em.close();
	        }
	    }

}

package blueHorn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import blueHorn.customTools.DBUtil;
import blueHorn.models.Bhpost;

public class BhpostDao {
	public static void insert(Bhpost bhPost) {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(bhPost);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Bhpost bhPost) {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(bhPost);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Bhpost bhPost) {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(bhPost));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static List<Bhpost> bhPost (){
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        String qString = "select b from Bhpost b";
        
        List<Bhpost> posts = null;
        try{
            TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
            posts = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return posts;
    }
    
    public static List<Bhpost> postsofUser(long userid)
    {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<Bhpost> userposts = null;
        String qString = "select b from Bhpost b where b.bhuser.bhuserid = :userid "
        		+ "and b.parentid = -1";
        
        try{
            TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
            query.setParameter("userid", userid);
            userposts = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return userposts;    
    }
    public static List<Bhpost> postsofUser(String useremail)
    {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<Bhpost> userposts = null;
        //List<Bhpost> posts = null;
        String qString = "select b from Bhpost b "
                + "where b.bhuser.useremail = :useremail and b.parentid = -1";
        
        try{
            TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
            query.setParameter("useremail", useremail);
            userposts = query.getResultList();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return userposts;    
    }
    
    public static List<Bhpost> searchPosts (String search)
    {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<Bhpost> searchposts = null;
        String qString = "select b from Bhpost b "
                + "where b.posttext like :search";
        
        try{
            TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
            query.setParameter("search", "%" + search + "%");
            searchposts = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }
        return searchposts;
    }

	public static List<Bhpost> getAllPosts() {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<Bhpost> userposts = null;
        String qString = "select b from Bhpost b where b.parentid = -1";
        
        try{
            TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
            
            userposts = query.getResultList();
            
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return userposts;  
	}

	public static Bhpost getPost(long postId) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        String qString = "select b from Bhpost b where b.postid = :postId";
        
        Bhpost post = new Bhpost();
        try{
            TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
            query.setParameter("postId", postId);
            post = query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
		return post;
	}

	public static List<Bhpost> getComments(Bhpost p) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        String qString = "select b from Bhpost b where b.parentid = :pId";
        
        List<Bhpost> post = null;
        try{
            TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
            query.setParameter("pId", p.getPostid());
            post = query.getResultList();
        }catch (Exception e){
            return null;
        }
        finally{
                em.close();
            }
		return post;
	}

}

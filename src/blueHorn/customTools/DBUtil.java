package blueHorn.customTools;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlueHorn");
	
	public static EntityManagerFactory getEmfFactory() {
		return emf;
	}

	public static String getGrUrl(String hash) {
		return "https://www.gravatar.com/avatar/" + hash + "?s=";
	}

}

package blueHorn.models;

import java.io.Serializable;
import java.util.List;

public class BhpostComments implements Serializable{
	private static final long serialVersionUID = 1L;
	Bhpost mainPost;
	List<Bhpost> comments;
	public Bhpost getMainPost() {
		return mainPost;
	}
	public void setMainPost(Bhpost mainPost) {
		this.mainPost = mainPost;
	}
	public List<Bhpost> getComments() {
		return comments;
	}
	public void setComments(List<Bhpost> comments) {
		this.comments = comments;
	}
	

}

package socialmedia;

import java.util.ArrayList;

/**
 * Class of comments.
 */
public class Comments {
	
	private static ArrayList<Comment> commentList = new ArrayList<Comment>();
	
	public static ArrayList<Comment> getCommentList() {
        return commentList;
    }
	
	public static void setCommentList(ArrayList<Comment> list) {
		commentList = list;
	}

	/**
	 * Method that adds a comment to the list of comments.
	 * @param item - Comment
	 */
    public static void addComment(Comment item){
        commentList.add(item);
    }

	/**
	 * Method that selects a comment based on its id.
	 * @param id - Int
	 * @return Returns the Comment - comment.
	 */
	public static Comment getComment(int id) {
    	for(Comment comment: commentList) {
    		if(comment.getCommentId() == id) {
    			return comment;
    		}
    	}
    	return null;
    }

	/**
	 * Method that selects the id of a comment.
	 * @param id - Int
	 * @return Returns the int - id.
	 */
	public static int getCommentId(int id){
		for(Comment comment: commentList) {
			if(comment.getCommentId() == id) {
				return comment.getCommentId();
			}
		}
		return 0;
	}

	/**
	 * Method that computes the number of comments.
	 * @param originalId - Int
	 * @return Returns the int - number of comments.
	 */
	public static int getCommentCount(int originalId) {
		int numComments = 0;
		for(Comment comment: Comments.getCommentList()){
			if(comment.getOriginalPostId() == originalId){
				numComments++;
			}
		}
		return numComments;
	}

	/**
	 * Method that selects the comment based on the original id.
	 * @param originalId - Int
	 * @return Returns the Comment - comment.
	 */
	public static Comment getOriginalCommentID(int originalId) {
		for(Comment comment: commentList) {
			if(comment.getOriginalPostId() == originalId) {
				return comment;
			}
		}
		return null;
	}

	/**
	 * Method that clears the list of comments.
	 */
	public static void clearComments() {
		commentList.clear();
	}
}

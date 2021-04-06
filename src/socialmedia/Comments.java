package socialmedia;

import java.util.ArrayList;

public class Comments {
	
	private static ArrayList<Comment> commentList = new ArrayList<Comment>();
	
	public static ArrayList<Comment> getCommentList() {
        return commentList;
    }

    public static void addComment(Comment item){
        commentList.add(item);
    }
    
    public static Comment getComment(int id) {
    	for(Comment comment: commentList) {
    		if(comment.getOriginalPostId() == id) {
    			return comment;
    		}
    	}
    	return null; // If the comment wasn't found
    }

}

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
    		if(comment.getCommentId() == id) {
    			return comment;
    		}
    	}
    	return null; // If the comment wasn't found
    }

    public static int getCommentId(int id){
		for(Comment comment: commentList) {
			if(comment.getCommentId() == id) {
				return comment.getCommentId();
			}
		}
		return 0;
	}

	public static int getCommentCount(int originalId) {
		int numComments = 0;
		for(Comment comment: Comments.getCommentList()){
			if(comment.getOriginalPostId() == originalId){
				numComments++;
			}
		}
		return numComments;
	}

	public static Comment getOriginalCommentID(int originalId) {
		for(Comment comment: commentList) {
			if(comment.getOriginalPostId() == originalId) {
				return comment;
			}
		}
		return null; // If the comment wasn't found
	}
	
	public static void clearComments() {
		commentList.clear();
	}
}

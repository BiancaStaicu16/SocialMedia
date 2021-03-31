package socialmedia;

public class Comment extends Post {
    
	private int originalPostId;
	
	private int commentId;

    public Comment(String message, String stringHandle, int commentId) {
        super(message, stringHandle);
        this.commentId = commentId;
    }

    public int getCommentId() {
        return commentId;
    }
    
    public int getOriginalPostId() {
    	return originalPostId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
    
    public void setOriginalPostId(int id) {
    	originalPostId = id;
    }

    @Override
    public void setMessage(String message){
        super.setMessage(message);
    }
}

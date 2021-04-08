package socialmedia;

public class Comment extends Post {
    
	private int originalPostId;
	
	private int commentId;

    public Comment(String message, String stringHandle, int originalPostId) {
        super(message, stringHandle);
        this.originalPostId = originalPostId;
    }

   public int getCommentId(){
        return this.commentId;
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
    
    public String toString() {
    	
    	return "Original Post ID: " + originalPostId + " Comment ID: " + commentId;

    }
}

package socialmedia;

/**
 * Class of comment.
 */
public class Comment extends Post {
    
	private int originalPostId;
	
	private int commentId;

    /**
     * Constructor method.
     * @param message - String
     * @param stringHandle - String
     * @param originalPostId - Int
     */
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

    /**
     * Method that constructs a string.
     * @return Returns the string created.
     */
    public String toString() {
    	return "Original Post ID: " + originalPostId + " Comment ID: " + commentId;
    }
}
package socialmedia;

public class Post {

    private static int id = 0;

    private String message;

    private String stringHandle;

    private int postId = 0;

    public Post( String message, String stringHandle){
        this.message = message;
        this.stringHandle = stringHandle;
        this.postId = id;
        id++;
    }

    public String getStringHandle() {
    	return stringHandle;
    }
    
    public String getMessage() {
        return message;
    }

    public int getPostId() {
        return postId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}

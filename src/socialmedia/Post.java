package socialmedia;

import java.io.Serializable;

/**
 * Class of post.
 */
public class Post implements Serializable {

    private static int id = 0;

    private String message;

    private String stringHandle;

    private int postId = 0;

    /**
     * Constructor method.
     * @param message - String
     * @param stringHandle - String
     */
    public Post( String message, String stringHandle){
        this.message = message;
        this.stringHandle = stringHandle;
        id++;
        postId = id;
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
    
    public void setStringHandle(String handle) {
    	stringHandle = handle;
    }
}
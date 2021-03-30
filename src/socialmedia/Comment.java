package socialmedia;

public class Comment extends Post {
    private int postId;

    public Comment(String message, String stringHandle, int postId) {
        super(message, stringHandle);
        this.postId = postId;
    }

    @Override
    public int getPostId() {
        return postId;
    }

    @Override
    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setMessage(String message){
        super.setMessage(message);
    }
}

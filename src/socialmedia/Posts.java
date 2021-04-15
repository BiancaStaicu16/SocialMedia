package socialmedia;

import java.util.ArrayList;

/**
 * Class of posts.
 */
public class Posts {

    private static ArrayList<Post> postList = new ArrayList<Post>();

    public static ArrayList<Post> getPostList() {
        return postList;
    }
    
    public static void setPostList(ArrayList<Post> list) {
    	postList = list;
    }

    /**
     * Method that add a post to the post list.
     * @param item - Post
     */
    public static void addPost(Post item){
        postList.add(item);
    }

    /**
     * Method that selects a post based on a given id.
     * @param id - Int
     * @return Returns the Post - post.
     */
    public static Post getPost (int id) {
    	for(Post post: postList) {
    		if(post.getPostId() == id) {
    			return post;
    		}
    	}
    	return null;
    }

    /**
     * Method that computes the number of posts.
     * @param stringHandle - String
     * @return Returns the Int - number of posts.
     */
    public static int getPostCount(String stringHandle) {
    	int postCount = 0;
    	for(Post post: postList) {
    		if(post.getStringHandle().equals(stringHandle)) {
    			postCount++;
    		}
    	}
    	return postCount;
    }

    /**
     * Method that clear the post list.
     */
    public static void clearPosts() {
    	postList.clear();
    }
}
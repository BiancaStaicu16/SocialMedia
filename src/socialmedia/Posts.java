package socialmedia;

import java.util.ArrayList;

public class Posts {

    private static ArrayList<Post> postList = new ArrayList<Post>();

    public static ArrayList<Post> getPostList() {
        return postList;
    }

    public static void addPost(Post item){
        postList.add(item);
    }
    
    public static Post getPost (int id) {
    	for(Post post: postList) {
    		if(post.getPostId() == id) {
    			return post;
    		}
    	}
    	return null; // If the post hasn't been found
    }
    
    public static int getPostCount(String stringHandle) {
    	int postCount = 0;
    	for(Post post: postList) {
    		if(post.getStringHandle().equals(stringHandle)) {
    			postCount++;
    		}
    	}
    	
    	return postCount;
    }
    
    public static void clearPosts() {
    	postList.clear();
    }
}

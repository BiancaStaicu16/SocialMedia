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

}

package socialmedia;

public class Comments {
	
	private static Comment[] commentList;
	
	
	public static Comment[] getCommentList() {
        return commentList;
    }

    public static void addComment(Comment item){
        commentList[commentList.length + 1] = item;
    }

}

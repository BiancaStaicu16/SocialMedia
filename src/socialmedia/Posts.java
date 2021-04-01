package socialmedia;

public class Posts {

    private static Post[] postList;

    public static Post[] getPostList() {
        return postList;
    }

    public static void addPost(Post item){
        postList[postList.length + 1] = item;
    }

    public static void setPostList(Post[] postList) {
        Posts.postList = postList;
    }
}

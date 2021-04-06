import socialmedia.*;

/**
 * A short program to illustrate an app testing some minimal functionality of a
 * concrete implementation of the SocialMediaPlatform interface -- note you will
 * want to increase these checks, and run it on your SocialMedia class (not the
 * BadSocialMedia class).
 *
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class SocialMediaPlatformTestApp {

	/**
	 * Test method.
	 * 
	 * @param args not used
	 * @throws IllegalHandleException 
	 * @throws HandleNotRecognisedException
	 * @throws NotActionablePostException 
	 */
	public static void main(String[] args) throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException, InvalidPostException, PostIDNotRecognisedException, NotActionablePostException {
		System.out.println("The system compiled and started the execution...");


		SocialMediaPlatform platform = new SocialMedia();

		assert (platform.getNumberOfAccounts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalOriginalPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalCommentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalEndorsmentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";

		Integer id;
		try {
			id = platform.createAccount("my_handle");
			assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";

			int newPost = platform.createPost("my_handle", "Hello");
			
			int newEndorsement = platform.endorsePost("my_handle", newPost);
			int newComment = platform.commentPost("my_handle", newPost, "Bye");
			System.out.println(platform.showPostChildrenDetails(newPost));
			
			platform.removeAccount(id);
			assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";

		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
		 } catch (AccountIDNotRecognisedException e) {
			 assert (false) : "AccountIDNotRecognizedException thrown incorrectly";
		} catch (InvalidHandleException e) {
			e.printStackTrace();
		}
	}

}

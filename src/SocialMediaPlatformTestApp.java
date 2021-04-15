import java.io.IOException;

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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException, InvalidPostException, PostIDNotRecognisedException, NotActionablePostException, IOException, ClassNotFoundException {

		System.out.println("The system compiled and started the execution...");

		SocialMediaPlatform platform = new SocialMedia();

		assert (platform.getNumberOfAccounts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalOriginalPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalCommentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalEndorsmentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";

		Integer id;
		Integer id1;
		Integer id2;
		Integer id3;
		Integer id_of_post;
		try {

			// Creating a few accounts.

			id = platform.createAccount("my_handle");
			id1 = platform.createAccount("my_other_account", " my_description");
			id2 = platform.createAccount("my_handle1");
			id3 = platform.createAccount("my_other_account1", " my_description1");

			assert (platform.getNumberOfAccounts() == 4) : "number of accounts registered in the system does not match";

			platform.removeAccount("my_handle1");
			platform.removeAccount(id3);

			assert (platform.getNumberOfAccounts() == 2): "number of accounts registered in the system does not match";

			// Creating a few posts.

			id_of_post = platform.createPost("my_handle", "a_message");

			assert (platform.getTotalOriginalPosts() == 1) : "Innitial SocialMediaPlatform not empty as required.";

			platform.commentPost("my_handle",id_of_post, "another_message");

			assert (platform.getTotalCommentPosts() == 1) : "Innitial SocialMediaPlatform not empty as required.";

			platform.endorsePost("my_handle", id_of_post);

			assert (platform.getTotalEndorsmentPosts() == 1) : "Innitial SocialMediaPlatform not empty as required.";

		} catch (IllegalHandleException | AccountIDNotRecognisedException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
		 } catch (InvalidHandleException e) {
			e.printStackTrace();
		}
	}
}
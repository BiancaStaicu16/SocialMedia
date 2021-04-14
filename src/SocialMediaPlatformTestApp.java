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
	 * @throws AccountIDNotRecognisedException 
	 */
	public static void main(String[] args) throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException, InvalidPostException, PostIDNotRecognisedException, NotActionablePostException, IOException, ClassNotFoundException, AccountIDNotRecognisedException {
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
		try {
			id = platform.createAccount("my_handle");
			id1 = platform.createAccount("this_handle", "This is my account");
			id2 = platform.createAccount("delete_this_account", "This account will be deleted");
			id3 = platform.createAccount("also_delete_this");

			assert (platform.getNumberOfAccounts() == 4) : "Number of accounts registered in the system does not match";
			
			platform.removeAccount(id2);
			
			assert (platform.getNumberOfAccounts() == 3) : "Number of accounts registered in the system does not match";
			
			platform.removeAccount("also_delete_this");
			
			assert (platform.getNumberOfAccounts() == 2) : "Number of accounts registered in the system does not match";
			
			
			System.out.println(platform.showAccount("this_handle"));
			platform.changeAccountHandle("this_handle", "new_handle");
			System.out.println(platform.showAccount("new_handle"));



		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
//		 } catch (AccountIDNotRecognisedException e) {
//			 assert (false) : "AccountIDNotRecognizedException thrown incorrectly";
//		} catch (InvalidHandleException e) {
			e.printStackTrace();
		}
	}
}

package socialmedia;

import java.io.IOException;
import java.util.Arrays;

/**
 * BadSocialMedia is a minimally compiling, but non-functioning implementor of
 * the SocialMediaPlatform interface.
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class SocialMedia implements SocialMediaPlatform {

	@Override
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException {
		// If the handle is invalid, throw the exception
		if (handle == null) {
			assert false;
			if (handle.length() >= 30 && !handle.contains(" ")) {
				throw new InvalidHandleException("Your string handle is invalid.");
			}
		}

		// If the handle already exists, throw an exception
		for (Account account : Accounts.getAccountsList()) {
			if (account.getStringHandle().equals(handle)) {
				throw new IllegalHandleException("An account with this string handle already exists.");
			}
		}

		Account firstAccount = new Account(handle);
		Accounts.addAccount(firstAccount);
		return firstAccount.getNumId();
	}

	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		// If the handle is invalid, throw the exception
		if (handle == null) {
			assert false;
			if (handle.length() >= 30 && !handle.contains(" ")) {
				throw new InvalidHandleException("Your string handle is invalid.");
			}
		}

		// If the handle already exists, throw an exception
		for (Account account : Accounts.getAccountsList()) {
			if (account.getStringHandle().equals(handle)) {
				throw new IllegalHandleException("An account with this string handle already exists.");
			}
		}

		Account firstAccount = new Account(handle,description);
		Accounts.addAccount(firstAccount);
		System.out.println(Arrays.toString(Accounts.getAccountsList()));
		return firstAccount.getNumId();
	}

	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
		System.out.println(Accounts.getAccountsList().length);
		boolean accountFound = false;
		// Looping until the index variable reaches the length of the accounts list
		System.out.println(Accounts.getAccountsList().length);
		if(Accounts.getAccountsList().length > 0){
			for(int index = 0; index < Accounts.getAccountsList().length; index++) {
				// Getting the numerical ID of each account and comparing it to the id that has been passed in
				if (Accounts.getAccountsList()[index].getNumId() == id) {
					// If the id has been found, it will be removed from the list of accounts
					Accounts.removeAccount(index);
					accountFound = true;
					break;
				}
			}
		}
		// If there is no matching ID
		if (!accountFound){
			throw new AccountIDNotRecognisedException("The account ID entered wasn't found.");
		}

	}

	@Override
	public void removeAccount(String handle) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		Accounts.changeAccountHandle(oldHandle, newHandle);

	}

	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub

	}

	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
		String showAnAccount = "";
		// Iterating through the list of accounts to see if an account with a corresponding handle exists, if so its details are displayed.
		for(Account account: Accounts.getAccountsList()){
			if(account.getStringHandle().equals(handle)){
				showAnAccount = "ID: " + account.getNumId() + "\n" + "Handle: " + account.getStringHandle() + "\n"
						+ "Description: " + account.getDescription() + "\n" + "Post count: " + "\n" + " Endorse count: " + "\n";
				return showAnAccount;
			}
		}
		throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
	}

	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		// Throwing exceptions for and invalid message
		if(message.isEmpty()) {
			throw new InvalidPostException("You entered an empty message.");
		}

		if(message.length() > 100) {
			throw new InvalidPostException("The message you entered was too long.");
		}

		// Looping through each account from the accounts list and comparing their handles to the handle passed in
		for(Account account: Accounts.getAccountsList()){
			if(account.getStringHandle().equals(handle)){
				// If an account with a corresponding handle is found, a post is created and added to the list of posts
				Post firstPost = new Post(message, handle);
				Posts.addPost(firstPost);
				return firstPost.getPostId();
			}
		}
		throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
	}

	@Override
	public int endorsePost(String handle, int id)
			throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		// Looping through each post from the posts list and checking some requirements for the post to be endorsed.
		for (Post post: Posts.getPostList()) {
			if(post.getPostId() == id && post.getStringHandle().equals(handle) && !post.getMessage().contains("EP@")) {
				String endorsedMessage = "EP@" + post.getStringHandle() + ": " + post.getMessage();
				Endorsement firstEndorsement = new Endorsement(endorsedMessage, handle, id);
				int initialPostId = firstEndorsement.getPostId();
				firstEndorsement.setEndorsementId(initialPostId);
				Endorsements.addEndorsement(firstEndorsement);
				return firstEndorsement.getPostId();
			}

			// Throwing exceptions for invalid requirements.
			else if(post.getPostId() != id ) {
				throw new PostIDNotRecognisedException("The post ID entered has not been found.");
			}
			else if(!post.getStringHandle().equals(handle) ) {
				throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
			}
			else if(post.getMessage().contains("EP@")) {
				throw new NotActionablePostException("This post cannot be endorsed.");
			}
		}
		return 0;
	}

	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		// Looping through each post from the posts list and checking some requirements for the post to be commented on.
		for (Post post: Posts.getPostList()) {
			if(post.getPostId() == id && post.getStringHandle().equals(handle) && message.length() <= 100 &&
					!message.isEmpty() && !post.getMessage().contains("EP@")){

				Comment firstComment = new Comment(message,handle, id);
				int initialPostId = firstComment.getPostId();
				firstComment.setCommentId(initialPostId);
				Comments.addComment(firstComment);
				return firstComment.getPostId();
			}

			// Throwing exceptions for invalid requirements.
			else if(post.getPostId() != id){
				throw new PostIDNotRecognisedException("The post ID entered has not been found.");
			}
			else if(!post.getStringHandle().equals(handle) ) {
				throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
			}
			else if(post.getMessage().contains("EP@")) {
				throw new NotActionablePostException("This post cannot be endorsed.");
			}
			else if(message.isEmpty()) {
				throw new InvalidPostException("You entered an empty message.");
			}
			else if(message.length() > 100) {
				throw new InvalidPostException("The message you entered was too long.");
			}
		}
		return 0;
	}

	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		boolean postFound = false;
		int index = 0;
		Post[] postList = Posts.getPostList();
		while(index < postList.length && !postFound) {
			if(postList[index].getPostId() == id) {
				postList[index].setMessage("The original content was removed from the system and is no longer available.");
				postList[index].setStringHandle(null); // No longer linked to an account
				postList[index].setPostId(000); // Post id changed so that the post can't be accessed using the post id
				postFound = true;
			}
			index++;
		}

		if(!postFound) {
			throw new PostIDNotRecognisedException("The post ID entered has not been recognised.");
		}

		else {
			// Removing any associated endorsements
			for (Endorsement endorsement: Endorsements.getEndorsementList()) {
				if(endorsement.getOriginalPostId() == id) {
					endorsement.setMessage("The original content was removed from the system and is no longer available.");
					endorsement.setStringHandle(null);
					endorsement.setPostId(000);
				}
			}

			// Removing any associated comments
			for (Comment comment: Comments.getCommentList()) {
				if(comment.getOriginalPostId() == id) {
					comment.setMessage("The original content was removed from the system and is no longer available.");
					comment.setStringHandle(null);
					comment.setOriginalPostId(000);
				}
			}
		}
	}

	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		boolean postFound = false;
		int index = 0;
		Post[] postList = Posts.getPostList();
		while(index < postList.length && !postFound) {
			if(postList[index].getPostId() == id) {
				postFound = true;
			}
			index++;
		}

		if(!postFound) {
			throw new PostIDNotRecognisedException("The post ID entered has not been recognised.");
		}
		// If the post was found
		else {
			// Finding the number of endorsed posted specific to the required post
			int numEndorsedPosts = 0;
			for(int num = 0; num < Endorsements.getEndorsementList().length; num++) {
				if(Endorsements.getEndorsementList()[num].getOriginalPostId() == id) {
					numEndorsedPosts++;
				}
			}

			// Finding the number of comments under the post
			int numComments = 0;
			for(int count = 0; count < Comments.getCommentList().length; count++) {
				if(Comments.getCommentList()[count].getOriginalPostId() == id) {
					numComments++;
				}
			}
			Post postToShow = Posts.getPostList()[index];
			// Formatting the string of post details
			String postDetails = "ID: " + postToShow.getPostId() + "/nAccount: " + postToShow.getStringHandle() +
					"/nNo. endorsements: " + numEndorsedPosts + "| No. comments: " + numComments + postToShow.getMessage();
			return postDetails;

		}
	}

	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {
		StringBuilder showDetailsStringBuilder = new StringBuilder();

		boolean postFound = false;
		int index = 0;
		Post[] postList = Posts.getPostList();

		// Looping through each post from the posts list and checking some requirements for that post to be displayed.
		while(index < postList.length) {
			if(postList[index].getPostId() == id) {
				postFound = true;
				String showDetails = showIndividualPost(id);
				showDetailsStringBuilder.append(showDetails);
				return showDetailsStringBuilder;
			}
			index++;
		}

		// If the post has not been found.
		if(postFound){
			throw new PostIDNotRecognisedException("The post ID entered has not been recognised.");
		}

		boolean endorsementFound = false;

		// Looping through the list of endorsements checking some requirements.
		for(Endorsement endorsement: Endorsements.getEndorsementList()){
			if(endorsement.getOriginalPostId() == id){
				endorsementFound = true;
				break;
			}
		}

		// If an endorsement has not been found.
		if(endorsementFound = true) {
			throw new NotActionablePostException(" Endorsement posts do not have children since they are not endorsable nor commented.");
		}

		int newId = id;
		int position = 0;
		Comment[] commentList = Comments.getCommentList();

		// Looping through the list of comments checking some requirements.
		while (position < commentList.length) {
			if (commentList[position].getOriginalPostId() == newId) {
				newId = commentList[position].getCommentId();
				showDetailsStringBuilder.append("|/n| > ");
				String showDetails = showIndividualPost(id);
				showDetailsStringBuilder.append(showDetails);
				position = 0;
			}
			position++;
		}
		return showDetailsStringBuilder;
	}

	@Override
	public int getNumberOfAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalOriginalPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalEndorsmentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCommentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedPost() {
		// Function that gets the most endorsed post.
		int maximumValue = -100000;
		int idOfMostEndorsedPost = 0;

		// Looping through the list of posts and the list of endorsements, finding the most endorsed post.
		for(Post post: Posts.getPostList()){
			int count = 0;
			int id = 0;
			for(Endorsement endorsement: Endorsements.getEndorsementList()){
				if(post.getPostId() == endorsement.getOriginalPostId()){
					count++;
					id = post.getPostId();
				}
			}
			if(count > maximumValue){
				idOfMostEndorsedPost = id;
			}
		}
		return idOfMostEndorsedPost;
	}

	@Override
	public int getMostEndorsedAccount() {
		// Function that gets the most endorsed account.
		int maximumValue = -100000;
		int idOfMostEndorsedAccount = 0;

		// Looping through the list of posts and the list of endorsements, finding the most endorsed account.
		for(Post post: Posts.getPostList()){
			int count = 0;
			int id = 0;
			for(Endorsement endorsement: Endorsements.getEndorsementList()){
				if(post.getStringHandle().equals(endorsement.getStringHandle())){
					count++;
				}
			}

			String newStringHandle = post.getStringHandle();

			// Checking requirements for most endorsed account.
			for(Account account: Accounts.getAccountsList()){
				if(newStringHandle.equals(account.getStringHandle()))
					id = account.getNumId();
			}

			if(count > maximumValue){
				idOfMostEndorsedAccount = id;
			}
		}
		return idOfMostEndorsedAccount;
	}

	@Override
	public void erasePlatform() {
		// TODO Auto-generated method stub

	}

	@Override
	public void savePlatform(String filename) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

}
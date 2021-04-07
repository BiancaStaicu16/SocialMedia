package socialmedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

		if(!Accounts.getAccountsList().isEmpty()) {
			for (Account account : Accounts.getAccountsList()) {
				if (account.getStringHandle().equals(handle)) {
					throw new IllegalHandleException("An account with this string handle already exists.");
				}
			}
		}
		// If the handle already exists, throw an exception
		int index = 0;
		Account firstAccount = new Account(handle);
		Accounts.addAccount(firstAccount, index);
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

		if(!Accounts.getAccountsList().isEmpty()) {
			for (Account account : Accounts.getAccountsList()) {
				if (account.getStringHandle().equals(handle)) {
					throw new IllegalHandleException("An account with this string handle already exists.");
				}
			}
		}
		// If the handle already exists, throw an exception
		int index = 0;
		Account firstAccount = new Account(handle, description);
		Accounts.addAccount(firstAccount, index);
		return firstAccount.getNumId();
	}

	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
		boolean accountFound = false;
		// Looping until the index variable reaches the length of the accounts list
		if(Accounts.getAccountsList().size() > 0){
			for(int index = 0; index < Accounts.getAccountsList().size(); index++) {
				// Getting the numerical ID of each account and comparing it to the id that has been passed in
				if (Accounts.getAccountsList().get(index).getNumId() == id) {
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
		boolean accountFound = false;
		// Looping until the index variable reaches the length of the accounts list
		if(Accounts.getAccountsList().size() > 0){
			for(int index = 0; index < Accounts.getAccountsList().size(); index++) {
				// Getting the numerical ID of each account and comparing it to the id that has been passed in
				if (Accounts.getAccountsList().get(index).getStringHandle().equals(handle)) {
					// If the id has been found, it will be removed from the list of accounts
					Accounts.removeAccount(index);
					accountFound = true;
					break;
				}
			}
		}
		// If there is no matching ID
		if (!accountFound){
			throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
		}
	}

	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		
		if (oldHandle == null) {
			assert false;
			if (oldHandle.length() >= 30 && ! oldHandle.contains(" ")) {
				throw new InvalidHandleException("Your string handle is invalid.");
			}
		}
		
		boolean accountFound = false;
		if(!Accounts.getAccountsList().isEmpty()) {
			for (Account account : Accounts.getAccountsList()) {
				if (account.getStringHandle().equals(oldHandle)) {
					accountFound = true;
					throw new IllegalHandleException("An account with this string handle already exists.");
				}
			}
		}
		
		if(accountFound)
			throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
		
		Accounts.changeAccountHandle(oldHandle, newHandle);

	}

	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		boolean accountFound = false;
		if(!Accounts.getAccountsList().isEmpty()) {
			for (Account account : Accounts.getAccountsList()) {
				if(account.getStringHandle().equals(handle)) {
					accountFound = true;
					account.setDescription(description);
				}
			}
		}
		
		if(accountFound) {
			throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
		}
	}

	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
		String showAnAccount = "";
		// Iterating through the list of accounts to see if an account with a corresponding handle exists, if so its details are displayed.
		for(Account account: Accounts.getAccountsList()){
			if(account.getStringHandle().equals(handle)){
				showAnAccount = "ID: " + account.getNumId() + "\n" + "Handle: " + account.getStringHandle() + "\n"
						+ "Description: " + account.getDescription() + "\n" + "Post count: " + Posts.getPostCount(handle) + "\n" + 
						"Endorse count: " + Endorsements.getEndorsementCount(handle) + "\n";
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
		// Looping through each post from the posts list and checking some requirements for the post to be endorsed.\

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
		ArrayList<Post> postList = Posts.getPostList();
		while(index < postList.size() && !postFound) {
			if(postList.get(index).getPostId() == id) {
				postList.get(index).setMessage("The original content was removed from the system and is no longer available.");
				postList.get(index).setStringHandle(null); // No longer linked to an account
				postList.get(index).setPostId(000); // Post id changed so that the post can't be accessed using the post id
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



		if(Posts.getPost(id) == null) {
			throw new PostIDNotRecognisedException("The post ID entered has not been recognised.");
		}


		else {
			// If any comments exist for the post
			if(Comments.getOriginalCommentID(id) != null) {
				Comment postsComment = Comments.getOriginalCommentID(id);
				int postID = postsComment.getPostId();
				int endorsementNum = Endorsements.getEndorsementCount(postID); // Gets endorsement count of the comment
				int commentNum = Comments.getCommentCount(postID); // Gets endorsement count of the comment
				System.out.println(endorsementNum + " " + commentNum);
			}

			int numEndorsedPosts = Endorsements.getEndorsementCount(id);
			int numComments = Comments.getCommentCount(id);

			Post postToShow = Posts.getPost(id);
			String postDetails = "ID: " +postToShow.getPostId() + "\nAccount: " + postToShow.getStringHandle() +
					"\nNo. endorsements: " + numEndorsedPosts + " | No. comments: " + numComments + "\n" + postToShow.getMessage();
			return postDetails;

		}
	}

	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {
		StringBuilder showDetailsStringBuilder = new StringBuilder();



		String showDetails = showIndividualPost(id);
		showDetailsStringBuilder.append(showDetails);
		Comment thisComment = Comments.getOriginalCommentID(id);
		if(thisComment == null)
			throw new PostIDNotRecognisedException("The post ID entered has not been recognised.");
		String showDetailsOfComment = showIndividualPost(thisComment.getOriginalPostId());
		showDetailsStringBuilder.append(showDetailsOfComment);



		return showDetailsStringBuilder;
	}


	@Override
	public int getNumberOfAccounts() {
		return Accounts.getNumberOfAccounts();
	}

	@Override
	public int getTotalOriginalPosts() {
		return Posts.getPostList().size();
	}

	@Override
	public int getTotalEndorsmentPosts() {
		return Endorsements.getEndorsementList().size();
	}

	@Override
	public int getTotalCommentPosts() {
		return Comments.getCommentList().size();
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

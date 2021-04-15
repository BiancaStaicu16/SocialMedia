package socialmedia;

import java.io.*;

import java.util.ArrayList;

/**
 * BadSocialMedia is a minimally compiling, but non-functioning implementor of
 * the SocialMediaPlatform interface.
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class SocialMedia implements SocialMediaPlatform {

	/**
	 * Method that creates an account.
	 * @param handle - String
	 * @return Returns the id of the account created.
	 * @throws IllegalHandleException - Account with the same string handle already exists
	 * @throws InvalidHandleException - Invalid string handle
	 */
	@Override
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException {

		// If the handle is invalid, throw the exception.

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

		// If the handle already exists, throw an exception.

		int index = 0;
		Account firstAccount = new Account(handle);
		Accounts.addAccount(firstAccount);
		return firstAccount.getNumId();
	}

	/**
	 * Method that creates an account.
	 * @param handle - String
	 * @param description - String
	 * @return Returns the id of the account created.
	 * @throws IllegalHandleException - Account with the same string handle already exists
	 * @throws InvalidHandleException - Invalid string handle
	 */
	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {

		// If the handle is invalid, throw the exception.

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

		// If the handle already exists, throw an exception.

		int index = 0;
		Account firstAccount = new Account(handle, description);
		Accounts.addAccount(firstAccount);
		return firstAccount.getNumId();
	}

	/**
	 * Method that removes an account.
	 * @param id - Int
	 * @throws AccountIDNotRecognisedException - The id of the account hasn't been recognised
	 */
	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
		boolean accountFound = false;

		// Looping until the index variable reaches the length of the accounts list.

		if(Accounts.getAccountsList().size() > 0){
			for(int index = 0; index < Accounts.getAccountsList().size(); index++) {

				// Getting the numerical ID of each account and comparing it to the id that has been passed in.

				if (Accounts.getAccountsList().get(index).getNumId() == id) {

					// If the id has been found, it will be removed from the list of accounts.

					Accounts.removeAccount(index);
					accountFound = true;
					break;
				}
			}
		}

		// If there is no matching id.

		if (!accountFound){
			throw new AccountIDNotRecognisedException("The account ID entered wasn't found.");
		}
	}

	/**
	 * Method that removes an account.
	 * @param handle - String
	 * @throws HandleNotRecognisedException - The handle hasn't been recognised
	 */
	@Override
	public void removeAccount(String handle) throws HandleNotRecognisedException {
		boolean accountFound = false;

		// Looping until the index variable reaches the length of the accounts list.

		if(Accounts.getAccountsList().size() > 0){
			for(int index = 0; index < Accounts.getAccountsList().size(); index++) {

				// Getting the numerical ID of each account and comparing it to the id that has been passed in.

				if (Accounts.getAccountsList().get(index).getStringHandle().equals(handle)) {

					// If the id has been found, it will be removed from the list of accounts.

					Accounts.removeAccount(index);
					accountFound = true;
					break;
				}
			}
		}

		// If there is no matching id.

		if (!accountFound){
			throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
		}
	}

	/**
	 * Method that replaces the account handle with a new one.
	 * @param oldHandle - String
	 * @param newHandle - String
	 * @throws HandleNotRecognisedException - The handle hasn't been recognised
	 * @throws IllegalHandleException - Account with the same string handle already exists
	 * @throws InvalidHandleException - Invalid string handle
	 */
	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {

		// Requirements for throwing the invalid string handle exception.

		if (oldHandle == null) {
			assert false;
			if (oldHandle.length() >= 30 && ! oldHandle.contains(" ")) {
				throw new InvalidHandleException("Your string handle is invalid.");
			}
		}

		if(!Accounts.getAccountsList().isEmpty()) {
			for (Account account : Accounts.getAccountsList()) {
				if (account.getStringHandle().equals(oldHandle)) {
					throw new IllegalHandleException("An account with this string handle already exists.");
				}
			}
		}

		// Requirements for throwing the handle hasn't been recognised exception.

		for(Account account: Accounts.getAccountsList()) {
			if(!account.getStringHandle().equals(oldHandle))
			throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
		}

		// Changing the account handle.

		Accounts.changeAccountHandle(oldHandle, newHandle);
	}

	/**
	 * Method that updates the description of an account.
	 * @param handle - String
	 * @param description - String
	 * @throws HandleNotRecognisedException - The handle hasn't been recognised
	 */
	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {

		boolean accountFound = false;

		// Requirements for the description of the account to be changed.

		if(!Accounts.getAccountsList().isEmpty()) {
			for (Account account : Accounts.getAccountsList()) {
				if(account.getStringHandle().equals(handle)) {
					accountFound = true;
					account.setDescription(description);
				}
			}
		}

		// Requirements for throwing the handle hasn't been recognised exception.

		if(accountFound) {
			throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
		}
	}

	/**
	 * Method that shows the details of an account.
	 * @param handle - String
	 * @return Returns the String - show an account.
	 * @throws HandleNotRecognisedException - The handle hasn't been recognised
	 */
	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {

		String showAnAccount;

		// Iterating through the list of accounts to see if an account with a corresponding handle exists.
		// If so, its details are displayed.

		for(Account account: Accounts.getAccountsList()){
			if(account.getStringHandle().equals(handle)){
				showAnAccount = "ID: " + account.getNumId() + "\n" + "Handle: " + account.getStringHandle() + "\n"
						+ "Description: " + account.getDescription() + "\n" + "Post count: " + Posts.getPostCount(handle) + "\n" + 
						"Endorse count: " + Endorsements.getEndorsementCount(handle) + "\n";
				return showAnAccount;
			}
		}

		// If not, throw exception.

		throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
	}

	/**
	 * Method that creates a post.
	 * @param handle - String
	 * @param message - String
	 * @return Returns the int - id of the created post.
	 * @throws HandleNotRecognisedException - The handle hasn't been recognised
	 * @throws InvalidPostException - Invalid string handle
	 */
	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {

		// Throwing exceptions for an invalid message.

		if(message.isEmpty()) {
			throw new InvalidPostException("You entered an empty message.");
		}

		if(message.length() > 100) {
			throw new InvalidPostException("The message you entered was too long.");
		}

		// Looping through each account from the accounts list and comparing their handles to the handle passed in.

		for(Account account: Accounts.getAccountsList()){
			if(account.getStringHandle().equals(handle)){

				// If an account with a corresponding handle is found, a post is created and added to the list of posts.

				Post firstPost = new Post(message, handle);
				Posts.addPost(firstPost);
				return firstPost.getPostId();
			}
		}

		// Throwing exception for handle hasn't been recognised case.

		throw new HandleNotRecognisedException("The handle that you have entered has not been recognised.");
	}

	/**
	 * Method that is going to endorse a post.
	 * @param handle - String
	 * @param id - Int
	 * @return Returns the id of the endorsed post.
	 * @throws HandleNotRecognisedException - The handle hasn't been recognised
	 * @throws PostIDNotRecognisedException - The id hasn't been found
	 * @throws NotActionablePostException - The post cannot be endorsed
	 */
	@Override
	public int endorsePost(String handle, int id)
			throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {

		// Looping through each post from the posts list and checking requirements for the post to be endorsed.

		for (Post post: Posts.getPostList()) {
			if(post.getPostId() == id && post.getStringHandle().equals(handle) && !post.getMessage().contains("EP@")) {
				String endorsedMessage = "EP@" + post.getStringHandle() + ": " + post.getMessage();
				Endorsement firstEndorsement = new Endorsement(endorsedMessage, handle, id);
				int initialPostId = firstEndorsement.getPostId();
				firstEndorsement.setEndorsementId(initialPostId);
				Endorsements.addEndorsement(firstEndorsement);
				return firstEndorsement.getPostId();
		}

		post = Posts.getPost(id);

		// Throwing exceptions for invalid requirements.

		assert post != null;
		if(post.getPostId() != id ) {
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

	/**
	 * Method that creates a comment.
	 * @param handle - String
	 * @param id - Int
	 * @param message - String
	 * @return Returns the id of the created comment.
	 * @throws HandleNotRecognisedException - The handle hasn't been recognised
	 * @throws PostIDNotRecognisedException - The id hasn't been found
	 * @throws NotActionablePostException - The post cannot be endorsed
	 * @throws InvalidPostException - The message entered is empty
	 */
	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {

		// Looping through each post from the posts list and checking requirements for the post to be commented on.

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

	/**
	 * Method that deletes a post.
	 * @param id - Int
	 * @throws PostIDNotRecognisedException - The id hasn't been found
	 */
	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		boolean postFound = false;
		int index = 0;

		ArrayList<Post> postList = Posts.getPostList();

		while(index < postList.size() && !postFound) {
			if(postList.get(index).getPostId() == id) {
				postList.get(index).setMessage("The original content was removed from the system and is no longer available.");

				// No longer linked to an account.

				postList.get(index).setStringHandle(null);

				// Post id changed so that the post can't be accessed using the post id.

				postList.get(index).setPostId(000);
				postFound = true;
			}
			index++;
		}

		if(!postFound) {
			throw new PostIDNotRecognisedException("The post ID entered has not been recognised.");
		}
		else {

			// Removing any associated endorsements.

			for (Endorsement endorsement: Endorsements.getEndorsementList()) {
				if(endorsement.getOriginalPostId() == id) {
					endorsement.setMessage("The original content was removed from the system and is no longer available.");
					endorsement.setStringHandle(null);
					endorsement.setPostId(000);
				}
			}

			// Removing any associated comments.

			for (Comment comment: Comments.getCommentList()) {
				if(comment.getOriginalPostId() == id) {
					comment.setMessage("The original content was removed from the system and is no longer available.");
					comment.setStringHandle(null);
					comment.setOriginalPostId(000);
				}
			}
		}
	}

	/**
	 * Method that shows the details of a post.
	 * @param id - Int
	 * @return Returns the String - details of a post.
	 * @throws PostIDNotRecognisedException - The id hasn't been found
	 */
	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {

		// If the id matches to a post.

		if(Posts.getPost(id) != null){
			int numEndorsedPosts = Endorsements.getEndorsementCount(id);
			int numComments = Comments.getCommentCount(id);
			Post postToShow = Posts.getPost(id);

			// Creating the details of the post.

			assert postToShow != null;
			return  "ID: " +postToShow.getPostId() + "\nAccount: " + postToShow.getStringHandle() +
					"\nNo. endorsements: " + numEndorsedPosts + " | No. comments: " + numComments + "\n" + postToShow.getMessage();
		}

		// If the id matches to a comment.

		else if(Comments.getCommentId(id) != 0) {
			int endorsementNum = Endorsements.getEndorsementCount(id); // Gets endorsement count of the comment
			int commentNum = Comments.getCommentCount(id);

			Comment comment = Comments.getComment(id);

			// Creating the details of the comment.

			assert comment != null;
			return  "ID: " + id + "\nAccount: " + comment.getStringHandle() +
					"\nNo. endorsements: " + endorsementNum + " | No. comments: " + commentNum + "\n" + comment.getMessage();
		}

		// If the id hasn't been recognised.

		if(Posts.getPost(id) == null) {
			throw new PostIDNotRecognisedException("The post ID entered has not been recognised.");
		}
		return null;
	}

	/**
	 * Method that will show the children of a post.
	 * @param id - Int
	 * @return Returns the StringBuilder - details created for that post.
	 * @throws PostIDNotRecognisedException - The id hasn't been found
	 * @throws NotActionablePostException - The post cannot be endorsed
	 */
	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {

		for(Endorsement endorsement: Endorsements.getEndorsementList()){
			if(endorsement.getPostId() == id){
				throw new NotActionablePostException("The post cannot be endorsed");
			}
		}

		StringBuilder showDetailsStringBuilder = new StringBuilder();
		String showDetails = showIndividualPost(id);
		showDetailsStringBuilder.append(showDetails);
		Comment thisComment = Comments.getOriginalCommentID(id);

		if(thisComment == null)
			throw new PostIDNotRecognisedException("The post ID entered has not been recognised.");

		String pipeFormatting = """

				|
				| >\s""";
		boolean commentExist = true;
		int countIndentation = 0;

		while (commentExist){
			countIndentation++;
			String tabs = "\t";
			String totalIndentations = tabs.repeat(countIndentation);

			showDetailsStringBuilder.append(pipeFormatting);
			int currentCommentId = thisComment.getCommentId();
			String showDetailsOfComment = showIndividualPost(currentCommentId);
			StringBuilder newShowDetailsOfComment = new StringBuilder();
			for (int i = 0; i < showDetailsOfComment.length(); i++){
				char c = showDetailsOfComment.charAt(i);
				newShowDetailsOfComment.append(showDetailsOfComment.charAt(i));

				if(c == '\n'){
					newShowDetailsOfComment.append(totalIndentations);
				}
			}

			showDetailsStringBuilder.append(newShowDetailsOfComment);

			if(Comments.getOriginalCommentID(currentCommentId) == null){
				commentExist = false;
			}
		}
		return showDetailsStringBuilder;
	}

	/**
	 * Method that computes the number of accounts.
	 * @return Returns the int - number of accounts.
	 */
	@Override
	public int getNumberOfAccounts() {

		// Returns the number of account in the accounts list

		return Accounts.getNumberOfAccounts();
	}

	/**
	 * Method that computes the number of posts.
	 * @return Returns the int - number of posts.
	 */
	@Override
	public int getTotalOriginalPosts() {

		// Returns the number of posts in the posts list

		return Posts.getPostList().size();
	}

	/**
	 * Method that computes the number of endorsements.
	 * @return Returns the int - number of endorsements.
	 */
	@Override
	public int getTotalEndorsmentPosts() {

		// Returns the number of endorsements in the endorsements list

		return Endorsements.getEndorsementList().size();
	}

	/**
	 * Method that computes the number of comments.
	 * @return Returns the int - number of comments.
	 */
	@Override
	public int getTotalCommentPosts() {

		// Returns the number of comments from the comments list

	return Comments.getCommentList().size();
	}

	/**
	 * Method that identifies the most endorsed post.
	 * @return Returns the int - id of the most endorsed post.
	 */
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

	/**
	 * Method that identifies the most endorsed account.
	 * @return Returns the int - id of the most endorsed account.
	 */
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

	/**
	 * Method that will erase the platform.
	 */
	@Override
	public void erasePlatform() {

		// All array lists (endorsements, posts, comments and account) are emptied.

		Endorsements.clearEndorsements();
		Posts.clearPosts();
		Comments.clearComments();
		Accounts.clearAccounts();
	}

	/**
	 * Method that will save the created platform.
	 * @param filename - String
	 * @throws IOException - Problem experienced when trying to save the store contents to the file
	 */
	@Override
	public void savePlatform(String filename) throws IOException {


		// All array lists (endorsements, posts, comments and account) are saved.

		ArrayList<Endorsement> endorsementList = Endorsements.getEndorsementList();
		ArrayList<Comment> commentList = Comments.getCommentList();
		ArrayList<Post> postList = Posts.getPostList();
		ArrayList<Account> accountList = Accounts.getAccountsList();
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(endorsementList);
			out.writeObject(commentList);
			out.writeObject(postList);
			out.writeObject(accountList);
		} catch (IOException exc) {
			throw new IOException("Problem experienced when trying to save the store contents to the file");
		}
	}

	/**
	 * Method that will load the saved platform.
	 * @param filename - String
	 * @throws IOException - Problem experienced when trying to save the store contents to the file
	 * @throws ClassNotFoundException -
	 */
	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
	
	  // Initializing array list for each object type.

	  ArrayList<Endorsement> endorsementList;
	  ArrayList<Comment> commentList;
	  ArrayList<Post> postList;
	  ArrayList<Account> accountList;
	  
	  try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
		  
		  endorsementList = (ArrayList<Endorsement>) in.readObject();
		  Endorsements.setEndorsementList(endorsementList);
		  
		  commentList = (ArrayList<Comment>) in.readObject();
		  Comments.setCommentList(commentList);
		  
		  postList = (ArrayList<Post>) in.readObject();
		  Posts.setPostList(postList);
		  
		  accountList = (ArrayList<Account>) in.readObject();
		  Accounts.setAccountList(accountList);

	  }
	  
	  catch (IOException exc) {
	  	throw new IOException("Problem experienced when trying to save the store contents to the file");
	  }
	}
}
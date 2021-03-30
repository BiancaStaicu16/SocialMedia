package socialmedia;

import java.io.IOException;

/**
 * BadMiniSocialMedia is a minimally compiling, but non-functioning implementor
 * of the MiniSocialMediaPlatform interface.
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class BadMiniSocialMedia implements MiniSocialMediaPlatform {

	@Override
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException {
		for(Account account: Accounts.getAccountsList()){
			if(account.getStringHandle().equals(handle)) {
				throw new IllegalHandleException("An account with this string handle already exists.");
			}
			
			else if (handle != null && handle.length() <= 30 && !handle.contains(" ")){
				throw new InvalidHandleException("Your string handle is invalid.");
			}
			
			else {
				Account firstAccount = new Account(handle);
				Accounts.addAccount(firstAccount);
				return firstAccount.getNumId();
			}
		}
		return 0;
	}

	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
		// Looping until the index variable reaches the length of the accounts list
		for(int index = 0; index < Accounts.getAccountsList().length; index++) {
			// Getting the numerical ID of each account and comparing it to the id that has been passed in
			if (Accounts.getAccountsList()[index].getNumId() == id) {
				// If the id has been found, it will be removed from the list of accounts
				Accounts.removeAccount(index);
				break;
			}
		}
		// If there is so matching ID
		throw new AccountIDNotRecognisedException("The account ID entered wasn't found.");
			
	}

	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		Accounts.changeAccountHandle(oldHandle, newHandle);
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
		
		for (Post post: Posts.getPostList()) {
			if(post.getPostId() == id && post.getStringHandle().equals(handle) && !post.getMessage().contains("EP@")) {
				String endorsedMessage = "EP@" + post.getStringHandle() + ": " + post.getMessage();
				Post firstEndorsement = new Endorsement(endorsedMessage, handle);
				Posts.addPost(firstEndorsement);
			}
			
		}
		
		throw new PostIDNotRecognisedException("The post ID entered has not been found.");
		

//		Post firstEndorsedPost = new Post()
		return 0;
	}

	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub

	}

	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMostEndorsedPost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedAccount() {
		// TODO Auto-generated method stub
		return 0;
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

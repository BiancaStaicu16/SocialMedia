package socialmedia;

import java.util.ArrayList;

/**
 * Class of accounts.
 */
public class Accounts {
	
	private static ArrayList<Account> accountList = new ArrayList<Account>();
	
	public static ArrayList<Account> getAccountsList() {
		return accountList;
	}
	
	public static void setAccountList(ArrayList<Account> list) {
		accountList = list;
	}
	
	public static int getNumberOfAccounts() {
		return accountList.size();
	}

	/**
	 * Method that add an account to the list of accounts.
	 * @param item - Account
	 */
	public static void addAccount(Account item) {
		accountList.add(item);
	}

	/**
	 * Method that removes an account from the list.
	 * @param index - Int
	 */
	public static void removeAccount(int index) {
		accountList.remove(index);
	}

	/**
	 * Method that changes the account handle, replacing it with a new one.
	 * @param oldHandle - String
	 * @param newHandle - String
	 */
	public static void changeAccountHandle(String oldHandle, String newHandle) {
		for(Account account: accountList){
			if(account.getStringHandle().equals(oldHandle)){
				account.setStringHandle(newHandle);
			}
		}
	}

	/**
	 * Method that clears the account list.
	 */
	public static void clearAccounts() {
		accountList.clear();
	}
}

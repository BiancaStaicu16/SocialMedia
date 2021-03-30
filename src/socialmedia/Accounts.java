package socialmedia;

import java.util.Arrays;
import java.util.List;

public class Accounts {
	
	private static Account[] accountList;
	
	public static Account[] getAccountsList() {
		return accountList;
	}
	
	public int getNumberOfAccounts() {
		return accountList.length;
	}
	
	public static void addAccount(Account item) {
		accountList[accountList.length + 1] = item;
	}
	
	public static void removeAccount(int index) {
		// Converting the array to an array list
		List<Account> tempList = Arrays.asList(accountList);
		// Removing the item from the array list at the given index
		tempList.remove(index);
		// Converting back to array
		Account[] tempArray = tempList.toArray(new Account[tempList.size()]);
		accountList = tempArray;
	}

	public static void changeAccountHandle(String oldHandle, String newHandle) {
		for(Account account: accountList){
			if(account.getStringHandle().equals(oldHandle)){
				account.setStringHandle(newHandle);
			}
		}
	}
}

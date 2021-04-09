package socialmedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Accounts {
	
	private static ArrayList<Account> accountList = new ArrayList<Account>();
	// private static Account[] accountList = {};
	
	public static ArrayList<Account> getAccountsList() {
		return accountList;
	}
	
	public static void setAccountList(ArrayList<Account> list) {
		accountList = list;
	}
	
	public static int getNumberOfAccounts() {
		return accountList.size();
	}
	
	public static void addAccount(Account item, int pos) {
		accountList.add(item);
	}
	
	public static void removeAccount(int index) {
		// Removing the item from the array list at the given index
		accountList.remove(index);

	}

	public static void changeAccountHandle(String oldHandle, String newHandle) {
		for(Account account: accountList){
			if(account.getStringHandle().equals(oldHandle)){
				account.setStringHandle(newHandle);
			}
		}
	}
	
	public static void clearAccounts() {
		accountList.clear();
	}
}

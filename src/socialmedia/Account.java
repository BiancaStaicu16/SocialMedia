package socialmedia;

import java.io.Serializable;

/**
 * Class of account.
 */
public class Account implements Serializable {
	
	private static int id = 0;
	private int numId;
	private String stringHandle;
	private String description;

	/**
	 * Constructor method.
	 * @param stringHandle - String
	 * @param description - String
	 */
	public Account (String stringHandle, String description) {
		this.stringHandle = stringHandle;
		this.description = description;
		id++;
		numId = id;
	}

	/**
	 * Constructor method.
	 * @param stringHandle - String
	 */
	public Account (String stringHandle) {
		this.stringHandle = stringHandle;
		id++;
		numId = id;
	}

	public int getNumId() {
		return numId;
	}
	
	public String getStringHandle() {
		return stringHandle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setStringHandle(String stringHandle) {
		this.stringHandle = stringHandle;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Method that creates a string.
	 * @return Returns the string created.
	 */
	public String toString(){
		return "NumId:  " + numId + " String Handle: " + stringHandle + " Description: "  + description;
	}
}

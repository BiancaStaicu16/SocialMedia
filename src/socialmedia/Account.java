package socialmedia;

import java.io.Serializable;

public class Account implements Serializable {
	
	private static int id = 0;
	private int numId;
	private String stringHandle;
	private String description;
	
	public Account (String stringHandle, String description) {
		this.stringHandle = stringHandle;
		this.description = description;
		id++;
		numId = id;
	}
	
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

	public String toString(){
		return "NumId:  " + numId + " String Handle: " + stringHandle + " Description: "  + description;
	}
}

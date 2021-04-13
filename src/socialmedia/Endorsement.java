package socialmedia;

/**
 * Class of endorsement.
 */
public class Endorsement extends Post{
	
	private int originalPostId;
	
	private int endorsementId;

    /**
     * Constructor method.
     * @param message - String
     * @param stringHandle - String
     * @param originalPostId - Int
     */
    public Endorsement(String message, String stringHandle, int originalPostId) {
        super(message, stringHandle);
        this.originalPostId = originalPostId;
    }
    
	@Override
    public void setMessage(String message) {
    	super.setMessage(message);
    }
    
    public int getOriginalPostId(){
    	return originalPostId;
    }

    public void setEndorsementId(int id) {
    	endorsementId = id;
    }

    /**
     * Method that creates a string.
     * @return Returns the string created.
     */
    public String toString() {
    	return "Original Post ID: " + originalPostId + " Endorsement ID: " + endorsementId;
    }
}

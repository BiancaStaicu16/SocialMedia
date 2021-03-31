package socialmedia;

public class Endorsement extends Post{
	
	private int originalPostId;
	
	private int endorsementId;

	@Override
    public Endorsement(String message, String stringHandle, int originalPostId) {
        super(message, stringHandle);
        this.originalPostId = originalPostId;
    }
    
    public void setMessage(String message) {
    	super.setMessage(message);
    }
    
    public int getOriginalPostId(){
    	return originalPostId;
    }
    
    public int getEndorsementId() {
    	return endorsementId;
    }
    
    public void setOriginalPostId(int id) {
    	originalPostId = id;
    }
    
    public void setEndorsementId(int id) {
    	endorsementId = id;
    }

}

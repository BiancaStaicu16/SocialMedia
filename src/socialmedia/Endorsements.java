package socialmedia;

import java.util.ArrayList;

/**
 * Class of endorsements.
 */
public class Endorsements {
	
	private static ArrayList<Endorsement> endorsementList = new ArrayList<Endorsement>();
	
	public static ArrayList<Endorsement> getEndorsementList() {
        return endorsementList;
    }
	
	public static void setEndorsementList(ArrayList<Endorsement> list) {
		endorsementList = list;
	}

	/**
	 * Method that add an endorsement to the endorsement list.
	 * @param item - Endorsement
	 */
    public static void addEndorsement(Endorsement item){
        endorsementList.add(item);
    }

	/**
	 * Method that computes the number of endorsements based on a string handle.
	 * @param stringHandle - String
	 * @return Returns the int - number of endorsements.
	 */
	public static int getEndorsementCount(String stringHandle) {
    	int endorsementCount = 0;
    	for(Endorsement endorsement: endorsementList) {
    		if(endorsement.getStringHandle().equals(stringHandle)) {
    			endorsementCount++;
    		}
    	}
    	return endorsementCount;
    }

	/**
	 * Method that computes the number of endorsements based on the original id.
	 * @param originalId - Int
	 * @return Returns the int - number of endorsements.
	 */
	public static int getEndorsementCount (int originalId) {
		int endorsementCount = 0;
		for(Endorsement endorsement: endorsementList) {
			if(endorsement.getOriginalPostId() == originalId) {
				endorsementCount++;
			}
		}
		return endorsementCount;
	}

	/**
	 * Method that clears the endorsement list.
	 */
	public static void clearEndorsements() {
		endorsementList.clear();
	}
}

package socialmedia;

import java.util.ArrayList;

public class Endorsements {
	
	private static ArrayList<Endorsement> endorsementList = new ArrayList<Endorsement>();
	
	
	public static ArrayList<Endorsement> getEndorsementList() {
        return endorsementList;
    }
	
	public static void setEndorsementList(ArrayList<Endorsement> list) {
		endorsementList = list;
	}

    public static void addEndorsement(Endorsement item){
        endorsementList.add(item);
    }
    
    
    public static int getEndorsementCount(String stringHandle) {
    	int endorsementCount = 0;
    	for(Endorsement endorsement: endorsementList) {
    		if(endorsement.getStringHandle().equals(stringHandle)) {
    			endorsementCount++;
    		}
    	}
 
    	return endorsementCount;
    }

	public static int getEndorsementCount (int originalId) {
		int endorsementCount = 0;
		for(Endorsement endorsement: endorsementList) {
			if(endorsement.getOriginalPostId() == originalId) {
				endorsementCount++;
			}
		}

		return endorsementCount;
	}
	
	public static void clearEndorsements() {
		endorsementList.clear();
	}


}

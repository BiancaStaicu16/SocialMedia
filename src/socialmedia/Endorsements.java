package socialmedia;

public class Endorsements {
	
	private static Endorsement[] endorsementList;
	
	
	public static Endorsement[] getEndorsementList() {
        return endorsementList;
    }

    public static void addEndorsement(Endorsement item){
        endorsementList[endorsementList.length + 1] = item;
    }

}

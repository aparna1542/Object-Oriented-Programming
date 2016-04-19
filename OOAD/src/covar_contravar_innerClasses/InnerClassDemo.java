package covar_contravar_innerClasses;
/**
 * @(#)InnerClassDemo.java
 *
 *
 * @author 
 * @version 1.00 
 */
 /////////////////////////////////////////////////////////////
interface RoomSelector{
	public boolean isOkToAirCondition(int index);

}
class House {
	private int [] roomFootage;
	
	public House (){
		roomFootage = new int[4]; 
		roomFootage[0] = 30; 
		roomFootage[1] = 50;
		roomFootage[2] = 100;
		roomFootage[3] = 120;			
	}
	//Inner class
	//public  class RoomConditioner implements RoomSelector {
	private class RoomConditioner implements RoomSelector {		
		public boolean isOkToAirCondition(int index){
			if (index < roomFootage.length){
				if (roomFootage[index] > 70)
					return true;
			}
			return false;	 
		}
	}	
	public RoomSelector getRoomConditioner()
	{
		return new RoomConditioner();
	}

}
public class InnerClassDemo {
        
    
    public static void main(String[] args) {
    	
    	House myHouse = new House();
    //	House.RoomConditioner rc=myHouse.new RoomConditioner();
    	//rc.isOkToAirCondition(2);
    	System.out.println(myHouse.getRoomConditioner().isOkToAirCondition(2));
    	
    }
}

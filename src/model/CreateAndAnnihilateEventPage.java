package model;
import java.util.Random;

public class  CreateAndAnnihilateEventPage {


	public static String createEventPageFileName(String strId){
		Random rand=new Random();
		return String.valueOf(( rand.nextInt(9999) + 1 )*10000 + Integer.parseInt(strId)+ ".jsp");
	}

	public static void createEventPageFile(Event event){
		event.setEventPageFileName(createEventPageFileName(event.getEventId()) + ".jsp");
	}

}

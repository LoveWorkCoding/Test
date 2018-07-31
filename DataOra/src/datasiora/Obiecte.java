package datasiora;

import java.util.logging.Logger;

public class Obiecte {
	
	private static Logger l=Logger.getAnonymousLogger();
	
	private String obiect1;
	private int obiect2;
	private char obiect3;
	
	public Obiecte(String obiect1, int obiect2, char obiect3) {

		this.obiect1 = obiect1;
		this.obiect2 = obiect2;
		this.obiect3 = obiect3;
	}
	
	public static void testLogger(String s) {
		l.info(s);
	}
	

}

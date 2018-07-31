package datasiora;

import java.util.logging.Logger;

public class Main {
	
	public static Logger logger=Logger.getAnonymousLogger();

	public static void main(String[] args) {
		
		DataOra data1=new DataOra();
		DataOra data2=new DataOra(14,0,0,29,7,2018);
		System.out.println("Prima data creata automat:"+data1);
		System.out.println("A doua data creata manual:"+data2);
		
		String timpScurs=DataOra.timpScurs(data1, data2);
		System.out.println(timpScurs);
		
		Obiecte.testLogger("Verificare Logger.");

	}

}

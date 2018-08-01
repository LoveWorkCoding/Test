package datasiora;

import java.time.LocalTime;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		
//		DataOra data1=new DataOra();
//		DataOra data2=new DataOra(14,0,0,29,7,2018);
//		System.out.println("Prima data creata automat:"+data1);
//		System.out.println("A doua data creata manual:"+data2);
//		
//		String timpScurs=DataOra.timpScurs(data2, data1);
//		System.out.println(timpScurs);
		
		
		Calendar cal=Calendar.getInstance();
		
		 int year = cal.get(Calendar.YEAR);
	      int month = cal.get(Calendar.MONTH);      // 0 to 11
	      int day = cal.get(Calendar.DAY_OF_MONTH);
	      int hour = cal.get(Calendar.HOUR_OF_DAY);
	      int minute = cal.get(Calendar.MINUTE);
	      int second = cal.get(Calendar.SECOND);
	      
	      
	      System.out.printf("Acum este ora %4d/%02d/%02d %02d:%02d:%02d\n",  year, month+1, day, hour, minute, second);
		
		

	}

}

package datasiora;

import java.util.Date;
import java.util.GregorianCalendar;

public class DataOra {
	
  private int ora;
  private int minute;
  private int secunde;
  private int anul;
  private int luna;
  private int ziua;
  private Date d;
  private GregorianCalendar gregorianCalendar;

  public DataOra(int ora, int minute, int secunde, int ziua, int luna, int anul) {
	  
    this.ora = ora;
    this.minute = minute;
    this.secunde = secunde;
    this.ziua = ziua;
    this.luna = luna;
    this.anul = anul;
  }

  
public DataOra() {
	
    this.gregorianCalendar = new GregorianCalendar();
    this.ora = gregorianCalendar.HOUR;
    this.minute = gregorianCalendar.MINUTE;
    this.secunde = gregorianCalendar.SECOND;
    this.ziua = gregorianCalendar.DAY_OF_MONTH;
    this.luna = gregorianCalendar.MONTH;
    this.anul = gregorianCalendar.YEAR;
  }

public static int daysInMonth(int luna, int an) {
	
	int zileLuna=0;
	if (luna==1 || luna==3 || luna==5 || luna==7 || luna==8 || luna==10 || luna==12){
		return 31;
	}
	if (luna==4 || luna==6 || luna==9 || luna==11){
		return 30;
	}
	if (luna==2){
		return ((an%400==0)||(an%4==0 && an%100!=0))? 29:28;
	}
	return 0;
}

//private static int diffDay(DataOra dateTime1, DataOra dateTime2) {
//	int day=0;
//	for(int ziua1=dateTime1.ziua;ziua1<daysInMonth(dateTime1.luna, dateTime1.anul);ziua1++) {
//		day++;
//	}day+=dateTime2.ziua;
//	return day;
//}


//ALL MONTHS

//public static int diffMonthYear(DataOra dateTime1, DataOra dateTime2) {
//	int difMonth=0;
//	if (dateTime1.anul==dateTime2.anul) {
//		if (dateTime1.luna<=dateTime2.luna)
//			difMonth= (dateTime2.luna-dateTime1.luna);
//		else
//			difMonth= (dateTime1.luna-dateTime2.luna);
//	}else if (dateTime1.anul<dateTime2.anul) {
//		difMonth = diffMonth(dateTime1, dateTime2);
//	}else {
//		difMonth = diffMonth(dateTime2, dateTime1);
//	}
//	return difMonth;
//}
//
//
//private static int diffMonth(DataOra dateTime1, DataOra dateTime2) {
//	int difMonth=0;
//	for(int luna1=dateTime1.luna;luna1<12;luna1++) {
//		difMonth++;
//	}difMonth+=dateTime2.luna+((diffYear(dateTime1,dateTime2)-1)*12);
//	return difMonth;
//}


public static String spentTime(DataOra dateTime1, DataOra dateTime2) {
	
	if(dateTime1.anul>dateTime2.anul) {
		DataOra temp=dateTime2;
		dateTime2=dateTime1;
		dateTime1=temp;
	}
	int difYear=dateTime2.anul-dateTime1.anul;
	int difMonth=dateTime2.luna-dateTime1.luna;
	if(difMonth<0) {
		difYear--;
		difMonth=12-(difMonth*(-1));
	}
	int difDay=dateTime2.ziua-dateTime1.ziua;
	if(difDay<0) {
		difMonth--;
		if(difMonth<0){
			difMonth=12-(difMonth*(-1));
			difYear--;
		}
		difDay=daysInMonth(dateTime1.luna,dateTime1.anul)-(difDay*(-1));
	}
	int difHour=timpScurs(dateTime1, dateTime2)[0];
	int difMinutes=timpScurs(dateTime1, dateTime2)[1];
	int difSeconds=timpScurs(dateTime1, dateTime2)[2];
	
	return "ore: "+difHour+", minute: "+ difMinutes+", secunde: " +difSeconds+", zile: " +difDay+", luni: "+ difMonth+", ani: "+ difYear;
	
}

  public static int[] timpScurs(DataOra t1, DataOra t2) {

    int ora = 0;
    int minute = 0;
    int secunde = 0;
    if (t1.ora != 0 && t2.ora != 0)
        ora = t2.ora - t1.ora;
      else if (t1.ora == 0 && t2.ora != 0)
        ora = t2.ora;
      else if (t1.ora != 0 && t2.ora == 0)
        ora = 24 - t1.ora;
      if (ora == 0)
        minute = t2.minute - t1.minute;
      else {
        minute = (60 - t1.minute) + t2.minute;
        ora--;
      }
      if (minute > 59) {
        minute = minute % 60;
        ora++;
      }
      if (minute == 0)
        secunde = t2.secunde - t1.secunde;
      else {
        secunde = (60 - t1.secunde) + t2.secunde;
        minute--;
      }
      if (secunde > 59) {
        secunde = secunde % 60;
        minute++;
      }
      int[] timp=new int[3];
      timp[0]=ora;
      timp[1]=minute;
      timp[2]=secunde;
    return timp;
  }

  public void setOra(int ora) {
    this.ora = ora;
  }

  public int getOra() {
    return this.ora;
  }

  public void setMinute(int minute) {
    this.minute = minute;
  }

  public int getMinute() {
    return this.minute;
  }

  public void setSecunde(int secunde) {
    this.secunde = secunde;
  }

  public int getSecunde() {
    return this.secunde;
  }

  public void setAnul(int anul) {
    this.anul = anul;
  }

  public int getAnul() {
    return this.anul;
  }

  public void setLuna(int luna) {
    this.luna = luna;
  }

  public int getLuna() {
    return this.luna;
  }

  public void setZiua(int ziua) {
    this.ziua = ziua;
  }

  public int getZiua() {
    return this.ziua;
  }

  @Override
  public boolean equals(Object d) {
    if (d instanceof GregorianCalendar) {
      DataOra td = (DataOra) d;
      if (this.ora == td.getOra() && this.minute == td.getMinute() && this.secunde == td.getSecunde() && this.anul == td.getAnul() && this.luna == td.getLuna() && this.ziua == td.getZiua())
        return true;
      else
        return false;
    } else
      return false;
  }

  @Override
  public String toString() {
    return "Data: " + this.anul + " luna " + this.luna + " ziua " + this.ziua + "\nla ora: " + this.ora + " : " + this.minute + " : " + this.secunde;
  }

}

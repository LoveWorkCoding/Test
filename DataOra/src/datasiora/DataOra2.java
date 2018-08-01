package datasiora;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataOra2 {
  private int ora;
  private int minute;
  private int secunde;
  private int anul;
  private int luna;
  private int ziua;
  private Calendar calendar=Calendar.getInstance();

  public DataOra2(int ora, int minute, int secunde, int ziua, int luna, int anul) {
	 
    this.ora = ora;
    this.minute = minute;
    this.secunde = secunde;
    this.ziua = ziua;
    this.luna = luna;
    this.anul = anul;
    //this.calendar=Calendar.getInstance();
    calendar.set(anul, luna, ziua, ora, minute, secunde);
  }

  
public DataOra2() {
	 int year = calendar.get(Calendar.YEAR);
     int month = calendar.get(Calendar.MONTH)+1;      // 0 to 11
     int day = calendar.get(Calendar.DAY_OF_MONTH);
     int hour = calendar.get(Calendar.HOUR_OF_DAY);
     int minute = calendar.get(Calendar.MINUTE);
     int second = calendar.get(Calendar.SECOND);
     calendar.set(year, month, day, hour, minute, second);
  }

public static DataOra2 spentTime(DataOra2 dateTime1, DataOra2 dateTime2) {
	int difYear=dateTime2.anul-dateTime1.anul;
	int difMonth=dateTime2.luna-dateTime1.luna;
	int difDay=0;
	int difHour=0;
	int difMinutes=0;
	int difSeconds=0;
	return null;
	
	
}

  public static String timpScurs(DataOra2 t1, DataOra2 t2) {

    int ora = 0;
    int minute = 0;
    int secunde = 0;
    int ziua = t1.ziua - t2.ziua;
    int luna = t1.luna - t2.luna;
    int an = t1.anul - t2.anul;
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
    return "Timpul scurs: " + ora + " : " + minute + " : " + secunde + " zile " + ziua + ", luni " + luna + ", ani " + an;
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

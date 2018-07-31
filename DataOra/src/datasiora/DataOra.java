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

  public static String timpScurs(DataOra t1, DataOra t2) {

    int ora = t1.ora - t2.ora;
    int minute = t1.minute - t2.minute;
    int secunde = t1.secunde - t2.secunde;
    int ziua = t1.ziua - t2.ziua;
    int luna = t1.luna - t2.luna;
    int an = t1.anul - t2.anul;
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

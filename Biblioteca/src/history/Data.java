
package history;

import java.util.Calendar;

public class Data {
  private int ora;
  private int minute;
  private int secunde;
  private int anul;
  private int luna;
  private int ziua;

  public Data(int ora, int minute, int secunde, int ziua, int luna, int anul) {

    this.ora = ora;
    this.minute = minute;
    this.secunde = secunde;
    this.ziua = ziua;
    this.luna = luna;
    this.anul = anul;
  }

  public Data() {

    Calendar calendar = Calendar.getInstance();
    this.anul = calendar.get(Calendar.YEAR);
    this.luna = calendar.get(Calendar.MONTH) + 1;
    this.ziua = calendar.get(Calendar.DAY_OF_MONTH);
    this.ora = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.secunde = calendar.get(Calendar.SECOND);
  }

  public static int daysInMonth(int month, int an) {

    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
      return 31;
    }
    if (month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
    }
    if (month == 2) {
      return ((an % 400 == 0) || (an % 4 == 0 && an % 100 != 0)) ? 29 : 28;
    }
    return 0;
  }

  public static int[] timpScurs(Data t1, Data t2) {

    int difOra = 0;
    int difMinute = 0;
    int difSecunde = 0;
    if (t1.ora != 0 && t2.ora != 0)
      difOra = t2.ora - t1.ora;
    else if (t1.ora == 0 && t2.ora != 0)
      difOra = t2.ora;
    else if (t1.ora != 0 && t2.ora == 0)
      difOra = 24 - t1.ora;
    if (difOra == 0)
      difMinute = t2.minute - t1.minute;
    else {
      difMinute = (60 - t1.minute) + t2.minute;
      difOra--;
    }
    if (difMinute > 59) {
      difMinute = difMinute % 60;
      difOra++;
    }
    if (difMinute == 0)
      difSecunde = t2.secunde - t1.secunde;
    else {
      difSecunde = (60 - t1.secunde) + t2.secunde;
      difMinute--;
    }
    if (difSecunde > 59) {
      difSecunde = difSecunde % 60;
      difMinute++;
    }
    int[] timp = new int[3];
    timp[0] = difOra;
    timp[1] = difMinute;
    timp[2] = difSecunde;
    return timp;
  }

  public static Data spentTime(Data dateTime1, Data dateTime2) {

    if (dateTime1.anul > dateTime2.anul) {
      Data temp = dateTime2;
      dateTime2 = dateTime1;
      dateTime1 = temp;
    }
    int difYear = dateTime2.anul - dateTime1.anul;
    int difMonth = dateTime2.luna - dateTime1.luna;
    if (difMonth < 0) {
      difYear--;
      difMonth = 12 - (difMonth * (-1));
    }
    int difDay = dateTime2.ziua - dateTime1.ziua;
    if (difDay < 0) {
      difMonth--;
      if (difMonth < 0) {
        difMonth = 12 - (difMonth * (-1));
        difYear--;
      }
      difDay = daysInMonth(dateTime1.luna, dateTime1.anul) - (difDay * (-1));
    }
    int difHour = timpScurs(dateTime1, dateTime2)[0];
    int difMinutes = timpScurs(dateTime1, dateTime2)[1];
    int difSeconds = timpScurs(dateTime1, dateTime2)[2];

    //String s = "ore: " + difHour + ", minute: " + difMinutes + ", secunde: " + difSeconds + ", zile: " + difDay + ", luni: " + difMonth + ", ani: " + difYear + ";\n";
    return new Data(difHour, difMinutes, difSeconds, difDay, difMonth, difYear);

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
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + anul;
    result = prime * result + luna;
    result = prime * result + minute;
    result = prime * result + ora;
    result = prime * result + secunde;
    result = prime * result + ziua;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Data))
      return false;
    Data other = (Data) obj;
    if (anul != other.anul)
      return false;
    if (luna != other.luna)
      return false;
    if (minute != other.minute)
      return false;
    if (ora != other.ora)
      return false;
    if (secunde != other.secunde)
      return false;
    if (ziua != other.ziua)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return " Data: " + this.anul + " luna " + this.luna + " ziua " + this.ziua + "\n ora: " + this.ora + " : " + this.minute + " : " + this.secunde + ".\n";
  }

}

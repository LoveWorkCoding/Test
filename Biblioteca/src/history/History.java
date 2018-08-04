
package history;

import biblioteca.Exemplar;
import users.Membru;

public class History {
  private Data dataImprumut;
  private Data dataReturnare;
  private Membru membru;
  private Exemplar carte;

  public History(Membru membru, Exemplar carte) {

    this.dataImprumut = new Data();
    this.membru = membru;
    this.carte = carte;
  }

  public History() {

  }

  public void returnareCarte() {

    this.dataReturnare = new Data();
  }

  public Data getDataImprumut() {
    return dataImprumut;
  }

  public void setDataImprumut(Data dataImprumut) {
    this.dataImprumut = dataImprumut;
  }

  public Data getDataReturnare() {
    return dataReturnare;
  }

  public void setDataReturnare(Data dataReturnare) {
    this.dataReturnare = dataReturnare;
  }

  public Exemplar getCarte() {
    return this.carte;
  }

  public Membru getMembru() {
    return this.membru;
  }

  @Override
  public String toString() {
    return this.carte + " imprumutata de " + this.membru.getNumeUtilizator() + " la " + this.dataImprumut + " returnata la " + this.dataReturnare;
  }
}

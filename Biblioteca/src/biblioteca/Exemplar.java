
package biblioteca;

public class Exemplar {

  private int idUnic;
  private Carte carte;

  public Exemplar(int id, Carte carte) {

    this.idUnic = id;
    this.carte = carte;
  }

  public Carte getCarte() {
    return this.carte;
  }

  //  public void setCarte(Carte carte) {
  //    this.carte = carte;
  //  }

  public int getIdUnic() {
    return this.idUnic;
  }

  //  public void setIdUnic(int idUnic) {
  //    this.idUnic = idUnic;
  //  }

  @Override
  public String toString() {
    return "Exemplar id= " + this.idUnic + ", " + this.carte;
  }

}

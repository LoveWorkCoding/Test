
package biblioteca;

public class Carte {

  private String numeCarte;
  private String autorCarte;
  //private Exemplar id;
  //private int nrExemplare;

  public Carte(String numeCarte, String autorCarte) {

    this.numeCarte = numeCarte;
    this.autorCarte = autorCarte;
  }

  //  public void cresteExemplar(int nr) {
  //    this.nrExemplare += nr;
  //  }
  //
  //  public void setNrExemplare(int nr) {
  //    this.nrExemplare = nr;
  //  }
  //
  //  public int getNrExemplare() {
  //    return this.nrExemplare;
  //  }

  public String getNumeCarte() {
    return numeCarte;
  }

  public void setNumeCarte(String numeCarte) {
    this.numeCarte = numeCarte;
  }

  public String getAutorCarte() {
    return autorCarte;
  }

  public void setAutorCarte(String autorCarte) {
    this.autorCarte = autorCarte;
  }

  //  public Exemplar getId() {
  //    return this.id;
  //  }
  //
  //  public void setId(Exemplar id) {
  //    this.id = id;
  //  }

  @Override
  public String toString() {
    return "nume carte=" + numeCarte + ", autor carte=" + autorCarte + ";";
  }

}

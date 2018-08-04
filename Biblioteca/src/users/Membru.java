
package users;

import java.util.ArrayList;

import biblioteca.Exemplar;

public class Membru extends User {
  private String numeMembru;
  private long nrTelefonMembru;
  private String adresa;
  private long cnp;
  private ArrayList<Exemplar> cartiImprumutate;

  public Membru(TipUser tipUser, String numeUtilizator, String parola, String numeMembru, long nrTelefonMembru, String adresa, long cnp) {
    super(tipUser, numeUtilizator, parola);
    this.numeMembru = numeMembru;
    this.nrTelefonMembru = nrTelefonMembru;
    this.adresa = adresa;
    this.cnp = cnp;
  }

  public String getNumeMembru() {
    return numeMembru;
  }

  public void setNumeMembru(String numeMembru) {
    this.numeMembru = numeMembru;
  }

  public long getNrTelefonMembru() {
    return nrTelefonMembru;
  }

  public void setNrTelefonMembru(long nrTelefonMembru) {
    this.nrTelefonMembru = nrTelefonMembru;
  }

  public String getAdresa() {
    return adresa;
  }

  public void setAdresa(String adresa) {
    this.adresa = adresa;
  }

  public long getCnp() {
    return cnp;
  }

  public void setCnp(long cnp) {
    this.cnp = cnp;
  }

  public ArrayList<Exemplar> getCartiImprumutate() {
    return this.cartiImprumutate;
  }

  public void setCartiImprumutate(Exemplar carte) {
    cartiImprumutate.add(carte);
  }

  @Override
  public String toString() {
    return "Membru: nume membru=" + numeMembru + ", telefon membru=" + nrTelefonMembru + ", adresa=" + adresa + ", cnp=" + cnp;
  }

}


package biblioteca;

import java.util.ArrayList;
import java.util.Collections;

import history.Data;
import history.History;
import interfata.Comanda;
import users.Admin;
import users.Membru;

public class Biblioteca implements Comanda {

  private String numeBiblioteca;
  private ArrayList<Exemplar> cartiDisponibile;
  private ArrayList<Exemplar> idCarti;
  private ArrayList<Membru> membri;
  private ArrayList<Admin> admini;
  private ArrayList<String> dateCarti;
  private ArrayList<History> istoricImprumut;
  private ArrayList<String> statisticiPenalizari;

  public Biblioteca(String numeBiblioteca) {
    this.numeBiblioteca = numeBiblioteca;
    this.cartiDisponibile = new ArrayList<>();
    this.idCarti = new ArrayList<>();
    this.membri = new ArrayList<>();
    this.admini = new ArrayList<>();
    this.dateCarti = new ArrayList<>();
    this.istoricImprumut = new ArrayList<>();
    this.statisticiPenalizari = new ArrayList<>();
  }

  public void umplereBiblioteca() {
    adaugareCarte("Multumesc pentru amintiri", "Cecelia Ahern");
    adaugareCarte("Multumesc pentru amintiri", "Cecelia Ahern");
    adaugareCarte("Multumesc pentru amintiri", "Cecelia Ahern");
    adaugareCarte("Masca de fier", "Alexandre Dumas");
    adaugareCarte("Masca de fier", "Alexandre Dumas");
    adaugareCarte("Masca de fier", "Alexandre Dumas");
    adaugareCarte("Insotitorii diavolului", "John Misto");
    adaugareCarte("Insotitorii diavolului", "John Misto");

  }

  public void afisareNrExemplare(String numeCarte, String autor) {

    int nrExemplare = 0;
    for (Exemplar id : this.idCarti) {
      if (numeCarte.equals(id.getCarte().getNumeCarte()) && autor.equals(id.getCarte().getAutorCarte())) {
        nrExemplare++;
        System.out.println(id);
      }
    }
    System.out.println("Sunt " + nrExemplare + " exemplare din " + numeCarte + " de " + autor + ".");

  }

  private Exemplar generareIdUnic(Carte carte) {

    Exemplar exemplar;
    ArrayList<Integer> id = new ArrayList<>();
    for (int i = 1000; i < 9000; i++) {
      int e = i + 1;
      id.add(e);
    }
    Collections.shuffle(id);
    if (verificaID(id.get(10))) {
      exemplar = new Exemplar(id.get(10), carte);
      this.idCarti.add(exemplar);
    } else {
      exemplar = new Exemplar(id.get(11), carte);
      this.idCarti.add(exemplar);
    }
    return exemplar;
  }

  private boolean verificaID(int id) {
    for (Exemplar e : idCarti) {
      if (e.getIdUnic() == id)
        return false;
    }
    return true;
  }

  @Override
  public void adaugareCarte(String numeCarte, String autor) {

    Carte carte = new Carte(numeCarte, autor);
    Exemplar e = generareIdUnic(carte);
    this.cartiDisponibile.add(e);
    Data data = new Data();
    this.dateCarti.add(e + "\n" + data);
  }

  @Override
  public void adaugareNrExemplareCarte(int nrExemplare, String numeCarte, String autor) {
    for (int k = 1; k <= nrExemplare; k++) {
      adaugareCarte(numeCarte, autor);
    }
  }

  @Override
  public void adaugareUser(Membru membru) {
    this.membri.add(membru);

  }

  @Override
  public void adaugareUser(Admin admin) {
    this.admini.add(admin);

  }

  public String zileRamaseDeReturnare(Exemplar e) {
    int zileRamase = 0;
    for (History h : istoricImprumut) {
      if (h.getCarte().equals(e)) {
        Data d = h.getDataImprumut();
        zileRamase = 7 - d.getZiua();
        if (zileRamase <= 0) {
          return " trebuie sa fie returnata cat mai curand.\n";
        } else
          return " trebuie sa fie returnata in \" + zileRamase + \" zile.\n";
      }
    }
    return "";
  }

  @Override
  public ArrayList<String> cautaCarte(String infoCarte) {

    ArrayList<String> cartiTemp = new ArrayList<>();
    for (Exemplar e : this.idCarti) {
      if (e.getCarte().getNumeCarte().contains(infoCarte)) {
        if (this.cartiDisponibile.contains(e)) {
          cartiTemp.add(e.toString() + " este disponibila.\n");
        } else {
          cartiTemp.add(e.toString() + zileRamaseDeReturnare(e));
        }
      }
    }
    return cartiTemp;
  }

  @Override
  public ArrayList<String> cautaCarteDupaAutor(String autor) {

    ArrayList<String> cartiTemp = new ArrayList<>();
    for (Exemplar e : this.idCarti) {
      if (e.getCarte().getAutorCarte().equals(autor))
        cartiTemp.add(e.toString() + "\n");
    }
    return cartiTemp;
  }

  public boolean membruCuPenalizari(Membru m) {

    for (String penalizare : this.statisticiPenalizari) {
      if (penalizare.contains(m.getNumeMembru()) && penalizare.contains(m.getNumeUtilizator())) {
        return true;
      }
    }
    return false;
  }

  public String membruPenalizari(Membru m) {

    String penalizari = "";
    for (String penalizare : this.statisticiPenalizari) {
      if (penalizare.contains(m.getNumeMembru()) && penalizare.contains(m.getNumeUtilizator()))
        penalizari += penalizare + "\n";
    }
    return penalizari;
  }

  @Override
  public void membruImprumut(Membru m, int id) {

    if (membruCuPenalizari(m)) {
      System.out.println("Aveti penalizari:\n" + membruPenalizari(m));
    } else if (m.getCartiImprumutate().size() < 3) {
      for (Exemplar e : this.idCarti) {
        if (e.getIdUnic() == id) {
          m.getCartiImprumutate().add(e);
          this.istoricImprumut.add(new History(m, e));
          this.cartiDisponibile.remove(e);
          System.out.println("Ati imprumutat " + e);

        } else {
          System.out.println("Nu exista acest id de carte.");
        }

      }
    } else
      System.out.println("Ati imprumutat prea multe carti! ");

  }

  public Exemplar getExemplarFromMembru(Membru m, int id) {

    for (Exemplar carte : m.getCartiImprumutate()) {
      if (carte.getIdUnic() == id) {
        return carte;
      }
    }
    System.out.println("Id " + id + " incorect.");
    return null;
  }

  public void scoatePenalizareMembru(Membru m, Exemplar e) {

    for (String penalizare : this.statisticiPenalizari) {
      if (penalizare.contains(m.getNumeMembru()) && penalizare.contains(m.getNumeUtilizator())) {
        if (penalizare.contains(e.toString()))
          this.statisticiPenalizari.remove(penalizare);
      }
    }
  }

  @Override
  public void membruReturnare(Membru m, int id) {

    Exemplar carte = getExemplarFromMembru(m, id);
    if (carte != null) {
      for (History istoric : this.istoricImprumut) {
        if (istoric.getMembru().equals(m) && istoric.getCarte().equals(carte)) {
          istoric.returnareCarte();
          m.getCartiImprumutate().remove(carte);
          this.cartiDisponibile.add(carte);
          System.out.println("Ati returnat " + carte);
          if (membruCuPenalizari(m)) {
            scoatePenalizareMembru(m, carte);
          }
        }
      }
    }

  }

  public Data dataReturnareCarte(Exemplar e) {

    for (History h : istoricImprumut) {
      if (h.getCarte().equals(e)) {
        return Data.spentTime(h.getDataImprumut(), new Data());
      }
    }
    return null;
  }

  @Override
  public String infoMembru(Membru membru) {
    int cartiImprumutate = membru.getCartiImprumutate().size();
    String dataReturnare = "";
    if (cartiImprumutate != 0) {
      for (Exemplar e : membru.getCartiImprumutate()) {
        Data d = dataReturnareCarte(e);
        int returnare = 7 - d.getZiua();
        if (returnare < 0) {
          dataReturnare += "Sunteti penalizat, ati depasit limita cu " + (returnare * (-1)) + "zile.\n";
          dataReturnare += "Va rugam sa returnati cartea cu id-ul " + e.getIdUnic() + ".\n";
        } else {
          //d.setZiua(d.getZiua()+7);
          dataReturnare += "Aveti " + returnare + " zile de returnare a cartii cu id-ul " + e.getIdUnic() + "\n";
          //dataReturnare += d+"\n";
        }
      }
    }
    return "Carti imprumutate: " + cartiImprumutate + ".\n" + dataReturnare;
  }

  @Override
  public ArrayList<String> statisticiPenalizari(Biblioteca biblioteca) {

    for (History h : this.istoricImprumut) {
      if (h.getDataReturnare() == null) {
        Data timpScurs = Data.spentTime(h.getDataImprumut(), new Data());
        if (timpScurs.getZiua() > 7) {
          this.statisticiPenalizari.add(h.getMembru().getNumeMembru() + " " + h.getMembru().getNumeUtilizator() + " nu a returnat " + h.getCarte().toString() + "\nPenalizare " + (timpScurs.getZiua() - 7) + " zile.");
        }
      }
    }
    return this.statisticiPenalizari;
  }

  @Override
  public ArrayList<String> istoricBiblioteca(Biblioteca biblioteca) {
    ArrayList<String> infoBiblioteca = new ArrayList<String>();
    for (String d : this.dateCarti) {
      infoBiblioteca.add(d + "\n");
    }
    for (History h : this.istoricImprumut) {
      infoBiblioteca.add(h + "\n");
    }

    return infoBiblioteca;
  }

  public ArrayList<Membru> getMembri() {
    return this.membri;
  }

  @Override
  public String toString() {
    return "nume biblioteca=" + this.numeBiblioteca + "\n" + this.idCarti.toString();
  }

}

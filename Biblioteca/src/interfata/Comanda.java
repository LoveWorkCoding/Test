
package interfata;

import java.util.ArrayList;

import biblioteca.Biblioteca;
import users.Admin;
import users.Membru;

public interface Comanda {

  public void adaugareCarte(String numeCarte, String autor);

  public void adaugareNrExemplareCarte(int nrExemplare, String numeCarte, String autor);

  public void adaugareUser(Membru membru);

  public void adaugareUser(Admin admin);

  public ArrayList<String> cautaCarte(String infoCarte);

  public ArrayList<String> cautaCarteDupaAutor(String autor);

  public void membruImprumut(Membru m, int id);

  public void membruReturnare(Membru m, int id);

  public String infoMembru(Membru membru);

  public ArrayList<String> statisticiPenalizari(Biblioteca biblioteca);

  public ArrayList<String> istoricBiblioteca(Biblioteca biblioteca);
}

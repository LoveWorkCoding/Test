
package ui;

import java.util.Scanner;

import biblioteca.Biblioteca;
import users.Membru;

public class MeniuBiblioteca {

  private Biblioteca b;

  public MeniuBiblioteca(Biblioteca b) {
    this.b = b;
  }

  public static void meniu() {
    Biblioteca biblioteca = new Biblioteca("WC Eminescu Drill");
    biblioteca.umplereBiblioteca();

    Scanner scan = new Scanner(System.in);

    while (true) {

      meniuPrincipal();
      int optiune = scan.nextInt();

      switch (optiune) {
        case 1:
          //System.out.println("1. Adauga carte:");
          System.out.print("Introduceti numele cartii: ");
          String numeCarte = scan.next();
          System.out.println();
          System.out.print("Introduceti autorul: ");
          String autor = scan.next();
          System.out.println();
          biblioteca.adaugareCarte(numeCarte, autor);
          System.out.println();
          break;
        case 2:
          //System.out.println("2. Adauga nr exemplare carte");
          //System.out.println();
          System.out.print("Introduceti numele cartii:");
          String numCarte = scan.nextLine();
          System.out.println();
          System.out.print("Introduceti autorul: ");
          String autorul = scan.nextLine();
          //System.out.println();
          System.out.println("Introduceti nr de exemplare:");
          int nrExemplare = scan.nextInt();
          System.out.println();
          biblioteca.adaugareNrExemplareCarte(nrExemplare, numCarte, autorul);
          System.out.println();
          break;
        case 3:
          System.out.println("3. Adauga membru sau admin");
          break;
        case 4:
          //System.out.println("4. Cauta carte");
          System.out.print("Introduceti cuvinte din numele cartii:");
          String infoCarte = scan.next();
          System.out.println();
          System.out.print(biblioteca.cautaCarte(infoCarte).toString());
          System.out.println();
          break;
        case 5:
          //System.out.println("5. Cauta dupa autor");
          System.out.print("Introduceti autorul: ");
          String a = scan.next();
          System.out.println();
          System.out.print(biblioteca.cautaCarteDupaAutor(a).toString());
          System.out.println();
          break;
        case 6:
          //System.out.println("6. Membru imprumutare carte");
          System.out.print("Introduceti numele membrului:");
          String numeMembru = scan.next();
          System.out.println();
          System.out.print("Introduceti numele de utilizator:");
          String numeUtilizator = scan.next();
          System.out.println();
          for (Membru m : biblioteca.getMembri()) {
            if (m.getNumeMembru().toUpperCase().equals(numeMembru.toUpperCase()) && m.getNumeUtilizator().toUpperCase().equals(numeUtilizator.toUpperCase())) {
              System.out.print("Introduceti id-ul cartii pe care o doriti:");
              int id = scan.nextInt();
              System.out.println();
              biblioteca.membruImprumut(m, id);
            }
          }
          break;
        case 7:
          //System.out.println("7. Membru returnare carte");
          System.out.print("Introduceti numele membrului:");
          String membru = scan.next();
          System.out.println();
          System.out.print("Introduceti numele de utilizator:");
          String utilizator = scan.next();
          System.out.println();
          for (Membru m : biblioteca.getMembri()) {
            if (m.getNumeMembru().toUpperCase().equals(membru.toUpperCase()) && m.getNumeUtilizator().toUpperCase().equals(utilizator.toUpperCase())) {
              System.out.print("Introduceti id-ul cartii pe care o doriti:");
              int id = scan.nextInt();
              System.out.println();
              biblioteca.membruReturnare(m, id);
            }
          }
          break;
        case 8:
          //System.out.println("8. Info membru");
          System.out.print("Introduceti numele membrului:");
          String memb = scan.next();
          System.out.println();
          System.out.print("Introduceti numele de utilizator:");
          String utl = scan.next();
          System.out.println();
          for (Membru m : biblioteca.getMembri()) {
            if (m.getNumeMembru().toUpperCase().equals(memb.toUpperCase()) && m.getNumeUtilizator().toUpperCase().equals(utl.toUpperCase())) {
              System.out.print(biblioteca.infoMembru(m));
            }
          }
          break;
        case 9:
          //System.out.println("9. Penalizari");
          System.out.println(biblioteca.statisticiPenalizari(biblioteca).toString());
          break;
        case 10:
          //System.out.println("10. Istoric biblioteca");
          System.out.println(biblioteca.istoricBiblioteca(biblioteca).toString());
          break;
        case 11:
          System.exit(0);

        default:
          System.out.println("Nu ati ales o optiune.");
          break;

      }
    }
  }

  public static void meniuPrincipal() {
    System.out.println("Selectati o optiune:");
    System.out.println("1. Adauga carte");
    System.out.println("2. Adauga nr exemplare carte");
    System.out.println("3. Adauga membru sau admin");
    System.out.println("4. Cauta carte");
    System.out.println("5. Cauta dupa autor");
    System.out.println("6. Membru imprumutare carte");
    System.out.println("7. Membru returnare carte");
    System.out.println("8. Info membru");
    System.out.println("9. Penalizari");
    System.out.println("10. Istoric biblioteca");
    System.out.println("11. Iesire din biblioteca.");
  }

}

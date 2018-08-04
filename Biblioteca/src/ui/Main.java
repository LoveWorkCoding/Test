
package ui;

import biblioteca.Biblioteca;

public class Main {

  /*public void run() {
  	while(true) {
  		afisareUtilizatori();
  		switch
  	}
  }*/

  private void afisareUtilizatori() {
    System.out.println("1. Admin");
    System.out.println("2. Membru");
    System.out.println("3. Guest");
  }

  public static void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca("WC Eminescu Drill");
    biblioteca.umplereBiblioteca();

    MeniuBiblioteca m = new MeniuBiblioteca(biblioteca);
    m.meniu();

    //		System.out.println(biblioteca);
    //		
    //		biblioteca.adaugareNrExemplareCarte(7,"Insotitorii diavolului","John Misto");
    //		System.out.println(biblioteca);
    //		
    //		biblioteca.afisareNrExemplare("Insotitorii diavolului","John Misto");
    //		biblioteca.afisareNrExemplare("Multumesc pentru amintiri", "Cecelia Ahern");

    //Admin admin1=new Admin()

  }

}

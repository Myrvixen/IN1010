
class Person{

  Bil3 eidBil;

  // Konstruktoer som tar et Bil3 objekt som argument
  public Person(Bil3 bil){
    eidBil = bil;
  }

  // Metode som henter og printer bilnummeret lagret i Bil3-objektet
  public void skrivBilNummer(){
    String bilNummer = eidBil.hentNummer();
    System.out.println("Bilnummer: " + bilNummer);
  }
}


class Bil3 {

  private String bilNummer;

  // Konstruktoer som tar bilnummer som argument
  public Bil3(String num){
    bilNummer = num;
  }

  // Metode som printer ut Bil-objektets bilnummer
  public void skrivBil(){
    System.out.println("Bilnummer: " + bilNummer);
  }

  // Metode som returner Bil-objektets bilnummer
  public String hentNummer(){
    return bilNummer;
  }
}

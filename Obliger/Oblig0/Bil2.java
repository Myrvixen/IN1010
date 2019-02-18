
class Bil2 {

  private String bilnummer;

  // Konstruktoer som tar bilnummer som argument
  public Bil2(String num){
    bilnummer = num;
  }

  // Metode som printer ut Bil-objektets bilnummer
  public void skrivBil(){
    System.out.println("Bilnummer: " + bilnummer);
  }
}

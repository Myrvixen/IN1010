
class TestGruppeoppmoete{

  public static void main(String[] args) throws Exception{

    Gruppemoete register = new Gruppemoete();
    register.lesInnFil("gruppeliste.txt");
    register.registrerOppmoete("Lisa");
    register.registrerOppmoete("Bilal");
    register.registrerOppmoete("Jens");
    register.registrerOppmoete("Emilie");
    register.skrivUtAlleOppmoette();
  }
}

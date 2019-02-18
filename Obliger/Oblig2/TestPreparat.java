
class TestPreparat{

  public static void main(String[] args){

    PreparatA a = new PreparatA("Pille A", 100, 10, 20);
    PreparatB b = new PreparatB("Pille B", 1000, 5, 10);
    PreparatC c = new PreparatC("Pille C", 50, 50);

    Legemiddel[] legemidler = new Legemiddel[]{a, b, c};

    int teller = 0;
    for (Legemiddel legemiddel : legemidler){

      System.out.println(legemiddel);

      System.out.println("\nEnhetstester for stoffet "+legemiddel.hentNavn()+":");
      sjekkId(legemiddel, teller);
      sjekkNyPris(legemiddel, 5000);

      teller++;
    }

  }

  // Test 1: Sjekker at ID'en til legemidlene er korrekte.
  public static void sjekkId(Legemiddel legemiddel, int sannId){
    if (legemiddel.hentId() == sannId){
      System.out.println("Test 1: Riktig");
    } else {
      System.out.println("Test 1: Feil");
    }
  }

  // Test 2: Sjekker at prisen på legemiddelet oppdateres riktig etter
  // aa ha kalt på settNyPris-metoden.
  public static void sjekkNyPris(Legemiddel legemiddel, double nyPris){
    legemiddel.settNyPris(nyPris);
    if (legemiddel.hentPris() == nyPris){
      System.out.println("Test 2: Riktig");
    } else {
      System.out.println("Test 2: Feil");
    }
  }
}

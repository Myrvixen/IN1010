
class TestResepter{

  public static void main(String[] args){

    testBruk();
    testPrisBlaa();
    testPrisPResept();
    testPrisMilitaer();
  }

  // Test 1: Sjekker at antall reit reduseres med 1 ved kall paa bruk()
  // Test 2: Sjekker at resepten ikke brukes hvis antReit = 0
  public static void testBruk(){

    PreparatA a = new PreparatA("PilleA", 100, 10, 20);
    Lege lege = new Lege("Jon");
    HvitResept resept = new HvitResept(a, lege, 1, 1);
    boolean brukt = resept.bruk(); // Bruker resept

    if (resept.hentReit() == 0 && brukt == true){
      System.out.println("Test 1: Riktig");
    } else {
      System.out.println("Test 1: Feil");
    }

    brukt = resept.bruk(); // Bruker resept på nytt
    if (resept.hentReit() == 0 && brukt == false){
      System.out.println("Test 2: Riktig");
    } else {
      System.out.println("Test 2: Feil");
    }
  }

  // Test 3: Sjekker at prisen på blaa resepter er riktig.
  public static void testPrisBlaa(){

    PreparatA a = new PreparatA("PilleA", 100, 10, 20);
    Lege lege = new Lege("Jon");
    BlaaResept resept = new BlaaResept(a, lege, 1, 1);

    double prisAaBetale = resept.prisAaBetale();
    if (prisAaBetale == 25.0){
      System.out.println("Test 3: Riktig");
    } else {
      System.out.println("Test 3: Feil");
    }
  }

  // Test 4: Sjekker at 108 kr trekkes fra prisen hvis pris >= 108 kr.
  // Test 5: Sjekker at prisen blir 0 hvis pris < 108 kr.
  public static void testPrisPResept(){

    PreparatA a = new PreparatA("PilleA", 200, 10, 20);
    PreparatB b = new PreparatB("PilleB", 100, 10, 20);
    Lege lege = new Lege("Jon");
    PResept resept1 = new PResept(a, lege, 1);
    PResept resept2 = new PResept(b, lege, 1);

    double prisAaBetale1 = resept1.prisAaBetale();
    if (prisAaBetale1 == 92.0){
      System.out.println("Test 4: Riktig");
    } else {
      System.out.println("Test 4: Feil");
    }

    double prisAaBetale2 = resept2.prisAaBetale();
    if (prisAaBetale2 == 0){
      System.out.println("Test 5: Riktig");
    } else {
      System.out.println("Test 5: Feil");
    }
  }

  // Test 6: Sjekker at pris på militaerresepter er 0.
  public static void testPrisMilitaer(){

    PreparatA a = new PreparatA("PilleA", 200, 10, 20);
    Lege lege = new Lege("Jon");
    MilitaerResept resept = new MilitaerResept(a, lege, 1, 1);

    double prisAaBetale = resept.prisAaBetale();
    if (prisAaBetale == 0){
      System.out.println("Test 6: Riktig");
    } else {
      System.out.println("Test 6: Feil");
    }
  }
}

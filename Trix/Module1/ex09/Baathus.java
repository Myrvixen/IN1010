

class Baat {

  private static int antProd = 0;
  private int prodnr;
  private String merke;

  public Baat(String mrk) {
    prodnr = antProd;
    antProd++;
    merke = mrk;
  }

  public String hentInfo(){
    return "Produksjonsnummer: " + prodnr + ", merke: " + merke;
  }
}

class Baathus {

  private Baat[] baathus;

  public Baathus(int antallPlasser){
    baathus = new Baat[antallPlasser];
  }

  public void settInn(Baat enBaat) {

    boolean sattInn = false;
    int teller = 0;

    while (teller < baathus.length && sattInn == false){
      if (baathus[teller] == null){
        baathus[teller] = enBaat;
        sattInn = true;
      }
      teller ++;
    }

    if (sattInn != true){
      System.out.println("Det er ikke plass til flere baater!");
    }
  }

  public void skrivBaater() {

    for (int i = 0; i < baathus.length; i++){
      if (baathus[i] != null){
        System.out.println(baathus[i].hentInfo());
      }
    }
  }
}


class TestBaathus{

  public static void main(String[] args){

    Baathus testHus = new Baathus(3);
    Baat baat1 = new Baat("Lol");
    Baat baat2 = new Baat("Lol");
    Baat baat3 = new Baat("Lol");
    Baat baat4 = new Baat("Lol");

    testHus.settInn(baat1);
    testHus.settInn(baat2);
    testHus.settInn(baat3);
    testHus.settInn(baat4);

    testHus.skrivBaater();
  }
}

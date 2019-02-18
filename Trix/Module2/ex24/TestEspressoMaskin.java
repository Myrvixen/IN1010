
class TestEspressoMaskin{
  public static void main(String[] args) {
    //Oppretter EspressoMaskin
    EspressoMaskin em = new EspressoMaskin();

    //Sjekker om vannmengde er 0 ved start.
    System.out.println("Ved opprettelse er vannmengde " + em.hentMengdeVann());

    //Prover aa lage en espresso
    System.out.println("Prover aa lage en espresso");
    em.lagEspresso();

    //Prover aa sette inn 500 ml
    System.out.println("Prover aa sette inn 500 ml");
    em.fyllVann(500);

    //Prover aa lage en lungo
    System.out.println("Prover aa lage en lungo");
    em.lagLungo();

    //Prover aa sette inn 1000 ml
    System.out.println("Prover aa sette inn 1000 ml");
    em.fyllVann(1000);
  }
}

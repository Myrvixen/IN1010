
class Node {

  private int minne;
  private int antProsessorer;

  // Konstruktør som tar ant GB minne og antall prosessorer som argumenter
  public Node(int antGB, int prosessorer){
    minne = antGB;
    antProsessorer = prosessorer;
  }

  // Metode som henter ut minnet (GB) lagret i objektet
  public int hentMinne(){
    return minne;
  }

  // Metode som henter ut antall prosessorerer lagret i objektet
  public int hentAntProssesorer(){
    return antProsessorer;
  }
}

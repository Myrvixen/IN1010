
class PreparatA extends Legemiddel{

  private int styrke;

  public PreparatA(String navn, double pris, double virkestoff, int styrke){
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public int hentNarkotiskStyrke(){
    return styrke;
  }

  public String toString(){
    String str = "";
    str += "\nPreparat type: Narkotisk (A)";
    str += "\nNavn: " + navn;
    str += "\nPris: " + pris;
    str += "\nVirkestoff (mg): " + virkestoff;
    str += "\nNarkotisk styrke: " + styrke;
    return str;
  }
}

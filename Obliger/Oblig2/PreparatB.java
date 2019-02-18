
class PreparatB extends Legemiddel{

  private int styrke;

  public PreparatB(String navn, double pris, double virkestoff, int styrke){
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public int hentVanedannendeStyrke(){
    return styrke;
  }

  public String toString(){
    String str = "";
    str += "\nPreparat type: Vanedannende (B)";
    str += "\nNavn: " + navn;
    str += "\nPris: " + pris;
    str += "\nVirkestoff (mg): " + virkestoff;
    str += "\nVanedannende styrke: " + styrke;
    return str;
  }
}

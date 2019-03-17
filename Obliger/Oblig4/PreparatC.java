
class PreparatC extends Legemiddel{

  public PreparatC(String navn, double pris, double virkestoff){
    super(navn, pris, virkestoff);
  }

  public String toString(){
    String str = "";
    str += "\nPreparat type: Vanlig (C)";
    str += "\nNavn: " + navn;
    str += "\nPris: " + pris;
    str += "\nVirkestoff (mg): " + virkestoff;
    return str;
  }
}

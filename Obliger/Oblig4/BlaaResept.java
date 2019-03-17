
class BlaaResept extends Resept{

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege,
    Pasient pasient, int reit){
      super(legemiddel, utskrivendeLege, pasient, reit);
    }

  public String farge(){
    return "blaa";
  }

  public double prisAaBetale(){
    return legemiddel.hentPris()*0.25;
  }

  public String toString(){
    String str = "";
    str += "\nResept type: Blaa";
    str += super.toString();
    return str;
  }
}

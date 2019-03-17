
class HvitResept extends Resept{

  public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege,
    Pasient pasient, int reit){
      super(legemiddel, utskrivendeLege, pasient, reit);
    }

  public String farge(){
    return "hvit";
  }

  public double prisAaBetale(){
    return legemiddel.pris;
  }

  public String toString(){
    String str = "";
    str += "\nResept type: Hvit";
    str += super.toString();
    return str;
  }
}

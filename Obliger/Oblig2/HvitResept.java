
class HvitResept extends Resept{

  public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege,
    int pasientId, int reit){
      super(legemiddel, utskrivendeLege, pasientId, reit);
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
    str += "\nLegemiddel: " + legemiddel.hentNavn();
    str += "\nLege: " + utskrivendeLege.hentNavn();
    str += "\nPasient (ID): " + pasientId;
    str += "\nPris aa betale (NOK): " + prisAaBetale();
    str += "\nAnt. reit: " + reit;
    return str;
  }
}

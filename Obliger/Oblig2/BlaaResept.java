
class BlaaResept extends Resept{

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege,
    int pasientId, int reit){
      super(legemiddel, utskrivendeLege, pasientId, reit);
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
    str += "\nLegemiddel: " + legemiddel.hentNavn();
    str += "\nLege: " + utskrivendeLege.hentNavn();
    str += "\nPasient (ID): " + pasientId;
    str += "\nPris aa betale (NOK): " + prisAaBetale();
    str += "\nAnt. reit: " + reit;
    return str;
  }
}

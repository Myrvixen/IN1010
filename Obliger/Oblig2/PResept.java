
class PResept extends HvitResept{

  public PResept(Legemiddel legemiddel, Lege utskrivendeLege,
    int pasientId){
      super(legemiddel, utskrivendeLege, pasientId, 3);
  }

  public double prisAaBetale(){
    if (legemiddel.pris - 108.0 < 0){
      return 0;
    } else {
      return legemiddel.pris -108.0;
    }
  }

  public String toString(){
    String str = "";
    str += "\nResept type: P-resept";
    str += "\nLegemiddel: " + legemiddel.hentNavn();
    str += "\nLege: " + utskrivendeLege.hentNavn();
    str += "\nPasient (ID): " + pasientId;
    str += "\nPris aa betale (NOK): " + prisAaBetale();
    str += "\nAnt. reit: " + reit;
    return str;
  }
}

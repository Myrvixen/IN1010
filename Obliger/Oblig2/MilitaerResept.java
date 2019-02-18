
class MilitaerResept extends HvitResept{

  public MilitaerResept(Legemiddel legemiddel, Lege utskrivendeLege,
    int pasientId, int reit){
      super(legemiddel, utskrivendeLege, pasientId, reit);
  }

  public double prisAaBetale(){
    return 0;
  }

  public String toString(){
    String str = "";
    str += "\nResept type: Militaerresept";
    str += "\nLegemiddel: " + legemiddel.hentNavn();
    str += "\nLege: " + utskrivendeLege.hentNavn();
    str += "\nPasient (ID): " + pasientId;
    str += "\nPris aa betale (NOK): " + prisAaBetale();
    str += "\nAnt. reit: " + reit;
    return str;
  }
}


class MilitaerResept extends HvitResept{

  public MilitaerResept(Legemiddel legemiddel, Lege utskrivendeLege,
    Pasient pasient, int reit){
      super(legemiddel, utskrivendeLege, pasient, reit);
  }

  public double prisAaBetale(){
    return 0;
  }

  public String toString(){
    String str = "";
    str += "\nResept type: Militaerresept";
    str += "\nLegemiddel: " + legemiddel.hentNavn();
    str += "\nLege: " + utskrivendeLege.hentNavn();
    str += "\nPasient: " + pasient.hentNavn() + " (ID " + pasient.hentId() + ")";
    str += "\nPris aa betale (NOK): " + prisAaBetale();
    str += "\nAnt. reit: " + reit;
    return str;
  }
}

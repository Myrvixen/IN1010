
class PResept extends HvitResept{

  public PResept(Legemiddel legemiddel, Lege utskrivendeLege,
    Pasient pasient){
      super(legemiddel, utskrivendeLege, pasient, 3);
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
    str += "\nPasient: " + pasient.hentNavn() + " (ID " + pasient.hentId() + ")";
    str += "\nPris aa betale (NOK): " + prisAaBetale();
    str += "\nAnt. reit: " + reit;
    return str;
  }
}

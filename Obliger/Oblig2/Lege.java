
class Lege{

  protected String navn;

  public Lege(String navn){
    this.navn = navn;
  }

  public Resept skrivResept(Legemiddel legemiddel, int pasientID, int reit)
    throws UlovligUtskrift{

      // En vanlig lege har ikke lov til aa skrive ut resept for legemiddel
      // av type PreparatA
      if (legemiddel instanceof PreparatA){
        throw new UlovligUtskrift(this, legemiddel);
      }

      return new BlaaResept(legemiddel, this, pasientID, reit);
    }

  public String hentNavn(){
    return navn;
  }

  public String toString(){
    String str = "";
    str += "\nLege type: Vanlig";
    str += "\nNavn: " + navn;
    return str;
  }
}

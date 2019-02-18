
class Spesialist extends Lege{

  private int kontrollID;

  public Spesialist(String navn, int id){
    super(navn);
    kontrollID = id;
  }

  public int hentKontrollID(){
    return kontrollID;
  }

  public Resept skrivResept(Legemiddel legemiddel, int pasientID, int reit){

      return new BlaaResept(legemiddel, this, pasientID, reit);
    }

  public String toString(){
    String str = "";
    str += "\nLege type: Spesialist";
    str += "\nNavn: " + navn;
    str += "\nKontrollID: " + kontrollID;
    return str;
  }
}

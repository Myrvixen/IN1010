
class Spesialist extends Lege{

  private int kontrollID;

  public Spesialist(String navn, int id){
    super(navn);
    kontrollID = id;
  }

  public int hentKontrollID(){
    return kontrollID;
  }

  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit){

      BlaaResept resept = new BlaaResept(legemiddel, this, pasient, reit);
      utskrevneResepter.leggTil(resept);
      pasient.leggTilResept(resept);

      return resept;
    }

  public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit){

      HvitResept resept = new HvitResept(legemiddel, this, pasient, reit);
      utskrevneResepter.leggTil(resept);
      pasient.leggTilResept(resept);

      return resept;
    }

  public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit){

      MilitaerResept resept = new MilitaerResept(legemiddel, this, pasient, reit);
      utskrevneResepter.leggTil(resept);
      pasient.leggTilResept(resept);

      return resept;
    }

  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient){

      PResept resept = new PResept(legemiddel, this, pasient);
      utskrevneResepter.leggTil(resept);
      pasient.leggTilResept(resept);

      return resept;
    }

  public String toString(){
    String str = "";
    str += "\nNavn: " + navn;
    str += "\nLege type: Spesialist";
    str += "\nKontrollID: " + kontrollID;
    return str;
  }
}

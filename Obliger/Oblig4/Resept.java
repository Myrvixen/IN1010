
abstract class Resept{

  protected static int id = 0;
  protected int reseptId;
  protected Legemiddel legemiddel;
  protected Lege utskrivendeLege;
  protected Pasient pasient;
  protected int reit;

  abstract public String farge();

  abstract public double prisAaBetale();


  public Resept(Legemiddel legemiddel, Lege utskrivendeLege,
    Pasient pasient, int reit){
      this.legemiddel = legemiddel;
      this.utskrivendeLege = utskrivendeLege;
      this.pasient = pasient;
      this.reit = reit;
      reseptId = id;
      id++;
    }

  public boolean bruk(){
    if (reit > 0){
      reit -= 1;
      return true;
    }
    else{
      return false;
    }
  }

  public int hentId(){
    return reseptId;
  }

  public Legemiddel hentLegemiddel(){
    return legemiddel;
  }

  public Lege hentLege(){
    return utskrivendeLege;
  }

  public Pasient hentPasient(){
    return pasient;
  }

  public int hentReit(){
    return reit;
  }

  public String toString(){
    String str = "";
    str += "\nLegemiddel: " + legemiddel.hentNavn();
    str += "\nLege: " + utskrivendeLege.hentNavn();
    str += "\nPasient: " + pasient.hentNavn() + " (ID " + pasient.hentId() + ")";
    str += "\nPris aa betale (NOK): " + prisAaBetale();
    str += "\nAnt. reit: " + reit;
    return str;
  }
}

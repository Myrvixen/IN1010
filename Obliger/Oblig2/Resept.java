
abstract class Resept{

  protected static int id = 0;
  protected int reseptId;
  protected Legemiddel legemiddel;
  protected Lege utskrivendeLege;
  protected int pasientId;
  protected int reit;

  abstract public String farge();

  abstract public double prisAaBetale();


  public Resept(Legemiddel legemiddel, Lege utskrivendeLege,
    int pasientId, int reit){
      this.legemiddel = legemiddel;
      this.utskrivendeLege = utskrivendeLege;
      this.pasientId = pasientId;
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

  public int hentPasientId(){
    return pasientId;
  }

  public int hentReit(){
    return reit;
  }
}

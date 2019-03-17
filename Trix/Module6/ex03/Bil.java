
class Bil{

  private String regNr;
  private int antSeter;

  public Bil(String regNr, int antSeter){
    this.regNr = regNr;
    this.antSeter = antSeter;
  }

  public String hentRegNr(){
    return regNr;
  }

  public int hentAntSeter(){
    return antSeter;
  }
}

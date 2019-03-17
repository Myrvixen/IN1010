
abstract class Legemiddel{

  protected String navn;
  protected double pris;
  protected double virkestoff;
  protected static int id = 0;
  protected int middelId;

  public Legemiddel(String navn, double pris, double virkestoff){
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
    middelId = id;
    id++;
  }

  public int hentId(){
    return middelId;
  }

  public String hentNavn(){
    return navn;
  }

  public double hentPris(){
    return pris;
  }

  public double hentVirkestoff(){
    return virkestoff;
  }

  public void settNyPris(double nyPris){
    pris = nyPris;
  }
}

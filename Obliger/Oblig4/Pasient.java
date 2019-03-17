
class Pasient{

  static private int pasientId = 0;
  private int id;
  private String navn;
  private String foedselsnummer;
  private Stabel<Resept> resepter = new Stabel<Resept>();

  public Pasient(String navn, String foedselsnummer){
    this.navn = navn;
    this.foedselsnummer = foedselsnummer;
    id = pasientId;
    pasientId++;
  }

  public Stabel<Resept> hentResepter(){
    return resepter;
  }

  public void leggTilResept(Resept resept){
    resepter.leggTil(resept);
  }

  public String hentNavn(){
    return navn;
  }

  public String hentFoedselsnummer(){
    return foedselsnummer;
  }

  public int hentId(){
    return id;
  }

  public String toString(){
    String str = "";
    str += "\nPasient ID: " + id;
    str += "\nNavn: " + navn;
    str += "\nFødeselsnummer: " + foedselsnummer;
    return str;
  }
}

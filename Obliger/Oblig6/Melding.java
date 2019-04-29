
class Melding implements Comparable<Melding>{

  private String tekst;
  private int sekvnr;
  private int kanalID;

  public Melding(String tekst, int sekvnr, int kanalID){
    this.tekst = tekst;
    this.sekvnr = sekvnr;
    this.kanalID = kanalID;
  }

  public int compareTo(Melding annenMelding){
    int annenSekvnr = annenMelding.hentSekvensnr();
    if (sekvnr > annenSekvnr){
      return 1;
    } else if (sekvnr < annenSekvnr){
      return -1;
    } else {
      return 0;
    }
  }

  public String hentTekst(){
    return tekst;
  }

  public int hentSekvensnr(){
    return sekvnr;
  }

  public int hentKanalID(){
    return kanalID;
  }
}

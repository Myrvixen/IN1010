
class Aapning extends HvitRute{

  public Aapning(int rad, int kolonne){
    super(rad, kolonne);
  }

  @Override
  public void gaa(Rute forrige, String utvei){//, Lenkeliste<Rute> besoekt){

    String str = "";
    if (forrige != null){
      str += "-->";
    }
    String koord = "(" + kolonne + ", " + rad + ")";
    str += koord;
    utvei += str;

    Lenkeliste<String> utveier = labyrint.hentUtveier();
    utveier.leggTil(utvei);

    if (labyrint.hentUtskrift()){
      System.out.println("Utvei ved " + koord);
    }
  }
}

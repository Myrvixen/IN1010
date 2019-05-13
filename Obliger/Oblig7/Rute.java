
abstract class Rute{

  protected int kolonne;
  protected int rad;
  protected Labyrint labyrint;
  protected Rute syd = null;
  protected Rute nord = null;
  protected Rute vest = null;
  protected Rute oest = null;

  abstract char tilTegn();

  public Rute(int rad, int kolonne){
    this.rad = rad;
    this.kolonne = kolonne;
  }

  public void gaa(Rute forrige, String utvei){//, Lenkeliste<Rute> besoekt){

    String koord = "(" + kolonne + ", " + rad + ")";
    String[] besoekt = utvei.split("-->");

    // Sjekker om ruta allerede er besoekt
    for (String s : besoekt){
      if (koord.equals(s)){
        return;
      }
    }

    String str = "";
    if (forrige != null){
      str += "-->";
    }

    str += koord;
    utvei += str;


    if (labyrint.hentUtskrift()){
      System.out.println("Rute: " + koord);
    }

    if (forrige != vest && vest != null){
      vest.gaa(this, utvei);
    }
    if (forrige != nord && nord != null){
      nord.gaa(this, utvei);
    }
    if (forrige != oest && oest != null){
      oest.gaa(this, utvei);
    }
    if (forrige != syd && syd != null){
      syd.gaa(this, utvei);
    }
  }

  public void settLabyrint(Labyrint labyrint){
    this.labyrint = labyrint;
  }

  public void settNaboSyd(Rute rute){
    syd = rute;
  }

  public void settNaboNord(Rute rute){
    nord = rute;
  }

  public void settNaboVest(Rute rute){
    vest = rute;
  }

  public void settNaboOest(Rute rute){
    oest = rute;
  }

  public int hentKolonne(){
    return kolonne;
  }

  public int hentRad(){
    return rad;
  }

  public Labyrint hentLabyrint(){
    return labyrint;
  }

  public Rute hentNaboSyd(){
    return syd;
  }

  public Rute hentNaboNord(){
    return nord;
  }

  public Rute hentNaboVest(){
    return vest;
  }

  public Rute hentNaboOest(){
    return oest;
  }
}

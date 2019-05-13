import java.io.*;
import java.util.Scanner;

class Labyrint{

  private Rute[][] ruter;
  private int antKolonner;
  private int antRader;
  private Lenkeliste<String> utveier;
  private boolean utskrift = false;

  private Labyrint(Rute[][] ruter, int rader, int kolonner){
    this.ruter = ruter;
    this.antKolonner = kolonner;
    this.antRader = rader;
  }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException{

    Scanner in = null;
    int kolonner;
    int rader;
    Rute rute;
    Rute[][] brett;


    in = new Scanner(fil);

    String linje = "";
    String[] deler;
    String tegn = "";
    linje = in.nextLine();

    deler = linje.split(" ");
    rader = Integer.parseInt(deler[0]);
    kolonner = Integer.parseInt(deler[1]);
    brett = new Rute[rader][kolonner];

    // Lager Rute-objektene
    for (int i = 0; i < rader; i++){
      linje = in.nextLine();
      deler = linje.split("");
      for (int j = 0; j < kolonner; j++){
        tegn = deler[j];
        if (tegn.equals(".")){
          if (erAapning(i,j, rader, kolonner)){
            rute = new Aapning(i, j);
          } else {
            rute = new HvitRute(i, j);
          }
        } else {
          rute = new SortRute(i, j);
        }
        brett[i][j] = rute;
      }
    }

    Labyrint labyrint = new Labyrint(brett, rader, kolonner);
    // Setter alle naboer til alle ruter, og pekere til labyrinten
    for (int i = 0; i < rader; i++){
      for (int j = 0; j < kolonner; j++){

          settNaboer(brett[i][j], brett, rader, kolonner);
          brett[i][j].settLabyrint(labyrint);
        }
      }

    return labyrint;

  }

  public static boolean erAapning(int rad, int kolonne, int antRader, int antKolonner){

      if (kolonne == 0 || kolonne == antKolonner-1){
        return true;
      } else if (rad == 0 || rad == antRader-1){
        return true;
      } else {
        return false;
      }
    }

    public static void settNaboer(Rute rute, Rute[][] brett, int antRader,
     int antKolonner){

       int i = rute.hentRad();
       int j = rute.hentKolonne();

       if (i != 0){
         rute.settNaboNord(brett[i-1][j]);
       }

       if (i != antRader-1){
         rute.settNaboSyd(brett[i+1][j]);
       }

       if (j != 0){
         rute.settNaboVest(brett[i][j-1]);
       }

       if (j != antKolonner-1){
         rute.settNaboOest(brett[i][j+1]);
       }
     }

  public Lenkeliste<String> finnUtveiFra(int kol, int rad){

    utveier = new Lenkeliste<String>();

    // Finn alle utveier
    Rute rute = ruter[rad][kol];
    rute.gaa(null, "");

    return utveier;
  }

  public void finnKortesteVei(Liste<String> utveier){
    // Beregn antall utveier, og korteste vei
    String deler[];
    int antUtveier;
    String kortesteVei = "";
    int kortest = 100000;

    antUtveier = utveier.stoerrelse();
    for (String s: utveier){
      deler = s.split("-->");
      if (deler.length < kortest){
        kortest = deler.length;
        kortesteVei = s;
      }
    }
    if (utskrift){
      System.out.println("\nAntall utveier: " + antUtveier);
      System.out.println("Korteste vei: " + kortest);
      System.out.println(kortesteVei + "\n");
    }
  }

  public String toString(){
    String str = "";
    str += Integer.toString(antRader) + " " + Integer.toString(antKolonner) + "\n";
    for (int i = 0; i < antRader; i++){
      for (int j = 0; j < antKolonner; j++){
        str += ruter[i][j].tilTegn();
      }
      str += "\n";
    }
    return str;
  }

  public void settUtskrift(boolean b){
    utskrift = b;
  }

  public Rute[][] hentBrett(){
    return ruter;
  }

  public Lenkeliste<String> hentUtveier(){
    return utveier;
  }

  public boolean hentUtskrift(){
    return utskrift;
  }

  public int hentKolonner(){
    return antKolonner;
  }

  public int hentRader(){
    return antRader;
  }
}

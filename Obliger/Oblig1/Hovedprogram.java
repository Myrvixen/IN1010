
/* Hovedprogram som genererer en regneklynge gitt fila "regneklynge.txt",
* eller en annen fil med samme format, og sjekker at de forskjellige metodene
* som er implementert fungerer som de skal*/

class Hovedprogram{

  public static void main(String[] args){

    Regneklynge abel = new Regneklynge("tekstfiler/regneklynge.txt");

    // Liste av minnegrenser som skal sjekkes i programmet.
    int[] minneListe = new int[]{32, 64, 128};
    for (int i = 0; i < 3; i++){
      int totAntNoder = abel.noderMedNokMinne(minneListe[i]);
      System.out.println("Noder med minst " + minneListe[i] + " GB: "
                          + totAntNoder);
    }

    int totAntPros = abel.antProsessorer();
    int totAntRacks = abel.hentAntRacks();

    System.out.println("\nAntall prosessorer: " + totAntPros);
    System.out.println("Antall rack: " + totAntRacks);

  }
}

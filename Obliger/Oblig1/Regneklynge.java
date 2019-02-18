import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

/** Klassen Regneklynge holder en liste med Rack-objekter, som igjen
* holder hver sin liste med Node-objekter. Klassen kan sende instruksjoner
* til hver rack i lista, som videre sender instruksjoner til nodene.*/

class Regneklynge{

  // Bruker her ArrayList for aa lage en dynamisk liste hvor man kan
  // legge til elementer til listen underveis
  private ArrayList<Rack> racks = new ArrayList<Rack>();
  private int antRacks;
  private int maxAntNoder;

  // Konstruktoer som initierer regneklyngen med et Rack-objekt
  // Antar her at en regneklynge må ha minst ett rack
  public Regneklynge(int maxNoder){
    racks.add(new Rack(maxNoder));
    antRacks = 1;
    maxAntNoder = maxNoder;
  }

  // Konstruktoer som i stedet tar et filnavn som argument. Antar at filene
  //har en fast form, hvis første linje angir max antall noder i hvert rack, og de
  //paafolgende linjene har form 'antallNoder minne prosessorer'. Regneklyngen
  // med de gitte konfigurasjonene genererer i konstruktoeren.
  public Regneklynge(String filNavn){

    // Sjekker at filen kan aapnes
    Scanner fil = null;
    try {
      fil = new Scanner(new File(filNavn));
    } catch (Exception e) {
      System.out.println("Kan ikke lese " + filNavn + "!");
      System.exit(1);
    }

    // Henter første linje i fila
    maxAntNoder = fil.nextInt();

    racks.add(new Rack(maxAntNoder));
    antRacks = 1;

    System.out.println(maxAntNoder);

    // Henter de neste linjene i fila, og plasserer nodene i regneklyngen
    while (fil.hasNextLine()){
      int antNoder = fil.nextInt();
      int minne = fil.nextInt();
      int antProsessorer = fil.nextInt();

      for (int i=0; i < antNoder; i++){
        settInnNode(new Node(minne, antProsessorer));
      }
    }
  }

  // Metode som forsoeker aa sette inn en node i det siste genererte racket
  // i regneklyngen. Er racket fullt lages et nytt rack, metoden kaller saa
  // paa seg selv, og plasserer noden i det nye racket.
  public void settInnNode(Node node){

    boolean sattInn = racks.get(antRacks-1).settInnNode(node);
    if (sattInn == false){
      //System.out.println("Alle racks er fulle, legger til nytt rack...");
      racks.add(new Rack(maxAntNoder));
      antRacks++;
      settInnNode(node);
    }
  }

  // Metode som hentet ut antall racks in regneklyngen
  public int hentAntRacks(){
    return antRacks;
  }

  // Metode som summerer opp antall prosessorer i regneklyngen. Den kaller paa
  // Rack-objektenes metode med samme navn, som returner hvert sitt
  // antall prosessorer.
  public int antProsessorer(){
    int totAntPros = 0;

    for (int i = 0; i < antRacks; i++){
      totAntPros += racks.get(i).antProsessorer();
    }
    return totAntPros;
  }

  // Metode som summerer opp antall noder i regneklyngen med minne over en
  // grense gitt av argumentet 'paakrevdMinne'.  Den kaller paa Rack-objektenes
  // metode med samme navn, som returner hvert sitt antall noder.
  public int noderMedNokMinne(int paakrevdMinne){
    int totAntNoder = 0;

    for (int i = 0; i < antRacks; i++){
      totAntNoder += racks.get(i).noderMedNokMinne(paakrevdMinne);
    }
    return totAntNoder;
  }
}

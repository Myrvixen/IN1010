
/** Klassen Rack har i oppgave å holde en liste med Node-objekter,
* samt å kunne holde styr på nodenes egenskaper*/
class Rack{

  private Node[] rack;
  private int antNoder;

  // Konstruktoer som tar antall noder racket har plass til, og lager
  // en tom liste av typen Node med samme antall plasser
  public Rack(int maxAntNoder){
    rack = new Node[maxAntNoder];
  }

  // Metode som forsøker aa legge til et Node-objekt hvis det er plass.
  // returnerer 'true' hvis den fant plass, 'false' ellers
  public boolean settInnNode(Node node){

    boolean sattInn = false;
    int teller = 0;

    while (teller < rack.length && sattInn == false){
      if (rack[teller] == null){
        rack[teller] = node;
        sattInn = true;
        antNoder++;
      }
      teller ++;
    }
    return sattInn;
  }

  // Metode som løper gjennom listen av noder, og summerer opp antall
  // prosessorer i racket
  public int antProsessorer(){
    int antPros = 0;
    int teller = 0;
    while (teller < antNoder){
      antPros += rack[teller].hentAntProssesorer();
      teller++;
    }
    return antPros;
  }

  // Metode som teller or returnerer antall noder i racket som har minst
  // like stort minne som argumentet 'paakrevdMinne' krever.
  public int noderMedNokMinne(int paakrevdMinne){
    int antNoderNokMinne = 0;
    for (int i = 0; i < antNoder; i++){
      if (rack[i].hentMinne() >= paakrevdMinne){
        antNoderNokMinne++;
      }
    }
    return antNoderNokMinne;
  }

  // Metode som returnerer antall noder som har blitt satt inn i lista
  public int hentAntNoder(){
    return antNoder;
  }
}

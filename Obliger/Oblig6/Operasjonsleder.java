import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class Operasjonsleder implements Runnable{

  ArrayList<SortertLenkeliste<Melding>> tekster;
  Hovedprogram.Monitor monitor;
  int antallKanaler;
  CountDownLatch barriere;

  public Operasjonsleder(Operasjonssentral ops, Hovedprogram.Monitor monitor,
   CountDownLatch barriere){
    this.monitor = monitor;
    this.barriere = barriere;
    antallKanaler = ops.hentAntallKanaler();
    tekster = new ArrayList<SortertLenkeliste<Melding>>();

    for (int i = 0; i < antallKanaler; i++){
      tekster.add(new SortertLenkeliste<Melding>());
    }
  }

  public void run(){

    boolean ferdig = false;
    try{
      while (!ferdig){
        Melding melding = monitor.hentDekryptertMelding();
        if(melding == null){
          ferdig = true;
          barriere.countDown();
        } else {
          int kanal = melding.hentKanalID();
          tekster.get(kanal-1).leggTil(melding);
          System.out.println("OP " + melding.hentKanalID() + " " + melding.hentSekvensnr());
        }
      }
    } catch (InterruptedException e){}
  }

  public void skrivTilFil(){

    String filnavn = "";
    for (int i = 0; i < antallKanaler; i++){

      PrintWriter f = null;
      try{
        filnavn = "tekst" + (i+1) + ".txt";
        f = new PrintWriter(filnavn, "utf-8");
      } catch (Exception e){
        System.out.println("Kunne ikke lage filen " + filnavn);
        System.exit(1);
      }

      for (Melding melding : tekster.get(i)){
        //System.out.println(melding.hentTekst());
        f.println(melding.hentTekst() + "\n");
      }
      f.close();
    }
  }
}

import java.util.concurrent.CountDownLatch;

class Kryptograf implements Runnable{

  private Hovedprogram.Monitor monitor;
  private CountDownLatch barriere;

  public Kryptograf(Hovedprogram.Monitor monitor, CountDownLatch barriere){
    this.monitor = monitor;
    this.barriere = barriere;
  }

  public void run(){

    boolean ferdig = false;
    try{
      while(!ferdig){
        Melding kryptertMelding = monitor.hentKryptertMelding();
        if (kryptertMelding == null){
          ferdig = true;
          monitor.antFerdigeKryptografer++;
          barriere.countDown();
        } else {
          String dekryptertTekst = Kryptografi.dekrypter(kryptertMelding.hentTekst());
          int sekvnr = kryptertMelding.hentSekvensnr();
          int kanalID = kryptertMelding.hentKanalID();
          Melding dekryptertMelding = new Melding(dekryptertTekst, sekvnr, kanalID);

          monitor.leggTilDekryptertMelding(dekryptertMelding);
          System.out.println("Krypt " + kanalID + " " + sekvnr);
        }
      }
    } catch (InterruptedException e){}
  }
}

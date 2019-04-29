import java.util.concurrent.CountDownLatch;

class Telegrafist implements Runnable{

  Kanal kanal;
  String tekst;
  Hovedprogram.Monitor monitor;
  CountDownLatch barriere;
  int kanalID;
  int sekvnr = 0;

  public Telegrafist(Hovedprogram.Monitor monitor, Kanal kanal, CountDownLatch barriere){
    this.monitor = monitor;
    this.barriere = barriere;
    this.kanal = kanal;
    kanalID = kanal.hentId();
  }

  public void run(){

    boolean ferdig = false;
    try{
      while (!ferdig){
        tekst = kanal.lytt();
        if (tekst == null){
          ferdig = true;
          monitor.antFerdigeTelegrafister++;
          barriere.countDown();
        } else {
          Melding melding = new Melding(tekst, sekvnr++, kanalID);
          monitor.leggTilKryptertMelding(melding);
          System.out.println("Tele " + kanalID + " " + (sekvnr -1));
          //System.out.println(kanalID + ", " + sekvnr + ": " + tekst);
        }
      }
    } catch (InterruptedException e){}
  }
}

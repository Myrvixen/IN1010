import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.CountDownLatch;

public class Hovedprogram{

  int antTele;
  int antKrypt;
  CountDownLatch barriere;

  public Hovedprogram(int antTele, int antKrypt){
    this.antTele = antTele;
    this.antKrypt = antKrypt;
    Monitor monitor = new Monitor();
    // Barriere for x,y antall telegrafister,kryptografer + 1 Operasjonsleder
    barriere = new CountDownLatch(antTele + antKrypt +1);

    Operasjonssentral ops = new Operasjonssentral(antTele);
    Kanal[] kanaler = ops.hentKanalArray();

    for (int i = 0; i < antTele; i++){
      new Thread(new Telegrafist(monitor, kanaler[i], barriere)).start();
    }

    for (int i = 0; i < antKrypt; i++){
      new Thread(new Kryptograf(monitor,barriere)).start();
    }

    Operasjonsleder opLeder = new Operasjonsleder(ops, monitor, barriere);
    new Thread(opLeder).start();

    try{
      barriere.await();
    } catch (InterruptedException e){}
    //monitor.vent();

    opLeder.skrivTilFil();

  }

  public static void main(String[] args){

    if (args.length != 2){
      System.out.println("Feil bruk!\nargs: <antall telegrafister> <antall kryptografer>");
      System.exit(1);
    }
    int antallTele = Integer.parseInt(args[0]);
    int antallKrypt = Integer.parseInt(args[1]);
    new Hovedprogram(antallTele, antallKrypt);
  }

  class Monitor{

    private Lock laas1, laas2, laas3;
    private Condition ikkeTom1, ikkeTom2, alleFerdige;
    private Lenkeliste<Melding> krypterteMeldinger, dekrypterteMeldinger;
    int antKrypterteMeldinger = 0;
    int antDekrypterteMeldinger = 0;
    int antFerdigeTelegrafister = 0;
    int antFerdigeKryptografer = 0;

    Monitor(){
      laas1 = new ReentrantLock();
      laas2 = new ReentrantLock();
      ikkeTom1 = laas1.newCondition();
      ikkeTom2 = laas2.newCondition();
      //alleFerdige = laas3.newCondition();
      krypterteMeldinger = new Lenkeliste<Melding>();
      dekrypterteMeldinger = new Lenkeliste<Melding>();
    }

    public void leggTilKryptertMelding(Melding melding) throws InterruptedException{
      laas1.lock();
      try{
        krypterteMeldinger.leggTil(melding);
        antKrypterteMeldinger++;
        ikkeTom1.signalAll();
      } finally {
        laas1.unlock();
      }
    }

    public Melding hentKryptertMelding() throws InterruptedException{
      laas1.lock();
      try{

        if(antKrypterteMeldinger == 0 && antFerdigeTelegrafister == antTele){
          return null;
        } else {
          while (antKrypterteMeldinger == 0){
            ikkeTom1.await();
          }
          antKrypterteMeldinger--;
          return krypterteMeldinger.fjern();
        }
      } finally {
        laas1.unlock();
      }
    }

    public void leggTilDekryptertMelding(Melding melding) throws InterruptedException{
      laas2.lock();
      try{
        dekrypterteMeldinger.leggTil(melding);
        antDekrypterteMeldinger++;
        ikkeTom2.signalAll();
      } finally {
        laas2.unlock();
      }
    }

    public Melding hentDekryptertMelding() throws InterruptedException{
      laas2.lock();
      try{

        if(antDekrypterteMeldinger == 0 && antFerdigeKryptografer == antKrypt){
          return null;
        } else {
          while (antDekrypterteMeldinger == 0){
            ikkeTom2.await();
          }
          antDekrypterteMeldinger--;
          return dekrypterteMeldinger.fjern();
        }
      } finally {
        laas2.unlock();
      }
    }
  }
}

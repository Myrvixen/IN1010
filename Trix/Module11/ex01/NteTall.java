import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NteTall{

  Condition ikkeNeste;
  Condition provIgjen;
  Lock tallLaas;

  NteTall(){
    tallLaas = new ReentrantLock();
    ikkeNeste = tallLaas.newCondition();
    provIgjen = tallLaas.newCondition();
    NteMonitor m = new NteMonitor();

    for (int i = 0; i < 10; i++){
      new Thread(new MinRun(i, 0, 1000, m)).start();
    }
  }

  public static void main(String[] args){
    new NteTall();
  }

  class NteMonitor{
    int tall = -1;

    public void skrivUt(int i){
      tallLaas.lock();
      try{
        while(i-1 != tall){
          ikkeNeste.await();
        }

        tall = i;
        System.out.println(tall);
        ikkeNeste.signalAll();
      } catch(InterruptedException e){
        System.out.println("feil");
      } finally {
        tallLaas.unlock();
      }
    }
  }
}

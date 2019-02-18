import java.util.ArrayList;

public class KoSystem{

  ArrayList<KoLapp> koLapper = new ArrayList<>();
  int teller = 0;

  public void trekkKoLapp(){
    teller++;
    KoLapp nyLapp = new KoLapp(teller);
    koLapper.add(nyLapp);

    System.out.println("Du har fått tildelt billettnr " + nyLapp.hentNummer());
    System.out.println("Det staar " + (koLapper.size()-1) +" foran deg.\n");
  }

  public void betjenKunde(){
    if (koLapper.isEmpty()){
      System.out.println("ingen er i ko");
    }
    else{
      KoLapp betjenes = koLapper.remove(0);
      System.out.println("Kunde med billettnr: " + betjenes.hentNummer()
                          + " er betjent.\n");
    }
  }

  public void printKunderIKo(){
    System.out.println("Disse er i ko: ");

    for(KoLapp koLapp : koLapper){
      System.out.print("nr." + koLapp.hentNummer() + ", ");
    }
    System.out.println("\n\n");
  }
}

import java.util.ArrayList;

class Brev{

  String avsender;
  String mottaker;
  ArrayList<String> linjer = new ArrayList<String>();

  public Brev(String fra, String til){
    avsender = fra;
    mottaker = til;
  }

  public void skrivLinje(String linje){
    linjer.add(linje);
  }

  public void lesBrev(){
    System.out.println("Hei, " + mottaker +"\n");

    for (String linje : linjer){
      System.out.println(linje);
    }
    System.out.println("\nHilsen fra,\n" + avsender);
  }
}

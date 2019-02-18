import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

class Hovedprogram{

  public static void main(String[] args) throws Exception{

    String navn;
    String linje;
    Scanner fil = new Scanner(new File("navn.txt"));

    ArrayList<Person> personer = new ArrayList<Person>();
    ArrayList<Hund> hunder = new ArrayList<Hund>();

    while (fil.hasNextLine()){
      linje = fil.nextLine();

      String[] delt = linje.split(" ");

      navn = "";
      for (int i = 1; i < delt.length; i++){
        navn += delt[i] + " ";
      }

      if (delt[0].equals("P")){
        Person p = new Person(navn);
        personer.add(p);
      }
      else if (delt[0].equals("H")){
        Hund h = new Hund(navn);
        hunder.add(h);
      }
      else{
        System.out.println("Feil format!");
      }
    }

    System.out.println("Personer:");

    for (Person person : personer){
      System.out.println(person.hentNavn());
    }

    System.out.println("\nHunder:");

    for (Hund hund : hunder){
      System.out.println(hund.hentNavn());
    }

  }
}

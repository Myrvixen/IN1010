import java.util.Scanner;
import java.io.File;


class Linjenummer{

  public static void main(String[] args) throws Exception{

    String filNavn = "fil1.txt";
    Scanner fil = new Scanner(new File(filNavn));

    int teller = 1;

    while (fil.hasNextLine()){
      System.out.println("# " + teller + ": " + fil.nextLine());
      teller++;
    }
  }
}

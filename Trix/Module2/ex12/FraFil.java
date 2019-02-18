import java.util.Scanner;
import java.io.File;


class FraFil{

  public static void main(String[] args) throws Exception{

    String filNavn = "tekst.txt";

    Scanner fil = new Scanner(new File(filNavn));

    while (fil.hasNextLine()){
      System.out.println(fil.nextLine());
    }
  }
}

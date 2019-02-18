import java.util.Scanner;
import java.io.File;

class TemperaturLeser{

  public static void main(String[] args) throws Exception{

    String[] array = new String[12];

    Scanner fil = new Scanner(new File("temperatur.txt"));

    int teller = 0;
    String linje;

    while (fil.hasNextLine()){
      linje = fil.nextLine();
      array[teller] = linje;
      teller++;
    }

    for (int i = 0; i < 12; i++){
      System.out.println(array[i]);
    }
  }
}

import java.io.*;

class Test{

  public static void main(String[] args){

    Labyrint lab1 = null;

    try{
      lab1 = Labyrint.lesFraFil(new File("3.in"));
    } catch (FileNotFoundException e){
      System.out.println("Fant ikke filen!");
    }
    Lenkeliste<String> utveier = lab1.finnUtveiFra(5,3);

    if (utveier.stoerrelse() > 0){
      System.out.println("Utveier:");
      for (String utvei : utveier){
        System.out.println(utvei);
      }
    } else {
      System.out.println("Ingen utveier.");
    }

    String lol = "(1, 2)-->(2, 2)";
    String[] deler = lol.split("-->");
    //System.out.println(deler[0] + " " +  deler[1]);
    for (String s : deler){
      System.out.println(s);
    }
  }
}

import java.util.Scanner;

class Handletur{

  public static void main(String[] args){

    int prisBroed = 20;
    int prisMelk = 15;
    int prisOst = 40;
    int prisYoghurt = 12;
    int totPris = 0;

    Scanner in = new Scanner(System.in);

    System.out.println("Hei! Velkommen til IFI-butikken.");

    System.out.println("Hvor mange broed vil du ha?");
    totPris += Integer.parseInt(in.nextLine())*prisBroed;

    System.out.println("Hvor mange melk vil du ha?");
    totPris += Integer.parseInt(in.nextLine())*prisMelk;

    System.out.println("Hvor mange ost vil du ha?");
    totPris += Integer.parseInt(in.nextLine())*prisOst;

    System.out.println("Hvor mange yoghurt vil du ha?");
    totPris += Integer.parseInt(in.nextLine())*prisYoghurt;

    System.out.println("Du skal betale: " + totPris + " kr.");
  }
}

import java.util.Scanner;

class Differanse{

  public static void main(String[] args){

    int tall1;
    int tall2;
    String lest;

    Scanner tast = new Scanner(System.in);

    System.out.println("Oppgi verdien til x:");
    lest = tast.nextLine();

    tall1 = Integer.parseInt(lest);

    System.out.println("Oppgi verdien til y:");
    lest = tast.nextLine();

    tall2 = Integer.parseInt(lest);

    System.out.println("Differanse mellom x og y: " + (tall1 - tall2));
  }
}

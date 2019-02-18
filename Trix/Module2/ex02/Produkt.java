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

    System.out.println("Produkter av x og y er:" + (tall1*tall2));

    int diff = tall1 - tall2;

    if (diff > 0){
      System.out.println("Differansen mellom x og y er positiv");
    }
    else{
      System.out.println("Differansen mellom x og y er negativ");
    }
  }
}

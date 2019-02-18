import java.util.Scanner;

class MindreStorre{

  public static void main(String[] args){

    int tall;
    String lest;

    System.out.println("Tast inn et tall: ");
    Scanner tast = new Scanner(System.in);
    lest = tast.nextLine();

    tall = Integer.parseInt(lest);

    if (tall < 10){
      System.out.println("Tallet er under 10");
    }
    else if (tall > 10 && tall < 20){
      System.out.println("Tallet er mellom 10 og 20");
    }
    else{
      System.out.println("Tallet er over 20");
    }
  }
}


class Heltallsarray{

  public static void main(String[] args){

    int tall1 = 0;
    int tall2 = 1;
    int tall3 = 2;
    int tall4 = 3;
    int tall5 = 4;

    System.out.println("Utskrift av variable:");
    System.out.println("Tall1: " + tall1);
    System.out.println("Tall2: " + tall2);
    System.out.println("Tall3: " + tall3);
    System.out.println("Tall4: " + tall4);
    System.out.println("Tall5: " + tall5);

    int[] tall = new int[5];

    for (int i = 0; i < 5; i++){
      tall[i] = i;
    }

    System.out.println("Utskrift av array:");

    for (int i = 0; i < 5; i++){
      System.out.println("tall[" + i + "] = " + tall[i]);
    }
  }
}

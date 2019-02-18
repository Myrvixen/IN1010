

class Sammenlign{

  public static void main(String[] args){
    int a;
    int b;

    a = Integer.parseInt(args[0]);
    b = Integer.parseInt(args[1]);

    if (a > b){
      System.out.println(a + " er større enn " + b);
    }
    else{
      System.out.println(a + " er ikke større enn " + b);
    }
  }
}

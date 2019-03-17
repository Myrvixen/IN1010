
class Teddy{

  public static void main(String[] args){

    System.out.println(teddy(250));
    System.out.println(teddy(42));
    System.out.println(teddy(84));
    System.out.println(teddy(53));
    System.out.println(teddy(41));
  }

  static boolean teddy(int n){

    if (n < 42){
      return false;
    } else if (n == 42){
      return true;
    }

    boolean mulig = false;
    if ((n % 2) == 0){
      mulig = teddy(n/2);
    }
    if (((n % 3) == 0 || (n % 4) == 0) && mulig == false){
      int a = n % 10;
      int b = (n % 100)/10;
      mulig = teddy(n - a*b);
    }
    if ((n % 5) == 0 && mulig == false){
      mulig = teddy(n - 42);
    }

    return mulig;
  }
}

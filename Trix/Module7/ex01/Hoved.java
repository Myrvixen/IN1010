
class Hoved{

  public static void main(String[] args){

    Katt katt1 = new Katt("Pus", 10);
    Katt katt2 = new Katt("Pusur", 5);
    Katt katt3 = new Katt("Pusen", 12);

    Katt[] katter = {katt1, katt2, katt3};

    Katt eldst = katter[0];
    for (Katt k: katter){
      if (k.compareTo(eldst) > 0){
        eldst = k;
      }
    }
    System.out.println("Eldste katt:");
    System.out.println(eldst);
  }
}

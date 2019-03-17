
class TestGraadigBeholder{

  public static void main(String[] args){

    Integer tall1 = new Integer(10);
    Integer tall2 = new Integer(20);

    Graadigbeholder<Integer> beholder = new Graadigbeholder<Integer>();
    beholder.settInn(tall1);
    System.out.println(beholder.hentNode());
    beholder.settInn(tall2);
    System.out.println(beholder.hentNode());
  }
}

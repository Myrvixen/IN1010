
class TestBeholder{

  public static void main(String[] args){

    Sirkel sirkel = new Sirkel(2);
    Kvadrat kvadrat = new Kvadrat(2);

    Beholder<Sirkel> beholder = new Beholder<>();

    beholder.settInn(sirkel);
    //beholder.settInn(kvadrat);
  }
}

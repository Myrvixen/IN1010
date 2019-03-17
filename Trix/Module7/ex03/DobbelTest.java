
class DobbelTest{

  public static void main(String[] args){

    DobbelLenke<Integer> lenke = new DobbelLenke<>();

    Integer int1 = new Integer(10);
    Integer int2 = new Integer(20);
    Integer int3 = new Integer(30);

    lenke.settInn(int1);
    lenke.settInn(int2);
    lenke.settInn(int3);

    lenke.skrivLenke();
  }
}

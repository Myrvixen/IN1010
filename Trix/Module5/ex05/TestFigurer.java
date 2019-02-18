
class TestFigurer{

  public static void main(String[] args){

    Rektangel rektangel = new Rektangel(2, 3);
    Sirkel sirkel = new Sirkel(2);

    System.out.println(rektangel.beregnAreal());
    System.out.println(rektangel.beregnOmkrets());

    System.out.println(sirkel.beregnAreal());
    System.out.println(sirkel.beregnOmkrets());

  }
}

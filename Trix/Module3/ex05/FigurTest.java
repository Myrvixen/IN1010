
class FigurTest{

  public static void main(String[] args){

    double totAreal = 0;

    Trekant trekant = new Trekant(2, 3);
    Sirkel sirkel = new Sirkel(3);
    Rektangel rektangel = new Rektangel(3, 7);
    Kvadrat kvadrat = new Kvadrat(4);

    totAreal += trekant.areal();
    totAreal += sirkel.areal();
    totAreal += rektangel.areal();
    totAreal += kvadrat.areal();

    System.out.println("Total areal: " + totAreal);

    public void figurAreal(Figur figur){
      System.out.println(figur.areal());
    }

  }
}

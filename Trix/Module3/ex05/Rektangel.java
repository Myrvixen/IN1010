
class Rektangel extends Figur{

  private double lengde;
  private double bredde;

  public Rektangel(double l, double b){
    lengde = l;
    bredde = b;
  }

  public double areal(){
    return lengde*bredde;
  }
}

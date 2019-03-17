
class Kvadrat extends Figur{

  private double side;

  public Kvadrat(double s){
    side = s;
  }

  public double areal(){
    return side*side;
  }
}

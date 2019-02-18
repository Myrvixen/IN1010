
class Sirkel implements Figur{

  private double radius;

  public Sirkel(double radius){
    this.radius = radius;
  }

  public double beregnAreal(){
    return radius*radius *Math.PI;
  }

  public double beregnOmkrets(){
    return 2*radius*Math.PI;
  }
}



class Rektangel{

  double bredde;
  double lengde;

  public Rektangel(double l, double b){
    lengde = l;
    bredde = b;
  }

  public void oekLengde(int okning){
    lengde += okning;
  }
  public void oekBredde (int okning){
    bredde += okning;
  }
  public double areal(){
    double areal = bredde*lengde;
    return areal;
  }
  public double omkrets(){
    double omkrets = 2*(lengde + bredde);
    return omkrets;
  }
  public void redLengde(int red){
    lengde -= red;
  }
  public void redBredde (int red){
    bredde -= red;
  }
}

class LagRektangeler{

  public static void main(String[] args){

    Rektangel rek1 = new Rektangel(2, 3);
    Rektangel rek2 = new Rektangel(4, 6);

    System.out.println("Areal rektangel 1: " + rek1.areal());
    System.out.println("Areal rektangel 2: " + rek2.areal());

    rek1.oekLengde(2);
    rek2.oekBredde(3);

    System.out.println("Omkrets rektangel 1: " + rek1.omkrets());
    System.out.println("Omkrets rektangel 2: " + rek2.omkrets());
  }
}

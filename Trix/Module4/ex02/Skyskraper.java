
class Skyskraper extends Bygning{

  protected int antallEtasjer;

  public Skyskraper(double bruttoAreal, int antallEtasjer){
    super(bruttoAreal);
    this.antallEtasjer = antallEtasjer;
    System.out.println("Hallo fra Skyskraper!");
  }
}

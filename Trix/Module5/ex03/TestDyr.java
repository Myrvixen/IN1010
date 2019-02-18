
class TestDyr{

  public static void main(String[] args){

    Bjorn bjorn = new Bjorn();
    Ulv ulv = new Ulv();
    Elg elg = new Elg();
    Sau sau = new Sau();

    Rovdyr[] rovdyr = new Rovdyr[2];
    Planteetere[] planteetere = new Planteetere[2];

    rovdyr[0] = bjorn;
    rovdyr[1] = ulv;

    planteetere[0] = elg;
    planteetere[1] = sau;

    bjorn.gaaPaaJakt();
    ulv.gaaPaaJakt();
    elg.beskytt();
    sau.beskytt();
  }
}

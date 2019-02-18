
class EspressoMaskin{

  private int mengdeVann;
  private int vannMax = 1000;
  private int vannEspresso = 40;
  private int vannLungo = 110;

  public void lagEspresso(){
    if (mengdeVann >= vannEspresso){
      System.out.println("Espresso laget!");
      mengdeVann -= vannEspresso;
    }
    else{
      System.out.println("Ikke nok vann, fyll på beholderen!");
    }
  }

  public void lagLungo(){
    if (mengdeVann >= vannLungo){
      System.out.println("Lungo laget!");
      mengdeVann -= vannLungo;
    }
    else{
      System.out.println("Ikke nok vann, fyll på beholderen!");
    }
  }

  public void fyllVann(int ml){
    if (mengdeVann + ml > vannMax){
      mengdeVann = vannMax;
    }
    else{
      mengdeVann += ml;
    }
  }

  public int hentMengdeVann(){
    return mengdeVann;
  }
}

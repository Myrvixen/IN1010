

class Bil {

  private String eier;
  private String merke;

  public Bil(String navn, String mrk){
    eier = navn;
    merke = mrk;
  }

  public void skrivInfo(){
    System.out.println("eier: " + eier + ", merke: " + merke);
  }
}


class TestLege{

  // Liten test for aa sjekke at exception "UlovligUtskrift" slaar ut
  // naar den skal.
  public static void main(String[] args){

    PreparatA a = new PreparatA("PilleA", 100, 10, 10);
    PreparatB b = new PreparatB("PilleB", 100, 10, 10);

    Lege lege1 = new Lege("Nope");
    Spesialist lege2 = new Spesialist("Yep", 123);

    try{
      lege1.skrivResept(a, 1, 3); // denne skal slaa ut
      lege1.skrivResept(b, 1, 3);
      lege2.skrivResept(a, 1, 3);
      lege2.skrivResept(b, 1, 3);
    } catch (UlovligUtskrift uu){
      System.out.println(uu.getMessage());
    }
  }
}

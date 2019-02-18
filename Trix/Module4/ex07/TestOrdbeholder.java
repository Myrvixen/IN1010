
class TestOrdbeholder{

  public static void main(String[] args){

    Ordbeholder o = new Ordbeholder();

    // Test 1: Sjekker at pop paa en tom liste returnerer korrekt
    if (o.pop() == null){
      System.out.println("Test 1: Riktig");
    }
    else{
      System.out.println("Test 1: Feil");
    }

    //Test 2: Sjekker at settInn returnerer riktig med et nytt ord
    if (o.settInn("Lol") == true){
      System.out.println("Test 2: Riktig");
    }
    else{
      System.out.println("Test 2: Feil");
    }

    //Test 3: Sjekker at settInn returnerer riktig med et ord allerede i lista
    if (o.settInn("Lol") == false){
      System.out.println("Test 3: Riktig");
    }
    else{
      System.out.println("Test 3: Feil");
    }

    // Test 4: Sjekker at antallOrd returnerer riktig antall
    o.settInn("Lulz");
    o.settInn("kolle");

    if (o.antallOrd() == 3){
      System.out.println("Test 4: Riktig");
    }
    else{
      System.out.println("Test 4: Feil");
    }

    // Test 5: Sjekker at pop returnerer det siste elementer i lista
    if (o.pop().equals("kolle")){
      System.out.println("Test 5: Riktig");
    }
    else{
      System.out.println("Test 5: Feil");
    }

    //Test 6: Sjekker at pop faktisk fjerner elementer
    if (o.antallOrd() == 2){
      System.out.println("Test 6: Riktig");
    }
    else{
      System.out.println("Test 6: Feil");
    }

  }
}

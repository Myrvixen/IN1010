
class BilBruk3{

  // Hovedprogram som lager et nytt Bil3-objekt, sender det inn i
  // et Person-objekt, og kaller på skrivBilNummer metoden i Person-klassen.
  public static void main(String[] args){

    Bil3 bil1 = new Bil3("AB 12345");
    Person person1 = new Person(bil1);
    person1.skrivBilNummer();
  }
}

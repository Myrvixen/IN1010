import java.util.ArrayList;
import java.util.HashMap;

class Telefonbok{

  public static void main(String[] args){

      //OPPGAVE B
      /*Person[] personer = new Person[10];

      personer[0] = new Person("Alf", "11111111", "Lol1");
      personer[1] = new Person("Tor", "22222222", "Lol2");
      personer[2] = new Person("Mikkel", "33333333", "Lol3");

      for (int i = 0; i < 10; i++){
        if (personer[i] != null){
          personer[i].skrivInfo();
        }
      }*/

      //OPPGAVE C
      /*ArrayList<Person> personer = new ArrayList<Person>();

      personer.add(new Person("Alf", "11111111", "Lol1"));
      personer.add(new Person("Tor", "22222222", "Lol2"));
      personer.add(new Person("Mikkel", "33333333", "Lol3"));

      for (Person person : personer){
        person.skrivInfo();
      }*/

      //OPPGAVE D
      HashMap<String, Person> personer = new HashMap<String, Person>();

      Person p1 = new Person("Alf", "11111111", "Lol1");
      Person p2 = new Person("Tor", "22222222", "Lol2");
      Person p3 = new Person("Mikkel", "33333333", "Lol3");

      personer.put(p1.hentNavn(), p1);
      personer.put(p2.hentNavn(), p2);
      personer.put(p3.hentNavn(), p3);

      for (Person person : personer.values()){
        person.skrivInfo();
      }
  }
}

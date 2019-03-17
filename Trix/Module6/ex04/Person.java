
class Person{

  private String navn;
  private String gjenstand;
  private Person neste = null;

  public Person(String navn, String gjenstand){
    this.navn = navn;
    this.gjenstand = gjenstand;
  }

  public void settInnNeste(Person person){
    this.neste = person;
  }

  public Person hentNeste(){
    return neste;
  }

  public String hentNavn(){
    return navn;
  }

  public String hentGjenstand(){
    return gjenstand;
  }
}


class Butikk{

  private Person foerstIKo = null;

  public void entreButikk(Person p){
    Person pNeste;
    if (foerstIKo == null){
      foerstIKo = p;
    } else {
      pNeste = foerstIKo;
      while(pNeste.hentNeste() != null){
        pNeste = pNeste.hentNeste();
      }

      pNeste.settInnNeste(p);
    }
  }

  public void kassa(){

    while (foerstIKo != null){
      System.out.println(foerstIKo.hentNavn() + " kjøper "
          + foerstIKo.hentGjenstand() + ".");
      System.out.println("- Hade bra!");
      foerstIKo = foerstIKo.hentNeste();
    }
    System.out.println("Ingen flere kunder. Vi stenger butikken for i dag.");
  }
}

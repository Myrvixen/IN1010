
class KvadratStabel{

  class Node{
    Node neste = null;
    Kvadrat data;

    Node(Kvadrat x){
      data = x;
    }
  }

  private Node start = null;
  /*
  public void leggPaa(Kvadrat kvadrat){
    Node k = start;
    while (k != null){
      k = k.neste;
    }
    k.neste = new Node(kvadrat);
  }
  */

  public void leggPaa(Kvadrat kvadrat){
    Node ny = new Node(kvadrat);
    ny.neste = start;
    start = ny;
  }

  public Kvadrat taAv(){
    if (start != null){
      Node svar = start;
      start = start.neste;
      return svar.data;
    } else {
      return null;
    }
  }

  public boolean erTom(){
    if (start == null){
      return true;
    } else {
      return false;
    }
  }
}

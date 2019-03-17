
class GeneriskStabel<T>{

  class Node{
    Node neste = null;
    T data;

    Node(T x){
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

  public void leggPaa(T x){
    Node ny = new Node(x);
    ny.neste = start;
    start = ny;
  }

  public T taAv(){
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

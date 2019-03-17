
class Stabel<T> extends Lenkeliste<T>{

  public void leggPaa(T x){

    Node node = start;

    if (start == null){
      start = new Node(x);
    } else {
      while (node.neste != null){
        node = node.neste;
      }

      node.neste = new Node(x);
    }
  }

  public T taAv(){

    Node node = start;
    Node forrige = null;

    if (start == null){
      throw new UgyldigListeIndeks(-1);

    } else if (start.neste == null){
      start = null;
      return node.data;

    } else {
      while (node.neste != null){
        forrige = node;
        node = node.neste;
      }

      forrige.neste = null;
      return node.data;
    }
  }
}

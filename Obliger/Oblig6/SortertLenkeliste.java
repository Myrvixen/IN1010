import java.util.*;

class SortertLenkeliste<T extends Comparable<T> > extends Lenkeliste<T>{

  public void leggTil(T x){

    Node node = start;
    Node nyNode = new Node(x);

    if (start == null){
      start = nyNode;
    } else if (x.compareTo(node.data) <= 0){
      nyNode.neste = start;
      start = nyNode;
    } else {
      while (node.neste != null && x.compareTo(node.neste.data) > 0){
        node = node.neste;
      }
      nyNode.neste = node.neste;
      node.neste = nyNode;
    }
  }

  public T fjern(){

    Node node = start;
    Node forrige = null;

    if (start == null){
      throw new UgyldigListeIndeks(-1);
    } else {
      while(node.neste != null){
        forrige = node;
        node = node.neste;
      }
      if (node == start){
        start = null;
        return node.data;
      } else {
        forrige.neste = null;
        return node.data;
      }
    }
  }
  @Override
  public void sett(int pos, T x){
    throw new UnsupportedOperationException();
  }
  @Override
  public void leggTil(int pos, T x){
    throw new UnsupportedOperationException();
  }
}

import java.util.*;

class Lenkeliste<T> implements Liste<T>{

  class Node {
    Node neste = null;
    T data;
    Node(T x ) { data = x;}
  }

  class LenkelisteIterator implements Iterator<T>{

    private int gjeldendeIndex = 0;

    public boolean hasNext(){
      return gjeldendeIndex < stoerrelse();
    }

    public T next(){
      return hent(gjeldendeIndex++);
    }

    public void remove(){};
  }

  protected Node start = null;

  public void leggTil(T x){
    Node nyNode = new Node(x);

    if (start == null){
      start = nyNode;
    } else {
      Node node = start;
      while (node.neste != null){
        node = node.neste;
      }
      node.neste = nyNode;
    }
  }

  public Iterator<T> iterator(){
    return new LenkelisteIterator();
  }


  public void leggTil(int pos, T x){

    Node node = start;
    Node forrige = null;
    Node nyNode = new Node(x);
    int teller = 0;

    // Tilfellet hvor pos = 0
    if (pos == 0){
      start = nyNode;
      start.neste = node;
    } else if (pos < 0){
      throw new UgyldigListeIndeks(-1);
    } else {
      while (pos > teller){
        // Har vi kommet til enden av lista før indeksen er nådd?
        if (node == null){
          throw new UgyldigListeIndeks(pos);
        } else {
         forrige = node;
         node = node.neste;
         teller++;
        }
      }
      forrige.neste = nyNode;
      nyNode.neste = node;
    }
  }

  public void sett(int pos, T x){

    Node node = start;
    Node forrige = null;
    Node nyNode = new Node(x);
    int teller = 0;

    // Tilfellet hvor pos = 0
    if (pos == 0){
      if (start != null){
        nyNode.neste = start.neste;
        start = nyNode;
      } else {
        throw new UgyldigListeIndeks(-1);
      }
    } else if (pos < 0){
      throw new UgyldigListeIndeks(-1);
    } else {
      while (pos > teller){
        // Har vi kommet til enden av lista før indeksen er nådd?
        if (node.neste == null){
          throw new UgyldigListeIndeks(pos);
        } else {
         forrige = node;
         node = node.neste;
         teller++;
        }
      }
      nyNode.neste = node.neste;
      forrige.neste = nyNode;
    }
  }

  public T fjern(){
    Node ut = start;

    if (ut == null){
      throw new UgyldigListeIndeks(-1);
    } else {
      start = start.neste;
      return ut.data;
    }
  }

  public T fjern(int pos){

    Node ut = start;
    Node forrige = null;
    int teller = 0;

    if (pos == 0){
      if (ut != null){
        start = start.neste;
        return ut.data;
      } else {
        throw new UgyldigListeIndeks(-1);
      }
    }

    while (ut != null){

      if (teller == pos){
        forrige.neste = ut.neste;
        break;
      } else {
        forrige = ut;
        ut = ut.neste;
        teller++;
      }
    }

    if (ut == null){
      throw new UgyldigListeIndeks(pos);
    }
    return ut.data;
  }

  public int stoerrelse(){

    int lengde = 0;
    Node node = start;

    while (node != null){
      node = node.neste;
      lengde++;
    }
    return lengde;
  }

  public T hent(int pos){

    Node node = start;
    int teller = 0;

    if (pos == 0){
      if (node != null){
        return node.data;
      } else {
        throw new UgyldigListeIndeks(-1);
      }
    } else if (pos < 0){
      throw new UgyldigListeIndeks(-1);
    }

    while (pos > teller){
      // Har vi kommet til enden av lista før indeksen er nådd?
      if (node.neste == null){
        throw new UgyldigListeIndeks(pos);
      } else {
       node = node.neste;
       teller++;
      }
    }

    return node.data;
  }
}

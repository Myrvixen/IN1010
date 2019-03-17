
class DobbelLenke<T>{

  class Node{
    Node forrige = null;
    Node neste = null;
    T data;

    public Node(T x){
      data = x;
    }
  }

  protected Node start = null;

  public void settInn(T element){

    Node node = start;
    Node nyNode = new Node(element);
    if (start == null){
      start = nyNode;
    } else {
      while (node.neste != null){
        node = node.neste;
      }
      node.neste = nyNode;
      nyNode.forrige = node;
    }
  }

  public void skrivLenke(){

    Node node = start;

    while (node != null){
      System.out.println(node.data);
      node = node.neste;
    }
  }
}


class Graadigbeholder<T extends Comparable<T> >{

  T node = null;
  public T settInn(T ny){
    if (node == null){
      node = ny;
      return null;
    }
    if (ny.compareTo(node) > 0){
      T ut = node;
      node = ny;
      return ut;
    } else {
      return null;
    }
  }

  public T hentNode(){
    return node;
  }
}

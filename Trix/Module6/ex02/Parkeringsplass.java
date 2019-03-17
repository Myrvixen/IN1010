
class Parkeringsplass<T>{

  private T kjoeretoy;

  public void parkerKjoeretoy(T kjoeretoy){
    this.kjoeretoy = kjoeretoy;
  }

  public T hentKjoeretoy(){

    T tmp = this.kjoeretoy;

    this.kjoeretoy = null;
    return tmp;
  }
}


class Islandshest extends Hest implements KanToelte, KanPasse{

  public Islandshest(String n, int a){
    super(n, a);
  }

  public void toelt(){
    System.out.println("Hesten toelter.");
  }

  public void pass(){
    System.out.println("Hesten passer.");
  }
}

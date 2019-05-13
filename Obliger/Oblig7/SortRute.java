
class SortRute extends Rute{

  public SortRute(int kolonne, int rad){
    super(kolonne, rad);
  }

  @Override
  public void gaa(Rute forrige, String utvei){//, Lenkeliste<Rute> besoekt){
    // Sort rute, ikke gaa hit!
    return;
  }

  public char tilTegn(){
    return '#';
  }
}

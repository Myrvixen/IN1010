import java.util.Iterator;

class EnkelArrayListe implements Iterable<String>{

  private String[] liste;
  private int maksStorrelse;
  private int storrelse = 0;

  public EnkelArrayListe(int kapasitet){
    maksStorrelse = kapasitet;
    liste = new String[kapasitet];
  }

  public void leggTil(String str){
    if (storrelse >= maksStorrelse){
      throw new IllegalStateException("Ikke plass til flere");
    }
    liste[storrelse++] = str;
  }

  public Iterator<String> iterator(){
    return new ListeIterator();
  }

  private class ListeIterator implements Iterator<String>{

    private int gjeldendeIndeks = 0;

    public String next(){
      return arr[gjeldendeIndeks++];
    }

    public boolean hasNext(){
      return gjeldendeIndeks < storrelse;
    }
  }
}

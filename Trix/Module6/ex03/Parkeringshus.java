
class Parkeringshus {
  private Parkeringsplass[] etasje1 = new Parkeringsplass[10];
  private Parkeringsplass[] etasje2 = new Parkeringsplass[10];

  public Parkeringshus() {
      for (int i = 0; i < 10; i++) {
          if (i % 2 == 0) {
               etasje1[i] = new Parkeringsplass<Bil>("123", 10);
               etasje2[i] = new Parkeringsplass<Motorsykkel>("123", 10);

          }
          etasje1[i] = new Parkeringsplass<Bil>("123", 10);
          etasje2[i] = new Parkeringsplass<Motorsykkel>("123", 10);
      }
  }

  public <T> void settInn(T kjoeretoy) {
      for (Parkeringsplass p : etasje1) {
          p.settInn(kjoeretoy);
      }
  }
}

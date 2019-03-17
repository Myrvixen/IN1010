
class Hoved{

  public static void main(String[] args){

    Parkeringsplass<Bil> park1 = new Parkeringsplass<Bil>();
    Parkeringsplass<Motorsykkel> park2 = new Parkeringsplass<Motorsykkel>();

    Bil bil = new Bil("123", 2);
    Motorsykkel sykkel = new Motorsykkel("234", 10);

    park1.parkerKjoeretoy(bil);
    park2.parkerKjoeretoy(sykkel);

  }
}

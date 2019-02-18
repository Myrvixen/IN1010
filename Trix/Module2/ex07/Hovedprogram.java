
class Hovedprogram{

  public static void main(String[] args){

    Student student1 = new Student("Joakim", 0, 0);
    Student student2 = new Student("Kristin", 10, 1);
    Student student3 = new Student("Dag", 35, 3);

    student1.leggTilQuizScore(10);
    student1.leggTilQuizScore(15);

    student2.leggTilQuizScore(10);
    student2.leggTilQuizScore(15);

    student3.leggTilQuizScore(10);
    student3.leggTilQuizScore(15);

    System.out.println("Total score for " + student1.getName() + ": "
              + student1.hentTotalScore());
    System.out.println("Gjennomsnittlig score for " + student1.getName() + ": " +
                        student1.hentGjennomsnittligScore());

    System.out.println("Total score for " + student2.getName() + ": "
              + student2.hentTotalScore());
    System.out.println("Gjennomsnittlig score for " + student2.getName() + ": " +
                        student2.hentGjennomsnittligScore());

    System.out.println("Total score for " + student3.getName() + ": "
              + student3.hentTotalScore());
    System.out.println("Gjennomsnittlig score for " + student3.getName() + ": " +
                        student3.hentGjennomsnittligScore());
  }
}

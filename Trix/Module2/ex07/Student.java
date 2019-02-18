
class Student{

  String navn;
  int score;
  int antQuizer;

  public Student(String navn, int score, int antQuizer){
    this.navn = navn;
    this.score = score;
    this.antQuizer = antQuizer;
  }

  public String getName(){
    return navn;
  }

  public void leggTilQuizScore(int score){
    this.score += score;
    antQuizer++;
  }

  public int hentTotalScore(){
    return score;
  }

  public int hentGjennomsnittligScore(){
    return score / antQuizer;
  }
}

import java.util.Scanner;
import java.io.File;

class Gruppemoete{

  private String[] navn = new String[14];
  private boolean[] oppmoete = new boolean[14];
  private int antallStudenter = 0;

  public void lesInnFil(String filNavn) throws Exception{
    Scanner fil = new Scanner(new File(filNavn));

    while (fil.hasNextLine() && antallStudenter < navn.length){
      navn[antallStudenter] = fil.nextLine();
      antallStudenter++;
    }
  }

  public void registrerOppmoete(String studentnavn){

    for (int i = 0; i <antallStudenter; i++){
      if (studentnavn.equals(navn[i])){
        oppmoete[i] = true;
      }
    }
  }

  public void skrivUtAlleOppmoette(){

    for (int i = 0; i < antallStudenter; i++){
      if (oppmoete[i]){
        System.out.println(navn[i] + " har moett.");
      }
      else{
        System.out.println(navn[i] + " har IKKE moett");
      }
    }
  }
}

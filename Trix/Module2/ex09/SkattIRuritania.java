import java.util.Scanner;

class SkattIRuritania{

  public static void main(String[] args){

    double inntekt;
    double skatt;

    Scanner in = new Scanner(System.in);

    System.out.println("Anngi inntekt: ");
    inntekt = Double.parseDouble(in.nextLine());

    if (inntekt < 10000){
      skatt = inntekt/10;
    }
    else{
      skatt = 1000 + (inntekt - 10000)*0.3;
    }

    System.out.println("Skatt på " + inntekt + " kr inntekt: " + skatt);
  }
}

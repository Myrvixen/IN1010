
public class UlovligUtskrift extends Exception{

  UlovligUtskrift(Lege lege, Legemiddel lm){
    super("Legen " +lege.hentNavn() + " har ikke lov til aa skrive ut "
          + lm.hentNavn() +".");
  }
}

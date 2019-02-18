import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

class Integrasjonstest{

  public static void main(String[] args) throws Exception{

    String filNavn = "inndata.txt";
    Scanner fil = new Scanner(new File(filNavn));

    ArrayList<Legemiddel> legemidler = new ArrayList<Legemiddel>();
    ArrayList<Lege> leger = new ArrayList<Lege>();
    ArrayList<Resept> resepter = new ArrayList<Resept>();

    String linje;

    fil.nextLine(); // Skip foerste linje

    // Finn alle legemidler i filen
    while (true){

      linje = fil.nextLine();
      if (linje.charAt(0) == '#') break;

      leggTilLegemiddel(legemidler, linje);
    }

    // Finn alle leger i filen
    while (true){

      linje = fil.nextLine();
      if (linje.charAt(0) == '#') break;

      leggTilLege(leger, linje);
    }

    // Finn alle resepter i filen (resten av linjene)
    while (fil.hasNextLine()){

      linje = fil.nextLine();
      leggTilResept(resepter, legemidler, leger, linje);
    }

    String dashes = "--------------------------------------";


    System.out.println("\n\nALLE LEGEMIDLER\n" + dashes);
    for (Legemiddel legemiddel : legemidler){
      System.out.println(legemiddel);
    }

    System.out.println("\n\nALLE LEGER\n" + dashes);
    for (Lege lege : leger){
      System.out.println(lege);
    }

    System.out.println("\n\nALLE RESEPTER\n" + dashes);
    for (Resept resept : resepter){
      System.out.println(resept);
    }

  }

  // Hjelpemetode som legger til et legemiddelet lest fra fil i legemiddel
  // arrayet.
  public static void leggTilLegemiddel(ArrayList<Legemiddel> legemidler,
    String linje){

      String[] deler = linje.split(", ");
      String navn = deler[0];
      String type = deler[1];
      int pris = Integer.parseInt(deler[2]);
      int virkestoff = Integer.parseInt(deler[3]);

      int styrke = 0;
      if (deler.length == 5){
        styrke = Integer.parseInt(deler[4]);
      }

      if (type.equals("a")){
        legemidler.add(new PreparatA(navn, pris, virkestoff, styrke));
      } else if (type.equals("b")){
        legemidler.add(new PreparatB(navn, pris, virkestoff, styrke));
      } else if (type.equals("c")){
        legemidler.add(new PreparatC(navn, pris, virkestoff));
      }
  }

  // Hjelpemetode som legger til en lege lest fra fil i lege-arrayet.
  public static void leggTilLege(ArrayList<Lege> leger, String linje){

      String[] deler = linje.split(", ");
      String navn = deler[0];
      int kontrollID = Integer.parseInt(deler[1]);

      if (kontrollID != 0){
        leger.add(new Spesialist(navn, kontrollID));
      } else {
        leger.add(new Lege(navn));
      }
  }

  // Hjelpemetode som legger til en resept lest fra fil i resept-arrayet
  public static void leggTilResept(ArrayList<Resept> resepter,
    ArrayList<Legemiddel> legemidler, ArrayList<Lege> leger, String linje){

      String[] deler = linje.split(", ");
      String type = deler[0];

      int legemiddelNummer = Integer.parseInt(deler[1]);
      Legemiddel legemiddel = legemidler.get(legemiddelNummer);

      String legeNavn = deler[2];
      Lege utskrivendeLege =null;
      for (Lege lege : leger){
        if (lege.hentNavn().equals(legeNavn)){
          utskrivendeLege = lege;
        }
      }

      int persID = Integer.parseInt(deler[3]);
      int reit = 0;
      if (deler.length == 5) reit = Integer.parseInt(deler[4]);

      if (type.equals("blaa")){
        resepter.add(new BlaaResept(legemiddel, utskrivendeLege,
          persID, reit));
      } else if (type.equals("hvit")){
        resepter.add(new HvitResept(legemiddel, utskrivendeLege,
          persID, reit));
      } else if (type.equals("prevensjon")){
        resepter.add(new PResept(legemiddel, utskrivendeLege, persID));
      } else if (type.equals("militaer")){
        resepter.add(new MilitaerResept(legemiddel, utskrivendeLege,
          persID, reit));
      }
  }
}

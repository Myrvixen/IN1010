import java.util.*;
import java.io.*;

public class Legesystem{
    // Opprett lister som lagrer objektene i legesystemet

    static Lenkeliste<Pasient> pasienter = new Lenkeliste<Pasient>();
    static Lenkeliste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
    static SortertLenkeliste<Lege> leger = new SortertLenkeliste<Lege>();
    static Lenkeliste<Resept> resepter = new Lenkeliste<Resept>();


    public static void main(String[] args){

      File fil = new File("inndata.txt");
      lesFraFil(fil);
      Scanner in = new Scanner(System.in);
      String input = "";

      while (input != "5"){
        System.out.println("\n\nVelkommen! Dine alternativer er:\n");
        System.out.println("0: Se oversikt over pasienter, leger, legemidler og resepter.");
        System.out.println("1: Opprett og legg til nytt element i systemet.");
        System.out.println("2: Bruke resept for en pasient.");
        System.out.println("3: Se statistikk.");
        System.out.println("4: Skriv data til fil.");
        System.out.println("5: Avslutt.");
        input = in.nextLine();

        if (input.equals("0")){
          skrivOversikt();

        } else if (input.equals("1")){
          opprettNyttElement();

        } else if (input.equals("2")){
          brukResept();

        } else if (input.equals("3")){
          skrivStatistikk();

        } else if (input.equals("4")){
          skrivTilFil();

        } else if(input.equals("5")){
          System.out.println("\nAvslutter...");
          System.exit(0);
        } else {
          System.out.println("Ugyldig input: " + input);
        }
      }
    }

    private static void lesFraFil(File fil){
        Scanner scanner = null;
        try{
            scanner = new Scanner(fil);
        }catch(FileNotFoundException e){
            System.out.println("Fant ikke filen, starter opp som et tomt Legesystem");
            return;
        }

        String innlest = scanner.nextLine();


        while(scanner.hasNextLine()){

            String[] info = innlest.split(" ");

            // Legger til alle pasientene i filen
            if(info[1].compareTo("Pasienter") == 0){
                while(scanner.hasNextLine()) {
                    innlest = scanner.nextLine();

                    //Om vi er ferdig med å legge til pasienter, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til legemiddler
                    if(innlest.charAt(0) == '#'){
                        break;
                    }

                    pasienter.leggTil(lesPasient(innlest));
                }

            }
            //Legger inn Legemidlene
            else if(info[1].compareTo("Legemidler") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    //Om vi er ferdig med å legge til legemidler, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til leger
                    if(innlest.charAt(0) == '#'){
                        break;
                    }

                    legemidler.leggTil(lesLegemiddel(innlest));

                }
            }
            //Legger inn leger
            else if(info[1].compareTo("Leger") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    //Om vi er ferdig med å legge til leger, bryt whileløkken,
                    //slik at vi fortsetter til koden for å legge til resepter
                    if(innlest.charAt(0) == '#'){
                        break;
                    }

                    leger.leggTil(lesLege(innlest));

                }

            }
            //Legger inn Resepter
            else if(info[1].compareTo("Resepter") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    //info = innlest.split(", ");

                     resepter.leggTil(lesResept(innlest));
                }
            }
        }
    }

    // Hjelpemetode som leser en streng, og returnerer det tilsvarende
    // Pasient-objektet.
    private static Pasient lesPasient(String innlest){

      String[] deler = innlest.split(", ");
      String navn = deler[0];
      String fnr = deler[1];
      return new Pasient(navn, fnr);
    }

    // Hjelpemetode som leser en streng, og returnerer det tilsvarende
    // Legemiddel-objektet. Returnerer 'null' hvis noe går galt.
    private static Legemiddel lesLegemiddel(String innlest){

      String[] deler = innlest.split(", ");
      String navn = deler[0];
      String type = deler[1];
      double pris = 0;
      double virkestoff = 0;

      // Sjekker at 'pris'-strengen kan konverteres til double
      try{
        pris = Double.parseDouble(deler[2]);
      } catch (NumberFormatException nfe){
        System.out.println("\nArgumentet 'pris' må være et tall!");
        return null;
      }
      // Sjekker at 'virkestoff'-strengen kan konverteres til double
      try{
        virkestoff = Double.parseDouble(deler[3]);
      } catch (NumberFormatException nfe){
        System.out.println("\nArgumentet 'virkestoff' må være et tall!");
        return null;
      }

      int styrke = 0;
      if (deler.length == 5){
        // Sjekker at 'styrke'-strengen kan konverteres til double
        try{
          styrke = Integer.parseInt(deler[4]);
        } catch (NumberFormatException nfe){
          System.out.println("\nArgumentet 'styrke' må være et heltall!");
          return null;
        }
      }

      if (type.equals("a")){
        return new PreparatA(navn, pris, virkestoff, styrke);
      } else if (type.equals("b")){
        return new PreparatB(navn, pris, virkestoff, styrke);
      } else if (type.equals("c")){
        return new PreparatC(navn, pris, virkestoff);
      } else {
        System.out.println("\nArgumentet 'type' må være enten 'a', 'b' eller 'c'!");
        return null;
      }
    }

    // Hjelpemetode som leser en streng, og returnerer det tilsvarende
    // Lege-objektet. Returnerer 'null' hvis noe går galt.
    private static Lege lesLege(String innlest){

      String[] deler = innlest.split(", ");
      String navn = deler[0];
      int kontrollID = 0;
      // Sjekker at 'kontrollID'-strengen kan konverteres til int
      try{
        kontrollID = Integer.parseInt(deler[1]);
      } catch (NumberFormatException nfe){
        System.out.println("\nArgumentet 'kontrollID' må være et heltall!");
        return null;
      }

      if (kontrollID != 0){
        return new Spesialist(navn, kontrollID);
      } else {
        return new Lege(navn);
      }
    }

    // Hjelpemetode som leser en streng, og returnerer det tilsvarende
    // Resept-objektet. Returnerer 'null' hvis noe går galt.
    private static Resept lesResept(String innlest){

      int legemiddelId = 0;
      int pasientId = 0;
      int reit = 0;
      String type = "";
      String[] info = innlest.split(", ");

      // Sjekker for info om resepttype
      if (info.length == 5){
        type = info[4];
      }

      // Sjekker at strengene kan konverteres til heltall
      try{
        legemiddelId = Integer.parseInt(info[0]);
        pasientId = Integer.parseInt(info[2]);
        reit = Integer.parseInt(info[3]);
      } catch (NumberFormatException nfe){
        System.out.println("'legemiddelID', 'pasientID' og 'reit' må være heltall!");
        return null;
      }

      Legemiddel legemiddel = finnLegemiddel(legemiddelId);
      Lege lege = finnLege(info[1]);
      Pasient pasient = finnPasient(pasientId);
      Resept resept;

      // Sjekker om noe gikk galt i lagingen av objektene
      if (legemiddel == null || lege == null || pasient == null){
        return null;
      }

      // Hvis en vanlig lege forsøker å skrive ut resept på legemiddel av typen
      // PreparatA vil UlovligUtskrift-unntaket kastes.
      try{
        if (type.equals("blaa")){
          resept = lege.skrivBlaaResept(legemiddel, pasient, reit);
        } else if (type.equals("prevensjon")){
          resept = lege.skrivPResept(legemiddel, pasient);
        } else if (type.equals("militaer")){
          resept = lege.skrivMilitaerResept(legemiddel, pasient, reit);
        } else {
          resept = lege.skrivHvitResept(legemiddel, pasient, reit);
        }
      } catch (UlovligUtskrift uu){
          System.out.println(uu.getMessage());
          return null;
      }

      return resept;
    }

    // Hjelpemetode som leter etter et legemiddel med en gitt ID i
    // legemiddel-lenkelista. Returnerer 'null' hvis det ikke ble funnet.
    private static Legemiddel finnLegemiddel(int legemiddelId){
      for (Legemiddel legemiddel : legemidler){
        if (legemiddel.hentId() == legemiddelId){
          return legemiddel;
        }
      }
      System.out.println("\nFant ikke legemiddel med ID " + legemiddelId + "!");
      return null;
    }

    // Hjelpemetode som leter etter en lege med et gitt navn i
    // lege-lenkelista. Returnerer 'null' hvis det ikke ble funnet.
    private static Lege finnLege(String navn){

      for (Lege lege : leger){
        if (navn.equals(lege.navn)){
          return lege;
        }
      }
      System.out.println("\nFant ikke legen med navn '" + navn + "'!");
      return null;
    }

    // Hjelpemetode som leter etter en pasient med en gitt ID i
    // pasient-lenkelista. Returnerer 'null' hvis det ikke ble funnet.
    private static Pasient finnPasient(int pasientId){
      for (Pasient pasient : pasienter){
        if (pasient.hentId() == pasientId){
          return pasient;
        }
      }
      System.out.println("\nFant ikke pasienten med ID " + pasientId + "!");
      return null;
    }

    // Metode som skiver ut en oversikt over alle legemidler, leger,
    // pasienter og resepter lagret i lenkelistene.
    private static void skrivOversikt(){

      String dash = "-------------------------------";

      System.out.println("\nPASIENTER:\n" + dash);
      for (Pasient pasient : pasienter){
        System.out.println(pasient);
      }


      System.out.println(dash + "\n\nLEGER:\n" + dash);
      for (Lege lege : leger){
        System.out.println(lege);
      }

      System.out.println(dash + "\n\nLEGEMIDLER:\n" + dash);
      for (Legemiddel legemiddel : legemidler){
        System.out.println(legemiddel);
      }

      System.out.println(dash + "\n\nRESEPTER:\n" + dash);
      for (Resept resept : resepter){
        System.out.println(resept);
      }
      System.out.println(dash);
    }

    // Gir brukeren mulighet til å legge til nye elementer i lenkelistene
    private static void opprettNyttElement(){

      Scanner in = new Scanner(System.in);
      String input = "";

      System.out.println("\nHvilket element vil du opprette?");
      System.out.println("0: Pasient");
      System.out.println("1: Lege");
      System.out.println("2: Legemiddel");
      System.out.println("3: Resept");

      input = in.nextLine();
      if (input.equals("0")){

        System.out.println("Pasient valgt. Angi følgende argumenter:");
        System.out.println("navn, fødselsnummer");

        input = in.nextLine();
        Pasient pasient = lesPasient(input);
        pasienter.leggTil(pasient);

        System.out.println("\nOpprettet følgende pasient:");
        System.out.println(pasient);

      } else if (input.equals("1")){

        System.out.println("Lege valgt. Angi følgende argumenter:");
        System.out.println("navn, kontrollID");

        input = in.nextLine();
        Lege lege = lesLege(input);
        // Sjekker om noe gikk galt i lesLegemiddel
        if (lege == null){
          System.out.println("Kunne ikke opprette legen!");
          return;
        }
        leger.leggTil(lege);

        System.out.println("\nOpprettet følgende lege:");
        System.out.println(lege);

      } else if (input.equals("2")){

        System.out.println("Legemiddel valgt. Angi følgende argumenter:");
        System.out.println("navn, type, pris, virkestoff [, styrke]");

        input = in.nextLine();
        Legemiddel legemiddel = lesLegemiddel(input);
        // Sjekker om noe gikk galt i lesLegemiddel
        if (legemiddel == null){
          System.out.println("Kunne ikke opprette legemiddelet!");
          return;
        }
        legemidler.leggTil(legemiddel);

        System.out.println("\nOpprettet følgende legemiddel:");
        System.out.println(legemiddel);

      } else if (input.equals("3")){

        String type;
        System.out.println("\nVelg type resept:");
        System.out.println("0: Hvit resept (standard)");
        System.out.println("1: Blaa resept");
        System.out.println("2: P-resept");
        System.out.println("3: Militaerresept");
        type = in.nextLine();

        System.out.println("\nAngi følgende argumenter:");
        System.out.println("legemiddel ID, lege navn, pasient ID, reit");

        input = in.nextLine();
        if (type.equals("0")){;}
        else if (type.equals("1")) { input += ", blaa";}
        else if (type.equals("2")) { input += ", prevensjon";}
        else if (type.equals("3")) { input += ", militaer";}
        else { System.out.println("Ugyldig input: " + type); return;}

        Resept resept = lesResept(input);
        // Sjekker om noe gikk galt i lesLegemiddel
        if (resept == null){
          System.out.println("Kunne ikke opprette resepten!");
          return;
        }
        resepter.leggTil(resept);

        System.out.println("\nOpprettet følgende resept:");
        System.out.println(resept);
      }
    }

    // Gir brukeren til å bruke en resept lagret hos en pasient.
    private static void brukResept(){

      Scanner in = new Scanner(System.in);
      String input = "";

      System.out.println("Hvilken pasient vil du se resepter for?\n");
      for (Pasient pasient : pasienter){
        System.out.println(pasient.hentId() + ": " + pasient.hentNavn()
          + " (fnr " + pasient.hentFoedselsnummer() + ").");
      }
      input = in.nextLine();
      Pasient pasient = pasienter.hent(Integer.parseInt(input));
      System.out.println("\nValgt pasient: " + pasient.hentNavn()
          + " (fnr " + pasient.hentFoedselsnummer() + ").");
      System.out.println("Hvilken resept vil du bruke?\n");

      int teller = 0;
      Stabel<Resept> pasientResepter = pasient.hentResepter();
      for (Resept resept : pasientResepter){
        System.out.println(teller + ": " + resept.legemiddel.hentNavn()
          + " (" + resept.hentReit() + " reit)");
          teller++;
      }

      if (teller == 0){
        System.out.println("Pasient " + pasient.hentNavn() + " har ingen "
          + "utskrevne resepter.");
        return;
      }

      input = in.nextLine();
      Resept resept = pasientResepter.hent(Integer.parseInt(input));
      boolean brukt = resept.bruk();

      if (brukt){
        System.out.println("Brukte resept på " + resept.legemiddel.hentNavn()
          + ". Antall gjenværende reit: " + resept.hentReit());
      } else {
        System.out.println("Kunne ikke bruke paa " + resept.legemiddel.hentNavn()
          + " (ingen gjenværende reit).");
      }
    }

    // Skriver ut diverse statisikk
    private static void skrivStatistikk(){

      Scanner in = new Scanner(System.in);
      String input = "";

      System.out.println("\nDu kan se følgende statistikker: ");
      System.out.println("0: Antall utskrevne resepter på vanedannende legemidler.");
      System.out.println("1: Antall utskrevne resepter på narkotiske legemidler.");
      System.out.println("2: Undersøk potensielt narkotisk misbruk.");

      input = in.nextLine();

      if (input.equals("0")){

        int antResepter = 0;
        for (Resept resept : resepter){
          if (resept.hentLegemiddel() instanceof PreparatB){
            antResepter++;
          }
        }
        System.out.println("\nAntall utskrevne resepter på vanedannende legemidler: "
          + antResepter);
      } else if (input.equals("1")){

        int antResepter = 0;
        for (Resept resept : resepter){
          if (resept.hentLegemiddel() instanceof PreparatA){
            antResepter++;
          }
        }
        System.out.println("\nAntall utskrevne resepter på narkotiske legemidler: "
          + antResepter);
      } else if (input.equals("2")){

        System.out.println("\nLeger som har skrevet ut narkotiske midler:\n");

        for (Lege lege : leger){
          for (Resept resept : lege.utskrevneResepter){
            if (resept.hentLegemiddel() instanceof PreparatA){
              System.out.println(lege.hentNavn());
              break;
            }
          }
        }
        int antResepter;
        System.out.println("\nPasienter med resepter på narkotiske midler:\n");

        for (Pasient pasient : pasienter){
          antResepter = 0;
          for (Resept resept : pasient.hentResepter()){
            if (resept.hentLegemiddel() instanceof PreparatA){
              antResepter++;
            }
          }
          if (antResepter > 0){
            System.out.println(pasient.hentNavn() + ", antall: " + antResepter);
          }
        }
      } else {
        System.out.println("Ugyldig input: " + input);
      }
    }

    // Skriver elementene i lenkelistene til fil, samme format som det som leses.
    private static void skrivTilFil(){

      PrintWriter f = null;
      try{
        f = new PrintWriter("data.txt");
      } catch (Exception e){
        System.out.println("Kan ikke lage filen data.txt.");
        return;
      }

      f.println("# Pasienter (navn, fnr)");

      // Loop gjennom alle pasienter
      for (Pasient pasient : pasienter){
        f.println(pasient.hentNavn() + ", " + pasient.hentFoedselsnummer());
      }

      f.println("# Legemidler (navn, type, pris, virkestoff [, styrke])");

      String navn;
      String type;
      double pris;
      double virkestoff;
      int styrke = 0;
      // Loop gjennom alle legemidler
      for (Legemiddel legemiddel : legemidler){
        navn = legemiddel.hentNavn();
        pris = legemiddel.hentPris();
        virkestoff = legemiddel.hentVirkestoff();
        if (legemiddel instanceof PreparatA){
          type = "a";
          styrke = ((PreparatA) legemiddel).hentNarkotiskStyrke();
        } else if (legemiddel instanceof PreparatB){
          type = "b";
          styrke = ((PreparatB) legemiddel).hentVanedannendeStyrke();
        } else {
          type = "c";
        }
        f.print(navn + ", " + type + ", " + pris + ", " + virkestoff);
        if (!(legemiddel instanceof PreparatC)){
          f.print(", " + styrke + "\n");
        } else {
          f.print("\n");
        }
      }

      f.println("# Leger (navn, kontrollid / 0 hvis vanlig lege)");
      // Loop gjennom leger
      for (Lege lege : leger){
        f.print(lege.hentNavn());
        if (lege instanceof Spesialist){
          f.print(", " + ((Spesialist) lege).hentKontrollID() + "\n");
        } else {
          f.print(", 0\n");
        }
      }

      int middelId;
      int pasientId;
      int reit;

      f.println("# Resepter (legemiddelNummer, legeNavn, persID, reit [, type])");
      //Loop gjennom resepter
      for (Resept resept : resepter){
        middelId = resept.legemiddel.hentId();
        navn = resept.utskrivendeLege.hentNavn();
        pasientId = resept.pasient.hentId();
        reit = resept.hentReit();
        f.print(middelId + ", " + navn + ", " + pasientId + ", " + reit);

        // Sjekk for type-informasjon, hvit er standard type og blir ikke lagt
        // til som argument. 
        if (resept instanceof BlaaResept){ f.print(", blaa\n");}
        else if (resept instanceof PResept){ f.print(", prevensjon\n");}
        else if (resept instanceof MilitaerResept){ f.print(", militaer\n");}
        else {f.print("\n");}
      }
      System.out.println("\nData skrevet til fil data.txt.");
      f.close();
    }
}

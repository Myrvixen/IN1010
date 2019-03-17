
class Lege implements Comparable<Lege>{

  protected String navn;
  protected Lenkeliste<Resept> utskrevneResepter = new Lenkeliste<Resept>();

  public Lege(String navn){
    this.navn = navn;
  }

  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit)
    throws UlovligUtskrift{

      // En vanlig lege har ikke lov til aa skrive ut resept for legemiddel
      // av type PreparatA
      if (legemiddel instanceof PreparatA){
        throw new UlovligUtskrift(this, legemiddel);
      }
      BlaaResept resept = new BlaaResept(legemiddel, this, pasient, reit);
      utskrevneResepter.leggTil(resept);
      pasient.leggTilResept(resept);

      return resept;
    }

  public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit)
    throws UlovligUtskrift{

      // En vanlig lege har ikke lov til aa skrive ut resept for legemiddel
      // av type PreparatA
      if (legemiddel instanceof PreparatA){
        throw new UlovligUtskrift(this, legemiddel);
      }
      HvitResept resept = new HvitResept(legemiddel, this, pasient, reit);
      utskrevneResepter.leggTil(resept);
      pasient.leggTilResept(resept);

      return resept;
    }

  public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit)
    throws UlovligUtskrift{

      // En vanlig lege har ikke lov til aa skrive ut resept for legemiddel
      // av type PreparatA
      if (legemiddel instanceof PreparatA){
        throw new UlovligUtskrift(this, legemiddel);
      }
      MilitaerResept resept = new MilitaerResept(legemiddel, this, pasient, reit);
      utskrevneResepter.leggTil(resept);
      pasient.leggTilResept(resept);

      return resept;
    }

  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient)
    throws UlovligUtskrift{

      // En vanlig lege har ikke lov til aa skrive ut resept for legemiddel
      // av type PreparatA
      if (legemiddel instanceof PreparatA){
        throw new UlovligUtskrift(this, legemiddel);
      }
      PResept resept = new PResept(legemiddel, this, pasient);
      utskrevneResepter.leggTil(resept);
      pasient.leggTilResept(resept);

      return resept;
    }


  public int compareTo(Lege annenLege){
    // returnerer < 0 hvis legens navn ligger alfabetisk foran
    // navnet til den andre legen.
    return navn.compareTo(annenLege.hentNavn());
  }

  public Lenkeliste<Resept> hentUtskrevneResepter(){
    return utskrevneResepter;
  }

  public String hentNavn(){
    return navn;
  }

  public String toString(){
    String str = "";
    str += "\nNavn: " + navn;
    str += "\nLege type: Vanlig";
    return str;
  }
}

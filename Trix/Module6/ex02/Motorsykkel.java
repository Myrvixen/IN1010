
class Motorsykkel{

  private String regNr;
  private int motorStoerrelse;

  public Motorsykkel(String regNr, int motorStoerrelse){
    this.regNr = regNr;
    this.motorStoerrelse = motorStoerrelse;
  }

  public String hentRegNr(){
    return regNr;
  }

  public int hentMotorStoerrelse(){
    return motorStoerrelse;
  }
}

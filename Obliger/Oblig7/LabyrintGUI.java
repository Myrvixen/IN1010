import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.event.*;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class LabyrintGUI extends Application{

  double side = 42;
  Labyrint labyrint = null;
  GridPane rutenett;
  Text statusinfo;
  ArrayList<HvittFelt> markert = new ArrayList<HvittFelt>();
  Lenkeliste<String> utveier = null;
  int antUtveier;
  int teller = 0;
  int rader;
  int kolonner;
  Button nesteknapp;
  Button forrigeknapp;

  class HvittFelt extends Button{

    char merke = ' ';
    int kolonne;
    int rad;
    double font;
    HvittFelt(int kolonne, int rad){
      super(" ");
      this.kolonne = kolonne;
      this.rad = rad;
      setPrefSize(side, side);
      font = (side/2.5);
      setFont(new Font(font));
    }

    void settMerke(char c){
      setText(""+c); merke = c;
    }

    void fjernMerke(){
      setText(" "); merke = ' ';
    }

  }

  class Klikkbehandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
      HvittFelt rute = (HvittFelt)e.getSource();
      int rad = rute.rad;
      int kolonne = rute.kolonne;

      utveier = labyrint.finnUtveiFra(rute.rad, rute.kolonne);
      antUtveier = utveier.stoerrelse();
      teller = 0;

      if (antUtveier == 0){
        fjernMarkerte();
        statusinfo.setFont(new Font(17));
        statusinfo.setText("Fant ingen løsninger!");
        nesteknapp.setVisible(false);
        forrigeknapp.setVisible(false);
      } else {
        // Vis foerste losning
        visLosning(0);
        nesteknapp.setVisible(true);
        forrigeknapp.setVisible(true);
      }
    }
  }

  class NesteLosning implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
      if (teller != antUtveier -1){
        visLosning(++teller);
      } else {
        teller = 0;
        visLosning(teller);
      }
    }
  }

  class ForrigeLosning implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
      if (teller != 0){
        visLosning(--teller);
      } else {
        teller = antUtveier - 1;
        visLosning(teller);
      }
    }
  }

  class Avslutt implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
      Platform.exit();
    }
  }

  @Override
  public void start(Stage teater){

    File fil = new FileChooser().showOpenDialog(teater);
    try{
      Scanner f = new Scanner(fil);
      labyrint = Labyrint.lesFraFil(fil);
    } catch (Exception e){}

    Rute[][] ruter = labyrint.hentBrett();
    rader = ruter.length;
    kolonner = ruter[0].length;

    // side = 42 default
    // Tilpass rutestorrelsen hvis vinduet blir for stort 
    if (side*rader > 900){
      side = 900.0/rader;
    }


    statusinfo = new Text("Velg en rute");
    statusinfo.setFont(new Font(25));
    statusinfo.setX(side*kolonner + 30); statusinfo.setY(100);

    Klikkbehandler klikk = new Klikkbehandler();

    nesteknapp = new Button("Neste");
    nesteknapp.setLayoutX(side*kolonner + 50); nesteknapp.setLayoutY(140);
    NesteLosning neste = new NesteLosning();
    nesteknapp.setOnAction(neste);
    nesteknapp.setVisible(false);

    forrigeknapp = new Button("Forrige");
    forrigeknapp.setLayoutX(side*kolonner + 120); forrigeknapp.setLayoutY(140);
    ForrigeLosning forrige = new ForrigeLosning();
    forrigeknapp.setOnAction(forrige);
    forrigeknapp.setVisible(false);

    Button avsluttknapp = new Button("Avslutt");
    avsluttknapp.setLayoutX(side*kolonner + 85); avsluttknapp.setLayoutY(180);
    Avslutt avslutt = new Avslutt();
    avsluttknapp.setOnAction(avslutt);

    rutenett = new GridPane();
    rutenett.setGridLinesVisible(true);
    for (int i = 0; i < rader; i++){
      for (int j = 0; j < kolonner; j++){
        if (ruter[i][j].tilTegn() == '.'){
          HvittFelt rute = new HvittFelt(i, j);
          rutenett.add(rute, j, i);
          rute.setOnAction(klikk);
        } else {
          Rectangle rute = new Rectangle(side, side);
          rutenett.add(rute, j, i);
        }
      }
    }
    Pane kulisser = new Pane();
    kulisser.setPrefSize(side*kolonner + 230, side*rader);
    kulisser.getChildren().add(rutenett);
    kulisser.getChildren().add(statusinfo);
    kulisser.getChildren().add(nesteknapp);
    kulisser.getChildren().add(forrigeknapp);
    kulisser.getChildren().add(avsluttknapp);

    Scene scene = new Scene(kulisser);

    teater.setTitle("Labyrint");
    teater.setScene(scene);
    teater.show();
  }

  public static void main(String[] args){
    launch(args);
  }

  /**
 * Konverterer losning-String fra oblig 5 til en boolean[][]-representasjon
 * av losningstien.
 * @param losningString String-representasjon av utveien
 * @param bredde        bredde til labyrinten
 * @param hoyde         hoyde til labyrinten
 * @return              2D-representasjon av rutene der true indikerer at
 *                      ruten er en del av utveien.
 */
  static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
      boolean[][] losning = new boolean[hoyde][bredde];
      java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
      java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
      while (m.find()) {
          int x = Integer.parseInt(m.group(1));
          int y = Integer.parseInt(m.group(2));
          losning[y][x] = true;
      }
      return losning;
  }

  public void visLosning(int nr){

    boolean[][] losning = losningStringTilTabell(utveier.hent(nr), kolonner, rader);

    // Fjern markeringer
    fjernMarkerte();

    for (int i = 0; i < rader; i++){
      for (int j = 0; j < kolonner; j++){
        if (losning[i][j]){
          HvittFelt felt = (HvittFelt) rutenett.getChildren().get(1+ kolonner*i+j);
          felt.settMerke('X');
          markert.add(felt);
        }
      }
    }

    statusinfo.setFont(new Font(20));
    statusinfo.setText("Viser løsning " + (nr+1) + "/" + antUtveier);
  }

  public void fjernMarkerte(){
    // Clean up
    for (HvittFelt felt : markert){
      felt.fjernMerke();
    }
    // Lag ny tom markert-liste
    markert = new ArrayList<HvittFelt>();
  }
}

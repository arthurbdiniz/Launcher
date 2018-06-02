package view;

import controller.*;
import helper.*;
import model.*;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Main {

  static String base_url = "http://ec2-54-233-228-194.sa-east-1.compute.amazonaws.com:3000";
  static String so_path_url = "";

  public static void main(String[] args) {

    final Gui gui = new Gui();

    Main main =  new Main();
    main.run(gui);
  }

  private static BuildObject build;
  private FileController fileController;

  private void run(Gui gui) {
    fileController = new FileController();

    updateVersion();

    if (build != null){
      try {
        fileController.validateVersion(build);
      }catch (Exception e) {

      }
    }
    gui.startButton.setEnabled(true);
    gui.loadingLabel.setVisible(false);
  }

  private static void updateVersion() {
    String os = new OSValidator().getOS();

    //Verify OS to download exe for especific system
    if(os == "win") {
      so_path_url = "/builds/latest_stable/Windows";
    } else if(os == "uni") {
      so_path_url = "/builds/latest_stable/Linux";
    } else if(os == "osx") {
      so_path_url = "/builds/latest_stable/OSX";
    } else {
      //erro
    }

    try {
        build = new RequestController().getVersionRequest(so_path_url);
    } catch(IOException | ParseException e){
      e.printStackTrace();
    }
  }
}

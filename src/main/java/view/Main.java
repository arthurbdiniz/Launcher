package view;

import controller.*;
import helper.*;
import java.io.IOException;
import java.io.File;

public class Main {

  static String base_url = "http://ec2-54-233-228-194.sa-east-1.compute.amazonaws.com:3000";
  static String so_path_url = "";

  public static void main(String[] args) {

    final Gui gui = new Gui();

    //new downloadController().downloadTask();
    download();
    // version();
    try {
      File rootDir = new File("src/build/");
      File sampleZipFile = new File("src/build/file.zip");

      new UnzipFile().unzip(sampleZipFile, rootDir);
    }catch (Exception e) {

    }
    
  }

  private static void download() {
    String os = new OSValidator().getOS();
    System.out.println(os);

    //Verify OS to download exe for especific system
    if(os == "win"){
      so_path_url = "/file_objects/79/windows.zip";
    }else if(os == "uni") {
      so_path_url = "/file_objects/80/linux.zip";
    }else if(os == "osx") {
      so_path_url = "/file_objects/81/mac.zip";
    } else {
      //erro
    }

    try {
      new JavaDownloadFileFromUrl().downloadUsingNIO(base_url + so_path_url, "src/build/file.zip");

    } catch (IOException e) {
           e.printStackTrace();
    }
  }

  private void version() {
    try {
        new RequestController().getRequest();
    } catch(IOException e){
      e.printStackTrace();
    }
  }
}

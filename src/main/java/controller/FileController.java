package controller;

import java.io.IOException;
import java.io.*;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.nio.charset.StandardCharsets;
import model.*;
import java.io.File;
import controller.*;
import java.io.IOException;
import helper.*;

public class FileController {

    static String base_url = "http://ec2-54-233-228-194.sa-east-1.compute.amazonaws.com:3000";

    public FileController() {} //Construtor

    public void validateVersion(BuildObject build) {
      String versionFromFile = readVersionFromFile();
      String versionFromSite = build.getVersion();


      if(versionFromSite.equals(versionFromFile)){
        //nothing
        System.out.println("OK");
      }else {
        //download
        System.out.println("Outdated");
        System.out.println("Updating to version " + build.getVersion());
        FileObject file = build.getFile();
        download(file.getUrl());
        unzipFolder();
        try {
            writeVersionToFile(build.getVersion());
        }catch (IOException e) {

        }

      }

    }

    private static void download(String path) {
      System.out.println("Downloading...");
      try {
        new JavaDownloadFileFromUrl().downloadUsingNIO(base_url + path, "file.zip");

      } catch (IOException e) {
             e.printStackTrace();
      }
    }

    private void unzipFolder() {
        System.out.println("Unziping");
      try {
        File rootDir = new File("download");
        File sampleZipFile = new File("file.zip");

        new UnzipFile().unzip(sampleZipFile, rootDir);
      }catch (Exception e) {

      }
    }


    private String readVersionFromFile() {
      File f = new File("ver.txt");
      try {
          List<String> lines = Files.readAllLines(Paths.get(f.getAbsolutePath()), StandardCharsets.UTF_8);
          for (String str : lines){
              System.out.println("Version: " + str);
              return str;
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
      return "";
    }

    private void writeVersionToFile(String version) throws IOException{

      File f = new File("ver.txt");
      if (f.exists()) f.delete();
      f.createNewFile();
      PrintWriter writer = new PrintWriter(f.getAbsoluteFile(), "UTF-8");
      writer.println(version);
      System.out.println("Updated to version " + version);
      writer.close();

    }
}

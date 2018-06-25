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
import view.*;

import model.*;

public class FileController {

    static String base_url = "http://ec2-18-231-174-28.sa-east-1.compute.amazonaws.com:3000";
    Gui gui = null;

    public FileController(Gui gui) {
      this.gui = gui;
    }

    public void validateVersion(BuildObject build) {
      String versionFromFile = readVersionFromFile();
      String versionFromSite = build.getVersion();


      if(versionFromSite.equals(versionFromFile)){
        //nothing
        System.out.println("OK");

      }else {
        //download
        new Thread() {
            @Override
            public void run() {
              for (int i = 0;i < 95 ; i++ ) {
                gui.progressBar.setValue(i);
                gui.progressBar.setString(i + "%");
                try {
                    Thread.sleep(100);
                }catch (Exception e) {

                }
              }

            }
        }.start();

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

      String version = "";

      if(new File("ver.txt").isFile()) {
        File f = new File("ver.txt");

        try {
            List<String> lines = Files.readAllLines(Paths.get(f.getAbsolutePath()), StandardCharsets.UTF_8);
            for (String str : lines){
                System.out.println("Version: " + str);
                version = str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

      }else {
        version = "0.0";
      }

      return version;
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

package listener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import helper.*;

public  class StartButtonListener implements ActionListener {

    private String exe_path;

    @Override
    public void actionPerformed(ActionEvent event) {

        String os = new OSValidator().getOS();

        //Verify OS to download exe for especific system
        if("win".equals(os)) {
          exe_path = "download/Build/windows/Reabilitacao-Motora";
        } else if("uni".equals(os)) {
          exe_path = "download/Build/linux/Reabilitacao-Motora.x86_64";
        } else if("osx".equals(os)) {
          exe_path = "download/Build/osx/Reabilitacao-Motora.app";
        }

        try {
          new FilePermission(exe_path).setAll(true);
          // Runtime.getRuntime().exec(exe_path);
          new ProcessBuilder(exe_path).start();
        }catch (Exception e) {

        }


    }
}

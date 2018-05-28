package listener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import helper.*;

public  class StartButtonListener implements ActionListener {

    private String exe_path;

    @Override
    public void actionPerformed(ActionEvent event) {

        String os = new OSValidator().getOS();

        //Verify OS to download exe for especific system
        if(os == "win") {
          exe_path = "src/build/Build/windows/Reabilitacao-Motora.exe";
        } else if(os == "uni") {
          exe_path = "src/build/Build/linux/Reabilitacao-Motora.x86_64";
        } else if(os == "osx") {
          exe_path = "src/build/Build/osx/Reabilitacao-Motora.app";
        } else {
          //erro
        }

        try {
          new FilePermission(exe_path).setAll(true);

          Runtime.getRuntime().exec(exe_path);
        }catch (Exception e) {

        }
    }
}

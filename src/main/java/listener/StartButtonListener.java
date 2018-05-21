package listener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public  class StartButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
              Runtime.getRuntime().exec("src/build/Build/linux/Reabilitacao-Motora.x86");
        }catch (Exception e) {

        }

    }
}

package listener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.Desktop;
import java.net.*;

import controller.*;

public  class SiteButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        URI myUri = URI.create("https://github.com/fga-gpp-mds/2018.1-Reabilitacao-Motora");

        try {
            Desktop.getDesktop().browse(myUri);
        }catch(IOException exception){

        }
    }
}

package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;
import javax.swing.Icon;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import listener.*;
import view.*;

import java.io.File;
import java.io.IOException;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Desktop;

import java.net.*;

public class Gui {

  JFrame frame;
  JPanel bottomPanel;
  JLabel gitButton;
  JButton startButton;
  JLabel loadingLabel;

  public Gui() {

    frame =  new JFrame();

    frame.setIconImage(new ImageIcon("src/drawable/icon.png").getImage());

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();
    frame.setResizable(false);
    frame.setTitle("Reabilitação Motora");
    frame.setBounds(width / 2 - 500, height / 2 - 400, 1000, 700);

    bottomPanel = new JPanel();

    BorderLayout experimentLayout = new BorderLayout();
    bottomPanel.setLayout(experimentLayout);
    bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

    BufferedImage buttonIcon = null;
    try {
      buttonIcon = ImageIO.read(new File("src/drawable/github-512.png"));

    }catch (IOException e) {
    }

    Image dimg = buttonIcon.getScaledInstance(40, 40,
        Image.SCALE_SMOOTH);

    gitButton = new JLabel(new ImageIcon(dimg));
    gitButton.setPreferredSize(new Dimension(40, 40));
    gitButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        URI myUri = URI.create("https://github.com/fga-gpp-mds/2018.1-Reabilitacao-Motora");
        try {
            Desktop.getDesktop().browse(myUri);
        }catch(IOException exception){}
      }
    });

    //gitButton.addActionListener(new SiteButtonListener());

    startButton = new JButton("INICIAR");
    startButton.addActionListener(new StartButtonListener());
    startButton.setEnabled(false);
    startButton.setPreferredSize(new Dimension(80, 40));
    startButton.setFocusPainted(false);
    startButton.setBorder(null);
    startButton.setForeground(Color.decode("#000000"));
    startButton.setBackground(Color.decode("#ffffff"));
    startButton.setFont(new Font("Gill Sans MT",Font.BOLD,14));
    startButton.setOpaque(true);

    loadingLabel =  new JLabel("Carregando...");

    bottomPanel.add(gitButton, BorderLayout.WEST);
    bottomPanel.add(loadingLabel);
    bottomPanel.add(startButton,  BorderLayout.EAST);

    bottomPanel.setBackground(new Color(240, 95, 64));

    JFXPanel jfxPanel = new JFXPanel();
    frame.add(jfxPanel, BorderLayout.CENTER);

    // Creation of scene and future interactions with JFXPanel
    // should take place on the JavaFX Application Thread
    Platform.runLater(() -> {
        WebView webView = new WebView();
        jfxPanel.setScene(new Scene(webView));
        webView.getEngine().load("https://fga-gpp-mds.github.io/2018.1-Reabilitacao-Motora/");
    });

    frame.add(bottomPanel, BorderLayout.PAGE_END);

    frame.setVisible(true);

  }

}

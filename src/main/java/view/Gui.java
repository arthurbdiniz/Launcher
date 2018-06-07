package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;
import javax.swing.Icon;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;

import listener.*;
import view.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Gui {

  JFrame frame;
  JPanel bottomPanel;
  JButton siteButton;
  JButton startButton;
  JLabel loadingLabel;

  public Gui() {

    frame =  new JFrame();

    // frame.setIconImage(new ImageIcon("test.png").getImage());

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();
    frame.setResizable(false);
    frame.setTitle("Launcher");
    frame.setBounds(width / 2 - 500, height / 2 - 400, 1000, 700);

    bottomPanel = new JPanel();

    BorderLayout experimentLayout = new BorderLayout();
    bottomPanel.setLayout(experimentLayout);
    bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

    siteButton = new JButton("Site");
    siteButton.addActionListener(new SiteButtonListener());

    startButton = new JButton("Start");
    startButton.addActionListener(new StartButtonListener());
    startButton.setEnabled(false);
    startButton.setPreferredSize(new Dimension(80, 40));

    loadingLabel =  new JLabel("Carregando...");

    bottomPanel.add(siteButton, BorderLayout.WEST);
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


    //new DrawShapes();

  }

}

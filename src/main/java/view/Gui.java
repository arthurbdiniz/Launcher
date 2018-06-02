package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;
import javax.swing.Icon;
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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

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

    FlowLayout experimentLayout = new FlowLayout();
    bottomPanel.setLayout(experimentLayout);

    siteButton = new JButton("Site");
    siteButton.addActionListener(new SiteButtonListener());

    startButton = new JButton("Start");
    startButton.addActionListener(new StartButtonListener());
    startButton.setEnabled(false);

    loadingLabel =  new JLabel("Carregando...");

    bottomPanel.add(siteButton);
    bottomPanel.add(startButton);
    bottomPanel.add(loadingLabel);

    frame.add(bottomPanel);

    frame.setVisible(true);


    //new DrawShapes();

  }

}

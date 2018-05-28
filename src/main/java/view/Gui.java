package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;

import listener.*;

public class Gui {

  JFrame frame;
  JPanel bottomPanel;
  JButton siteButton;
  JButton startButton;
  JProgressBar progressBar;

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

    progressBar = new JProgressBar(0);
    progressBar.setBounds(0, 0, 400, 50);
    progressBar.setValue(0);

    bottomPanel.add(siteButton);
    bottomPanel.add(progressBar);
    bottomPanel.add(startButton);

    frame.add(bottomPanel);

    frame.setVisible(true);

  }

}

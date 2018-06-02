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
import view.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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

    bottomPanel = new JPanel() {

      @Override
      public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //circle 1
        g.setColor(Color.ORANGE);
        g.fillOval(100, 200, 200, 200);

        //text 1
        g.setColor(Color.WHITE);
        g.drawString("Verificando",175,300);

        //line 1
        g.setColor(Color.ORANGE);
        g.drawLine(100, 300, 700, 300);

        //circle 2
        g.setColor(Color.ORANGE);
        g.fillOval(400, 200, 200, 200);

        //text 2
        g.setColor(Color.WHITE);
        g.drawString("Atualizando",475,300);

        //circle 3
        g.setColor(Color.ORANGE);
        g.fillOval(700, 200, 200, 200);

        //text 3
        g.setColor(Color.WHITE);
        g.drawString("Pronto",775,300);

      }
    };



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


    //new DrawShapes();

  }

}

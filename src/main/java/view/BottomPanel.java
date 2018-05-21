package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.Graphics;
import java.awt.Color;

import listener.*;
import java.awt.event.*;
import java.awt.FlowLayout;



public class BottomPanel extends JPanel implements ActionListener{

  JPanel bottomPanel;

  JButton siteButton;
  JButton startButton;
  JProgressBar progressBar;
  JProgressBar oprogressBar;

  public BottomPanel() {

      bottomPanel = new JPanel();

      FlowLayout experimentLayout = new FlowLayout();
      bottomPanel.setLayout(experimentLayout);

      siteButton = new JButton("Site");
      startButton = new JButton("Start");
      siteButton.addActionListener(new SiteButtonListener());
      bottomPanel.add(siteButton);
      bottomPanel.add(startButton);

      progressBar = new JProgressBar(0);
      oprogressBar = new JProgressBar(0);
      progressBar.setBounds(0, 0, 400, 50);
      oprogressBar.setBounds(0, 50, 400, 50);
      progressBar.setValue(0);
      oprogressBar.setValue(0);
      bottomPanel.add(progressBar);
      bottomPanel.add(oprogressBar);

  }

  public void actionPerformed(java.awt.event.ActionEvent evt) {

  }

  @Override
  protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       // g.setColor(Color.BLUE);
       // g.fillRect(0, 0, this.getWidth(), this.getHeight());
  }




}

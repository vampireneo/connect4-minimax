package com.xebia.xke.algo.minimax.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Use playersDir system property. ex : -DplayersDir=ui/src/main/assembly/players
 */
public class Launcher {

    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingApplication");
        ConnectFourGame app = new ConnectFourGame();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);



        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {


        }
    }
}


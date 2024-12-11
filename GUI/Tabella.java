package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class Tabella {
    private JFrame frameGioco;
    private static Dimension bordoEsterno = new Dimension(600, 600); 
    private PanelloScacchiera panelloScacchiera;

    public Tabella() {
        this.frameGioco = new JFrame("Scacchi");
        this.frameGioco.setLayout(new BorderLayout());
        JMenuBar barraMenu = inizializzaBarraMenu();
        this.frameGioco.setJMenuBar(barraMenu);
        this.frameGioco.setSize(bordoEsterno);

        this.panelloScacchiera = new PanelloScacchiera();
        this.frameGioco.add(this.panelloScacchiera, BorderLayout.CENTER );

        this.frameGioco.setVisible(true);
        
    }

    private JMenuBar inizializzaBarraMenu() {
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.add(creaFileMenu());
        return barraMenu;
    }

    private JMenu creaFileMenu() {
        JMenu fileMenu = new JMenu("File");
        JMenuItem apriPNG = new JMenuItem("Load PGN file"); 
        apriPNG.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Apri PGN");
                }
            }
        );
        fileMenu.add(apriPNG);
        return fileMenu;
    }




}

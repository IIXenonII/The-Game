package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;


import GUI.Tabella;
import GameSide.Scacchiera;


public class Tabella {
    private JFrame frameGioco;
    private static Dimension bordoEsterno = new Dimension(600, 600); 
    private PanelloScacchiera panelloScacchiera;
    public final Scacchiera scacchiera;
    private String pathDefaultIconaPezzo="arte/";
    
    public Scacchiera getScacchiera() {
        return scacchiera;
    }


    public Tabella() {
        this.frameGioco = new JFrame("Scacchi");
        this.frameGioco.setLayout(new BorderLayout());
        final JMenuBar barraMenu = inizializzaBarraMenu();
        this.frameGioco.setJMenuBar(barraMenu);
        this.frameGioco.setSize(bordoEsterno);
        this.scacchiera = Scacchiera.scacchieraStandard();
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
        JMenuItem esciMenuItem = new JMenuItem("Esci");
        esciMenuItem.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }

            }
        );
        fileMenu.add(esciMenuItem);
        return fileMenu;
    }


    public class PanelloScacchiera extends JPanel{
        private List<PanelloTile> caselleScacchiera;
        private Dimension dimensioneScacchiera= new Dimension(400, 350);

        PanelloScacchiera(){
            super(new GridLayout(8, 8));
            this.caselleScacchiera = new ArrayList<>();
            for (int i = 0; i < 64; i++) {
                PanelloTile panelloTile = new PanelloTile(this, i);
                caselleScacchiera.add(panelloTile);
                // Lo mette nella gui
                add(panelloTile);
            }
            setPreferredSize(dimensioneScacchiera);
            validate();
        }
    
    }

    private class PanelloTile extends JPanel{
        private Color chiaro = Color.decode("#FFFACD");
        private Color scuro = Color.decode("#593E1A");;
        private Dimension dimensioneTile =  new Dimension(10, 10);
        private int tileID;
        PanelloTile(PanelloScacchiera panelloScacchiera, int tileID){
            super(new GridBagLayout());
            this.tileID = tileID;
            setPreferredSize(dimensioneTile);
            assegnaColore();
            assegnaIconaPezzo(scacchiera);
            validate();

        }

        private void assegnaIconaPezzo(Scacchiera scacchiera){
            this.removeAll();
            if (scacchiera.getTile(this.tileID).isThere()) {
                
                try {
                    final BufferedImage imagine = 
                        ImageIO.read(new File(pathDefaultIconaPezzo + scacchiera.getTile(this.tileID).getPezzo().getColorePezzo().toString() + 
                        scacchiera.getTile(this.tileID).getPezzo().toString() + ".gif"));
                    this.add(new JLabel(new ImageIcon(imagine)));
                    } catch (IOException e) {
                        e.printStackTrace();
                }
                
            }
        }

        private void assegnaColore() {
            boolean isLight = ((this.tileID + this.tileID / 8) % 2 == 0);
            setBackground(isLight ? chiaro : scuro);
        }
            
    }



}



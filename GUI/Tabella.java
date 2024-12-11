package GUI;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

public class Tabella {
    private JFrame frameGioco;
    private static DimensionUIResource bordoEsterno = new DimensionUIResource(600, 600)  ; 

    public Tabella() {
        this.frameGioco = new JFrame("Scacchi");
        JMenuBar barraMenu = inizializzaBarraMenu();
        
        this.frameGioco.setSize(bordoEsterno);
        this.frameGioco.setVisible(true);
        this.frameGioco.setJMenuBar(barraMenu);
    }

    private JMenuBar inizializzaBarraMenu() {
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.add(creaFileMenu());
        return barraMenu;
    }

    private JMenu creaFileMenu() {
        JMenu fileMenu = new JMenu("File");
        JMenuItem apriPNG = new JMenuItem("Load PGN file"); 
        apriPNG.addActionListener(new Action() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Apri PGN");
            }

            @Override
            public Object getValue(String key) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getValue'");
            }

            @Override
            public void putValue(String key, Object value) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'putValue'");
            }

            @Override
            public void setEnabled(boolean b) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'setEnabled'");
            }

            @Override
            public boolean isEnabled() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'addPropertyChangeListener'");
            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'removePropertyChangeListener'");
            }
        });
        fileMenu.add(apriPNG);
        return fileMenu;
    }




}

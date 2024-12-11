package GUI;

import javax.swing.JFrame;

public class Tabella {
    private JFrame frameGioco;

    //private Dimensione bordoEsterno = new Dimensione(600, 600); 

    public Tabella() {
        this.frameGioco = new JFrame("Scacchi");
        this.frameGioco.setSize(null);
        this.frameGioco.setVisible(true);
    }
}

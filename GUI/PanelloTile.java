package GUI;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import GameSide.Strumenti;
import javax.swing.JPanel;


public class PanelloTile extends JPanel{
    private Dimension dimensioneTile =  new Dimension(10, 10);
    private int tileID;
    PanelloTile(PanelloScacchiera panelloScacchiera, int tileID){
        super(new GridBagLayout());
        this.tileID = tileID;
        setPreferredSize(dimensioneTile);
        assegnaColore();
        validate();

    }
    private void assegnaColore() {
        if () {
            
        }
        
    }
    
}

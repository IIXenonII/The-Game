package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JPanel;


public class PanelloTile extends JPanel{
    private Color chiaro = Color.decode("#FFFACD");
    private Color scuro = Color.decode("#593E1A");;
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
        boolean isLight = ((this.tileID + this.tileID / 8) % 2 == 0);
        setBackground(isLight ? chiaro : scuro);
    }

        
}

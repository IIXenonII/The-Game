package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.JPanel;

public class PanelloScacchiera extends JPanel{
    private List<PanelloTile> caselleScacchiera;
    private Dimension dimensioneScacchiera= new Dimension(400, 350);

    public PanelloScacchiera(){
        super(new GridLayout(8, 8));
        this.caselleScacchiera = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            PanelloTile panelloTile = new PanelloTile();
            caselleScacchiera.add(panelloTile);
            // Lo mette nella gui
            add(panelloTile);
        }
        setPreferredSize(dimensioneScacchiera);
        validate();
    }
    
}

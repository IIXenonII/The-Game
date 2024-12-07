import java.util.ArrayList;
import java.util.List;

public class Pedone extends Pezzo {

    private int[] possibiliMosse = {8, 16, 7 ,9};

    public Pedone(int posizionePezzo, Colore colorePezzo) {
        super(posizionePezzo, colorePezzo);
    }

    @Override
    public List<Mossa> calcolaSeMossaELegale(Scacchiera board) {
        List<Mossa> mosseLegali = new ArrayList<>();

        int posizioneMossaLegale;
        for(int offset : possibiliMosse){
            posizioneMossaLegale = this.getPosizionePezzo() + (this.getColorePezzo().getDirezione() * offset);
            
            if (!isPosizineLegale(posizioneMossaLegale)) {
                continue;
            }

            if (offset == 8 && board.getTile(posizioneMossaLegale).getClass().equals(TileEmpty.class)) {
                mosseLegali.add(new MossaMovimento(board, this, posizioneMossaLegale));
                // to be continued (promozine e en passant)
            }
            else if (offset == 16 && this.isPrimaMossa() && 
                    (Strumenti.SecondaRiga[this.getPosizionePezzo()] && this.getColorePezzo().isNero() ||
                    Strumenti.SecondaRiga[this.getPosizionePezzo()] && this.getColorePezzo().isBianco()) ) {
                    // vedo se tra il salto c'è qualche pezzo
                int posizioneIntermedia = this.getPosizionePezzo() + (this.getColorePezzo().getDirezione()* 8);
                if (board.getTile(posizioneMossaLegale).getClass().equals(TileEmpty.class) && 
                board.getTile(posizioneIntermedia).getClass().equals(TileEmpty.class)) {
                    mosseLegali.add(new MossaMovimento(board, this, posizioneMossaLegale));

                            
                }
            }
            else if (offset == 7 &&
                    // se sei un pedone nero alla ottava colanna pui attacare nel offset 7 mentre se sei bianco no pui 
                    // e vice versa nella prima colonna 
                    !(Strumenti.OttavaColonna[this.getPosizionePezzo()] && this.getColorePezzo().isBianco() || 
                    Strumenti.PrimaColonna[this.getPosizionePezzo()] && this.getColorePezzo().isNero())){
                if (board.getTile(posizioneMossaLegale).getClass().equals(TileOccupiade.class)) {
                    Pezzo pezzoAttacato = board.getTile(posizioneMossaLegale).getPezzo();
                    if (this.getColorePezzo() != pezzoAttacato.getColorePezzo()) {
                        mosseLegali.add(new MossaAttacante(board, this, posizioneMossaLegale, pezzoAttacato));
                    }
                }

            }
            else if (offset == 9 && 
                    // stessa cosa di prima ma senza il not
                    !(Strumenti.OttavaColonna[this.getPosizionePezzo()] && this.getColorePezzo().isNero() || 
                    Strumenti.PrimaColonna[this.getPosizionePezzo()] && this.getColorePezzo().isBianco())) {
                if (board.getTile(posizioneMossaLegale).getClass().equals(TileOccupiade.class)) {
                    Pezzo pezzoAttacato = board.getTile(posizioneMossaLegale).getPezzo();
                    if (this.getColorePezzo() != pezzoAttacato.getColorePezzo()) {
                        mosseLegali.add(new MossaAttacante(board, this, posizioneMossaLegale, pezzoAttacato));
                    }
                }
                
            }
        
        }

        return mosseLegali;
    }
    
}

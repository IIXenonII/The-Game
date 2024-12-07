import java.util.ArrayList;
import java.util.List;

public class Torre extends Pezzo{
    private int[] possibiliMosse = {1, -1, 8, -8};

    public Torre(int posizionePezzo, Colore colorePezzo) {
        super(posizionePezzo, colorePezzo);
    }

    @Override
    public List<Mossa> calcolaSeMossaELegale(Scacchiera board) {
        List<Mossa> mosseLegali = new ArrayList<>();
        int posizioneMossaLegale;
        for(int offset : possibiliMosse){
            posizioneMossaLegale= this.getPosizionePezzo();
            while (isPosizineLegale(posizioneMossaLegale)) {
                posizioneMossaLegale+= offset;
                Tile destinazioneValida = board.getTile(posizioneMossaLegale); // data la posizione mi da la casella che lo indica
                // checa se quella casella non e occupata o
                if (!destinazioneValida.getClass().equals(TileOccupiade.class)) {
                    mosseLegali.add(new MossaMovimento(board, this, posizioneMossaLegale));
                }
                else{
                    Pezzo pezzoDestinazione = destinazioneValida.getPezzo();
                    if (this.getColorePezzo() != pezzoDestinazione.getColorePezzo()) {
                        mosseLegali.add(new MossaAttacante(board, this, posizioneMossaLegale, pezzoDestinazione));
                        // come uccidere pezzo
                        // to be continued
                    }
                    break; // faccio break dato che se in mezzo alla linea obliqua c'è un pezzo non posso oltre passarlo
                };
            }
        }



        return mosseLegali;
    }
    
}

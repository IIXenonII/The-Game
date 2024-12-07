import java.util.ArrayList;
import java.util.List;

public class Alfiere extends Pezzo {
    private int[] possibiliMosse = {-9, -7, 7, 9};

    public Alfiere(int posizionePezzo, Colore colorePezzo) {
        super(posizionePezzo, colorePezzo);
    }

    @Override
    public List<Mossa> calcolaSeMossaELegale(Scacchiera board) {
        List<Mossa> mosseLegali = new ArrayList<>();

        int posizioneMossaLegale;
        for (int offset : possibiliMosse) {
            posizioneMossaLegale = this.getPosizionePezzo();

            while (isPosizineLegale(offset)) {
                // aggiungo alla posizine di partezza l'offset
                posizioneMossaLegale+= offset;

                if (isPosizineLegale(posizioneMossaLegale)) {

                    if (isPrimaColonnaEsclusa(this.getPosizionePezzo(), offset) || isOttavaColonnaEsclusa(this.getPosizionePezzo(), offset)) {
                        break;
                    }
                    
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
            
        }
        return mosseLegali;
    }

    private boolean isPrimaColonnaEsclusa(int posizione_Del_Pezzo, int offset){
        // se la posizione e 0,8,16, ecc non cosideriamo alcuni offset
        return Strumenti.PrimaColonna[posizione_Del_Pezzo]  && ((offset == -9) || (offset == +7));
    }

    private boolean isOttavaColonnaEsclusa(int posizione_Del_Pezzo, int offset){
        // se la posizione e 7,15,23, ecc non cosideriamo alcuni offset
        return Strumenti.OttavaColonna[posizione_Del_Pezzo]  && ((offset == 9) || (offset == -7));
    }


}

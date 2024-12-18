package GameSide;

import java.util.ArrayList;
import java.util.List;

public class Regina extends Pezzo {

    private int[] possibiliMosse= {-9, -7, 7, 9, 1, -1, 8, -8};

    public Regina(int posizionePezzo, Colore colorePezzo) {
        super(posizionePezzo, colorePezzo);
    }

    @Override
    public List<Mossa> calcolaSeMossaELegale(Scacchiera board) {
        List<Mossa> mosseLegali = new ArrayList<>();
        int posizioneMossaLegale;
        for(int offset : possibiliMosse){

            posizioneMossaLegale= this.getPosizionePezzo();
            while (isPosizineLegale(posizioneMossaLegale)) {
                if (isPrimaColonnaEsclusa(this.getPosizionePezzo(), offset) || isOttavaColonnaEsclusa(this.getPosizionePezzo(), offset)) {
                    break;
                }
                posizioneMossaLegale+= offset;
                if (isPosizineLegale(posizioneMossaLegale)) {
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
        return Strumenti.PrimaColonna[posizione_Del_Pezzo]  && ((offset == -9) || (offset == +7) || (offset == -1));
    }

    private boolean isOttavaColonnaEsclusa(int posizione_Del_Pezzo, int offset){
        // se la posizione e 7,15,23, ecc non cosideriamo alcuni offset
        return Strumenti.OttavaColonna[posizione_Del_Pezzo]  && ((offset == 9) || (offset == -7) || (offset == +1));
    }
    @Override
    public String toString() {
        return  TipoPezzo.REGINE.toString();
    }

    public Regina muoviPezzo(Mossa mossa) {
        return new Regina(mossa.getDestinazionePezzo(), mossa.getPezzoMosso().getColorePezzo());
    }
    
}

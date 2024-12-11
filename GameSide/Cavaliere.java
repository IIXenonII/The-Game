package GameSide;

import java.util.ArrayList;
import java.util.List;

public class Cavaliere extends Pezzo {

    private int[] possibiliMosse = {-17, -15, -10, -6, 6, 10, 15, 17};
    // se numero ogni casella in una scacchiera il massimo numero di mosse che un cavaliere puo fare e 8 
    // e questa posizione e meno o piu quei numeri dalla posizione del cavaliere

    public Cavaliere(int posizionePezzo, Colore colorePezzo) {
        super(posizionePezzo, colorePezzo);
    }

    @Override
    public List<Mossa> calcolaSeMossaELegale(Scacchiera board) {
        List<Mossa> mosseLegali = new ArrayList<>();
        int posizioneMossaLegale;
        
        for (int i : possibiliMosse) {
            posizioneMossaLegale = this.getPosizionePezzo() + i;

            if(isPosizineLegale(posizioneMossaLegale)){

                if (isPrimaColonnaEsclusa(this.getPosizionePezzo(), i) || 
                    isSecondaColonnaEsclusa(this.getPosizionePezzo(), i) ||
                    isSettimaColonnaEsclusa(this.getPosizionePezzo(), i) || 
                    isOttavaColonnaEsclusa(this.getPosizionePezzo(), i)) {
                    continue;
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
                    };
                }
            }

        return mosseLegali;
    }

    @Override
    public String toString() {
        return  TipoPezzo.CAVALIERE.toString();
    }

    private boolean isPrimaColonnaEsclusa(int posizione_Del_Pezzo, int offset){
        // se la posizione e 0,8,16, ecc non cosideriamo alcuni offset
        return Strumenti.PrimaColonna[posizione_Del_Pezzo]  && ((offset == -17) || (offset == -10) || (offset == 6) || (offset == 15));
    }

    private boolean isSecondaColonnaEsclusa(int posizione_Del_Pezzo, int offset){
        // se la posizione e 1,9,17, ecc non cosideriamo alcuni offset
        return Strumenti.SecondaColonna[posizione_Del_Pezzo]  && ((offset == -10) ||  (offset == 6) );
    }

    private boolean isSettimaColonnaEsclusa(int posizione_Del_Pezzo, int offset){
        // se la posizione e 6,14,22, ecc non cosideriamo alcuni offset
        return Strumenti.SettimaColonna[posizione_Del_Pezzo]  && ((offset == +10) ||  (offset == -6) );
    }

    private boolean isOttavaColonnaEsclusa(int posizione_Del_Pezzo, int offset){
        // se la posizione e 7,15,23, ecc non cosideriamo alcuni offset
        return Strumenti.OttavaColonna[posizione_Del_Pezzo]  && ((offset == +17) || (offset == +10) || (offset == -6) || (offset == -15));
    }
    public Cavaliere muoviPezzo(Mossa mossa) {
        return new Cavaliere(mossa.getDestinazionePezzo(), mossa.getPezzoMosso().getColorePezzo());
    }
    
}

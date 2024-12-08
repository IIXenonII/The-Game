import java.util.ArrayList;
import java.util.List;

public class Re extends Pezzo {
    private int[] possibiliMosse= {-1, -9, -8, -7, 1, 7, 8, 9};

    public Re(int posizionePezzo, Colore colorePezzo) {
        super(posizionePezzo, colorePezzo);
    }

    @Override
    public List<Mossa> calcolaSeMossaELegale(Scacchiera board) {
        List<Mossa> mosseLegali = new ArrayList<>();
        int posizioneMossaLegale;
        for(int offset : possibiliMosse){
            if (isPrimaColonnaEsclusa(this.getPosizionePezzo(), offset) || isOttavaColonnaEsclusa(this.getPosizionePezzo(), offset)) {
                continue;
            }
            posizioneMossaLegale = this.getPosizionePezzo() + offset;
            if (isPosizineLegale(posizioneMossaLegale)) {
                if (board.getTile(posizioneMossaLegale).getClass().equals(TileEmpty.class)) {
                    mosseLegali.add(new MossaMovimento(board, this, posizioneMossaLegale));
                }else{
                    Pezzo pezzoAttacato = board.getTile(posizioneMossaLegale).getPezzo();
                    if (this.getColorePezzo() != pezzoAttacato.getColorePezzo()) {
                        mosseLegali.add(new MossaAttacante(board, this, posizioneMossaLegale, pezzoAttacato));
                    }

                }
            }

            
        }

        return mosseLegali;
    }

    private boolean isPrimaColonnaEsclusa(int posizione_Del_Pezzo, int offset){
        // se la posizione e 0,8,16, ecc non cosideriamo alcuni offset
        return Strumenti.PrimaColonna[posizione_Del_Pezzo]  && ((offset == -9) || (offset == 7) || (offset == -1));
    }

    private boolean isOttavaColonnaEsclusa(int posizione_Del_Pezzo, int offset){
        // se la posizione e 7,15,23, ecc non cosideriamo alcuni offset
        return Strumenti.OttavaColonna[posizione_Del_Pezzo]  && ((offset == 9) || (offset == -7) || (offset == +1));
    }
    @Override
    public String toString() {
        return  TipoPezzo.RE.toString();
    }
    
}

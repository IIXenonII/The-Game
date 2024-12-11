package GameSide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GiocatoreNero  extends Giocatore{
    
    public GiocatoreNero(Scacchiera board, Collection<Mossa> mosseLegali, Collection<Mossa> mosseLegaliAvversario) {
        super(board, mosseLegali, mosseLegaliAvversario);
    }

    @Override
    public Collection<Pezzo> getPezziAttivi() {
        return this.board.getPezziNeri();
    }

    @Override
    public Colore getColore() {
        return Colore.NERO;
    }

    @Override
    public Giocatore getAvversario() {
        return this.board.getGiocatoreBianco();
    }

    @Override
    public Collection<Mossa> calcolaReArrocato(Collection<Mossa> giocateLegali,
            Collection<Mossa> giocateAversarioLegali) {
        List<Mossa> reArrocato = new ArrayList<>();

        if (this.reGiocatore.isPrimaMossa() && !this.isScacco()) {

            // Dalla parte del Re
            // vedo se ce tra il re e la torre ci sono dei pezzi
            if (!this.board.getTile(5).isThere() && this.board.getTile(6).isThere() ) {
                Tile torre= this.board.getTile(7);
                if (torre.isThere() &&  torre.getPezzo().isPrimaMossa()){
                    if (Giocatore.calcolaSeAttacciCassella(5, this.getAvversario().getMosseLegali()).isEmpty()&&
                    Giocatore.calcolaSeAttacciCassella(6, this.getAvversario().getMosseLegali()).isEmpty() && 
                    torre.getPezzo().getClass() == Torre.class) {
                        reArrocato.add(new MossaArrocoDaRe(this.board, this.reGiocatore, 6, (Torre)torre.getPezzo(), torre.cordTile, 5));
                    }
                    
                }
            }
            // Dalla parte della Regina
            if (!this.board.getTile(1).isThere() && this.board.getTile(2).isThere() && this.board.getTile(3).isThere() ) {
                Tile torre= this.board.getTile( 0);
                if (torre.isThere() &&  torre.getPezzo().isPrimaMossa()){
                    reArrocato.add(new MossaArrocoDaRe(this.board, this.reGiocatore, 2, (Torre)torre.getPezzo(), torre.cordTile, 3));
                }
            }
        }


        return reArrocato;
    }
    

}

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GiocatoreBianco extends Giocatore {

    public GiocatoreBianco(Scacchiera board, Collection<Mossa> mosseLegali, Collection<Mossa> mosseLegaliAvversario) {
        super(board, mosseLegali, mosseLegaliAvversario);
    }

    @Override
    public Collection<Pezzo> getPezziAttivi() {
        return this.board.getPezziBianchi();
    }

    @Override
    public Colore getColore() {
        return Colore.BIANCO;
    }

    @Override
    public Giocatore getAvversario() {
        return this.board.getGiocatoreNero();
    }

    @Override
    public Collection<Mossa> calcolaReArrocato(Collection<Mossa> giocateLegali,
            Collection<Mossa> giocateAversarioLegali) {
        List<Mossa> reArrocato = new ArrayList<>();

        if (this.reGiocatore.isPrimaMossa() && !this.isScacco()) {

            // Dalla parte del Re
            // vedo se ce tra il re e la torre ci sono dei pezzi
            if (!this.board.getTile(61).isThere() && this.board.getTile(62).isThere() ) {
                Tile torre= this.board.getTile(63);
                if (torre.isThere() &&  torre.getPezzo().isPrimaMossa()){
                    if (Giocatore.calcolaSeAttacciCassella(61, this.getAvversario().getMosseLegali()).isEmpty()&&
                    Giocatore.calcolaSeAttacciCassella(63, this.getAvversario().getMosseLegali()).isEmpty() && 
                    torre.getPezzo().getClass() == Torre.class) {
                        reArrocato.add(new MossaArrocoDaRe(this.board, this.reGiocatore, 62, (Torre)torre.getPezzo(), torre.getCordTile(), 61));
                    }
                    
                }
            }
            // Dalla parte della Regina
            if (!this.board.getTile(57).isThere() && this.board.getTile(58).isThere() && this.board.getTile(59).isThere() ) {
                Tile torre= this.board.getTile(56);
                if (torre.isThere() &&  torre.getPezzo().isPrimaMossa()){
                    reArrocato.add(new MossaArrocoDaRegina(this.board, this.reGiocatore, 58, (Torre)torre.getPezzo(), torre.getCordTile(), 59));
                }
            }
        }


        return reArrocato;
    }
    

}

import java.util.Collection;

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
    

}

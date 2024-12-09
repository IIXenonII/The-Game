import java.util.Collection;

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
    

}

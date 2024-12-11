package GameSide;

public class MossaPedoneSalto extends Mossa{
    public MossaPedoneSalto(Scacchiera scacchiera, Pezzo pezzoMosso, int destinazionePezzo) {
        super(scacchiera, pezzoMosso, destinazionePezzo);
    }

    @Override
    protected Scacchiera eseguisci() {
        Costruttore costruttore = new Costruttore();
        for (Pezzo pezzo : this.scacchiera.getGiocatoreAdesso().getPezziAttivi()) {
            if (!this.pezzoMosso.equals(pezzo)){
                costruttore.setPezzo(pezzo);
            }
        }
        for (Pezzo pezzo : this.scacchiera.getGiocatoreAdesso().getAvversario().getPezziAttivi()) {
            costruttore.setPezzo(pezzo);
        }
        Pedone pedoneMosso = (Pedone)this.pezzoMosso.muoviPezzo(this);
        costruttore.setPezzo(pedoneMosso);
        costruttore.setEnPassantPedone(pedoneMosso);
        costruttore.setProssimoMuovere(this.scacchiera.getGiocatoreAdesso().getAvversario().getColore());

        return costruttore.crea();
    }    
    
}

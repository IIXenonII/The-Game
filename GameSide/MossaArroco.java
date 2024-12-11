package GameSide;

public abstract class MossaArroco extends Mossa {
    protected Torre torreArroco;
    protected int torrePartenza;
    protected int torreDestinazione;

    public MossaArroco(Scacchiera scacchiera, Pezzo pezzoMosso, int destinazionePezzo, Torre torreArroco,
            int torrePartenza, int torreDestinazione) {
        super(scacchiera, pezzoMosso, destinazionePezzo);
        this.torreArroco = torreArroco;
        this.torrePartenza = torrePartenza;
        this.torreDestinazione = torreDestinazione;
    }
    
    public Torre getTorreArroco() {
        return torreArroco;
    }

    @Override
    public boolean isMossaArroco() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    protected Scacchiera eseguisci() {
        Costruttore costruttore = new Costruttore();
        for (Pezzo pezzo : this.scacchiera.getGiocatoreAdesso().getPezziAttivi()){
            if (!this.pezzoMosso.equals(pezzo) && !this.torreArroco.equals(pezzo) ) {
                costruttore.setPezzo(pezzo);
            }
        }
        for (Pezzo pezzo : this.scacchiera.getGiocatoreAdesso().getAvversario().getPezziAttivi()) {
            costruttore.setPezzo(pezzo);
        }
        costruttore.setPezzo(this.pezzoMosso.muoviPezzo(this));
        costruttore.setPezzo(new Torre(this.destinazionePezzo, this.scacchiera.getGiocatoreAdesso().getAvversario().getColore()));
        costruttore.setProssimoMuovere(this.scacchiera.getGiocatoreAdesso().getAvversario().getColore());

        return super.eseguisci();
    }

    
}

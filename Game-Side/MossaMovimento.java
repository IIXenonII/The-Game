public class MossaMovimento extends Mossa {
    public MossaMovimento(Scacchiera scacchiera, Pezzo pezzoMosso, int destinazionePezzo) {
        super(scacchiera, pezzoMosso, destinazionePezzo);
        
    }

    @Override
    protected Scacchiera eseguisci() {
        Costruttore costruttore = new Costruttore();
        for (Pezzo pezzo : this.scacchiera.getGiocatoreAdesso().getPezziAttivi()) {
            if (!this.pezzoMosso.equals(pezzo)) {
                costruttore.setPezzo(pezzo); 
            }
        }

        for (Pezzo pezzo : this.scacchiera.getGiocatoreAdesso().getAvversario().getPezziAttivi()) {
            if (!this.pezzoMosso.equals(pezzo)) {
                costruttore.setPezzo(pezzo);
            }
        }
        // muovo il pezzo
        costruttore.setPezzo(this.pezzoMosso.muoviPezzo(this));
        // dico che il prossimo ha muovere è aversario
        costruttore.setProssimoMuovere(this.scacchiera.getGiocatoreAdesso().getAvversario().getColore());

        return costruttore.crea();

        

        
    } 
    
}

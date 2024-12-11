package GameSide;

public abstract class Mossa {
    protected Scacchiera scacchiera;
    protected Pezzo pezzoMosso;
    protected int destinazionePezzo;

    public static MossaNulla mossaNulla = new MossaNulla();


    public Mossa(Scacchiera scacchiera, Pezzo pezzoMosso, int destinazionePezzo) {
        this.scacchiera = scacchiera;
        this.pezzoMosso = pezzoMosso;
        this.destinazionePezzo = destinazionePezzo;
    }

    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mossa)) {
            return false;
        }
        Mossa mossaObj = (Mossa) obj;
        return this.getCordinataAdesso() == mossaObj.getCordinataAdesso() && this.getDestinazionePezzo() == mossaObj.getDestinazionePezzo()
                && this.getPezzoMosso().equals(mossaObj.getPezzoMosso());
    }

    public boolean isAttacco(){
        return false;
    }

    public boolean isMossaArroco(){
        return false;
    }

    public Pezzo getPezzoAttacato(){
        return null;
    }

    public int getCordinataAdesso(){
        return this.getPezzoMosso().getPosizionePezzo();
    }

    public int getDestinazionePezzo() {
        return destinazionePezzo;
    }

    public Pezzo getPezzoMosso() {
        return pezzoMosso;
    }
    protected Scacchiera eseguisci() {
        Costruttore costruttore = new Costruttore();
        for (Pezzo pezzo : this.scacchiera.getGiocatoreAdesso().getPezziAttivi()) {
            // se il pezzo non e quello che e stato messo allora lo copio sulla nuova scacchiera
            if (!this.pezzoMosso.equals(pezzo)) {
                costruttore.setPezzo(pezzo); 
            }
        }

        for (Pezzo pezzo : this.scacchiera.getGiocatoreAdesso().getAvversario().getPezziAttivi()) {
            // stessa cosa di prima con i pezzi del aversario
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

public abstract class Mossa {
    protected Scacchiera scacchiera;
    protected Pezzo pezzoMosso;
    protected int destinazionePezzo;


    public Mossa(Scacchiera scacchiera, Pezzo pezzoMosso, int destinazionePezzo) {
        this.scacchiera = scacchiera;
        this.pezzoMosso = pezzoMosso;
        this.destinazionePezzo = destinazionePezzo;
    }

    public int getDestinazionePezzo() {
        return destinazionePezzo;
    }

    protected abstract Scacchiera eseguisci();


    public Pezzo getPezzoMosso() {
        return pezzoMosso;
    }
}

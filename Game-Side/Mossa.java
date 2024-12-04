public abstract class Mossa {
    private Scacchiera scacchiera;
    private Pezzo pezzoMosso;
    private int destinazionePezzo;

    public Mossa(Scacchiera scacchiera, Pezzo pezzoMosso, int destinazionePezzo) {
        this.scacchiera = scacchiera;
        this.pezzoMosso = pezzoMosso;
        this.destinazionePezzo = destinazionePezzo;
    }
    
}

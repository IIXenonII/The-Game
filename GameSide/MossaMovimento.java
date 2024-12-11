package GameSide;

public class MossaMovimento extends Mossa {
    public MossaMovimento(Scacchiera scacchiera, Pezzo pezzoMosso, int destinazionePezzo) {
        super(scacchiera, pezzoMosso, destinazionePezzo);
        
    }

    @Override
    protected Scacchiera eseguisci() {
        return null;        
    } 
    
}

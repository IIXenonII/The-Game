public class MossaAttacante extends Mossa {
    private Pezzo pezzoAttacato;

    public MossaAttacante(Scacchiera scacchiera, Pezzo pezzoMosso, int destinazionePezzo, Pezzo pezzoAttacato) {
        super(scacchiera, pezzoMosso, destinazionePezzo);
        this.pezzoAttacato = pezzoAttacato;
        
    }

    @Override
    protected Scacchiera eseguisci() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eseguisci'");
    } 
    
}

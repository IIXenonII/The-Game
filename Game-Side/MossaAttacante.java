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


    public boolean isAttacco(){
        return true;
    }
    @Override
    public Pezzo getPezzoAttacato(){
        return this.pezzoAttacato;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof MossaAttacante)) {
            return false;
        }
        MossaAttacante questo = (MossaAttacante)obj;
        return super.equals(obj) && this.getPezzoAttacato().equals(questo.getPezzoAttacato());
    }
}

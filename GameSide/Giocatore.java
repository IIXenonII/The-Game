package GameSide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Giocatore {
    public Scacchiera board;
    private Collection<Mossa> mosseLegali;
    
    protected Re reGiocatore;

    private boolean scacco;

    public Giocatore(Scacchiera board, Collection<Mossa> mosseLegali, Collection<Mossa> mosseLegaliAvversario) {
        this.board = board;
        this.reGiocatore = this.confermaRe();
        mosseLegali.addAll(calcolaReArrocato(mosseLegali, mosseLegaliAvversario));
        this.mosseLegali = mosseLegali;
        
        // vede se ci sono nella lista di mosse avversarie delle mosse che puntano dove è il re
        this.scacco = !Giocatore.calcolaSeAttacciCassella(this.reGiocatore.getPosizionePezzo(), mosseLegaliAvversario).isEmpty();        
    }
        
    protected static Collection<Mossa> calcolaSeAttacciCassella(int posizionePezzo, Collection<Mossa> mosse){
        List<Mossa> mosseAttacanti = new ArrayList<>();
        for (Mossa m : mosse) {
            if (posizionePezzo == m.getDestinazionePezzo()) {
                mosseAttacanti.add(m);
            }
        }
        return mosseAttacanti;
    }

    public Re confermaRe() {
        for (Pezzo pezzo : this.getPezziAttivi()){
            if (pezzo.getClass() == Re.class) {
                return (Re)pezzo; 
            }
        }
        throw new RuntimeException("Error non hai un Re");
    }

    public boolean IsMossaLegale(Mossa mossa){
        return this.mosseLegali.contains(mossa);
    }

    public boolean isScacco(){
        return this.scacco;
    }

    public boolean isScaccoMatto(){
        return this.isScacco() && !mosseScappo();
    }

    private boolean mosseScappo(){
        for (Mossa mossa : this.mosseLegali) {
            Transizione transizione = faiMossaTransizione(mossa);
            if (transizione.getStatusMossa().isFatto()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStallo(){
        return !this.scacco && !this.mosseScappo();
    }

    public boolean isArroco(){
        return false;
    }

    public Transizione faiMossaTransizione(Mossa mossa){
        
        if (!IsMossaLegale(mossa)) {
            // la mossa e illegale e vuoldire non cambio la scacchiera dato che non ci non cambiamenti
            return new Transizione(this.board, mossa, StatusMossa.MOSSA_ILLEGALE);
        }
        // questo crea una nuova scacchiera dove il turno e del aversario
        Scacchiera boardTrasizione = mossa.eseguisci(); 
        // questo garda dalla prospettiva del aversario e vede senza fare mosse se il re avversaio 
        // cioe quello prima che creaiamo la nuova scachiera e sotto attaco
        Collection<Mossa> attacoRe = calcolaSeAttacciCassella(boardTrasizione.getGiocatoreAdesso().getAvversario().getReGiocatore().getPosizionePezzo(), 
                                                                boardTrasizione.getGiocatoreAdesso().getMosseLegali());
        
        // perche non pui fare un mossa dove lasci il Re sotto attaco
        if (!attacoRe.isEmpty()) {
            return new Transizione(boardTrasizione, mossa, StatusMossa.METTE_SOTTO_SCACCO);
        }
        
        return new Transizione(boardTrasizione, mossa, StatusMossa.FATTO);
    }

    public abstract Collection<Pezzo> getPezziAttivi();
    public abstract Colore getColore();
    public abstract Giocatore getAvversario();
    public abstract Collection<Mossa> calcolaReArrocato(Collection<Mossa> giocateLegali, Collection<Mossa> giocateAversarioLegali);

    public Collection<Mossa> getMosseLegali() {
        return mosseLegali;
    }

    public Re getReGiocatore() {
        return this.reGiocatore;
    }

}

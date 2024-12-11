
public class Transizione {

    private Scacchiera scacchieraTransizione;
    @SuppressWarnings("unused")
    private Mossa mossa;
    private StatusMossa statusMossa;
    public Transizione(Scacchiera scacchieraTransizione, Mossa mossa, StatusMossa statusMossa) {
        this.scacchieraTransizione = scacchieraTransizione;
        this.mossa = mossa;
        this.statusMossa = statusMossa;
    }
    
    public Scacchiera getScacchieraTransizione() {
        return scacchieraTransizione;
    }
    
    public StatusMossa getStatusMossa() {
        return statusMossa;
    }

}

public class MossaCreatore {
    public MossaCreatore(){

    }

    public Mossa creaMossa(Scacchiera scacchiera, int cordinataAdesso, int cordinataDestinata){
        for (Mossa mossa : scacchiera.getTutteMosseLegali()) {
            if (mossa.getCordinataAdesso() == cordinataAdesso  && mossa.getDestinazionePezzo() == cordinataDestinata) {
                return mossa;
            }
            
        }

        return Mossa.mossaNulla;
    }

    
}

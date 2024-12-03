import java.util.List;

public abstract class Pezzo {    
    private int posizionePezzo ;
    private Colore colorePezzo;

    public Pezzo(int posizionePezzo, Colore colorePezzo) {
        this.posizionePezzo = posizionePezzo;
        this.colorePezzo = colorePezzo;
    }


    public abstract List<Mossa> calcolaSeMossaELegale(Scacchiera board);

    public int getPosizionePezzo() {
        return posizionePezzo;
    }
}

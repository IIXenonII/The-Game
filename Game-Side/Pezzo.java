import java.util.List;

public abstract class Pezzo {    
    private int posizionePezzo ;
    private Colore colorePezzo;


    public Pezzo(int posizionePezzo, Colore colorePezzo) {
        this.posizionePezzo = posizionePezzo;
        this.colorePezzo = colorePezzo;
    }


    public abstract List<Mossa> calcolaSeMossaELegale(Scacchiera board);
    public boolean isPosizineLegale(int posizioneRicevuta) {
        return (posizioneRicevuta >=0 && posizioneRicevuta < 64);
    }

    public int getPosizionePezzo() {
        return posizionePezzo;
    }

    public Colore getColorePezzo() {
        return colorePezzo;
    }

}

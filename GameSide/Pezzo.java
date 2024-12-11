package GameSide;

import java.util.List;

public abstract class Pezzo {    
    private int posizionePezzo ;
    private Colore colorePezzo;
    private boolean isPrimaMossa;


    public Pezzo(int posizionePezzo, Colore colorePezzo) {
        this.posizionePezzo = posizionePezzo;
        this.colorePezzo = colorePezzo;

        this.isPrimaMossa = false;
    }

    public abstract Pezzo muoviPezzo(Mossa mossa);

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

    public boolean isPrimaMossa() {
        return isPrimaMossa;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (!(obj instanceof Pezzo)) {
            return false;
        }
        Pezzo pezzoObj = (Pezzo) obj;
        return this.getColorePezzo() == pezzoObj.getColorePezzo() && this.getClass() == pezzoObj.getClass()
                && this.isPrimaMossa() == pezzoObj.isPrimaMossa() && this.getPosizionePezzo() == pezzoObj.getPosizionePezzo();
    }

    @Override
    // this
    public int hashCode() {
        return this.getClass().hashCode();
    }

    

    

}

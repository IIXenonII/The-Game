import java.util.List;

public class Cavaliere extends Pezzo {

    private int[] possibiliMosse = {-17, -15, -10, -6, 6, 10, 15, 17};
    // se numero ogni casella in una scacchiera il massimo numero di mosse che un cavaliere puo fare e 8 
    // e questa posizione e meno o piu quei numeri dalla posizione del cavaliere

    public Cavaliere(int posizionePezzo, Colore colorePezzo) {
        super(posizionePezzo, colorePezzo);
    }

    @Override
    public List<Mossa> calcolaSeMossaELegale(Scacchiera board) {

        int posizioneMossaLegale;
        
        for (int i : possibiliMosse) {

            posizioneMossaLegale = this.getPosizionePezzo() + i;
            
        }

        return null;
    }
    
}

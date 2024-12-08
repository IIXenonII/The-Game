import java.util.HashMap;
import java.util.Map;

public class Costruttore {
    // La posizione del pezzo e il pezzo stesso
    Map<Integer, Pezzo> configScacchiera;
    Colore prossimoMuovere;

    public Costruttore(){
        this.configScacchiera = new HashMap<>();
    }

    public Costruttore setPezzo(Pezzo p){
        this.configScacchiera.put(p.getPosizionePezzo(), p);
        return this;
    }

    public Costruttore setProssimoMuovere(Colore c){
        this.prossimoMuovere = c;
        return this;
    }

    public Scacchiera crea(){
        return new Scacchiera(this);
    }
    
}

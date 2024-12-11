package GameSide;

public class MossaArrocoDaRe extends MossaArroco {
    public MossaArrocoDaRe(Scacchiera scacchiera, Pezzo pezzoMosso, int destinazionePezzo, Torre torreArroco,
    int torrePartenza, int torreDestinazione) {
        super(scacchiera, pezzoMosso, destinazionePezzo, torreArroco, torrePartenza, torreDestinazione);
    }

    @Override
    public String toString() {
        return "0-0";
    }
    
}

package GameSide;

public class MossaArrocoDaRegina extends MossaArroco {
    public MossaArrocoDaRegina(Scacchiera scacchiera, Pezzo pezzoMosso, int destinazionePezzo, Torre torreArroco,
    int torrePartenza, int torreDestinazione) {
        super(scacchiera, pezzoMosso, destinazionePezzo, torreArroco, torrePartenza, torreDestinazione);
    }

    @Override
    public String toString() {
        return "0-0-0";
    }
    
}

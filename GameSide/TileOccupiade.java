package GameSide;

public class TileOccupiade extends Tile {
    Pezzo cosoSulQuad;

    public TileOccupiade(int cordTile, Pezzo cosoSulQuad) {
        super(cordTile);
        this.cosoSulQuad = cosoSulQuad;
    }

    public String toString(){
        return  this.getPezzo().getColorePezzo().isNero() ? this.getPezzo().toString().toLowerCase() : this.getPezzo().toString();
    }

    @Override
    public boolean isThere() {
        return true;
    }

    @Override
    public Pezzo getPezzo() {
        return cosoSulQuad;
    }


}

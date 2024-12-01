public class TileOccupiade extends Tile {
    Pezzo cosoSulQuad;

    public TileOccupiade(int cordTile, Pezzo cosoSulQuad) {
        super(cordTile);
        this.cosoSulQuad = cosoSulQuad;
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

public class TileEmpty extends Tile{
    public TileEmpty (int cordTile){
        super(cordTile);
    }

    @Override
    public boolean isThere() {
        return false;
    }

    @Override
    public Pezzo getPezzo() {
        return null;
    }
    

}


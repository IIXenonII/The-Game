package GameSide;

public class TileEmpty extends Tile{
    public TileEmpty (int cordTile){
        super(cordTile);
    }

    public String toString(){
        return "-";
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


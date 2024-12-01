public abstract class Tile {
    int cordTile;

    public Tile(int cordTile) {
        this.cordTile = cordTile;
    }


    public abstract boolean isThere();  // per vedere se ce qualcosa li 

    public abstract Pezzo getPezzo(); // da il pezzo
}

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {
    int cordTile;
    

    static Map<Integer, TileEmpty> casellaVuote = creaTutteCaselleLibere();

    public Tile(int cordTile) {
        this.cordTile = cordTile;
    }

    private static Map<Integer, TileEmpty> creaTutteCaselleLibere(){
        Map<Integer, TileEmpty> caselleLibereMap = new HashMap<>();

        for (int i = 0; i < 64; i++) {
            caselleLibereMap.put(i, new TileEmpty(i));
        }

        return caselleLibereMap;
    }

    public static Tile creaCasella(int cordTile, Pezzo pezzo){
        if (pezzo != null){
            return new TileOccupiade(cordTile, pezzo);
        }
        else{
            return casellaVuote.get(cordTile);
        }
    }
    
    public int getCordTile() {
        return cordTile;
    }
    public abstract boolean isThere();  // per vedere se ce qualcosa li 

    public abstract Pezzo getPezzo(); // da il pezzo
}

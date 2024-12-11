package GameSide;

public class Strumenti {
    public static final boolean[] PrimaColonna = colonna(0);
    public static final boolean[] SecondaColonna = colonna(1);
    public static final boolean[] SettimaColonna = colonna(6);
    public static final boolean[] OttavaColonna = colonna(7);

    public static final boolean[] OttavoRank= riga(0);
    public static final boolean[] SettimoRank = riga(8);
    public static final boolean[] SestoRank= riga(16);
    public static final boolean[] QuintoRank= riga(24);
    public static final boolean[] QuartoRank= riga(32);
    public static final boolean[] TerzoRank= riga(40);
    public static final boolean[] SecondaRank= riga(48);
    public static final boolean[] PrimoRank= riga(56);
    
    public Strumenti(){
    
    }

    private static boolean[] riga(int rigaNum) {
        boolean[] riga = new boolean[64];
        while(rigaNum % 8 != 0){
            riga[rigaNum] = true;
            rigaNum ++;
        }
        return riga;
    }
    
    private static boolean[] colonna(int colonnaNum) {
        boolean[] colonna = new boolean[64];
        while(colonnaNum < 64){
            colonna[colonnaNum] = true;
            colonnaNum += 8;
        }
        return colonna;
    }


    
}

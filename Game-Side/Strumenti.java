public class Strumenti {
    public static final boolean[] PrimaColonna = colonna(0);
    public static final boolean[] SecondaColonna = colonna(1);
    public static final boolean[] SettimaColonna = colonna(6);
    public static final boolean[] OttavaColonna = colonna(7);


    public static final boolean[] SecondaRiga = null;
    public static final boolean[] SettimaRiga= null;
    
    public Strumenti(){
    
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

public class MossaNulla extends Mossa {
    public MossaNulla() {
        super(null, null, -1);
    }

    public Scacchiera eseguisci() {
        throw new RuntimeException("Sai giocare a scacchi ????");    
    } 
}

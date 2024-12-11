package GameSide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Scacchiera {

    private List<Tile> scacchieraGioco;
    private Collection<Pezzo> pezziBianchi;
    private Collection<Pezzo> pezziNeri;

    private Giocatore giocatoreAdesso;
    private GiocatoreNero giocatoreNero;
    private GiocatoreBianco giocatoreBianco;

    public Scacchiera (Costruttore costruttore){
        scacchieraGioco = creaScachiera(costruttore);
        this.pezziBianchi = calcolaPezziVivi(scacchieraGioco, Colore.BIANCO);
        this.pezziNeri = calcolaPezziVivi(scacchieraGioco, Colore.NERO);

        Collection<Mossa> mosseLegaliNere = calcolaMosseLegali(this.pezziNeri);
        Collection<Mossa> mosseLegaliBianche = calcolaMosseLegali(this.pezziBianchi);

        this.giocatoreBianco= new GiocatoreBianco(this, mosseLegaliBianche, mosseLegaliNere);
        this.giocatoreNero = new GiocatoreNero(this, mosseLegaliNere, mosseLegaliBianche);
        this.giocatoreAdesso = costruttore.prossimoMuovere.segniGiocatore(this.giocatoreBianco, this.giocatoreNero);
    }

    public Giocatore getGiocatoreAdesso(){
        return this.giocatoreAdesso;
    }

    private Collection<Mossa> calcolaMosseLegali(Collection<Pezzo> pezzi) {
        List<Mossa> possibiliMosse = new ArrayList<>();
        for (Pezzo pezzo : pezzi) {
            possibiliMosse.addAll(pezzo.calcolaSeMossaELegale(this));
        }

        return possibiliMosse;
    }

    private Collection<Pezzo> calcolaPezziVivi(List<Tile> scacchieraGioco2, Colore colore) {
        List<Pezzo> listaPezziVivi= new ArrayList<>();
        for (Tile tile : scacchieraGioco2) {
            if(tile.isThere()){
                Pezzo pezzo = tile.getPezzo();
                if (pezzo.getColorePezzo() ==  colore) {
                    listaPezziVivi.add(pezzo);
                }
            }
        }
        return listaPezziVivi;
    }

    public Tile getTile(int posizione){
        return scacchieraGioco.get(posizione);
    }

    private List<Tile> creaScachiera(Costruttore costruttore) {
        List<Tile> caselle= new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            caselle.add(Tile.creaCasella(i, costruttore.configScacchiera.get(i)));
        }
        return caselle;
    }

    public static Scacchiera scacchieraStandard(){
        Costruttore c = new Costruttore();
        // Pezzi Neri
        c.setPezzo(new Torre(0, Colore.NERO));
        c.setPezzo(new Cavaliere(1, Colore.NERO));
        c.setPezzo(new Alfiere(2, Colore.NERO));
        c.setPezzo(new Regina(3, Colore.NERO));
        c.setPezzo(new Re(4, Colore.NERO));
        c.setPezzo(new Alfiere(5, Colore.NERO));
        c.setPezzo(new Cavaliere(6, Colore.NERO));
        c.setPezzo(new Torre(7, Colore.NERO));
        c.setPezzo(new Pedone(8, Colore.NERO));
        c.setPezzo(new Pedone(9, Colore.NERO));
        c.setPezzo(new Pedone(10, Colore.NERO));
        c.setPezzo(new Pedone(11, Colore.NERO));
        c.setPezzo(new Pedone(12, Colore.NERO));
        c.setPezzo(new Pedone(13, Colore.NERO));
        c.setPezzo(new Pedone(14, Colore.NERO));
        c.setPezzo(new Pedone(15, Colore.NERO));

        // Pezzi Bianchi
        c.setPezzo(new Pedone(48, Colore.BIANCO));
        c.setPezzo(new Pedone(49, Colore.BIANCO));
        c.setPezzo(new Pedone(50, Colore.BIANCO));
        c.setPezzo(new Pedone(51, Colore.BIANCO));
        c.setPezzo(new Pedone(52, Colore.BIANCO));
        c.setPezzo(new Pedone(53, Colore.BIANCO));
        c.setPezzo(new Pedone(54, Colore.BIANCO));
        c.setPezzo(new Pedone(55, Colore.BIANCO));
        c.setPezzo(new Torre(56, Colore.BIANCO));
        c.setPezzo(new Cavaliere(57, Colore.BIANCO));
        c.setPezzo(new Alfiere(58, Colore.BIANCO));
        c.setPezzo(new Regina(59, Colore.BIANCO));
        c.setPezzo(new Re(60, Colore.BIANCO));
        c.setPezzo(new Alfiere(61, Colore.BIANCO));
        c.setPezzo(new Cavaliere(62, Colore.BIANCO));
        c.setPezzo(new Torre(63, Colore.BIANCO));

        // Prima mossa bianchi
        c.setProssimoMuovere(Colore.BIANCO);
        
        return c.crea();

    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 64; i++) {
            String casella = this.scacchieraGioco.get(i).toString();
            b.append(String.format("%3s", casella));
            if((i + 1)%8 ==0 ){
                b.append("\n");
            }
        }
        return b.toString();
    }

    public Collection<Pezzo> getPezziBianchi() {
        return pezziBianchi;
    }

    public Collection<Pezzo> getPezziNeri() {
        return pezziNeri;
    }

    public GiocatoreNero getGiocatoreNero() {
        return giocatoreNero;
    }

    public GiocatoreBianco getGiocatoreBianco() {
        return giocatoreBianco;
    }

    public Collection<Mossa> getTutteMosseLegali() {
        Collection<Mossa> tutteMosseLegali = this.getGiocatoreBianco().getMosseLegali();
        tutteMosseLegali.addAll(this.getGiocatoreNero().getMosseLegali());
        return tutteMosseLegali;
    }

}

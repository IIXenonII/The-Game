package GameSide;

public enum TipoPezzo {
    PEDONE("P"),
    AlFIRE("A"),
    TORRE("T"),
    REGINE("R"),
    RE("S"),
    CAVALIERE("C");

    private String nomePezzo;
    TipoPezzo(String nome){
        this.nomePezzo = nome;
    }

    public String toString(){
        return this.nomePezzo;
    }
}

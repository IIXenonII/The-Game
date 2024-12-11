package GameSide;

public enum Colore {
    NERO {
        public int getDirezione(){
            // perchè i neri vanno in basso cioe da 0 a 64
            return 1;
        }

        @Override
        protected boolean isNero() {
            return true;
        }

        @Override
        protected boolean isBianco() {
            return false;
        }

        @Override
        protected Giocatore segniGiocatore(GiocatoreBianco giocatoreBianco, GiocatoreNero giocatoreNero) {
            return giocatoreBianco;
        }

    },
    BIANCO{
        public int getDirezione(){
            // perchè i bianchi vanno in alto cioe da 64 a 1
            return -1;
        }

        @Override
        protected boolean isNero() {
            return false;
        }

        @Override
        protected boolean isBianco() {
            return true;
        }

        @Override
        protected Giocatore segniGiocatore(GiocatoreBianco giocatoreBianco, GiocatoreNero giocatoreNero) {
            return giocatoreNero;
        }

    };

    public abstract int getDirezione();

    protected abstract boolean isNero();

    protected abstract boolean isBianco();

    protected abstract Giocatore segniGiocatore(GiocatoreBianco giocatoreBianco, GiocatoreNero giocatoreNero);


}

// uso la classe enum per definire meglio i colori
// in questo modo non devo vedere con la metodo equals se il futuro pezzo e nero o biancho 

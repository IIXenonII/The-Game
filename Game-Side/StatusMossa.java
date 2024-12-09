
public enum StatusMossa{
    FATTO{
        @Override
        boolean isFatto() {
            return true;
        }
    },
    MOSSA_ILLEGALE {
        @Override
        boolean isFatto() {
            return false;   
        }
    }, METTE_SOTTO_SCACCO {
        @Override
        boolean isFatto() {
            return false;
        }
    };
    abstract boolean isFatto();
    

}

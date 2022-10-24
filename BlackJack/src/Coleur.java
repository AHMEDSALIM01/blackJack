public enum Coleur {
    CARREAU,COEUR,PIQUE,TREFLE;
    public String getColeur(){
        switch (this){
            case CARREAU :
                return "\u2666";
            case COEUR:
                return "\u2665";
            case PIQUE:
                return "\u2660";
            case TREFLE:
                return "\u2663";
            default:
                return null;
        }
    }
}

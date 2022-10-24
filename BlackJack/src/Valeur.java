public enum Valeur {
    DEUX,TROIS,QUATRE,CINQ,SIX,SEPT,HUIT,NEUF,DIX,VALET,DAME,ROI,AS;
    public String getValeur(){
        switch (this){
            case DEUX :
                return "2";
            case TROIS:
                return "3";
            case QUATRE:
                return "4";
            case CINQ:
                return "5";
            case SIX:
                return "6";
            case SEPT:
                return "7";
            case HUIT:
                return "8";
            case NEUF:
                return "9";
            case DIX:
                return "10";
            case VALET:
                return "11";
            case DAME:
                return "12";
            case ROI:
                return "13";
            case AS:
                return "1";
            default:
                return null;
        }
    }
}

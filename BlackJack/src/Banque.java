import java.util.ArrayList;

public class Banque {
    private ArrayList<Cartes> banqueList;

    public Banque() {

        this.banqueList = new ArrayList();
    }

    public ArrayList getBanqueList() {
        return banqueList;
    }

    public void getCarte(int i){
        System.out.println(this.banqueList.get(i));
    }

    public void setBanqueList(ArrayList banqueList) {
        this.banqueList = banqueList;
    }

    public int cartesBanqueValeur(){
        int totalValeur = 0;
        int as = 0;

        for (Cartes uneCarte : this.banqueList){
            switch (uneCarte.getValeur()){
                case "2": totalValeur +=2;break;
                case "3": totalValeur +=3;break;
                case "4": totalValeur +=4;break;
                case "5": totalValeur +=5;break;
                case "6": totalValeur +=6;break;
                case "7": totalValeur +=7;break;
                case "8": totalValeur +=8;break;
                case "9": totalValeur +=9;break;
                case "10": totalValeur +=10;break;
                case "11": totalValeur +=10;break;
                case "12": totalValeur +=10;break;
                case "13": totalValeur +=10;break;
                case "1" : as += 1;break;
            }
        }
        for (int i = 0;i<as;i++){
            if (totalValeur>10){
                totalValeur +=1;
            } else{
                totalValeur+=11;
            }
        }
        return  totalValeur;
    }

    @Override
    public String toString() {
        return
                ""+banqueList
                ;
    }
}

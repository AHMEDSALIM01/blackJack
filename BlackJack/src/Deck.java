import java.util.*;

public class Deck {

    private ArrayList<ArrayList<Cartes>> cartes;
    private ArrayList<Cartes> cartesBanque;
    private ArrayList<Cartes> cartesPioche;
    private ArrayList<Cartes> cartesDefausse;
    private ArrayList<Cartes> exemples;
    private Players player;
    private Banque banque;
    public Deck(){
        this.cartes=new ArrayList();
        this.cartesPioche=new ArrayList<Cartes>();
        this.cartesDefausse = new ArrayList<>();
    }
    public ArrayList getListPioche(){
        return this.cartesPioche;
    }

    public int getListPiocheSize(){
        return this.cartesPioche.size();
    }

    public void creerJeu(){
        for (Coleur carteColeur: Coleur.values()){
            for (Valeur cartValeur : Valeur.values()){
                this.cartesPioche.add(new Cartes(cartValeur.getValeur(), carteColeur.getColeur()));
            }
        }
    }


    public void creerBlackJack(Players player,Banque banque){
        this.player=player;
        this.banque=banque;
        this.cartes.add(this.cartesPioche);
        this.cartes.add(player.getPlayerList());
        this.cartes.add(banque.getBanqueList());
    }

    public ArrayList tire_une_carte(ArrayList list){
        Random random = new Random();
        int randomCarteIndex = 0;
        randomCarteIndex = random.nextInt((list.size()-1)+1);
        return extraire_ieme_carte(list,randomCarteIndex);
    }

    public ArrayList extraire_ieme_carte(ArrayList list,int n){
        ArrayList tmp = new ArrayList<>();
        tmp.add(list.get(n));
        list.remove(n);
        tmp.add(list);
        list = tmp;
        return list;
    }


    public void melanger_jeu_carte(){
        ArrayList x;
        ArrayList temp = new ArrayList();
        for (int i=0;i<52;i++){
            x=tire_une_carte(this.cartesPioche);
            temp.add(x.get(0));
        }
       this.cartesPioche=temp;
    }

    public void pioche_n_carte(int n,ArrayList list){
        while(n>0){
            list.add(this.cartesPioche.get(0));
            this.cartesPioche.remove(0);
            n--;
        }
    }
    public void setCartesDefausse(){
        this.cartesDefausse.addAll(this.player.getPlayerList());
        this.cartesDefausse.addAll(this.banque.getBanqueList());
        this.player.getPlayerList().clear();
        this.banque.getBanqueList().clear();
    }

    public void defausser_cartes(){
        ArrayList temp = new ArrayList();
        temp.addAll(this.cartesPioche);
        temp.addAll(this.cartesDefausse);
        this.cartesDefausse.clear();
        this.cartesPioche=temp;
    }
    public String getCarte(int i,ArrayList list){
        return list.get(i).toString();
    }
    public void getDefausse(){
        System.out.println(this.cartesDefausse);
    }
    @Override
    public String toString() {
        return "Deck{" +
                "cartes=" + cartes +
                '}';
    }
}

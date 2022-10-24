import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BlackJack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deck playingDeck = new Deck();
        Players player1 =new Players(1500);
        Banque banque = new Banque();
        System.out.println("Bienvenu sur blackJack");
        int betTotal = player1.getBet();
        playingDeck.creerJeu();
        playingDeck.melanger_jeu_carte();
        playingDeck.creerBlackJack(player1,banque);
        int bet;
        int randomCarteIndex =(int) (Math.random() * (((playingDeck.getListPiocheSize()-32) - 5) + 1)) + 5;
        while (betTotal>0){
            System.out.println("combien de jeton veux tu miser");
            boolean tour =false;
            while (!input.hasNextInt()){
                input.next();
                System.out.println("svp entrer un nombre valid");
            }
            bet= input.nextInt();
            while(betTotal<bet || bet <=0){
                System.out.println("miser un prix inferieur ou égal ton prix total");
                while (!input.hasNextInt()){
                    input.next();
                    System.out.println("svp entrer un nombre valid");
                }
                bet = input.nextInt();
            }
            if(playingDeck.getListPiocheSize()<=randomCarteIndex){
                System.out.println("defaussing......");
                playingDeck.defausser_cartes();
                playingDeck.melanger_jeu_carte();
            }
            playingDeck.pioche_n_carte(1,banque.getBanqueList());
            System.out.println("banque main :\n"+playingDeck.getCarte(0,banque.getBanqueList()));
            playingDeck.pioche_n_carte(1,player1.getPlayerList());
            System.out.println("votre main: \n" + playingDeck.getCarte(0,player1.getPlayerList()));
            playingDeck.pioche_n_carte(1,banque.getBanqueList());
            System.out.println("banque main: \n"+playingDeck.getCarte(0,banque.getBanqueList())+"[masquée]");
            playingDeck.pioche_n_carte(1,player1.getPlayerList());
            System.out.println("votre main: \n" + playingDeck.getCarte(0,player1.getPlayerList())+playingDeck.getCarte(1,player1.getPlayerList()));
            System.out.println("votre main valeur = "+player1.cartesJoueurValeur());
            if(banque.cartesBanqueValeur()==21){
                System.out.println("banque main: \n"+playingDeck.getCarte(0,banque.getBanqueList())+playingDeck.getCarte(1,banque.getBanqueList()));
                System.out.println("banque a un black jack");
                System.out.println("vous avez perdus ton mise");
                betTotal -= bet;
                tour=true;
            }else if(player1.cartesJoueurValeur()==21){
                System.out.println("vous avez un black jack");
                System.out.println("vous avez gangné");
                betTotal += 1.5*bet;
                tour=true;
            }
            while (!tour){
                System.out.println("tirer [t] ou rester [r]");
                while (!input.hasNext()){
                    input.nextInt();
                    System.out.println("svp entrer un just des caractère [r] ou [t]");
                }
                String chois = input.next();
                switch (chois.toLowerCase()){
                    case "t":
                        playingDeck.pioche_n_carte(1,player1.getPlayerList());
                        System.out.println("vous avez tirer la carte: \n" + playingDeck.getCarte(player1.getPlayerList().size()-1,player1.getPlayerList()));
                        System.out.println("votre main valeur = "+player1.cartesJoueurValeur());
                        if (player1.cartesJoueurValeur()>21){
                            System.out.println("vous avez perdus");
                            betTotal -= bet;
                            tour =true;
                            break;
                        } else if (player1.cartesJoueurValeur()==21) {
                            System.out.println("vous avez gangé");
                            betTotal += bet;
                            System.out.println("banque main :");
                            System.out.println(playingDeck.getCarte(0,banque.getBanqueList())+playingDeck.getCarte(1,banque.getBanqueList()));
                            System.out.println(banque.cartesBanqueValeur());
                            tour=true;
                            break;
                        }
                        break;
                    case "r":
                        System.out.println("banque main :");
                        System.out.println(playingDeck.getCarte(0,banque.getBanqueList())+playingDeck.getCarte(1,banque.getBanqueList()));
                        System.out.println(banque.cartesBanqueValeur());
                        while (banque.cartesBanqueValeur()<17){
                            playingDeck.pioche_n_carte(1,banque.getBanqueList());
                            System.out.println("banque à tirer:"+playingDeck.getCarte(banque.getBanqueList().size()-1,banque.getBanqueList()));
                            System.out.println(banque.cartesBanqueValeur());
                            if(banque.cartesBanqueValeur()==21){
                                System.out.println("banque gagne");
                                betTotal -=bet;
                            }
                        }
                        tour = true;
                    default:break;
                }
            }
            if(banque.cartesBanqueValeur()>player1.cartesJoueurValeur() && banque.cartesBanqueValeur()<21){
                System.out.println("vous avez perdus");
                betTotal -= bet;
            } else if (banque.cartesBanqueValeur()<player1.cartesJoueurValeur() && player1.cartesJoueurValeur()<21) {
                System.out.println("vous avez gagné");
                betTotal +=bet;
            }else if(banque.cartesBanqueValeur()==player1.cartesJoueurValeur()){
                System.out.println("Egalité");
                betTotal = betTotal;
            }else if(banque.cartesBanqueValeur()>21){
                System.out.println("vous avez gagné");
                betTotal +=bet;
            }
            playingDeck.setCartesDefausse();
            System.out.println("Votre solde est: "+betTotal);
            System.out.println("---------------------------------------------------------------------------");
        }
    }
}
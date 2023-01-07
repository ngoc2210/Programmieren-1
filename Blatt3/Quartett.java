
import java.util.Scanner;
import java.util.Random;
public class Quartett {
    Stack stapelcomputer = new Stack();
    Stack stapelplayer = new Stack();
    Player computer = new Player("Bot", 0, stapelcomputer); 
    Player player = new Player("Player", 0, stapelplayer);
    
    public Card[] cardGenerator() {  
        Card[] cardArray = new Card[8];
        cardArray[0] = new Card("Grogu", "REBEL", 1.67, 4, 5, 9);
        cardArray[1] = new Card("Max", "REBEL", 1.61, 9, 2, 7);
        cardArray[2] = new Card("Tim", "REBEL", 1.55, 6, 6, 6);
        cardArray[3] = new Card("Mac", "REBEL", 1.58, 5, 9, 5);
        cardArray[4] = new Card("Trox", "IMPERIUM", 1.52, 10, 3, 4);
        cardArray[5] = new Card("Stephen", "IMPERIUM", 1.63, 3, 4, 3);
        cardArray[6] = new Card("Marco", "IMPERIUM", 1.53, 7, 1, 8);
        cardArray[7] = new Card("John", "IMPERIUM", 1.62, 2, 7, 1);
        return cardArray;
    }

    public Card[] ShuffleOfCards() {
        Card[] deckOfCard = cardGenerator();
        Random random = new Random();
        int j;
        for ( int i = 0; i < deckOfCard.length; i++ ) {
            j = random.nextInt(8);
            Card temp = deckOfCard[i];
            deckOfCard[i] = deckOfCard[j];
            deckOfCard[j] = temp;
        }
        return deckOfCard;
    }

 
    public void DealCards(Player computer, Player player) {
        Card[] shuffleCard = ShuffleOfCards();
        for (int i = 0; i < 4; i++) {     
            computer.getKartenstapel().cardStack[i] = shuffleCard[i];      
        }
        for (int i = 0; i < 4; i++) {
            player.getKartenstapel().cardStack[i] = shuffleCard[7-i];
        }   

        /*for (Card card : player.getKartenstapel().cardStack) {
            System.out.println("Karten vom Spieler: "+ card);
        }  
        for (Card card : computer.getKartenstapel().cardStack) {
            System.out.println("Karten vom Computer: "+ card);
        }  */  
    } 

    public void spielRegel() {
        System.out.println("Sie haben jetzt 4 Karte als ein Kartenstapel. Nur die oberstekarte dürfen Sie kennen.");
        System.out.println("Wählen Sie bitte jetzt eine Kategorie: height, intelligence, strength, jedipower.");
        System.out.println("Es werden deine oberstekarten und die von deinem Gegner in dieser Kategorie überprüft.");
        System.out.println("Wählen Sie bitte jetzt eine Kategorie: height, intelligence, strength, jedipower.");
        System.out.println("Der Spieler mit dem höchsten Wert in dieser Kategorie gewinnt die Runde und erhält einen Punkt.");
        System.out.println("Jeder anschließende Spielrunde wird vom vorherigen Sieger begonnen.");
        System.out.println("Das Spiel endet, sobald alle Karten gespielt wurden.");
        System.out.println("Am Ende des Spiels gewinnt der Spieler, der mehr Punkte kriegt. So los geht's");
    }

    public void spielerchoose() {
        System.out.println("Du bist dran. Ihre oberste Karte ist: ");
        player.showCard();
    }
    public boolean compareto(int kategorie, Player playercompare, Player playertocompare, boolean x) {
        boolean a = false;
        switch (kategorie) {
            case 1:
                if (playercompare.playCard().height > playertocompare.playCard().height ) {
                    a = true;
                }
                break;
            case 2:
                if (playercompare.playCard().intelligence > playertocompare.playCard().intelligence ) {
                    a = true;
                }
                break;
            case 3:
                if (playercompare.playCard().strength > playertocompare.playCard().strength ) {
                    a = true;
                }
                break;
            case 4:
                if (playercompare.playCard().jedipower > playertocompare.playCard().jedipower ) {
                    a = true;
                }
                break;
            default:
                break;
        }
        return a;
    }
    public static void main(String[] args) {
        Quartett test = new Quartett();
        test.DealCards(test.computer, test.player);
        test.spielRegel();
        test.spielerchoose();
        boolean x = true; 
        int kategorieofplayer = test.player.spielerchoosedKategorie();
        System.out.println("die Karte Ihres Gegners ist ");
        test.computer.showCard();
        boolean resultofRound = test.compareto(kategorieofplayer, test.player, test.computer, x);      
        while ( test.player.countCards() != 0) {
            if (resultofRound == false) {
                test.computer.addPoint();
                System.out.println("Sie sind in dieser Runde leider verloren.");
                System.out.println("Ihre aktuelle Punktestand ist:" + test.player.getPoints());
                int kategorieofcomputer = test.computer.computerchoosedKategorie();
                System.out.println("Ihr Gegner wählt die Kategorienummer: "+ kategorieofcomputer);
                System.out.println("Ihre nächste Karte und die nächste Karte Ihres Gegners sind:");
                test.player.showCard();
                test.computer.showCard();
                resultofRound = !test.compareto(kategorieofcomputer, test.computer, test.player, x); 
            } else {
                System.out.println( "Sie sind in dieser Runde gewonnen." );
                test.player.addPoint();
                System.out.println("Ihre aktuelle Punktestand ist:" + test.player.getPoints());
                test.spielerchoose();
                kategorieofplayer = test.player.spielerchoosedKategorie();
                System.out.println("die Karte Ihres Gegners ist ");
                test.computer.showCard();
                resultofRound = test.compareto(kategorieofplayer, test.player, test.computer, x);   
            }
        }
        if (resultofRound == true) {
            System.out.println( "Sie sind in letzter Runde gewonnen." );
            test.player.addPoint();
            System.out.println("Ihr endlicher Punktestand ist:" + test.player.getPoints());
        } else {
            test.computer.addPoint();
            System.out.println("Sie sind in letzter Runde leider verloren.");
            System.out.println("Ihre endlicher Punktestand ist " + test.player.getPoints());
        }
        if ( test.player.getPoints() > test.computer.getPoints()) {
            System.out.println("Congratulation!Sie sind gewonnen!");
            System.out.println("die Punkte Ihres Gegners ist " + test.computer.getPoints());
        } else if (test.player.getPoints() < test.computer.getPoints()) {
            System.out.println("Sie sind in dem Game leider verloren." );
            System.out.println("die Punkte Ihres Gegners ist " + test.computer.getPoints()+" .Versuch nochmal!");
        } else {
            System.out.println("Nicht schlecht! Sie und der Bott haben gleiche Punkte." );
            System.out.println("die Punkte Ihres Gegners ist auch " + test.computer.getPoints());
        }
    }  
}
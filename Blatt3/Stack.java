import java.util.Random;
public class Stack {
    
    Card[] cardStack = new Card[4]; 
    public Card playCard() {
        Card obersteCard = null;
        for ( int i = 3; i > -1; i--) {
            if (cardStack[i] != null) {
                obersteCard = cardStack[i];
                cardStack[i] = null;
                break;
            }             
        }
        return obersteCard;        
    }

    public void showCard() {
        Card obersteCard = null;
        for ( int i = 3; i > -1; i--) {
            if (cardStack[i] != null) {
                obersteCard = cardStack[i];
                break;
            }             
        }
        System.out.println(obersteCard); 
    }

    public int count() {
        int restKarten = 0;
        for ( int i = 3; i > -1; i--) {
            if ( cardStack[i] != null ) {
                restKarten = i+1;
                break;
            }
        }
        return restKarten;
    }
}
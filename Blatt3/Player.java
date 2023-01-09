import java.util.Random;
import java.util.Scanner;

public class Player {

    String name;
    private Stack kartenStapel; 
    private int punkteStand;

    public Player(String name, int punkteStand, Stack kartenStapel) {
        this.name = name;
        this.punkteStand = punkteStand;
        this.kartenStapel = kartenStapel;
    }

    public int countCards() {
        return kartenStapel.count();
    }
    
    public void addPoint() {
        punkteStand++;
    }

    public int getPoints() {
        return punkteStand;
    }

    public Stack getKartenstapel() {
        return kartenStapel;
    }

    public void showCard() {
        kartenStapel.showCard();
    }

    public Card playCard(int kategorie) {
        return kartenStapel.playCard();
    }

    public Card playCard() {
        return kartenStapel.playCard();    
    }

    public int spielerchoosedKategorie() {
        System.out.println("Geben Sie bitte 1 für height, 2 für intelligence,3 für strength oder 4 für jedipower ein! ");
        Scanner sc = new Scanner(System.in);
        int kategorieofplayer = sc.nextInt();
        return kategorieofplayer;
    }

    public int computerchoosedKategorie() {
        Random random = new Random();
        int kategorieofcomputer = random.nextInt(4)+1;
        return kategorieofcomputer;
    }
}
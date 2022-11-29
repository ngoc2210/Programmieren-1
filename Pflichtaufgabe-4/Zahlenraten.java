public class Zahlenraten{
    public static void main(String[] args) {
        if (args.length>0){
            computerRaten(Integer.parseInt(args[0]));
        }
    }

    public static void computerRaten(int numToGuess){
        int zahl = 1;
        int versuchZahl = 1;

        while (zahl != numToGuess){
            zahl = (int)(Math.random()*100);
            versuchZahl++;      
        }

        System.out.println("Die Versuchzahl ist " + versuchZahl);
    }

}
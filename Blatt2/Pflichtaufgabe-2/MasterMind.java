import java.util.Random;
import java.util.Scanner;

public class MasterMind {
    private static int [] mastermindArray; // Deklarieren private MastermindArray 
    public static void main(String[] args){
        /*Generate random number with methode mastermindArrayGenerator */
        mastermindArray =  mastermindArrayGenerator(); 
        /*String[] strArray = new String[mastermindArray.length];
        for ( int i = 0; i < mastermindArray.length; i++){
            strArray[i] = String.valueOf(mastermindArray[i]);
        } */
        Scanner input = new Scanner(System.in);
        String eingabe = input.next();
        // check if input is nummeric          
        try {
            Integer.parseInt(eingabe);
        } catch (Exception e) {
            System.out.println("Geben Sie bitte nur eine natuerliche Zahl, deren Ziffer von 1 bis 8 und keine Wiederholung einer Ziffer!!");            
        }
        eingabe = input.next();

        int len = eingabe.length();        
        if ( len != 4  ){
            System.out.println("Geben Sie bitte genau 4-stellige Code mit oben Bedingungen ein");
            eingabe = input.next();

        } else {   
            int Versuchzahl = 10; 
            int richtigPosition = 0;
            int falsePosition = 0;       
            for ( int a = 0 ; a < 4; a++ ){
                for( int b = 0; b < 4; b++ ){                    
                    if( eingabe.charAt(b) == mastermindArray[a] ){
                        if( a == b ) {
                            richtigPosition = richtigPosition + 1;
                        } else {
                            falsePosition = falsePosition + 1;  
                        }
                        System.out.println("")
                    }    
                    else {
                        System.out.println("Ihre Zahl hat keine richtigen Ziffer. Bitte geben Sie weiter eine 4-stellige Zahl mit den oben Bedingungen!");
                        eingabe = input.next();

                    }
                } 
            }       
            System.out.println("die Anzahl des Ziffers mit richtiger Position " + richtigPosition);
            System.out.println("die Anzahl des Ziffers mit falscher Position " + falsePosition);                  
                
        }         
    }   
    public static  int [] mastermindArrayGenerator() {
        int[] availabelNummer = new int[8];
        int[] generatedNummer = new int[4];
        for ( int i = 0; i < 8; i++ ) {
            // Stelle 0 hat den Wert 1,usw...Stelle 7 hat den Wert 8           
            availabelNummer[i] = i + 1;               
        }
        for ( int i = 0; i < 4; i++ ) {
            Random random = new Random();
            // Speichern randome Nummer im Index von Array availabelNummer
            int availabelNummerIndex = random.nextInt(availabelNummer.length);
            // Speichern den Wert des jeweiligen Indexes in Array generatedNummer            
            generatedNummer[i] = availabelNummer[availabelNummerIndex];          
            availabelNummer = remove(availabelNummer, availabelNummerIndex);

        }
        return generatedNummer;
    }   
    public static int[] remove( int[] inputArray, int removeIndex ) {
        int[] outputArray = new int[inputArray.length - 1];
        // copy all the elements in the original to the outputArray except the one at the remove index
        for ( int i = 0, k = 0; i < inputArray.length; i++) {
            // check if is crosse, continue without copying
            if ( i == removeIndex ) {
                continue;
            }
            // else copy the element
            outputArray[k++] = inputArray[i];
        }  
        return outputArray;
    }  

}
       

    
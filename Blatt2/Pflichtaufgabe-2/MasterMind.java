import java.util.Random;
import java.util.Scanner;

public class MasterMind {   
    private static int[] mastermindArray;
    public static void main(String[] args){
        mastermindArray = mastermindArrayGenerator();
        for ( int i : mastermindArray ) {
            System.out.print (i);
        }
        Scanner input = new Scanner(System.in);
        String eingabe = input.next();        
        int Versuchzahl = 10;        
        // check if input is nummeric          
        try {
            Integer.parseInt(eingabe);
        } catch (Exception e) {
            System.out.println("Geben Sie bitte nur eine natuerliche Zahl, deren Ziffer von 1 bis 8 und keine Wiederholung der Ziffer!!"); 
            Versuchzahl = Versuchzahl - 1; 
            System.out.println("die restlichen Versuchen sind " + Versuchzahl);
        }
        /*        
        if ( places[0] == 4 ) {
            System.out.println(" Sie sind gewonnen. ");          
        }*/
         
        eingabe = input.next();            
        int len = eingabe.length();
        // check the length of Input        
        if (  len != 4  ) {
            System.out.println("Geben Sie bitte genau 4-stellige Code mit oben Bedingungen ein");
            Versuchzahl = Versuchzahl - 1;
            System.out.println("die restlichen Versuchen sind " + Versuchzahl);
            eingabe = input.next();                 
        }
        // check the number and the position            
        for ( int i = Versuchzahl-1 ; i > 0; i-- ) {    
            int[] places = new int[2];
            int richtigPosition = 0;
            int falsePosition = 0;
        // the return of method is Array output 
        places = Zahlenraten(richtigPosition, falsePosition, eingabe);           
            if ( places[0] == 4 ) {
                System.out.println(" Sie sind gewonnen. ");
                break;
            } else {
                System.out.println("Anzahl der richtigen Ziffer mit richter Position ist " + places[0] + " .Geben Sie bitte weiter genau 4-stellige Code mit oben Bedingungen!");
                System.out.println("Anzahl der richtigen Ziffer mit falscher Position ist " + places[1]);
                System.out.println("die restlichen Versuchen sind " + i);
                eingabe = input.next(); 
            }
        }
        System.out.println(" Sie sind leider verloren. " );  
    }  
    public static int [] Zahlenraten( int richtig, int falsch, String eingabe) {
        int[] output = new int[2];
        for ( int a = 0 ; a < 4; a++ ){
            for( int b = 0; b < 4; b++ ){                    
                if( Character.getNumericValue(eingabe.charAt(b)) == mastermindArray[a] ){
                    if( a == b ) {
                        richtig = richtig + 1;
                    } else {
                        falsch = falsch + 1;  
                    }
                }     
            }           
        }
        output[0] = richtig;
        output[1] = falsch;
        return output;       
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
       

    
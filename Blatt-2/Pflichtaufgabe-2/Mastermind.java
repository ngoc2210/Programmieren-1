import java.util.Random;
import java.util.Scanner;

public class Mastermind {
    private static int [] mastermindArray;
    
    public static void main(String args[]) {
        int maxGuessTimes = 10;
        int remainedGuessTimes;
        mastermindArray = mastermindArrayGenerator();
        
        for (int i : mastermindArray)
        System.out.print(i); 

        System.out.println("");  

        Scanner input = new Scanner(System.in);
        
        for (remainedGuessTimes = maxGuessTimes; remainedGuessTimes > 0; remainedGuessTimes--) {
            System.out.println("Raten Sie bitte den Code: ");
            String eingabe = input.next();
            boolean isValidGuess = isMastermind(eingabe);
            if (isValidGuess) {
            System.out.println("Sie sind gewonnen!"); 
            break;
            }
            else {
            System.out.println("Sie können noch " + (remainedGuessTimes-1) + " mal versuchen!");
            }
        }
        
        if (remainedGuessTimes == 0)
        System.out.println("Sie sind verloren!"); 
    }

    public static boolean isMastermind(String eingabe) {
        inputFormatCheck(eingabe);
        boolean isLengthCorrect = mastermindLengthCheck(eingabe);
        boolean isNumberAndPositionCorrect = nummberAndPositionCheck(eingabe);
        
        return isLengthCorrect && isNumberAndPositionCorrect;
    }

    public static void inputFormatCheck(String eingabe){
        try{
            Integer.parseInt(eingabe);
        }
        catch (NumberFormatException ex){
            System.out.println("Geben Sie bitte nur Zahlen ein!");
            ex.printStackTrace();
        }
    }

    public static boolean mastermindLengthCheck(String eingabe) {
        if (eingabe.length() != mastermindArray.length)
            System.out.println("Ihre Nummer hat die falsche Länge!");
            
        return eingabe.length() == mastermindArray.length; 
    }

    public static boolean nummberAndPositionCheck(String eingabe) {
        int numCorrectNumberAndPosition = 0;
        int numCorrectNumberFalsePosition = 0;
        
        for (int i = 0; i < eingabe.length(); i++) {
            int checkedNumber = Character.getNumericValue(eingabe.charAt(i));
            if(i < mastermindArray.length) {
                if (mastermindArray[i] == checkedNumber)
                    numCorrectNumberAndPosition++;    
            }
            
            for (int j = 0; j < mastermindArray.length; j++) {
                if (j != i && mastermindArray[j] == checkedNumber) {
                    numCorrectNumberFalsePosition++;
                }
            }
        }
        
        System.out.println("Sie haben " + numCorrectNumberAndPosition + " richtige Ziffern an der richtigen Stelle geraten!");
        System.out.println("Sie haben " + numCorrectNumberFalsePosition + " richtige Ziffern an der falschen Stelle geraten!"); 

        return numCorrectNumberAndPosition == mastermindArray.length;
    }


    public static int[] mastermindArrayGenerator () {
        int[] generatedMastermindArray = new int[4];
        int[] availableNumberArray = new int[8];
        
        for (int i = 0; i < 8; i++) {
        availableNumberArray[i] = i + 1; 
        }
        
        for (int i = 0; i < 4; i++) {
            Random generator = new Random();
            int nextRandomNumberIndex = generator.nextInt(availableNumberArray.length);
            int nextRandomNumber = availableNumberArray[nextRandomNumberIndex];
            
            generatedMastermindArray[i] = nextRandomNumber;
            availableNumberArray = removeArrayElement(availableNumberArray, nextRandomNumberIndex); 
        }
        return generatedMastermindArray;
    } 

    public static int[] removeArrayElement(int [] inputArray, int removeIndex) {
        if (inputArray == null || removeIndex < 0 || removeIndex > inputArray.length) {
            System.out.println("Removal operation cannot be performed!!");
            return null;
        }
        else {
            int[] outputArray = new int[inputArray.length - 1]; 
            // copy all the elements in the original to the output array except the one at the remove index 
            for (int i = 0, k = 0; i < inputArray.length; i++) { 
                // check if index is crossed, continue without copying 
                if (i == removeIndex) { 
                    continue; 
                } 
                // else copy the element
                outputArray[k++] = inputArray[i]; 
            }
            
            return outputArray;
        }
    }
}
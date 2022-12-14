import java.util.Random;

public class Mastermind {
    public static void main(String args[]) {
      int[] mastermindArray = new int[4];
      int[] availableNumberArray = new int[8];
      
      for (int i = 0; i < 8; i++) {
        availableNumberArray[i] = i + 1; 
      }
      
      for (int i = 0; i < 4; i++) {
          Random generator = new Random();
          int nextRandomNumberIndex = generator.nextInt(availableNumberArray.length);
          int nextRandomNumber = availableNumberArray[nextRandomNumberIndex];
          
          mastermindArray[i] = nextRandomNumber;
          availableNumberArray = removeArrayElement(availableNumberArray, nextRandomNumberIndex); 
      }
      
      for (int i : mastermindArray)
        System.out.print(i);  
    }
    
    public static int[] removeArrayElement(int [] inputArray, int removeIndex){
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
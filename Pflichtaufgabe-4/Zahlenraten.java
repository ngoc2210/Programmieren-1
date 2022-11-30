
import java.util.Scanner;

public class Zahlenraten{
    public static void main(String[] args){
               if(args[]==0) {                       
               selberraten(); 
               }
               else {
               computerRaten(Integer.parseInt(args[0]);
               }
               
               

    }
    public static void selberraten() {
        int Suchzahl = (int)(Math.random()*100);
        Scanner sc = new Scanner(System.in);
        int nextNummer = sc.nextInt();

        while(nextNummer != Suchzahl ){
            System.out.println("doan tiep di ma");
            
            if(nextNummer > Suchzahl){                                
                System.out.println("Die Suchzahl ist kleiner");
                nextNummer = sc.nextInt();
            }    
            else{
                System.out.println("die Suchzahl ist groesser");
                nextNummer = sc.nextInt();

            }                             
        }
        System.out.println("doan dung ui"); 
            
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






  

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Mastermind2{
    public static void main(String[] args){
        int a, b, c, d;
        boolean x;
        int[] code= new int[4];
        Random random= new Random();


     do{
        a=random.nextInt(9)+1;
        b=random.nextInt(9)+1;
        c=random.nextInt(9)+1;
        d=random.nextInt(9)+1;

        if(a==b & a==c & a==d){
            x=false;
        } else if(b==c & b==d){
            x=false;
        }else if(c==d){
            x=false;

        }else{
            x= true;
            code[0]=a;
            code[1]=b;
            code[2]=c;
            code[3]=d;

            

        }
   
    
         }while(x==false);


         System.out.println(code[0]);
         System.out.println(code[1]);
         System.out.println(code[2]);
         System.out.println(code[3]);

        funktionMastermind(code);
    }

    public static void funktionMastermind(int code1[]){
        Scanner input= new Scanner(System.in);
        int versuchen=10;
        /*int code1[]={1,2,3,4};/* */
        String code2= Arrays.toString(code1);
        String cod1, cod2, cod3, cod4;
        cod1= Character.toString(code2.charAt(1));
        cod2= Character.toString(code2.charAt(4));
        cod3= Character.toString(code2.charAt(7));
        cod4= Character.toString(code2.charAt(10));
               
        int zahler1=0;
        int zahler2=0;
        for(int i=0; i<10; i++){
            do{
                

              versuchen= versuchen-1;
              System.out.print("Geben Sie ihren 4 Eingaben");
              String eingabe= input.next();
              int len= eingabe.length();
              String eingabe1, eingabe2, eingabe3, eingabe4;

            if(len==4){
              eingabe1=Character.toString(eingabe.charAt(0));
              eingabe2=Character.toString(eingabe.charAt(1));
              eingabe3=Character.toString(eingabe.charAt(2));
              eingabe4=Character.toString(eingabe.charAt(3));


                if(eingabe1.equals(cod1)){
                   zahler1++;
 
                 } else if(eingabe1.equals(cod2) || eingabe1.equals(cod3) ||  eingabe1.equals(cod4)){
                   zahler2++;
                 }
                if(eingabe2.equals(cod2)){
                   zahler1++;
                  }else if(eingabe2.equals(cod1) || eingabe2.equals(cod3) || eingabe2.equals(cod4)){
                   zahler2++;
                     }
                if(eingabe3.equals(cod3)){
                    zahler1++;
                  }else if(eingabe3.equals(cod1)|| eingabe3.equals(cod2)|| eingabe3.equals(cod4)){
                    zahler2++;
                    }

                if(eingabe4.equals(cod4)){
                       zahler1++;
                 }else if(eingabe4.equals(cod1)|| eingabe4.equals(cod2) || eingabe4.equals(cod3)){
                       zahler2++;
                }

                 System.out.println("Die richtige Ziffern an der richtigen Stelle sind");
                 System.out.println(zahler1);
                 System.out.println("Die Ziffern zwar richtig, aber an der falschen Stelle sind:");
                 System.out.println(zahler2);
                 System.out.println("Du hast noch");
                 System.out.println(versuchen);
                 System.out.println("versuchen");
            
               }
            else{
                System.out.println("Du kannst nur 4 Zahlen eingeben. Versucht noch einmal. Du hast noch");
                System.out.println(versuchen);
                System.out.println("versuchen");
               }

               
        
            } while(zahler1!=4 );

            System.out.println("Du hast recht. Die Zahlen sind:");
            System.out.println(code2);

            }
        }
         
}
        
 
       
    
        
 




   
        
    
            







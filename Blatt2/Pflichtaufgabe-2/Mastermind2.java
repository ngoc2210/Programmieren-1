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
      a=random.nextInt(8)+1;
      b=random.nextInt(8)+1;
      c=random.nextInt(8)+1;
      d=random.nextInt(8)+1;

      if( a==b || a==c || a==d){
        x=false;
      } else if ( b==c || b==d){
        x=false;
      } else if(c==d){
        x=false;
      } else{
        x= true;
        code[0]=a;
        code[1]=b;
        code[2]=c;
        code[3]=d;
      }
    } while( x == false );
    for ( int i : code ) {
      System.out.print (i);
    }
    while (true) {
      Scanner input= new Scanner(System.in);
      String eingabe = input.next();
      int versuchen=10;
      while ( true ) {
        while ( checkNummeric ( x, eingabe, versuchen ) == false ) {
          System.out.println("Geben Sie bitte nur eine natuerliche Zahl, deren Ziffer von 1 bis 8 und keine Wiederholung der Ziffer!!"); 
          versuchen = versuchen - 1;
          System.out.println("die restlichen Versuchen sind " + versuchen);
            if ( versuchen >  0) {
              eingabe = input.next();
            } else {
              break;  
            }      
        } 
        if ( versuchen <= 0 ){
          System.out.println("Sie sind leider verloren " );
          break;
        } else {
          funktionMastermind(code, versuchen, input, eingabe );
        }     
      }
    }  
  }
  public static boolean checkNummeric(boolean y, String input, int Versuchzahl ) {
    try {
        Integer.parseInt(input);
    } catch (Exception e) {
      y = false;
    }
    return y;        
  }

  public static boolean funktionMastermind(int code1[], int Versuchzahl, Scanner input, String eingabe){ 
    boolean x = false;  
    /*int code1[]={1,2,3,4};/* */
    String code2= Arrays.toString(code1);
    String cod1, cod2, cod3, cod4;
    cod1= Character.toString(code2.charAt(0));
    cod2= Character.toString(code2.charAt(1));
    cod3= Character.toString(code2.charAt(2));
    cod4= Character.toString(code2.charAt(3));

    int zahler1=0;
    int zahler2=0;
    for(int i = Versuchzahl - 1; i > 0; i--){
      do{
        Versuchzahl= Versuchzahl - 1;
        System.out.print("Geben Sie bitte ihren 4 Eingaben, die nicht gleich zueinander sind!");
        eingabe= input.next();
        int len= eingabe.length();
        String eingabe1, eingabe2, eingabe3, eingabe4;

        if(len==4){
          eingabe1=Character.toString(eingabe.charAt(0));
          eingabe2=Character.toString(eingabe.charAt(1));
          eingabe3=Character.toString(eingabe.charAt(2));
          eingabe4=Character.toString(eingabe.charAt(3));

          if(eingabe1.equals(cod1)) {
            zahler1++;
          } else if ( eingabe1.equals(cod2) || eingabe1.equals(cod3) ||  eingabe1.equals(cod4) ) {
            zahler2++;
          }
          if(eingabe2.equals(cod2)) {
            zahler1++;
          }else if ( eingabe2.equals(cod1) || eingabe2.equals(cod3) || eingabe2.equals(cod4) ) {
            zahler2++;
          }
          if(eingabe3.equals(cod3)) {
            zahler1++;
          }else if ( eingabe3.equals(cod1)|| eingabe3.equals(cod2)|| eingabe3.equals(cod4) ) {
            zahler2++;
          }
          if(eingabe4.equals(cod4)) {
            zahler1++;
          } else if ( eingabe4.equals(cod1) || eingabe4.equals(cod2) || eingabe4.equals(cod3) ) {
            zahler2++;
          }

          System.out.println("Die richtige Ziffern an der richtigen Stelle sind");
          System.out.println(zahler1);
          System.out.println("Die Ziffern zwar richtig, aber an der falschen Stelle sind:");
          System.out.println(zahler2);
          System.out.println("Sie haben noch");
          System.out.println(Versuchzahl);
          System.out.println("versuchen");  
          zahler1 = 0;
          zahler2 = 0;
        }
        else {
          System.out.println("Sie können nur 4 Zahlen eingeben. Versuchen noch einmal. Sie haben noch");
          System.out.println(Versuchzahl);
          System.out.println("versuchen");
        }
      } while ( zahler1 != 4 );

      System.out.println("Sie haben Recht. Die Zahlen sind:");
      System.out.println(code2);
      x = true;
    } return x;  
  }       
}
        
 
       
    
        
 




   
        
    
            







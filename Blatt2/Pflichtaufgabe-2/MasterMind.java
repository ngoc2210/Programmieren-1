
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
	public class MasterMind {
		public static void main(String[] args) {
	
			System.out.println("Geben Sie bitte eine Code!");
			int[] mastermindArray;
			mastermindArray = mastermindArrayGenerator();
			for ( int i : mastermindArray ) {
				System.out.print (i);
		    }
		    Scanner input = new Scanner(System.in);
		    String eingabe = input.next();
		    int Versuchzahl = 10;
		    while ( true ) {
			  	boolean x = true;
			    while ( checkNummeric ( x, eingabe, Versuchzahl ) == false ) {
			        System.out.println("Geben Sie bitte nur eine natuerliche Zahl, deren Ziffer von 1 bis 8 und keine Wiederholung der Ziffer!!"); 
			        Versuchzahl = Versuchzahl - 1;
			        System.out.println("die restlichen Versuchen sind " + Versuchzahl);
                    if ( Versuchzahl <= 0) {
                       break;
                    } else {
			            eingabe = input.next();
                    }    
			    }
			    while ( checkLength(x, eingabe, Versuchzahl) == false) {
			        System.out.println("Geben Sie bitte genau 4-stellige Code, deren Ziffer von 1 bis 8 und keine Wiederholdung vom Ziffer!");
			        Versuchzahl = Versuchzahl - 1;
			        System.out.println("die restlichen Versuchen sind " + Versuchzahl);
                    if ( Versuchzahl <= 0 ) {
                        break;
                    } else {
			            eingabe = input.next();
                    }    
			    }
			    if (checkPosition( Versuchzahl, eingabe, input, mastermindArray ) == true){
                    break;
                } else {
			        System.out.println("Sie sind leider verloren.Die Code ist " );
					for ( int i : mastermindArray ) {
						System.out.print (i);
					}	
                    break;
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
	    public static boolean checkLength ( boolean y, String input, int Versuchzahl ) {   
	        int len = input.length();       
			if( len != 4 ) {
				y = false;                       
		    } else {
			    y = true;

			}    
		    return y;
		}            
			       
		// check the position 
	    public static boolean checkPosition( int Versuchzahl, String eingabe, Scanner input, int[] mastermindArray ) { 
            boolean x = false;
	    	int[] places = new int[2];
		    int richtigPosition = 0;
		    int falsePosition = 0;
	        for ( int i = Versuchzahl -1; i > -1; i--) { 
                // the return of method is Array output 
		        places = Zahlenraten(richtigPosition, falsePosition, eingabe, mastermindArray);                 
		        if ( places[0] == 4 ) {
		        	System.out.println("Sie sind gewonnen. ");
                    x = true;
			        break;
			    } else {
			        System.out.println("Anzahl der richtigen Ziffer mit richtiger Position ist " + places[0] + ". Geben Sie bitte genau 4-stellige Code, deren Ziffer von 1 bis 8 und keine Wiederholdung vom Ziffer!");
			        System.out.println("Anzahl der richtigen Ziffer mit falscher Position ist " + places[1]);
			        System.out.println("die restlichen Versuchen sind " + i );
			        eingabe = input.next(); 
			    }
	        }
            return x;    
	    }  
	    public static int [] Zahlenraten( int richtig, int falsch, String eingabe, int[] mastermindArray) {
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
	    public static int [] mastermindArrayGenerator() {
		    int a, b, c, d;
		    boolean x;
		    int[] code= new int[4];
		    Random random= new Random();
		    do {
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
		    } while ( x == false);
		    return code;
	    }  
	}
			       

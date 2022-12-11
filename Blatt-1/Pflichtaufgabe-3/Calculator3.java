public class Calculator3{
    public static void main(String[] args){

        float operand1=Float.parseFloat(args[0]);
        String operator=args[1];
        float operand2=Float.parseFloat(args[2]);

        switch(operator){
            case "+":
                System.out.println(operand1+operand2);                
                break;

            case "-":
                System.out.println(operand1-operand2);  
                break;

            case "*":
                System.out.println(operand1*operand2); 
                break; 

            case "/":
                System.out.println(operand1/operand2); 
                break; 
            default:
                System.out.println("ranh tinh minh di ma ai ranh dau tinh"); 
                break;
                     
        }
    }
}
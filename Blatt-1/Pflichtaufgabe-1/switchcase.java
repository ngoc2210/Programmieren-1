import java.util.Scanner;
class switchcase {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String input = sc.next();
        switch (input) {
            case "hoch":
                System.out.println("tief");
                break;
            case "tief":
                System.out.println("hoch");
                break;
            case "klein":
                System.out.println("groß");
                break;
            case "groß":
                System.out.println("klein");
                break;
            case "stark":
                System.out.println("schwach");
                break;
            case "schwach":
                System.out.println("stark");
                break; 
            default:
                break;
        }
    }
}
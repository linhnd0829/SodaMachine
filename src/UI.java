import java.util.List;
import java.util.Scanner;

public abstract class UI {
    public static void printWelcome(){
        System.out.println("WELCOME TO SODA MACHINE");
        System.out.println("PLEASE INSERT CASH");
    }

    public static void printCashInput(){
        System.out.println("----------------------------");
        System.out.println("THESE NOTES WERE ACCEPTED");
        for(int i=1 ; i<Def.NOTES.length ; i++){
            System.out.println(i + " : " + Def.NOTES[i]);
        }
        System.out.println("0 : CANCEL");
        System.out.println("ENTER A VALUE TO SELECT NOTE (0-5)");
    }

    public static int getInput(){
        Scanner keyboard = new Scanner(System.in);
        int userInput = keyboard.nextInt();
        return userInput;
    }

    public static void printGoodbye(){
        System.out.println("SEE YOU LATER");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx END_TRANSACTION xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("\n");
        System.out.println("\n");
    }

    public static void printInsertedCash(int value){
        System.out.println("----------------------------");
        System.out.println("YOU INSERTED : " + value);
    }

    public static void printProduct(List<Product> l){
        System.out.println("THIS IS OUR PRODUCT");
        for(int i=1; i<l.size() ; i++){
            System.out.println(l.get(i).getID() + " : " + l.get(i).getName() + " ( " + l.get(i).getPrice() + ")");
        }
        System.out.println("0 : CANCEL");
        System.out.println("ENTER A VALUE TO SELECT NOTE (0-4)");
    }

    public static void printInvalidInput(){
        System.out.println("* INVALID INPUT, PLEASE WAIT AND START AGAIN *");
    }

    public static void printSelectedProduct(Product p){
        System.out.println("You selected : " + p.getName());
    }

    public static void printNotEnoughCash(){
        System.out.println("NOT ENOUGH CASH, PLEASE WAIT AND START AGAIN");
    }

    public static void printSendBackLastNode(int value){
        System.out.println("REFUND : " + value);
    }

    public static void printSendProduct(Product p){
        System.out.println("Finish Making : " + p.getName());
    }

    public static void printSendRemainingCash(List<Cash> l){
        for(int i=0 ; i<l.size() ; i++){
            System.out.println("Refund " + l.get(i).getValue());
        }
    }
}

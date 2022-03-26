
package assignment2;

import java.util.Scanner;

/**
 *
 * @author UMIT KILINC 101232721
 * @author RAVKEERAT SINGH 101344680
 */
public class Assignment2 {

    boolean exit;
    
    public void printMenu(){
        System.out.println("\n1) Add new word. ");
        System.out.println("2) Delete word. ");
        System.out.println("3) Get meaning. ");
        System.out.println("4) Dictionary list. ");
        System.out.println("5) Spell check a text file. ");
        System.out.println("6) Exit. ");
    }
    
    public void runMenu(){
        while(!exit){
            printMenu();
            int option = getInput();
            menuAction(option);
        }
    }

    private int getInput(){
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while(option < 1 || option > 6){
            try{
                System.out.print("\nEnter an option: ");
                option = Integer.parseInt(sc.nextLine());
            }
            catch(NumberFormatException e){
                System.out.print("Invalid selection. Try again.");
            }
        }
        return option;
    }
    
    private void menuAction(int option){
        switch(option){
            case 1 -> addNewWord();
            case 2 -> System.out.println("Delete word.");
            case 3 -> System.out.println("Get meaning");
            case 4 -> System.out.println("Dictionary list");
            case 5 -> System.out.println("Spell check a text file.");
            case 6 -> {
                exit = true;
                System.out.println("Take care!");
            }
            default -> System.out.println("Unknown error."); 
        }
    }

        private void addNewWord(){
            System.out.println("Add new word.");
        }
    public static void main(String[] args) {
        Assignment2 menu = new Assignment2();
        menu.runMenu();
    }
    
}

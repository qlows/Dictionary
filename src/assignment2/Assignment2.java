package assignment2;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author UMIT KILINC 101232721
 * @author RAVKEERAT SINGH 101344680
 */

public class Assignment2 {
    
    private Dictionary dict;
    final static String filePath = "wordList.txt";
    final static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    boolean exit;
    
    Assignment2() {

        dict = new Dictionary();
        dict.build(filePath);

    }
    
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
    
 private void addNewWord(){
        try{
            FileWriter fw = new FileWriter("wordList.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter a word: ");
            String word = sc.nextLine();
            
            pw.print("\n" + word.toLowerCase());
            pw.close();
        }
        catch(IOException e){
            System.out.println("An error occured.");
        }
}
 
 private void spellCheck(){

        Scanner scan = new Scanner(System.in);
        boolean end = false;
        String input;
        while (true) {

            System.out.print("\n-------Enter a word: ");
            input = scan.nextLine();
            if (input.equals("")) {
                break;
            }
            if (dict.contains(input)) {
                System.out.println("\n" + input + " is spelled correctly");

            } else {

                System.out.print("is spelled incorrectly, ");            

            }

        }

    }
 
private void dictionaryList(){
    try{
        FileInputStream fileStream = new FileInputStream("wordList.txt");
        DataInputStream din = new DataInputStream(fileStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(din));
        String strLine;
        while((strLine = br.readLine()) != null){
            System.out.println(strLine);
        }
        din.close();
    }
    catch(Exception e){
        System.err.println("Error: " + e.getMessage());
    }
}
 
private void menuAction(int option) {
        switch(option){
            case 1 -> addNewWord();
            case 2 -> System.out.println("Delete word.");
            case 3 -> System.out.println("Get meaning");
            case 4 -> dictionaryList();
            case 5 -> spellCheck();
            case 6 -> {
                exit = true;
                System.out.println("Take care!");
            }
            default -> System.out.println("Unknown error."); 
        }
    }


    
    public static void main(String[] args) {
        Assignment2 menu = new Assignment2();
        menu.runMenu();
            
    }
}
    


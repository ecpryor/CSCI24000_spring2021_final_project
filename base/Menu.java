//Menu.java

import java.util.*;
import java.io.*;

public class Menu{

    static int passcode;
    static int check;
    static int counter;

    public static void main(String[] args){

        try{

            User u = null;

            //ask user if they want to create an account or log in
            Scanner input = new Scanner(System.in);
            System.out.println("Would you like to create an account or log in?");
            System.out.println("1) Create account");
            System.out.println("2) Log in");
            System.out.print("Please enter the digit of your selection: ");
            int choice = input.nextInt();

            //if the user chooses to create an account
            if(choice == 1){
                while(true){

                    //user has to put in an int passcode
                    System.out.print("Please enter a passcode: ");
                    int inpass = input.nextInt();

                    //check if login is taken
                    checkLogin(inpass);

                    //if passcode is taken make them try a new passcode
                    if(check == 0){
                        System.out.println("That passcode is taken");
                    } // end if

                    //if passcode isnt taken, use it to create a new instance of user and write it into users.txt
                    if(check == 1){
                        u = new User(inpass);
                        System.out.println("Account created and logged in");
                        FileWriter outFile = new FileWriter("users.txt", true);
                        PrintWriter output = new PrintWriter(outFile);
                        output.println(inpass);
                        outFile.close();
                        output.close();
                        break;
                    } // end if
                } // end while
            } // end if

            //if the user chooses to log in
            if(choice == 2){
                while(true){

                    //the user is asked to enter their passcode
                    System.out.print("Please enter your passcode: ");
                    passcode = input.nextInt();

                    //users input passcode is compared to existing passcodes
                    checkLogin(passcode);

                    //if user passcode exists, use object serialization to load in user object
                    if(check == 0){

                        try{
                            FileInputStream fIn = new FileInputStream(passcode + ".dat");
                            ObjectInputStream obIn = new ObjectInputStream(fIn);
                            u = (User)obIn.readObject();
                            System.out.println("Logged in");
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        } // end try
                    } // end if

                    //if user passcode doesnt exist, tell them it does not exist
                    if(check == 1){
                        System.out.println("Invalid passcode");
                    } // end if
                } // end while
            } // end if

            //create an instance of usermenu
            UserMenu um = new UserMenu();
            counter = 0;
            while(true){

                //print usermenu
                System.out.println();
                System.out.println("User Menu");
                System.out.println("0) Log out");
                System.out.println("1) Generate a chord progression in a major key");
                System.out.println("2) Generate a chord progression in a minor key");
                System.out.println("3) Generate a jazz chord progression");
                System.out.println("4) Generate a 12 bar blues progression");
                System.out.println("5) Generate a random progression (not always musical)");
                System.out.println("6) Load a preloaded progression");

                //if the user has generated a progression allow them the option to save
                if(counter >= 1){
                    System.out.println("7) Save Progression");
                } // end if

                //if the user has generated a progression that uses chord numbers instead of notes, allow them the option to set a key
                if(counter == 2){
                    System.out.println("8) Set a key for the current progression");
                } // end if

                //ask the user for their selection
                System.out.print("Please enter the digit of the option you select: ");
                choice = input.nextInt();

                //if the user chooses to log out, save the instance of user using object serialization
                if(choice == 0){
                    FileOutputStream fo = new FileOutputStream(passcode + ".dat");
                    ObjectOutputStream obOut = new ObjectOutputStream(fo);
                    obOut.writeObject(u);
                    System.out.println("Logged out, goodbye");
                    break;
                } // end if

                if(choice == 1){
                    um.genMajor();
                    counter = 2;
                } // end if

                if(choice == 2){
                    um.genMinor();
                    counter = 3;
                } // end if

                if(choice == 3){
                    um.genJazz();
                    counter = 2;
                } // end if

                if(choice == 4){
                    um.genBlues();
                    counter = 2;
                } // end if

                if(choice == 5){
                    um.genRand();
                    counter = 2;
                } // end if

                if(choice == 6){
                    u.numProgs();
                    System.out.println("Please enter a save slot digit: ");
                    int pos = input.nextInt();
                    u.loadProg(pos);
                    counter = 1;
                } // end if

                if(choice == 7 && counter >= 1){
                    String prog = um.getProg();
                    u.saveProg(prog);
                    counter = 0;
                } // end if

                if(choice == 8 && counter >= 2){
                    System.out.print("Please input root note: ");
                    String note = input.nextLine().toLowerCase();
                    um.setKey(note, counter);
                    counter = 1;
                } // end if
            } // end while

        } catch(NumberFormatException e){
            System.out.println("Improper format, not a number");
        } catch(IOException e){
            System.out.println(e.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        } // end try
    } // end main

    //start menu
    public Menu(){
        passcode = 0;
        check = 1;
        counter = 0;
    } // end constructor

    //start checkLogin
    public static int checkLogin(int passcode){
        try{
            File users = new File("users.txt");
            Scanner input = new Scanner(users);

            while(input.hasNext()){
                int pass = input.nextInt();

                if(passcode == pass){
                    check = 0;
                    break;
                } // end if

                if(passcode != pass){
                    check = 1;
                } // end if

            } // end while
        } catch(Exception e){
            System.out.println(e.getMessage());
        } // end try
            return check;
    } // end checkLogin
} // end class def


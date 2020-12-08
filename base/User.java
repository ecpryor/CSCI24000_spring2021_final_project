//User.java

import java.util.*;
import java.io.*;

public class User{

    //declare variables
    int passcode;
    ArrayList<String> userProgs = new ArrayList<String>();

    // start main
    public static void main(String[] args){

        User u = new User();

    } // end main

    // define constructor
    public User(){
        passcode = 00000;
    } // end constructor

    //define overloaded constructor
    public User(int passcode){
        passcode = passcode;
    } // end overloaded constructor

    //define saveProg
    public void saveProg(String prog){
        userProgs.add(prog);
    } // end saveProg

    //define numProgs
    public void numProgs(){
        int size = userProgs.size();
        for(int i = 0; i < size; i++){
            System.out.println("Slot " + i);
        } // end for
    } // end numProgs

    //define loadProg
    public void loadProg(int pos){
        System.out.println(userProgs.get(pos));
    } // end loadProg

}// end class def

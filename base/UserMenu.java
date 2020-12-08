//UserMenu.java

import java.util.*;

public class UserMenu{

    //declard variables
    ArrayList<String> genProg = new ArrayList<String>();
    String prog;

    //chromatic
    String[] notes = {"ab", "a", "bb", "b", "c", "db" , "d", "eb", "e", "f", "gb", "g", "ab", "a", "bb", "b", "c", "db" , "d", "eb", "e", "f", "gb", "g"};

    //Major
    String[] major = {"I", "ii", "iii", "IV", "V", "vi", "vii_dim"};
    String[] I = {"IV", "V", "vi"};
    String[] ii = {"IV", "V", "vii_dim"};
    String[] iii = {"ii", "IV", "V"};
    String[] IV = {"I", "V", "vi"};
    String[] V = {"I", "ii", "iii", "vi"};
    String[] vi = {"ii", "iii", "IV", "V"};
    String[] vii_dim = {"I", "V"};

    //Minor
    String[] minor = {"i", "ii_dim", "III", "iv", "v", "VI", "VII"};
    String[] i = {"ii_dim", "iv", "VI", "VII"};
    String[] ii_dim = {"i", "v"};
    String[] III = {"i", "VII"};
    String[] iv = {"v", "VII"};
    String[] v = {"i", "VII"};
    String[] VI = {"i", "ii_dim", "III", "iv", "v", "VII"};
    String[] VII = {"i", "III", "VI"};

    //Jazz
    String[] jazz = {"I_maj7", "ii_m7", "iii_m7", "IV_maj7", "V_7", "vi_m7", "vii_m7b5"};
    String[] I_maj7 = {"ii_m7", "bii_dim7 to ii_m7", "II_7 to ii_m7", "I_7 to IV_maj7", "iii_m7", "v_m7 to I_7 to IV_maj7", "IV_maj7", "vi_m7"};
    String[] ii_m7 = {"biii_dim7 to iii_m7", "IV_maj7", "V_7", "vii_m7b5"};
    String[] iii_m7 = {"ii_m7", "IV_maj7", "VI_7"};
    String[] IV_maj7 = {"I_maj7", "iv_m7 to iii_m7", "V_7", "vii_m7b5"};
    String[] V_7 = {"I_maj7", "iii_m7"};
    String[] vi_m7 = {"ii_m7", "VI_7"};
    String[] vii_m7b5 = {"I_maj7", "VII_7 to I_maj7", "iii_m7", "V_7"};
    String[] VI_7 = {"ii_m7"};

    //start main
    public static void main(String[] args){
        UserMenu um = new UserMenu();
    } // end main

    //define constructor
    public UserMenu(){
    } // end constructor

    //define genMajor
    public void genMajor(){
        try{
            //empties previous progression from genProg arraylist
            genProg.clear();

            //create an instance of random
            Random rand = new Random();

            //use random to generate random numbers to select random positions of arrays            
            int randInt = rand.nextInt(7);
            genProg.add(major[randInt]);
            while(true){

                //get the last chord in the array
                int pos = genProg.size();
                String chord = genProg.get(pos - 1);

                //depending on what chord it is get a random position
                //of that chords array and repeat
                if(chord == "I"){
                    randInt = rand.nextInt(3);
                    genProg.add(I[randInt]);
                } // end if
                if(chord == "ii"){
                    randInt = rand.nextInt(3);
                    genProg.add(ii[randInt]);
                } // end if
                if(chord == "iii"){
                    randInt = rand.nextInt(3);
                    genProg.add(iii[randInt]);
                } // end if
                if(chord == "IV"){
                    randInt = rand.nextInt(3);
                    genProg.add(IV[randInt]);
                } // end if
                if(chord == "V"){
                    randInt = rand.nextInt(4);
                    genProg.add(V[randInt]);
                } // end if
                if(chord == "vi"){
                    randInt = rand.nextInt(4);
                    genProg.add(vi[randInt]);
                } // end if
                if(chord == "vii_dim"){
                    randInt = rand.nextInt(2);
                    genProg.add(vii_dim[randInt]);
                } // end if

                //get the size of the array and the last chord
                pos = genProg.size();
                chord = genProg.get(pos - 1);

                //if the size of the arraylist is greater than eight
                //and the last chord is I, break the loop
                if(pos > 8 && chord == "I"){
                    break;
                } // end if
            } // end while
            System.out.println();

            //create an instance of stringBuffer and use it to take the contents of genProg
            //add them to string s with an added space and then convert that to string prog
            StringBuffer sb = new StringBuffer();
            for(String s : genProg){
                sb.append(s);
                sb.append(" ");
            } // end for
            prog = sb.toString();

            //print the final progression
            System.out.println(prog);
        } catch(Exception e){
            System.out.println(e.getMessage());
        } // end try
    } // end genMajor

    //start genMinor
    public void genMinor(){

        //clear genProg arraylist
        genProg.clear();

        //create instance of random
        Random rand = new Random();

        // use random to generate random numbers to choose random slots of arrays
        // get the first chord and start the while loop
        int randInt = rand.nextInt(7);
        genProg.add(minor[randInt]);
        while(true){

            //get the size of the array and the last chord
            int pos = genProg.size();
            String chord = genProg.get(pos - 1);

            //depending on the last chord it will use that chords array to randomly select
            //the next chord and add it to genProg
            if(chord == "i"){
                randInt = rand.nextInt(4);
                genProg.add(i[randInt]);
            } // end if
            if(chord == "ii_dim"){
                randInt = rand.nextInt(2);
                genProg.add(ii_dim[randInt]);
            } // end if
            if(chord == "III"){
                randInt = rand.nextInt(2);
                genProg.add(III[randInt]);
            } // end if
            if(chord == "iv"){
                randInt = rand.nextInt(2);
                genProg.add(iv[randInt]);
            } // end if
            if(chord == "v"){
                randInt = rand.nextInt(2);
                genProg.add(v[randInt]);
            } // end if
            if(chord == "VI"){
                randInt = rand.nextInt(6);
                genProg.add(VI[randInt]);
            } // end if
            if(chord == "VII"){
                randInt = rand.nextInt(3);
                genProg.add(VII[randInt]);
            } // end if

            //get the size and last chord of the array
            pos = genProg.size();
            chord = genProg.get(pos - 1);

            //if size is greater than 8 and the last chord is i, break the loop
            if(pos > 8 && chord == "i"){
                break;
            } // end if
        } // end while
        System.out.println();

        //create an instance of stringBuffer that will take the contents of genProg and
        //append them to string s with a space and converts that to string equal to prog
        StringBuffer sb = new StringBuffer();
        for(String s : genProg){
            sb.append(s);
            sb.append(" ");
        } // end for
        prog = sb.toString();

        //print final chord progression
        System.out.println(prog);
    } // end genMinor

    //start genJazz
    public void genJazz(){
        try{

            //clear arraylist genProg
            genProg.clear();

            //create an instance of random
            Random rand = new Random();

            //use random to get random numbers to select random slots of different arrays
            //get the first chord of the progression
            int randInt = rand.nextInt(7);
            genProg.add(jazz[randInt]);
            while(true){

                //get the size of the arraylist and the last chord of the array
                int pos = genProg.size();
                String chord = genProg.get(pos - 1);

                //based on the last chord, use that chords array to get the next random chord
                //add that chord to the arraylist and repeat
                if(chord == "I_maj7"){
                    randInt = rand.nextInt(8);
                    genProg.add(I_maj7[randInt]);
                } // end if
                if(chord == "ii_m7"){
                    randInt = rand.nextInt(4);
                    genProg.add(ii_m7[randInt]);
                } // end if
                if(chord == "iii_m7"){
                    randInt = rand.nextInt(3);
                    genProg.add(iii_m7[randInt]);
                } // end if
                if(chord == "IV_maj7"){
                    randInt = rand.nextInt(4);
                    genProg.add(IV_maj7[randInt]);
                } // end if
                if(chord == "V_7"){
                    randInt = rand.nextInt(2);
                    genProg.add(V_7[randInt]);
                } // end if
                if(chord == "vi_m7"){
                    randInt = rand.nextInt(2);
                    genProg.add(vi_m7[randInt]);
                } // end if
                if(chord == "vii_m7b5"){
                    randInt = rand.nextInt(4);
                    genProg.add(vii_m7b5[randInt]);
                } // end if
                if(chord == "VI_7"){
                     genProg.add("iim7");
                } // end if
                if(chord == "bii_dim7 to ii_m7"){
                    randInt = rand.nextInt(4);
                    genProg.add(ii_m7[randInt]);
                } // end if
                if(chord == "II_7 to ii_m7"){
                    randInt = rand.nextInt(4);
                    genProg.add(ii_m7[randInt]);
                } // end if
                if(chord == "I_7 to IV_maj7"){
                    randInt = rand.nextInt(4);
                    genProg.add(IV_maj7[randInt]);
                } // end if
                if(chord == "v_m7 to I_7 to IV_maj7"){
                    randInt = rand.nextInt(4);
                    genProg.add(IV_maj7[randInt]);
                } // end if
                if(chord == "biii_dim7 to iii_m7"){
                    randInt = rand.nextInt(3);
                    genProg.add(iii_m7[randInt]);
                } // end if
                if(chord == "iv_m7 to iii_m7"){
                    randInt = rand.nextInt(3);
                    genProg.add(iii_m7[randInt]);
                } // end if
                if(chord == "VII_7 to I_maj7"){
                    randInt = rand.nextInt(8);
                    genProg.add(I_maj7[randInt]);
                } // end if

                //get the size of the array and the last chord
                pos = genProg.size();
                chord = genProg.get(pos - 1);

                //if genProg has more than 8 chords and the last chord is I_maj7, end the loop
                if(pos > 8 && chord == "I_maj7"){
                    break;
                } // end if
            } // end while
            System.out.println();

            //create an instance of stringBuffer to append the chords in genProg to string s
            //with an added space and that is converted to string prog
            StringBuffer sb = new StringBuffer();
            for(String s : genProg){
                sb.append(s);
                sb.append(" ");
            } // end for
            prog = sb.toString();

            //print the final progression
            System.out.println(prog);
        } catch(Exception e){
            System.out.println(e.getMessage());
        } // end try
    } // end genJazz

    //start genBlues
    public void genBlues(){

        //clear arraylist
        genProg.clear();
        try{

            //take in user input for a root note
            Scanner input = new Scanner(System.in);
            System.out.print("Please input a note name(no sharps): ");

            //convert it to lowercase
            String note = input.nextLine().toLowerCase();
            int i;
            String pos = "";

            //compare each note in the notes array to the users note
	    for(i = 0; i < notes.length; i++){
                pos = notes[i];
                //if the users note and the note from the array are the same, break the loop
                if(pos.equals(note)){
                    break;
                } // end if
            } // end for

            //paste the root chord in the array 4 times
            for(int j = 0; j < 4; j++){
                genProg.add(pos);
            } // end for

            //create variables that hold the 4 and 5 chord
            String posFour = notes[i + 5];
            String posFive = notes[i + 7];

            //add the rest of a 12 bar blues progression to the genProg array
            genProg.add(posFour);
            genProg.add(posFour);
            genProg.add(pos);
            genProg.add(pos);
            genProg.add(posFive);
            genProg.add(posFour);
            genProg.add(pos);
            genProg.add(posFive);
            System.out.println();

            //create an instance of stringBuffer that converts the array to a string
            StringBuffer sb = new StringBuffer();
            for(String s : genProg){
                sb.append(s);
                sb.append(" ");
            } // end for
            prog = sb.toString();

            //print final progression
            System.out.println(prog);
        } catch(Exception e){
            System.out.println(e.getMessage());
        } // end try
    } // end genBlues

    //start genrand
    public void genRand(){

        //clear array
        genProg.clear();

        //create an instance of random
        Random rand = new Random();

        //create a loop that generates a random note and adds a random quality to them
        while(true){
            int randInt = rand.nextInt(2);

            if(randInt == 0){
                randInt = rand.nextInt(2);

                if(randInt == 0){
                    randInt = rand.nextInt(12);
                    genProg.add(notes[randInt]);
                } // end if

                if(randInt == 1){
                    randInt = rand.nextInt(12);
                    genProg.add(notes[randInt] + "m");
                } // end if
            } // end if

            if(randInt == 1){
                randInt = rand.nextInt(3);

                if(randInt == 0){
                    randInt = rand.nextInt(12);
                    genProg.add(notes[randInt] + "maj7");
                } // end if

                if(randInt == 1){
                    randInt = rand.nextInt(12);
                    genProg.add(notes[randInt] + "7");
                } // end if

                if(randInt == 2){
                    randInt = rand.nextInt(12);
                    genProg.add(notes[randInt] + "m7");
                } // end if
            } // end if
            //get the size and if it's 8, break
            int size = genProg.size();
            if(size == 8){
                break;
            } // end if
        } // end while

        //create an instance of stringBuffer that converts arraylist genProg to a string
        StringBuffer sb = new StringBuffer();
        for(String s : genProg){
            sb.append(s);
            sb.append(" ");
        } // end for
        prog = sb.toString();

        System.out.println();

        //print final array
        System.out.println(prog);
    } // end genRand

    //start getProg
    public String getProg(){
        return prog;
    } // end getProg

    //start setKey
    public void setKey(String note, int counter){
        String finalProg = "";
        String notePos = "";
        int i;
        //find user selected root note in note array and break
        for(i = 0; i < notes.length; i++){
            notePos = notes[i];
            if(notePos == note){
                break;
            } // end if
        } // end for

        //break up progression string using space delimiter
        String[] chords = prog.split(" ");

        //create a for loop that iterates for each chord in the chords array
        for(int j = 0; j < chords.length; j++){

            //take a chord from the array and split it up into an array where the first
            //position of the array holds the chord number and the second position holds
            //the quality of the chord
            String chord = chords[j];
            String[] arrayChord = chord.split("_");

            //take the chord number from the array
            String chordNum = arrayChord[0];

            //based on that number, change the chord number to a note name
            if(chordNum == "I" || chordNum == "i"){
                arrayChord[0] = notePos;
            } // end if

            if(chordNum == "bii"){
                arrayChord[0] = notes[i + 1];
            } // end if

            if(chordNum == "II" || chordNum == "ii"){
                arrayChord[0] = notes[i + 2];
            } // end if

            if(chordNum == "biii" || chordNum == "III"){
                arrayChord[0] = notes[i + 3];
            } // end if

            if(chordNum == "iii"){
                arrayChord[0] = notes[i + 4];
            } // end if

            if(chordNum == "IV" || chordNum == "iv"){
                arrayChord[0] = notes[i + 5];
            } // end if

            if(chordNum == "V" || chordNum == "v"){
                arrayChord[0] = notes[i + 7];
            } // end if

            if(chordNum == "vi"){
                arrayChord[0] = notes[i + 9];
            } // end if

            if(chordNum == "VI" && counter == 2){
                arrayChord[0] = notes[i + 9];
            } // end if

            if(chordNum == "VI" && counter == 3){
                arrayChord[0] = notes[i + 8];
            } // end if

            if(chordNum == "vii"){
                arrayChord[0] = notes[i + 11];
            } // end if

            if(chordNum == "VII" && counter == 2){
                arrayChord[0] = notes[i + 11];
            } // end if

            if(chordNum == "VII" && counter == 3){
                arrayChord[0] = notes[i + 10];
            } // end if

            else{
            } // end else

            //add the note name back into the array
            String finalChord = arrayChord[0];

            //if the chord had a specified quality, add that to string finalChord
            if(arrayChord.length == 2){
                finalChord += arrayChord[1];
            } // end if

            finalChord += " ";

            //add the full chord to the final progression
            finalProg += finalChord;

            //print the final progression
            System.out.println(finalProg);
        } // end for
    } // end setKey

} // end class def

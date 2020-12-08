Goals: Create a program that will allow users to log in and create an account where they can
generate, save, and load chord progressions of varying genres and lengths which can be
assigned a key.

Input: Users will input their account info and selections for menu options.

Output: The program will output menus, generated chord progressions, and loaded chord
progressions.

Steps:

1) Create A UML (attached on github)

2) Write the algorithm file and makefile

User.java: 

Import java.util

Import java.io

Start class definition

Declare int passcode for holding user passcodes and string arraylist userProgs that will
store a users saved progressions

Start main

Create an instance of User

End main

Define User constructor to create an account with passcode 00000

Define User overloaded constructor that will take in a passcode to create an account with

Define saveProg(string prog) as a void method that will take in string prog and add it
to the arraylist userProgs

Define numProgs() as a void method that will create an integer equal to the size of the
userProgs arraylist and then create a for loop that will print options for each slot

Define loadProg(int pos) as a void method that will take in an int and print that
position of the userProgs arraylist

End class definition

UserMenu.java

Import java.util

Start class definition

Declare arraylist genProg which will hold and print generated arrays and string prog
which will hold finished progressions

Define string array notes for all the notes on a keyboard which will be used to translate
chord progressions from roman numerals to letters and will be used to generate blues and
random chord progressions

Define string arrays for each chord of each progression that hold each chords options for
which chord to go to next

Start main

Create an instance of UserMenu

End main

Define UserMenu constructor really just empty because it isnt needed

Define genMajor() as a void method which will clear the genProg arraylist and start on a
random chord from the major group of chords and then will put that chord in the arrayList
genProg and will then go to the pasted chords array and repeats the process of randomly
selecting a chord from that array, pasting it, and going to that chords array until 
stopping after pasting a one chord into genProg when its over 8 chords long
and then prints the entire arraylist for the user

Define genMinor() as a void method which will do the same thing as genMajor but using the
minor set of chord arrays

Define genJazz() as a void method which will do the same thing as genMajor but using the
jazz set of chord arrays

Define genBlues() as a void method which will clear genProg and ask for a note to use for 
the key (ab-g), if the user puts in a uppercase letter, the program will make it lowercase
and put it in the genProg array, and then use it as the starting point in the notes array
and use that position to find where the four and five chord are and once it has all three
chords it will use those chords to make a twelve bar blues progression, convert it to a string
and print it out

Define genRand() as a void method which will pluck notes at random from the notes array and
will randomly decide to put the note into the progression as a major, minor,
major seventh, minor seventh, or dominant chord until it pastes 8 chords which are then
converted to a string and printed

Define setKey(string note, int counter) as a void method that will take the user input root
note and find that position in the notes array, then the progression will be split up using
a space delimiter and after that a for loop will run for each chord where each chord will be
split up using an underscore delimiter to separate the chord number from its quality where the
chord number will be taken and replaced with a note name, this is done for each chord which
is then added to a finalprog string and printed

Define getProg as a method that returns string prog

Menu.java

Import java.util

Import java.io

Start class definition

Declare int passcode, check, and counter

Start main

Start scanner

Ask the user if they want to create a new account or log in

If the user chooses to create a new account they will be asked to input a passcode using
digits, if they dont input a number there will be an exception that tells the user they need
to input a digit

When the user inputs a digit, the program will scan through users.txt to see if an
account already exists with that information

If there is an account with that information, the program will tell the user to input a
new passcode

If there is no account with that information, the program will create a new instance of
user with that passcode and then will add a new line to users.txt and paste the users
passcode on the line

If the  user chooses to log in, the program will ask them to put in their passcode

The program will take the digit that the user puts in, assign it to int passcode and compare
it to the passcodes in users.txt

If it doesnt find a match it will ask the user to retry

If it does find a match it will load the user object in to User u using object serialization
and then it will paste the user menu options

The user will be able to select from the options of generating a chord progression in a
major key, generating a chord progression in a minor key, generating a chord progression
with a jazz sound, generating a 12 bar blues progression, or generating a completely
random chord progression, or to load a progression

If the user chooses to generate a chord progression in a major key, then the program
will call genMajor() from the userMenu class

If the user chooses to generate a chord progression in a minor key, then the program
will call genMinor() from the userMenu class

If the user chooses to generate a jazz chord progression, then the program will call
genJazz() from the userMenu class

If the user chooses to generate a 12 bar blues chord progression, then the program
will call genBlues() from the userMenu class

If the user chooses to generate a random chord progression, then the program will
call genRand() from the userMenu class

If the user chooses to load a chord progression, then the program will call
loadProg() from the userMenu class

After any of these are selected and the result is output (with the exception of
the random and loaded progression) the user can choose to set a key where they will be asked
to select a note ab-g which will then be used to call setKey(string note, int counter) and
the resulting progression will be printed

After being set to a key or if the progression was randomly generated, the user
can choose to save the progression

If they choose to save the progression, the progression will be used to call
saveProg(string prog)

After choosing to save or not the user can choose to generate another progression

Define Menu constructor to set values for passcode, check, and counter

Define checkLogin() as a method that takes in an integer passcode and reads in a txt file
that holds all the passcodes and reads in each passcode and compares it to the passcode and
if one matches it then the method returns a 1 if not then the method returns a 0


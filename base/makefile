Menu.class: Menu.java UserMenu.java User.java
	javac -g Menu.java

UserMenu.class: UserMenu.java User.java
	javac -g UserMenu.java

User.class: User.java
	javac -g User.java

run: Menu.class
	java Menu

runUserMenu: UserMenu.class
	java UserMenu

runUser: User.class
	java User

clean:
	rm *.class

debug: Menu.class
	jdb Menu

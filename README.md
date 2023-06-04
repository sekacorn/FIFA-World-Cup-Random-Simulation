# FIFA-World-Cup-Random-Simulation
This is as the name suggests a random simulation of world football competion called the World Cup. 


How to Run
==========
1) Make sure your Machine (Computer) turned on  and that you have logged in your user account

2) Make sure  you have Java Development Kit (JDK) installed on your computer. If you dont look it up online. Download and install it
      -If you have just installed it, make sure the environment variables have been updated and set. 
        If you don't know how to do it no worries, browse the Internet to learn how to do it on your machine. Then, follow Step 3

3) Download the WorldCupSimulation.java file.

4) Open a command prompt  for Windows Users or terminal for Linux/ Unix users (include MacOS users) and navigate to the directory where the file is saved.

5) Compile the code by executing the following command:

   '''
   javac WorldCupSimulation.java
   '''
   
6) Run the program with the following command:

   '''
   java WorldCupSimulation
   '''
   
   
Decription
------------------
The program simulates the World Cup tournament with the following steps:
--------------------------------------------------------------------

a) The list of teams participating in the World Cup is defined and then 
the teams are divided into groups using the createGroups method.
Next is round of 16 matches is played using the playRound method with the groups as input.
After that the quarter-finals, semi-finals, and finals are played similarly, with the winners progressing to the next round.

b) The final match is played using the playFinals method, and the winner is determined.
The results of each round and the winner are displayed on the console.
Modifications and Customization

c) You can modify the list of teams by updating the teams list in the main method.
The number of groups and teams per group can be modified by changing the values in the createGroups method.
The scoring logic and random goals generation can be customized in the playMatch method.

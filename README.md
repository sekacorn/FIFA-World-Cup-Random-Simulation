# FIFA-World-Cup-Random-Simulation
This is as the name suggests a random simulation of world football competion called the World Cup. 


How to Run
==========
1)Make sure  you have Java Development Kit (JDK) installed on your machine.

2)Download the WorldCupSimulation.java file.

3)Open a command prompt or terminal and navigate to the directory where the file is saved.

4)Compile the code by executing the following command:

   '''javac WorldCupSimulation.java
   
5) Run the program with the following command:

   '''java WorldCupSimulation
   
   
   
Program Description
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

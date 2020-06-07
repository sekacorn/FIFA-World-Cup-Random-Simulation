import java.util.*;
//Sekacorn


public class WorldCupSimulation {
	
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
	int x,q,w,e,r,t,y,u;//Variables used for forloops
	String WinningTeam =" ";
	Vector<String> GroupA = new Vector();//Groups for Teams
	Vector<String> GroupB = new Vector();
	Vector<String> GroupC = new Vector();
	Vector<String> GroupD = new Vector();
	Vector<String> GroupE = new Vector();
	Vector<String> GroupF = new Vector();
	Vector<String> GroupG = new Vector();
	Vector<String> GroupH = new Vector();
	Vector<String>Round16 = new Vector(16);
	Vector<String>QuarterFinals = new Vector(16);
	Vector<String>SemiFinals = new Vector();
	Vector<String>Finals = new Vector();
	String FinalWinner =" ";
	 String[] teams ={"Russia", "Saudi Arabia", "Egypt","Uruguay", "Spain",
			 "Portugal","Iran","Morocco","France","Denmark","Peru", "Australia",
			 "Croatia","Argentina","Nigeria", "Iceland","Brazil","Switzerland", "Serbia",
			 "Costa Rica", "Sweden","Mexico", "Korea Republic", "Germany", "Belgium", "England",
			 "Tunisia", "Panama", "Colombia", "Japan", "Senegal", "Poland"};
	 //Grouping 32 teams to the respectable Groups
	 			
	 
					 for(int i = 0; i<32; i++) {
						
						if (i<4) {
							
							GroupA.addElement(teams[i]);
						}
						else if(i>=4&&i<8) {
							GroupB.addElement(teams[i]);
						}
						else if(i>=8&&i<12) {
							GroupC.addElement(teams[i]);
						}
						else if(i>=12&&i<16) {
							GroupD.addElement(teams[i]);
						}
						else if(i>=16&&i<20) {
							GroupE.addElement(teams[i]);
						}
						else if(i>=20&&i<24) {
							GroupF.addElement(teams[i]);
						}
						else if(i>=24&&i<28) {
							GroupG.addElement(teams[i]);
						}
						else if(i>=28&&i<32) {
							
							GroupH.addElement(teams[i]);
						}
						
					} x =0; q=0; w=0; e=0; r =0; t=0; y =0; u=0;
					 
					//Finds the Group Winners and then adds them to the Round of 16
					 for(int a =0; a<2; a++) {
						 
						WinningTeam= Winner(GroupA.elementAt(x),GroupA.elementAt(++x));
					 	++x;
						Round16.addElement(WinningTeam);
						WinningTeam= Winner(GroupB.elementAt(q),GroupB.elementAt(++q));
					 	++q;
						Round16.addElement(WinningTeam);
						WinningTeam= Winner(GroupC.elementAt(w),GroupC.elementAt(++w));
					 	++w;
						Round16.addElement(WinningTeam);
						WinningTeam= Winner(GroupD.elementAt(e),GroupD.elementAt(++e));
					 	++e;
						Round16.addElement(WinningTeam);
						WinningTeam= Winner(GroupE.elementAt(r),GroupE.elementAt(++r));
					 	++r;
						Round16.addElement(WinningTeam);
						WinningTeam= Winner(GroupF.elementAt(t),GroupF.elementAt(++t));
					 	++t;
						Round16.addElement(WinningTeam);
						WinningTeam= Winner(GroupG.elementAt(y),GroupG.elementAt(++y));
					 	++y;
						Round16.addElement(WinningTeam);
						WinningTeam= Winner(GroupH.elementAt(u),GroupH.elementAt(++u));
					 	++u;
						Round16.addElement(WinningTeam);
						}
					 System.out.println("===============================================");
					 System.out.println("Round of 16 Winners");
					 System.out.print(Round16+"\n");
					 System.out.println("===============================================");
					 	x =0; 
					 	
					 	//Round of 16 Matches
					 for(int a =0; a<8; a++) {
						 WinningTeam= Winner(Round16.elementAt(x),Round16.elementAt(++x));
						 QuarterFinals.addElement(WinningTeam);
						 ++x;
						 
						 
						 
					 } 
					 System.out.println("***********************************************");
					 System.out.println("Quarter Finals");
					 System.out.print(QuarterFinals+"\n");
					 System.out.println("***********************************************");
					 
					 x=0;
					 
					 //QuarterFinal Matches
					 for(int a =0; a< 4; a++) {
						 WinningTeam= Winner(QuarterFinals.elementAt(x),QuarterFinals.elementAt(++x));
						 SemiFinals.addElement(WinningTeam);
						 ++x;
						 
					 }
					 System.out.println("-----------------------------------------------");
					 System.out.println("Semi Finals");
					 System.out.print(SemiFinals+"\n");
					 System.out.println("-----------------------------------------------");
					 //SemiFinal Matches
					 x=0;
					 for(int a =0; a< 2; a++) {
						 WinningTeam= Winner(SemiFinals.elementAt(x),SemiFinals.elementAt(++x));
						 Finals.addElement(WinningTeam);
						 ++x;
						 
					 }
					 System.out.println("################################################");
					 System.out.println("Finals");
					 System.out.println("################################################");
					 //Final Match
					 WinningTeam= Winner(Finals.elementAt(1),Finals.elementAt(0));
					 
					 
					 System.out.print(Finals+"\n");
					 System.out.println("The winner for the current FIFA World Cup is "+WinningTeam);
	
	
	}
	public  static String Winner(String team1, String team2) {
		int a, b;
		String Winner="";
		a= (int)(Math.random()*(7-0));
		b = (int)(Math.random()*(7-0));
		if(a>b) {
			System.out.println(team1+"	"+a+" - "+b+"	"+team2+":	"+team1+" is the winner" );
			Winner = team1;
		}
		else if(a<b) {
			System.out.println(team1+"	"+a+" - "+b+"	"+team2+":	"+team2+" is the winner" );
			Winner = team2;
		}
		else if (a==b){//If there is a tie the functions runs recursively
			Winner =Winner(team1, team2);
		}
		
		return Winner;
	}
	

}

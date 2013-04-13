import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class AttendanceModify {
  static Scanner input=new Scanner(System.in);
	static int recieve;
	static int abtot=0;
	static int prtot = 0;
	static String clas;
	static String lect;
	static String rep;
	
	/*CREATE METHOD students which will Take a list of index numbers in the form of an Array*/
	public static  void students(ArrayList<Integer> xx){
		Date date = new Date();
		//CREATE JAVA FILE CREATER/READER 
		//new Formatter(new BufferedWriter(new FileWriter("src/Orders.txt", true)));
		Formatter xl=null;
		  try{
				//STORE FILE IN Attendance.txt
			
				xl=new Formatter(new BufferedWriter(new FileWriter("Attendance.txt", true)));
				System.out.println();
			}
			catch(Exception e){
				
				System.out.println("error");
			}
		  
		
		 //THIS ARRAYLIST STORES THE NUMBER  THE STUDENTS IN THE FORM OF "1's" & "0's"
		ArrayList<Integer>arr=new ArrayList<Integer>();
		
		//THIS ARRAYLIST WILL MAP arr TO IT INDEX AND ASSIGN A BOOLEAN
		ArrayList<Boolean>bool=new ArrayList<Boolean>();
		
		//THIS ARRAYLIST WILL MAP bool AND ASSIGN A STRING VARIABLE IN THE FORM OF "ABSENT " & "PRESENT"
		ArrayList<String>strin=new ArrayList<String>();
		
		// THIS FOR LOOP WILL LOOP THROUGH AN ARRAY CONTAINING STUDENT INDEX NUMBERS
		for(int i=0;i<xx.size();i++){
			
			//WHILE LOOPING
			
			System.out.printf("%s : ",xx.get(i));
		   //VARIABLE recieve WILL TAKE THE INPUT INTEGER
			recieve=input.nextInt();
			//recieve VARIABLE WILL BE ADDED TO ARRALIST arr
			arr.add(recieve);
			if(recieve==1){
				
				++prtot;
			}else{
				
				++abtot;
			}
			
			//THIS TENARY OPERATOR WILL CHECK THE INDEX VALUES IN arr,IF IT IS "1" IT ADD A BOOLEAN TRUE TO ARRAYLIST bool ELSE ADD FALSE
			if(arr.get(i)==1?bool.add(true):bool.add(false));
			
}
		xl.format("%s\n","*****************************************************************");
		xl.format("%s\n",date.toString());
		xl.format("%s\n","---------------------------------");
		xl.format("%s%8s\n", "CLASS ATTENDANCE FOR : ",clas);
		xl.format("%s\n","");
		xl.format("%s%6s\n", "LECTURER: ",lect);
		xl.format("%s\n","");
		xl.format("%s%10s%s%12s\n", "COURSE REP FOR ",clas ," : ", rep);
		xl.format("%s\n","");
		xl.format("%s\n","---------============================================-------");
		xl.format("%10s%20s%22s\n","INDEX # ", "  ", "ATTENDANCE");
		xl.format("%s\n","------------------------------------------------------------");
		
		//THIS FOR LOOP WILL LOOP THOUGH ARRALIST bool AND ASSIGN INDEX VALUES TO ARRAYLIST strin
		for(int p=0;p<xx.size();p++){
			//TENARY OPERATOR WILL CHECK IF THE INDEX VALUES IN ARRAYLIST bool IS TRUE,WHEN TRUE,IT WILL MAP ARRAYLIST strin AND ADD A STRING VALUES "PRESENT" ELSE ADD "ABSENT"
			if(bool.get(p)==true?strin.add("Present"):strin.add("Absent"));
		
			//NOW WE US THE FORMATTER xl TO PRINT THE INDEX NUMBERS AND ABSENT OR PRESENT VALUES 
			xl.format("%10d%20s%30s\n",xx.get(p),"was",strin.get(p));
			
			
		}
		
		xl.format("%s\n","");
		xl.format("%10s%6d\n", "Total Number of Students Present : ",prtot);
		xl.format("%10s%6d\n", "Total Number of Students Absent : ",abtot);
		xl.format("%s\n","*****************************************************************");
		xl.format("%s\n","\n");
	
		//ALWAYS IMPORTANT TO CLOSE THE FORMATTER
		
		xl.close();
		JOptionPane.showMessageDialog(null,"FILE SAVED IN YOUR CURRENT WORKSPACE ","CLASS ATTENDANCE",JOptionPane.INFORMATION_MESSAGE);
		}
	//END OF students METHOD
	

	//METHOD TO UPDATE INDEX NUMBERS
	public static ArrayList<Integer> updateIndexnumbers(){
		//takingList tk;
		ArrayList<Integer> list=new ArrayList<Integer>();
		Scanner input=new Scanner(System.in);
		
		System.out.print(" Specify Class : ");
		clas=input.nextLine();
		System.out.print(" Identify  Lecturer  : ");
		 lect=input.nextLine();
	     System.out.print(" Identify Course Rep : ");
	     rep=input.nextLine();
		int ad;
		System.out.print(" Enter number of Students : ");
		System.out.println();
		int cplas=input.nextInt();
		for(int a=0;a<cplas;a++){
		System.out.println(" Enter Index Number : ");
		ad=input.nextInt();
		list.add(ad);
		
		}
		
		return list; 
		}
	
	
	public static void main(String args[])  {
		
		
		
		students(updateIndexnumbers());
		
		
		
		
		
	}
	
}

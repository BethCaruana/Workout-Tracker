//Trainer.java

import java.io.*;
import java.util.*;

public class Trainer extends User implements Serializable{
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();

	public static void main(String[] args){
		Trainer beth = new Trainer("Beth","Caruana","bcaruana","swimming");
		beth.menu();
	}//end main

	public Trainer(){
	}//end trainer constructor

	public Trainer(String fName, String lName, String userName, String password){
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
	}//end Trainer constructor

	public void menu(){
		System.out.println("\n");
		String line = "Please select what you would like to do:\n"+
			"(0) list all athletes\n"+
			"(1) view workout log of an athlete\n"+
			"(2) add an athlete\n"+
			"(3) delete an athlete\n"+
			"(4) add a comment to a workout\n"+
			"(5) exit \n";
		System.out.println(line);
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		int response = 0;
		boolean keepGoing = true;
		while(keepGoing){
			try{
                        	response = Integer.parseInt(num);
                	}//end try
           		catch(NumberFormatException e){
                	        System.out.println("Invalid response, must be a number");
        	        }//end catch
			if(response == 0){
				this.listAthletes();
				this.menu();
				keepGoing = false;
			}//end if
			else if(response == 1){
				this.viewWorkoutLog();
				this.menu();
				keepGoing = false;
			}//end else if
			else if(response == 2){
				this.addAthlete();
				this.menu();
				keepGoing = false;
			}//end else if
			else if(response == 3){
				this.deleteAthlete();
				this.menu();
				keepGoing = false;
			}//end else if
			else if(response == 4){
				this.addComment();
				this.menu();
				keepGoing = false;
			}//end else if
			else if(response == 5){
				System.out.println("Exiting program ...");
				keepGoing = false;
			}//end else if
			else {
				System.out.println("Invalid number entered. Try again.");
				this.menu();
				keepGoing = false;
			}//end else
		}//end while loop
	}//end menu

	public void listAthletes(){
		System.out.println("\n");
		for(int i=0; i<athletes.size();i++){
			System.out.println(i+" "+athletes.get(i).getfName()+" "+athletes.get(i).getlName()+" "+athletes.get(i).getUserName()+" "+athletes.get(i).getPassword());
		}//end for loop
	}//end listAthletes

	public void viewWorkoutLog(){
		System.out.println("\n");
		this.listAthletes();
		System.out.println("\n");
		System.out.println("Please enter the number next to the athlete you would like to view the workout log for: ");
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		int response = 0;
		try{
                       	response = Integer.parseInt(num);
			if(athletes.get(response).workoutsSize()>0){
				athletes.get(response).viewWorkouts();
			}//end if
			else{
				System.out.println("This athlete has no workouts");
			}//end else
               	}//end try
           	catch(NumberFormatException e){
                        System.out.println("Invalid response, must be a number");
       	        }//end catch
		catch(IndexOutOfBoundsException e){
			System.out.println("Invalid index number");
		}//end catch
	}//end viewWorkoutLog

	public void addAthlete(){
		System.out.println("\n");
		System.out.println("Please enter the first name of the new Athlete: ");
		Scanner input = new Scanner(System.in);
		String fName1 = input.nextLine();
		System.out.println("Please enter the last name of the new Athlete: ");
                Scanner input2 = new Scanner(System.in);
                String lName2 = input2.nextLine();
		System.out.println("Please enter the username of the new Athlete: ");
                Scanner input3 = new Scanner(System.in);
                String username3 = input3.nextLine();
		System.out.println("Please enter the password of the new Athlete: ");
                Scanner input4 = new Scanner(System.in);
                String password4 = input4.nextLine();
		athletes.add(new Athlete(fName1, lName2, username3, password4));
		System.out.println("Athlete: "+ fName1+" "+lName2+" "+username3+" "+password4+" has been added");
	}//end addAthlete

	public void deleteAthlete(){
		System.out.println("\n");
		this.listAthletes();
		System.out.println("\n");
		System.out.println("Please enter the number next to the athlete you would like to delete: ");
                Scanner input = new Scanner(System.in);
                String num = input.nextLine();
                int response = 0;
		int answer = 0;
                try{
                        response = Integer.parseInt(num);
                        System.out.println("Are you sure you want to delete "+ athletes.get(response).getfName()+"?\n"+
					"(0) Yes	(1) No");
			Scanner respond = new Scanner(System.in);
			String number = respond.nextLine();
			try{
				answer = Integer.parseInt(number);
			}//end try
			catch(NumberFormatException e){
				System.out.println("Invalid response, must be 1 or 0");
			}//end catch
			if(answer == 0){
				athletes.remove(response);
				System.out.println("Athlete has been deleted");
			}//end if
			else{
				System.out.println("Athlete was not deleted");
			}//end else
                }//end try
                catch(NumberFormatException e){
                        System.out.println("Invalid response, must be a number");
                }//end catch
		catch(IndexOutOfBoundsException e){
			System.out.println("Invalid index number");
		}//end catch
	}//end deleteAthlete

	public void addComment(){
		System.out.println("\n");
		this.listAthletes();
		System.out.println("\n");
		System.out.println("Please enter the number next to the athlete you would like to comment on: ");
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		int response = 0;
		int answer = 0;
		try{
			response = Integer.parseInt(num);
			if(athletes.get(response).workoutsSize()>0){
				athletes.get(response).viewWorkouts();
				System.out.println("\n");
				System.out.println("Please enter the number next to the workout you would like to comment on: ");
				Scanner input1 = new Scanner(System.in);
				String num1 = input1.nextLine();
				try{
					answer = Integer.parseInt(num1);
					System.out.println("\n");
					System.out.println("What would you like to comment on workout: ");
					athletes.get(response).listWorkout(answer);
					Scanner input2 = new Scanner(System.in);
					String comment = input2.nextLine();
					athletes.get(response).writeComment(answer,comment);
					System.out.println("\n");
					System.out.println("Comment has been set: "); 
					athletes.get(response).listWorkout(answer);
				}//end try
				catch(NumberFormatException e){
					System.out.println("Invalid response");
				}//end catch
			}//end if
			else{
				System.out.println("This athlete does not have any workouts to comment on");
			}//end else
			}//end try
		catch(NumberFormatException e){
			System.out.println("Invalid response");
		}//end catch
		catch(IndexOutOfBoundsException e){
			System.out.println("Invalid Index Number");
		}//end catch
		}//end addComment

	public String athleteUserName(int index){
		String username1 = athletes.get(index).getUserName();
		return username1;
	}//end athleteUserName

	public String athletePassword(int index){
		String password1 = athletes.get(index).getPassword();
		return password1;
	}//end athletePassword

	public int athleteSize(){
		return athletes.size();
	}//end athleteSize

	public void athleteMenu(int index){
		athletes.get(index).menu();
	}//end athleteMenu

}//end class def


		


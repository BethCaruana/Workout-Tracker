//Athlete.java

import java.io.*;
import java.util.*;

public class Athlete extends User implements Serializable{
	private ArrayList<Workouts> workouts = new ArrayList<Workouts>();

	public static void main(String[] args){
		Athlete a = new Athlete("Beth","Caruana","bcaruana","swimming");
		a.menu();
	}//end main

	public Athlete(){
	}//end Athlete constructor

	public Athlete(String fName, String lName, String userName, String password){
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
	}//end Athlete constructor

	public void menu(){
		System.out.println("\n");
		String line = "Please select what you would like to do:\n"+
			"(0) view workouts\n"+
			"(1) add workout\n"+
			"(2) view trends\n"+
			"(3) edit workout\n"+
			"(4) delete workout\n"+
			"(5) settings\n"+
			"(6) exit";
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
				this.viewWorkouts();
				this.menu();
				keepGoing = false;
			}//end if
			else if(response == 1){
				this.addWorkout();
				this.menu();
				keepGoing = false;
			}//end else if
			else if(response == 2){
				this.viewTrends();
				this.menu();
				keepGoing = false;
			}//end else if
			else if(response == 3){
				this.editWorkout();
				this.menu();
				keepGoing = false;
			}//end else if
			else if(response == 4){
				this.deleteWorkout();
				this.menu();
				keepGoing = false;
			}//end else if
			else if(response == 5){
				this.settings();
				this.menu();
				keepGoing = false;
			}//end else if
			else if(response == 6){
				System.out.println("Logging out ...");
				keepGoing = false;
			}//end else if
			else {
				System.out.println("Invalid number entered. Try again.");
				keepGoing = false;
			}//end else
		}//end while loop
	}//end menu

	public void addWorkout(){
		System.out.println("\n");
		String line = "Please select the type of workout you would like to add:\n"+
			"(0) Walk\n"+
			"(1) Run\n"+
			"(2) Bike\n"+
			"(3) Swim\n"+
			"(4) Lift\n"+
			"(5) Yoga\n"+
			"(6) Return to menu";
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
				this.menu();
        	        }//end catch
			if(response == 0){
				this.addWalkRunBikeSwim("walk");
				keepGoing = false;
			}//end if
			else if(response == 1){
				this.addWalkRunBikeSwim("run");
				keepGoing = false;
			}//end else if
			else if(response == 2){
				this.addWalkRunBikeSwim("bike");
				keepGoing = false;
			}//end else if
			else if(response == 3){
				this.addWalkRunBikeSwim("swim");
				keepGoing = false;
			}//end else if
			else if(response == 4){
				this.addYogaLift("lift");
				keepGoing = false;
			}//end else if
			else if(response == 5){
				this.addYogaLift("yoga");
				keepGoing = false;
			}//end else if
			else if(response == 6){
				keepGoing = false;
			}//end else if
			else {
				System.out.println("Invalid number entered. Try again.");
				this.addWorkout();
				keepGoing = false;
			}//end else
		}//end while loop
	}//end addWorkout

	public void addWalkRunBikeSwim(String name){
		try{
		//date
		System.out.println("Enter the month of the workout (Example: 04): ");
		Scanner input1 = new Scanner(System.in);
		String month = input1.nextLine();
		System.out.println("Enter the day of the workout (Example: 06): ");
                Scanner input2 = new Scanner(System.in);
                String day = input2.nextLine();
		System.out.println("Enter the year of the workout (Example: 2022): ");
                Scanner input3 = new Scanner(System.in);
                String year = input3.nextLine();
		String date = (month+"/"+day+"/"+year);

		//time
		System.out.println("Enter total minutes: ");
                Scanner input4 = new Scanner(System.in);
                String minutesTemp = input4.nextLine();
		double minutes = Double.parseDouble(minutesTemp);
		System.out.println("Enter total seconds: ");
                Scanner input5 = new Scanner(System.in);
                String secondsTemp = input5.nextLine();
		double seconds = Double.parseDouble(secondsTemp);

		//avgHR
		System.out.println("Enter average heart rate: ");
                Scanner input6 = new Scanner(System.in);
                String avgHRTemp = input6.nextLine();
		int avgHR = Integer.parseInt(avgHRTemp);

		//calories
		System.out.println("Enter total calories burned: ");
                Scanner input7 = new Scanner(System.in);
                String caloriesTemp = input7.nextLine();
		int calories = Integer.parseInt(caloriesTemp);

		//distance
		System.out.println("Enter total distance: ");
                Scanner input8 = new Scanner(System.in);
                String distanceTemp = input8.nextLine();
		double distance = Double.parseDouble(distanceTemp);

		if(name.equals("swim")){
			workouts.add(new Swim(name, date, minutes, seconds, avgHR, calories, distance));
		}//end if
		else{
			workouts.add(new WalkRunBike(name, date, minutes, seconds, avgHR, calories, distance));
		}//end else
		}//end try
		catch(NumberFormatException e){
			System.out.println("Answer must be a number. No new workout was created");
		}//end catch
	}//end addWalkRunBike

	public void addYogaLift(String name){
		//date
		System.out.println("Enter the month of the workout (Example: 04): ");
		Scanner input1 = new Scanner(System.in);
		String month = input1.nextLine();
		System.out.println("Enter the day of the workout (Example: 06): ");
                Scanner input2 = new Scanner(System.in);
                String day = input2.nextLine();
		System.out.println("Enter the year of the workout (Example: 2022): ");
                Scanner input3 = new Scanner(System.in);
                String year = input3.nextLine();
		String date = (month+"/"+day+"/"+year);

		//time
		System.out.println("Enter total minutes: ");
                Scanner input4 = new Scanner(System.in);
                String minutesTemp = input4.nextLine();
		double minutes = Double.parseDouble(minutesTemp);
		System.out.println("Enter total seconds: ");
                Scanner input5 = new Scanner(System.in);
                String secondsTemp = input5.nextLine();
		double seconds = Double.parseDouble(secondsTemp);

		//avgHR
		System.out.println("Enter average heart rate: ");
                Scanner input6 = new Scanner(System.in);
                String avgHRTemp = input6.nextLine();
		int avgHR = Integer.parseInt(avgHRTemp);

		//calories
		System.out.println("Enter total calories burned: ");
                Scanner input7 = new Scanner(System.in);
                String caloriesTemp = input7.nextLine();
		int calories = Integer.parseInt(caloriesTemp);

		workouts.add(new YogaLift(name, date, minutes, seconds, avgHR, calories));
	}//end addYogaLift

	public void viewWorkouts(){
		System.out.println("\n");
		for(int i=0; i<workouts.size();i++){
			System.out.println(i +" "+workouts.get(i).getWorkout());
		}//end for loop
	}//end viewWorkouts

	public void enduranceTrends(String name){
		System.out.println("\n");
		int count = 0;
		double minutes = 0;
		double seconds = 0;
		int avgHR = 0;
		int calories = 0;
		double distance = 0;	
		//reverse for loop
		for (int i = workouts.size() - 1; i>=0 ; i--){
			if(workouts.get(i).getName().equals(name)){
				minutes = minutes + workouts.get(i).getMinutes();
				seconds = seconds + workouts.get(i).getSeconds();
				avgHR = avgHR + workouts.get(i).getAvgHR();
				calories = calories + workouts.get(i).getCalories();
				distance = distance + ((WalkRunBike) workouts.get(i)).getDistance();
				count++;		
			}//end if
			else if(count == 3){
				break;
			}//end else if
		}//end for loop
		
		double avgMinutes = minutes/3;
		double avgSeconds = seconds/3;
		double durationTemp = (avgMinutes*60) + avgSeconds;
                double Minutes = durationTemp/60;
                int mins = (int)Math.round(Minutes);
                double Seconds = durationTemp%60;
                int secs = (int)Math.round(Seconds);
		int avgAvgHR = avgHR/3;
		int avgCalories = calories/3;
		double avgDistanceTemp = distance/3;
		double avgDistance =Math.round(avgDistanceTemp*100.0)/100.0;

		//manually calculate Pace
		double tempMin = avgMinutes*60;
		double totalTime = tempMin+avgSeconds;
		double tempPace = totalTime/avgDistance;
		double minTemp = tempPace/60;
		int min = (int)Math.round(minTemp);
		double tempSec = tempPace%60;
		int sec = (int)Math.round(tempSec);
		String pace1;
		if(name.equals("Swim")){
			pace1 = (min+":"+sec+"/100yards");
		}//end if
		else {
			pace1 = (min+"'"+sec+"'' per mile");
		}//end else
	
		if(count < 3){
			System.out.println("Not enough data to provide trends. Need at least 3 workouts to view trends.");
		}//end if
		else{
			System.out.println("Averages for last three "+ name+" workouts:\n"+
					"Pace: "+ pace1 + "\n"+
					"Duration: "+mins+" mins "+secs+" secs\n"+
					"Distance: "+ avgDistance+ "\n"+
					"Average Heart Rate: "+avgAvgHR+ "\n"+
					"Calories: "+avgCalories+ "\n");
		}//end else
	}//end enduranceTrends

	public void swimTrends(String name){
		System.out.println("\n");
                int count = 0;
                double minutes = 0;
                double seconds = 0;
                int avgHR = 0;
                int calories = 0;
                double distance = 0;
                //reverse for loop
                for (int i = workouts.size() - 1; i>=0 ; i--){
                        if(workouts.get(i).getName().equals(name)){
                                minutes = minutes + workouts.get(i).getMinutes();
                                seconds = seconds + workouts.get(i).getSeconds();
                                avgHR = avgHR + workouts.get(i).getAvgHR();
                                calories = calories + workouts.get(i).getCalories();
                                distance = distance + ((Swim) workouts.get(i)).getDistance();
                                count++;
                        }//end if
                        else if(count == 3){
                                break;
                        }//end else if
                }//end for loop
		double avgMinutes = minutes/3;
                double avgSeconds = seconds/3;
                double durationTemp = (avgMinutes*60) + avgSeconds;
                double Minutes = durationTemp/60;
                int mins = (int)Math.round(Minutes);
                double Seconds = durationTemp%60;
                int secs = (int)Math.round(Seconds);
                int avgAvgHR = avgHR/3;
                int avgCalories = calories/3;
                double avgDistanceTemp = distance/3;
                double avgDistance =Math.round(avgDistanceTemp*100.0)/100.0;

                //manually calculate Pace
                double tempMin = avgMinutes*60;
                double totalTime = tempMin+avgSeconds;
		double distanceTemp = avgDistance/100;
                double tempPace = totalTime/distanceTemp;
                double minTemp = tempPace/60;
                int min = (int)Math.round(minTemp);
                double tempSec = tempPace%60;
                int sec = (int)Math.round(tempSec);
                String pace1;
		pace1 = (min+":"+sec+"/100yards");

		if(count < 3){
                        System.out.println("Not enough data to provide trends. Need at least 3 workouts to view trends.");
                }//end if
                else{
                        System.out.println("Averages for last three "+ name+" workouts:\n"+
                                        "Pace: "+ pace1 + "\n"+
                                        "Duration: "+mins+" mins "+secs+" secs\n"+
                                        "Distance: "+ avgDistance+ "\n"+
                                        "Average Heart Rate: "+avgAvgHR+ "\n"+
                                        "Calories: "+avgCalories+ "\n");
                }//end else
	}//end swimTrends

	public void yogaLiftTrends(String name){
		System.out.println("\n");
		int count = 0;
		double minutes = 0;
		double seconds = 0;
		int avgHR = 0;
		int calories = 0;
		double distance = 0;
		//reverse for loop
		for (int i = workouts.size() - 1; i>=0 ; i--){
			if(workouts.get(i).getName().equals(name)){
				minutes = minutes + workouts.get(i).getMinutes();
				seconds = seconds + workouts.get(i).getSeconds();
				avgHR = avgHR + workouts.get(i).getAvgHR();
				calories = calories + workouts.get(i).getCalories();
				count++;
			}//end if
			else if(count == 3){
				break;
			}//end else if
		}//end for loop

		double avgMinutes = minutes/3;
		double avgSeconds = seconds/3;
		double durationTemp = (avgMinutes*60) + avgSeconds;
		double Minutes = durationTemp/60;
		int mins = (int)Math.round(Minutes);
		double Seconds = durationTemp%60;
		int secs = (int)Math.round(Seconds);
		int avgAvgHR = avgHR/3;
		int avgCalories = calories/3;
		double avgDistance = distance/3;

		if(count < 3){
			System.out.println("Not enough data to provide trends. Need at least 3 workouts to view trends.");
		}//end if
		else{
			System.out.println("Averages for last three "+ name+" workouts:\n"+
					"Duration: "+ mins+" mins "+secs+" secs\n"+
					"Average Heart Rate: "+avgAvgHR+ "\n"+
					"Calories: "+avgCalories+ "\n");
		}//end else
	}//end yogaLiftTrends
		
	public void viewTrends(){
		System.out.println("\n");
		System.out.println("Select the workout type you would like to view trends for: \n"+
			"(0) Walk\n"+
			"(1) Run\n"+
			"(2) Bike\n"+
			"(3) Swim\n"+
			"(4) Lift\n"+
			"(5) Yoga\n"+
			"(6) Return to menu");
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
				this.enduranceTrends("walk");
				keepGoing = false;
			}//end if
			else if(response == 1){
				this.enduranceTrends("run");
				keepGoing = false;
			}//end else if
			else if(response == 2){
				this.enduranceTrends("bike");
				keepGoing = false;
			}//end else if
			else if(response == 3){
				this.swimTrends("swim");
				keepGoing = false;
			}//end else if
			else if(response == 4){
				this.yogaLiftTrends("lift");
				keepGoing = false;
			}//end else if
			else if(response == 5){
				this.yogaLiftTrends("yoga");
				keepGoing = false;
			}//end else if
			else if(response == 6){
				keepGoing = false;
			}//end else if
			else {
				System.out.println("Invalid number entered. Try again.");
				this.viewTrends();
				keepGoing = false;
			}//end else
		}//end while loop
	}//end viewTrends

	public void deleteWorkout(){
		System.out.println("\n");
		String line = "What type of workout would you like to delete? \n"+
			"(0) Walk\n"+
			"(1) Run\n"+
			"(2) Bike\n"+
			"(3) Swim\n"+
			"(4) Lift\n"+
			"(5) Yoga\n"+
			"(6) Return to menu";
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
				this.delete(this.listWorkout("walk"));
				keepGoing = false;
			}//end if
			else if(response == 1){
				this.delete(this.listWorkout("run"));
				keepGoing = false;
			}//end else if
			else if(response == 2){
				this.delete(this.listWorkout("bike"));
				keepGoing = false;
			}//end else if
			else if(response == 3){
				this.delete(this.listWorkout("swim"));
				keepGoing = false;
			}//end else if
			else if(response == 4){
				this.delete(this.listWorkout("lift"));
				keepGoing = false;
			}//end else if
			else if(response == 5){
				this.delete(this.listWorkout("yoga"));
				keepGoing = false;
			}//end else if
			else if(response == 6){
				keepGoing = false;
			}//end else if
			else {
				System.out.println("Invalid number entered. Try again.");
				this.deleteWorkout();
				keepGoing = false;
			}//end else
		}//end while loop
	}//end deleteWorkout

	public boolean listWorkout(String name){
		int count = 0;
		boolean present = false;
		for (int i = 0; i<workouts.size(); i++){
			if(workouts.get(i).getName().equals(name)){
				count++;
			}//end if
			}//end for loop
		if(count>=1){
			for(int x=0; x<workouts.size();x++){
				if(workouts.get(x).getName().equals(name)){
					System.out.println(x+" "+workouts.get(x).getWorkout());
					present = true;
				}//end if
			}//end for loop
		}//end if
		else if(count==0){
			System.out.println("No workouts of this type exist");
			present = false;
		}//end else if
		return present;
	}//end listWorkout

	public void listWorkout(int index){
		System.out.println(workouts.get(index).getWorkout());
	}//end listWorkout

	public void writeComment(int index,String comment){
		workouts.get(index).setComment(comment);
	}//end writeComment


	public void delete(boolean present){
		System.out.println("\n");
		if(present == true){
			System.out.println("Please enter the number next to the workout you would like to delete: ");
			Scanner input = new Scanner(System.in);
			String num = input.nextLine();
			int response= 0;
			int answer= 0;
			try{
       		               	response = Integer.parseInt(num);
                		}//end try
           		catch(NumberFormatException e){
               	        	System.out.println("Invalid response, must be a number");
				this.delete(present);
        		        }//end catch
			try{
				System.out.println("Are you sure you would like to delete the following workout: \n"+
						workouts.get(response).getWorkout()+"\n"+
						"(0) Yes	(1) No");
				Scanner respond = new Scanner(System.in);
				String number = respond.nextLine();
				try{
                        		        answer = Integer.parseInt(number);
                        		}//end try
    		                    	catch(NumberFormatException e){
                	                	System.out.println("Invalid response, must be a number");
                        	        	this.delete(present);
                        		}//end catch
				if (answer == 0){
        	               		 workouts.remove(response);
					 System.out.println("The workout has been deleted");
        		        }//end if
               			else {
                        		System.out.println("The workout was not deleted");
               		 	}//end else
				}//end try
			catch(IndexOutOfBoundsException e){
				System.out.println("Invalid index number");
			}//end catch
		}//end if
		else{
			System.out.println("There are no workouts of this type");
		}//end else
		}//end delete

	public void editWorkout(){
		System.out.println("\n");
		String line = "What type of workout would you like to edit? \n"+
			"(0) Walk\n"+
			"(1) Run\n"+
			"(2) Bike\n"+
			"(3) Swim\n"+
			"(4) Lift\n"+
			"(5) Yoga\n"+
			"(6) Return to menu";
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
				this.enduranceEdit(this.listWorkout("walk"));
				keepGoing = false;
			}//end if
			else if(response == 1){
				this.enduranceEdit(this.listWorkout("run"));
				keepGoing = false;
			}//end else if
			else if(response == 2){
				this.enduranceEdit(this.listWorkout("bike"));
				keepGoing = false;
			}//end else if
			else if(response == 3){
				this.enduranceEdit(this.listWorkout("swim"));
				keepGoing = false;
			}//end else if
			else if(response == 4){
				this.yogaLiftEdit(this.listWorkout("lift"));
				keepGoing = false;
			}//end else if
			else if(response == 5){
				this.yogaLiftEdit(this.listWorkout("yoga"));
				keepGoing = false;
			}//end else if
			else if(response == 6){
				keepGoing = false;
			}//end else if
			else {
				System.out.println("Invalid number entered. Try again.");
				this.editWorkout();
				keepGoing = false;
			}//end else
		}//end while loop
	}//end editWorkout

	public int indexChoice(){
		System.out.println("\n");
		System.out.println("Please enter the number next to the workout you would like to edit: ");
                Scanner input = new Scanner(System.in);
                String num = input.nextLine();
                int response= 0;
                try{
                        response = Integer.parseInt(num);
                        }//end try
                catch(NumberFormatException e){
                        System.out.println("Invalid response, must be a number");
                        this.indexChoice();
                        }//end catch
		return response;
	}//end indexChoice

	public void enduranceEdit(boolean present){
		System.out.println("\n");
		if(present == true){
			int index = this.indexChoice();
			try{
				System.out.println("Current workout: "+ workouts.get(index).getWorkout());
		//	}//end try
		//	catch(IndexOutOfBoundsException e){
		//		System.out.println("Not a valid index number");
		//	}//end catch
			System.out.println("Please select which attribute you would like to change: \n"+
					"(0) name\n"+
					"(1) date\n"+
					"(2) time\n"+
					"(3) avg HR\n"+
					"(4) calories\n"+
					"(5) distance\n"+
					"(6) exit \n");
			Scanner input = new Scanner(System.in);
			String num = input.nextLine();
			int response = 0;
			boolean keepGoing = true;
			while(keepGoing){
				try{
                        		response = Integer.parseInt(num);
                	//	}//end try
           		//	catch(NumberFormatException e){
                	// 	      	System.out.println("Invalid response, must be a number");
        		//        }//end catch
				if(response == 0){
					this.editName(index);
					keepGoing = false;
				}//end if
				else if(response == 1){
					this.editDate(index);
					keepGoing = false;
				}//end else if
				else if(response == 2){
					this.editTime(index);
					keepGoing = false;
				}//end else if
				else if(response == 3){
					this.editAvgHR(index);
					keepGoing = false;
				}//end else if
				else if(response == 4){
					this.editCalories(index);
					keepGoing = false;
				}//end else if
				else if(response == 5){
					this.editDistance(index);
					keepGoing = false;
				}//end else if
				else if(response == 6){
					keepGoing = false;
				}//end else if
				else {
					System.out.println("Invalid number entered. Try again.");
					this.enduranceEdit(present);
					keepGoing = false;
				}//end else
			       }//end try
                                catch(NumberFormatException e){
                                        System.out.println("Invalid response, must be a number");
					this.enduranceEdit(present);
                                }//end catch
			//	catch(IndexOutOfBoundsException e){
			//		System.out.println("Not a valid index number");
			//		this.enduranceEdit(present);
			//	}//end catch	
			}//end while loop
			}//end try
                        catch(IndexOutOfBoundsException e){
                                System.out.println("Not a valid index number");
                        }//end catch
		}//end if
		}//end enduranceEdit

	public void editName(int index){
		System.out.println("\n");
		System.out.println("Current workout: "+ workouts.get(index).getWorkout());
		int response = 0;
		boolean keepGoing1 = true;
		System.out.println("Select the workout type you would like to change to: \n"+
						"(0) Walk\n"+
						"(1) Run\n"+
						"(2) Bike\n"+
						"(3) Swim\n"+
						"(4) Lift\n"+
						"(5) Yoga\n"+
						"(6) Exit\n");
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		try{
                        response = Integer.parseInt(num);
                      	}//end try
                catch(NumberFormatException e){
                        System.out.println("Invalid response, must be a number");
                        }//end catch
		while(keepGoing1){
			if(response == 0){
				workouts.get(index).setName("walk");
				System.out.println("Workout name has been changed");
				keepGoing1 = false;
				}//end if
			else if(response == 1){
				workouts.get(index).setName("run");
				System.out.println("Workout name has been changed");
				keepGoing1 = false;
				}//end else if
			else if(response == 2){
				workouts.get(index).setName("bike");
				System.out.println("Workout name has been changed");
				keepGoing1 = false;
				}//end else if
			else if(response == 3){
				workouts.get(index).setName("swim");
				System.out.println("Workout name has been changed");
				keepGoing1 = false;
				}//end else if
			else if(response == 4){
				workouts.get(index).setName("lift");
				System.out.println("Workout name has been changed");
				keepGoing1 = false;
				}//end else if
			else if(response == 5){
				workouts.get(index).setName("yoga");
				System.out.println("Workout name has been changed");
				keepGoing1 = false;
				}//end else if
			else if(response == 6){
				keepGoing1 = false;
				}//end else if
			else {
				System.out.println("Invalid number entered. Try again.");
				this.editName(index);
				keepGoing1 = false;
				}//end else
			}//end while loop
	}//end editName

	public void editDate(int index){
		System.out.println("\n");
		System.out.println("Current workout: "+ workouts.get(index).getWorkout());
		System.out.println("Please enter the new month: ");
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		System.out.println("Please enter the new day: ");
                Scanner input1 = new Scanner(System.in);
                String num1 = input1.nextLine();
		System.out.println("Please enter the new year: ");
                Scanner input2 = new Scanner(System.in);
                String num2 = input2.nextLine();
		String date = (num+"/"+num1+"/"+num2);
		workouts.get(index).setDate(date);
		System.out.println("Date has been changed");
	}//end editDate

	public void editTime(int index){
		System.out.println("\n");
		System.out.println("Current workout: "+ workouts.get(index).getWorkout());
		System.out.println("Please enter the new minutes: ");
                Scanner input = new Scanner(System.in);
                String num = input.nextLine();
		double minutes = Double.parseDouble(num);
                System.out.println("Please enter the new seconds: ");
                Scanner input1 = new Scanner(System.in);
                String num1 = input1.nextLine();
		double seconds = Double.parseDouble(num1);
		workouts.get(index).setMinutes(minutes);
		workouts.get(index).setSeconds(seconds);
		if(workouts.get(index).getName().equals("swim")){
			double distance = ((Swim) workouts.get(index)).getDistance();
			((Swim)workouts.get(index)).setPace(((Swim) workouts.get(index)).calculatePace(distance,minutes,seconds));
		}//end if
		else if(workouts.get(index).getName().equals("yoga")){
		}//end else if
		else if(workouts.get(index).getName().equals("lift")){
		}//end else if
		else{
			double distance = ((WalkRunBike) workouts.get(index)).getDistance();
			((WalkRunBike)workouts.get(index)).setPace(((WalkRunBike) workouts.get(index)).calculatePace(distance,minutes,seconds));
		}//end else
		System.out.println("Time has been changed");
	}//end editTime

	public void editAvgHR(int index){
		System.out.println("\n");
		System.out.println("Current workout: "+ workouts.get(index).getWorkout());
		System.out.println("Please enter the new average heart rate: ");
                Scanner input = new Scanner(System.in);
                String num = input.nextLine();
		int HR = Integer.parseInt(num);
		workouts.get(index).setAvgHR(HR);
		System.out.println("Average heart rate has been changed");
	}//end editAvgHR

	public void editCalories(int index){
		System.out.println("\n");
		System.out.println("Current workout: "+ workouts.get(index).getWorkout());
                System.out.println("Please enter the new calories: ");
                Scanner input = new Scanner(System.in);
                String num = input.nextLine();
                int calories = Integer.parseInt(num);
                workouts.get(index).setCalories(calories);
                System.out.println("Calories has been changed");
	}//end editCalories

	public void editDistance(int index){
		System.out.println("\n");
		System.out.println("Current workout: "+ workouts.get(index).getWorkout());
                System.out.println("Please enter the new distance: ");
                Scanner input = new Scanner(System.in);
                String num = input.nextLine();
                double distance = Double.parseDouble(num);
		if(workouts.get(index).getName().equals("swim")){
			((Swim)workouts.get(index)).setDistance(distance);
			double minutes = workouts.get(index).getMinutes();
			double seconds = workouts.get(index).getSeconds();
			((Swim) workouts.get(index)).setPace(((Swim) workouts.get(index)).calculatePace(distance,minutes,seconds));
			System.out.println("Distance has been changed");
		}//end if
		else{
			((WalkRunBike)workouts.get(index)).setDistance(distance);
                        double minutes = workouts.get(index).getMinutes();
                        double seconds = workouts.get(index).getSeconds();
                        ((WalkRunBike) workouts.get(index)).setPace(((WalkRunBike) workouts.get(index)).calculatePace(distance,minutes,seconds));
                	System.out.println("Distance has been changed");
		}//end else
	}//end editDistance

	public void yogaLiftEdit(boolean present){
		System.out.println("\n");
		if(present == true){
			int index = this.indexChoice();
			try{
			System.out.println("Current workout: "+ workouts.get(index).getWorkout());
			System.out.println("Please select which attribute you would like to change: \n"+
					"(0) name\n"+
					"(1) date\n"+
					"(2) time\n"+
					"(3) avg HR\n"+
					"(4) calories\n"+
					"(5) exit\n");
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
					this.editName(index);
					keepGoing = false;
				}//end if
				else if(response == 1){
					this.editDate(index);
					keepGoing = false;
				}//end else if
				else if(response == 2){
					this.editTime(index);
					keepGoing = false;
				}//end else if
				else if(response == 3){
					this.editAvgHR(index);
					keepGoing = false;
				}//end else if
				else if(response == 4){
					this.editCalories(index);
					keepGoing = false;
				}//end else if
				else if(response == 5){
					keepGoing = false;
				}//end else if
				else {
					System.out.println("Invalid number entered. Try again.");
					this.yogaLiftEdit(present);
					keepGoing = false;
				}//end else
			}//end while loop
			}//end try
                        catch(IndexOutOfBoundsException e){
                                System.out.println("Not a valid index number");
                        }//end catch
		}//end if
	}//end yogaLiftEdit

	public void settings(){
		System.out.println("\n");
		int response = 0;
		boolean keepGoing1 = true;
		System.out.println("Please select an option: \n"+
						"(0) view account information\n"+
						"(1) edit account information\n"+
						"(2) exit\n");
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		try{
                        response = Integer.parseInt(num);
                      	}//end try
                catch(NumberFormatException e){
                        System.out.println("Invalid response, must be a number");
                        }//end catch
		while(keepGoing1){
			if(response == 0){
				this.viewAccountInfo();
				this.settings();
				keepGoing1 = false;
				}//end if
			else if(response == 1){
				this.editAccountInfo();
				this.settings();
				keepGoing1 = false;
				}//end else if
			else if(response == 2){
				keepGoing1 = false;
				}//end else if
		}//end while loop
	}//end settings

	public void viewAccountInfo(){
		System.out.println("\n");
		System.out.println("Please enter your password: ");
                Scanner input = new Scanner(System.in);
                String password = input.nextLine();
                if(this.getPassword().equals(password)){
			System.out.println("Name: "+this.getfName()+" "+this.getlName()+" username: "+this.getUserName()+" password: "+this.getPassword());
                }//end if
                else{
                        System.out.println("Password incorrect. Redirecting to menu.");
                        this.menu();
                }//end else
	}//end viewAccountInfo

	public void editAccountInfo(){
		System.out.println("\n");
		System.out.println("Please enter your password: ");
		Scanner input = new Scanner(System.in);
		String password = input.nextLine();
		if(this.getPassword().equals(password)){
			System.out.println("Please select what you would like to change:\n"+
					"(0) first name\n"+
					"(1) last name\n" +
					"(2) username\n" +
					"(3) password\n"+
					"(4) exit\n");
			Scanner input1 = new Scanner(System.in);
			String num = input1.nextLine();
			int response = 0;
			boolean keepGoing = true;
			while(keepGoing){
				try{
                	        	response = Integer.parseInt(num);
               	//	 	}//end try
           	//		catch(NumberFormatException e){
                //		        System.out.println("Invalid response, must be a number");
   		     //	        }//end catch
				if(response == 0){
					System.out.println("Please enter your new first name: ");
					Scanner text = new Scanner(System.in);
					String fName = text.nextLine();
					this.setfName(fName);
					keepGoing = false;
				}//end if
				else if(response == 1){
					System.out.println("Please enter your new last name: ");
					Scanner text2 = new Scanner(System.in);
                                        String lName = text2.nextLine();
                                        this.setlName(lName);
					keepGoing = false;
				}//end else if
				else if(response == 2){
					System.out.println("Please enter your new username: ");
					Scanner text3 = new Scanner(System.in);
                                        String username = text3.nextLine();
                                        this.setUserName(username);
					keepGoing = false;
				}//end else if
				else if(response == 3){
					System.out.println("Please enter your new password: ");
					Scanner text4 = new Scanner(System.in);
                                        String password1 = text4.nextLine();
                                        this.setPassword(password1);
					keepGoing = false;
				}//end else if
				else if(response == 4){
					keepGoing = false;
				}//end else if
				}//end try
                                catch(NumberFormatException e){
                                        System.out.println("Invalid response, must be a number");
					keepGoing = false;
                                }//end catch
		}//end while loop
		}//end if
		else{
			System.out.println("Password incorrect. Redirecting to menu.");
		}//end else
	}//end editAccountInfo

	public int workoutsSize(){
		return this.workouts.size();
	}//end workoutsSize

}//end class def

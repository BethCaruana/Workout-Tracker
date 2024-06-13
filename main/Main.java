//Main.java

import java.io.*;
import java.util.*;

public class Main implements Serializable{
	private ArrayList<Trainer> trainers = new ArrayList<Trainer>();
	private static final long serialversionUID = 8683452581122892189L; 

	public static void main(String[] args){
		Main m = new Main();
		m.readFile();
		m.mainMenu();
		m.writeFile();
		
	}//end main

	@SuppressWarnings("unchecked")
	public void readFile(){
		try{
			FileInputStream file = new FileInputStream("Gym.txt");
			ObjectInputStream in = new ObjectInputStream(file);

			trainers = (ArrayList<Trainer>)in.readObject();

			in.close();
			file.close();

	//		System.out.println("Object has been deserialized");
		}//end try
		catch(IOException ex){
			System.out.println(ex);
			System.out.println("IOException is caught");
		}//end catch
		catch(ClassNotFoundException ex){
			System.out.println("ClassNotFoundException is caught");
		}//end catch
	}//end readFile

	public void writeFile(){
		try{
			FileOutputStream file = new FileOutputStream("Gym.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(trainers);

			out.close();
			file.close();

	//		System.out.println("Object has been serialized");
		}//end try
		catch (IOException ex){
			System.out.println("IOException is caught");
		}//end catch
	}//end writeFile

	public void mainMenu(){
		System.out.println("\n");
		String line = "Please select what you would like to do:\n"+
			"(0) log in\n"+
			"(1) add Trainer\n"+
			"(2) delete Trainer\n"+
			"(3) exit\n";
		System.out.println(line);
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		int response = 0;
		boolean keepGoing = true;
		try{
                response = Integer.parseInt(num);
		while(keepGoing){
			if(response == 0){
				this.login();
				keepGoing = false;
			}//end if
			else if(response == 1){
				this.addTrainer();
				keepGoing = false;
			}//end else if
			else if(response == 2){
				this.deleteTrainer();
				keepGoing = false;
			}//end else if
			else if(response == 3){
				keepGoing = false;
			}//end else if
			else {
				System.out.println("Invalid number entered. Try again.");
				this.mainMenu();
				keepGoing = false;
			}//end else
		}//end while loop
			}//end try
                        catch(NumberFormatException e){
                                System.out.println("Invalid response, must be a number");
				this.mainMenu();
                        }//end catch
	}//end mainMenu

	public void login(){
		System.out.println("Please enter your username: ");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine();
		System.out.println("Please enter your password: ");
		Scanner input1 = new Scanner(System.in);
		String password = input1.nextLine();
		for(int i=0; i<trainers.size();i++){
			if(trainers.get(i).getUserName().equals(username)){
				if(trainers.get(i).getPassword().equals(password)){
					trainers.get(i).menu();
					}//end if
				}//end if
		}//end for loop
		for(int z=0; z<trainers.size();z++){
			int size = trainers.get(z).athleteSize();
                        for(int x=0; x<size; x++){
				if(trainers.get(z).athleteUserName(x).equals(username)){
					if(trainers.get(z).athletePassword(x).equals(password)){
						trainers.get(z).athleteMenu(x);
						}//end if
					}//end if
			}//end for loop
		}//end for loop
		this.mainMenu();
	}//end login

	public void addTrainer(){
		System.out.println("Enter the admin password: ");
		Scanner respond = new Scanner(System.in);
		String admin = respond.nextLine();
		if(admin.equals("fun2workout")){
			System.out.println("Please enter the first name of the new trainer: ");
			Scanner input = new Scanner(System.in);
			String fName = input.nextLine();
			System.out.println("Please enter the last name of the new trainer: ");
        	        Scanner input2 = new Scanner(System.in);
        	        String lName = input2.nextLine();
			System.out.println("Please enter the username of the new trainer: ");
                	Scanner input3 = new Scanner(System.in);
	                String username = input3.nextLine();
			System.out.println("Please enter the password of the new trainer: ");
      		        Scanner input4 = new Scanner(System.in);
                	String password = input4.nextLine();

			trainers.add(new Trainer(fName, lName, username, password));
			System.out.println("New trainer "+fName+" has been added");
		}//end if
		else{
			System.out.println("Invalid password, redirecting to main menu...");
		}//end else
		this.mainMenu();
	}//end addTrainer

	public void listTrainers(){
		for(int i=0; i<trainers.size(); i++){
			System.out.println(i+" "+trainers.get(i).getfName());
		}//end for loop
	}//end listTrainers

	public void deleteTrainer(){
		System.out.println("Enter the admin password: ");
                Scanner respond = new Scanner(System.in);
                String admin = respond.nextLine();
                if(admin.equals("fun2workout")){
			this.listTrainers();
			System.out.println("Please enter the number next to the trainer you would like to delete: ");
			Scanner input = new Scanner(System.in);
			String num = input.nextLine();
			int response= 0;
			int answer= 0;
			try{
                        	response = Integer.parseInt(num);
                		}//end try
           		catch(NumberFormatException e){
                	        System.out.println("Invalid response, must be a number");
				this.mainMenu();
        	        }//end catch
			catch(IndexOutOfBoundsException e){
				System.out.println("Invalid Index Number");
				this.mainMenu();
			}//end catch
			try{
				System.out.println("Are you sure you would like to delete trainer "+trainers.get(response).getfName()+"?\n");
				System.out.println("(0) Yes	(1) No");
				Scanner input1 = new Scanner(System.in);
				String num1 = input1.nextLine();
				try{
					answer = Integer.parseInt(num1);
					if(answer == 0){
						trainers.remove(response);
						System.out.println("Trainer has been deleted");
					}//end if
					else{
						System.out.println("No changes were made");
						this.mainMenu();
					}//end else
				}//end try
				catch(NumberFormatException e){
                                	System.out.println("Invalid response, must be a number");
                                	this.mainMenu();
                        	}//end catch
			}//end try
			catch(IndexOutOfBoundsException e){
				System.out.println("Invalid index number");
				this.mainMenu();
		}//end catch
		}//end if
		else{
			System.out.println("Invalid password, redirecting to main menu...");
		}//end else
		this.mainMenu();
		}//end deleteTrainer
}//end class def

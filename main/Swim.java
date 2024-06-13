//Swim.java

import java.io.*;

public class Swim extends Workouts implements Endurance, Serializable{
	String pace;
	double distance;

	public static void main(String[] args){
		Swim s = new Swim("swim","09/13/2022",12,40,124,356,1000);
		System.out.println(s.getWorkout());
	}//end main

	public Swim(String name, String date, double minutes,double seconds, int avgHR, int calories, double distance){
		this.name = name;
		this.date = date;
		this.minutes = minutes;
		this.seconds = seconds;
		this.avgHR = avgHR;
		this.calories = calories;
		this.comment = "	";
		this.distance = distance;
		String pace = this.calculatePace(distance, minutes, seconds);
		this.pace = pace;
	}//end constuctor

	public String calculatePace(double distance, double minutes, double seconds){
		//convert minutes to seconds
		double tempTime = minutes*60;
		//add minutes and seconds
		double time = tempTime+seconds;
		//get the total amount of 100 yards swam
		double temp = distance/100;
		//divide time in sec by total distance
		double tempPace = time/temp;
		//convert pace to minutes
		double tempMin = tempPace/60;
		//round to get just the minutes
		int min = (int)Math.floor(tempMin);
		//convert pace to minutes--> save remainder
		double tempSec = tempPace%60;
		//round to get total seconds
		int sec = (int)Math.floor(tempSec);
		//concatinate everything into a string
		String pace = (min+":"+sec+"/100yards");
		return pace;
	}//end calculatePace

	public void setPace(String pace){
		this.pace = pace;
	}//end setPace

	public String getPace(){
		return this.pace;
	}//end getPace

	public void setDistance(double distance){
		this.distance = distance;
	}//end distance

	public double getDistance(){
		return this.distance;
	}//end getDistance

	public String getWorkout(){
		String name = this.getName();
		String date = this.getDate();
		double Tempminutes = this.getMinutes();
		int minutes = (int)Math.round(Tempminutes);
		double Tempseconds = this.getSeconds();
		int seconds = (int)Math.round(Tempseconds);
		int avgHR = this.getAvgHR();
		int calories = this.getCalories();
		double Tempdistance = this.getDistance();
		int distance = (int)Math.round(Tempdistance);
		String pace = this.getPace();
		String comment = this.getComment();
		String workout = (name + " " + date + " "+ minutes + " min "+seconds+" sec "+avgHR+" BPM "+calories+" calories "+distance+" yards  "+pace+" comment:"+comment);
		return workout;
	}//end getWorkout
}//end class def

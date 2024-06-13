//WalkRunBike.java

import java.io.*;

public class WalkRunBike extends Workouts implements Endurance, Serializable{
	String pace;
	double distance;

	public static void main(String[] args){
		WalkRunBike w = new WalkRunBike("run","11/17/2022",40,29,149,327,3.01);
		System.out.println(w.getWorkout());
	}//end main

	public WalkRunBike(String name, String date, double minutes, double seconds, int avgHR, int calories, double distance){
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
	}//end constructor

	public String calculatePace(double distance, double minutes, double seconds){
		//convert minutes to seconds
		double tempTime = minutes*60;
		//add seconds together
		double time = tempTime+seconds;
		//divide total time by distance
		double tempPace = time/distance;
		//store the quotient as minutes
		double tempMin = tempPace/60;
		int min = (int)Math.floor(tempMin);
		//store the remainder as seconds
		double tempSec = tempPace%60;
		int sec = (int)Math.floor(tempSec);
		//concatinate everything into a string
		String pace = (min+"'"+sec+"'' per mile");
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
	}//end setDistance

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
		String workout = (name + " " + date + " "+ minutes + " min "+seconds+" sec "+avgHR+" BPM "+calories+" calories "+distance+" miles  "+pace+" comment:"+comment);
		return workout;
	}//end getWorkout
}//end class def

//YogaLift.java

import java.io.*;

public class YogaLift extends Workouts implements Serializable{

	public static void main(String[] args){
		YogaLift y = new YogaLift("swim","01/23/2022",40,30,123,240);
		System.out.println(y.getWorkout());
	}//end main

	public YogaLift(String name, String date, double minutes,double seconds, int avgHR, int calories){
		this.name = name;
		this.date = date;
		this.minutes = minutes;
		this.seconds = seconds;
		this.avgHR = avgHR;
		this.calories = calories;
		this.comment = "	";
	}//end constructor

	public String getWorkout(){
		String name = this.getName();
		String date = this.getDate();
		double tempMinutes = this.getMinutes();
		int minutes = (int)Math.round(tempMinutes);
		double tempSeconds = this.getSeconds();
		int seconds = (int)Math.round(tempSeconds);
		int avgHR = this.getAvgHR();
		int calories = this.getCalories();
		String comment = this.getComment();
		String workout = (name + " " + date + " "+ minutes + " min "+ seconds+ " sec "+avgHR+" BPM "+calories+" calories comment: "+comment);
		return workout;
	}//end getWorkout

}//end class def

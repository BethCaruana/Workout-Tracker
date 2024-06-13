//Workouts.java

import java.io.*;

public abstract class Workouts implements Serializable{
	String name;
	String date;
	double minutes;
	double seconds;
	int avgHR;
	int calories;
	String comment;

/*	public static void main(String[] args){
		Workouts w = new Workouts("swim","11/15/2022",60, 135, 290);
		System.out.println(w.getName()+w.getDate()+w.getDuration()+w.getAvgHR()+w.getCalories()+w.getComment());
		w.setName("run");
		w.setDate("12/21/2022");
		w.setDuration(80);
		w.setAvgHR(145);
		w.setCalories(289);
		w.setComment("good workout");
		System.out.println(w.getName()+w.getDate()+w.getDuration()+w.getAvgHR()+w.getCalories()+w.getComment());
	}//end main
*/
/*	public Workouts(String name, String date, double duration, int avgHR, int calories){
		this.name = name;
		this.date = date;
		this.duration = duration;
		this.avgHR = avgHR;
		this.calories = calories;
		this.comment = "	";
	}//end constructor
*/
	public void setName(String name){
		this.name = name;
	}//end setName

	public String getName(){
		return this.name;
	}//end getName

	public void setDate(String date){
		this.date = date;
	}//end setDate

	public String getDate(){
		return this.date;
	}//end getDate

	public void setMinutes(double minutes){
		this.minutes = minutes;
	}//end setMinutes

	public double getMinutes(){
		return this.minutes;
	}//end getMinutes

	public void setSeconds(double seconds){
		this.seconds = seconds;
	}//end setSeconds

	public double getSeconds(){
		return this.seconds;
	}//end getSeconds

	public void setAvgHR(int avgHR){
		this.avgHR = avgHR;
	}//end setAvgHR

	public int getAvgHR(){
		return this.avgHR;
	}//end getAvgHR

	public void setCalories(int calories){
		this.calories = calories;
	}//end setCalories

	public int getCalories(){
		return this.calories;
	}//end getCalories

	public void setComment(String comment){
		this.comment = comment;
	}//end setComment

	public String getComment(){
		return this.comment;
	}//end getComment

	public abstract String getWorkout();

}//end abstract class def

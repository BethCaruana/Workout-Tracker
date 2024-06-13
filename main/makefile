Main.class:		Main.java Trainer.class Athlete.class
			javac Main.java

Trainer.class:		Trainer.java Athlete.class User.class WalkRunBike.class Swim.class YogaLift.class Endurance.class Workouts.class
			javac Trainer.java

Athlete.class:		Athlete.java User.class WalkRunBike.class Swim.class YogaLift.class Endurance.class Workouts.class
			javac Athlete.java

User.class:		User.java 
			javac User.java

WalkRunBike.class:	WalkRunBike.java Endurance.class Workouts.class
			javac WalkRunBike.java

Swim.class:		Swim.java Endurance.class Workouts.class
			javac Swim.java

Endurance.class:	Endurance.java
			javac Endurance.java
			
YogaLift.class:		YogaLift.java Workouts.class
			javac YogaLift.java

Workouts.class:		Workouts.java
			javac Workouts.java

run:			Main.class
			java Main

clean:		
			rm *.class

debug:			Workouts.class
			jdb Workouts

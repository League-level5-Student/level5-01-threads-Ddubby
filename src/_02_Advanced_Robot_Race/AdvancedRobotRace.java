package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	// 1. make a main method
	public static void main(String[] args) {

		// 2. create an array of 5 robots.
		Robot[] robots = new Robot[5];
		// 3. use a for loop to initialize the robots.
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot();
		}
		// 4. make each robot start at the bottom of the screen, side by side, facing up
		for (int i = 0; i < robots.length; i++) {
			robots[i].setSpeed(20);
			robots[i].move(-200);
		}
		robots[1].turn(90);
		robots[1].move(200);
		robots[1].turn(-90);
		robots[2].turn(90);
		robots[2].move(100);
		robots[2].turn(-90);
		robots[3].turn(-90);
		robots[3].move(200);
		robots[3].turn(90);
		robots[4].turn(-90);
		robots[4].move(100);
		robots[4].turn(90);
		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.
		/*
		 * Random random = new Random(50); for (int i = 0; i < robots.length; i++) { int
		 * number = random.nextInt(50); robots[i].move(number); }
		 */
		// 6. use a while loop to repeat step 5 until a robot has reached the top of the
		// screen.
		Random random = new Random(50);
		boolean notreached = true;

		Thread r1 = new Thread(() -> {
			while (notreached) {
				int number = random.nextInt(50);
				robots[0].move(number);
				if (robots[0].getY() < 0) {
					System.out.println("Robot " + 1 + " is the winner!");
					break;
				}
			}
		});
		Thread r2 = new Thread(() -> {
			while (notreached) {
				int number = random.nextInt(50);
				robots[1].move(number);
				if (robots[1].getY() < 0) {
					System.out.println("Robot " + 2 + " is the winner!");
					break;
				}
			}
		});
		Thread r3 = new Thread(() -> {
			while (notreached) {
				int number = random.nextInt(50);
				robots[2].move(number);
				if (robots[2].getY() < 0) {
					System.out.println("Robot " + 3 + " is the winner!");
					break;
				}
			}
		});
		Thread r4 = new Thread(() -> {
			while (notreached) {
				int number = random.nextInt(50);
				robots[3].move(number);
				if (robots[3].getY() < 0) {
					System.out.println("Robot " + 4 + " is the winner!");
					break;
				}
			}
		});
		Thread r5 = new Thread(() -> {
			while (notreached) {
				int number = random.nextInt(50);
				robots[4].move(number);
				if (robots[4].getY() < 0) {
					System.out.println("Robot " + 5 + " is the winner!");
					break;
				}
			}
		});

		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		// 7. declare that robot the winner and throw it a party!

		// 8. try different races with different amounts of robots.

		// 9. make the robots race around a circular track.

		try {
			r1.join();
			r2.join();
			r3.join();
			r4.join();
			r5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < robots.length; i++) {
			robots[i].moveTo(450, 500);
			robots[i].turn(90);
		}

		Thread t1 = new Thread(() -> {
			int moves = random.nextInt(100);
			for (int g = 0; g < moves; g++) {
				move(robots[0]);
			}
		});
		Thread t2 = new Thread(() -> {

			int moves = random.nextInt(100);
			for (int g = 0; g < moves; g++) {
				move(robots[1]);
			}

		});
		Thread t3 = new Thread(() -> {

			int moves = random.nextInt(100);
			for (int g = 0; g < moves; g++) {
				move(robots[2]);
			}

		});
		Thread t4 = new Thread(() -> {
			for (int i = 0; i < robots.length; i++) {
				int moves = random.nextInt(100);
				for (int g = 0; g < moves; g++) {
					move(robots[3]);
				}
			}
		});
		Thread t5 = new Thread(() -> {

			int moves = random.nextInt(100);
			for (int g = 0; g < moves; g++) {
				move(robots[4]);
			}

		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}

		
	static void move(Robot robot) {
		robot.move(15);
		robot.turn(-5);
	}

}

package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {

		Robot one = new Robot(300, 300);
		Robot two = new Robot(350, 350);
		Robot three = new Robot(400, 300);
		Robot four = new Robot(450, 350);
		Robot five = new Robot(500, 300);

		one.setSpeed(10);
		two.setSpeed(10);
		three.setSpeed(10);
		four.setSpeed(10);
		five.setSpeed(10);

		one.setPenWidth(5);
		two.setPenWidth(5);
		three.setPenWidth(5);
		four.setPenWidth(5);
		five.setPenWidth(5);

		one.penDown();
		two.penDown();
		three.penDown();
		four.penDown();
		five.penDown();

		one.setPenColor(Color.BLUE);
		two.setPenColor(Color.YELLOW);
		three.setPenColor(Color.BLACK);
		four.setPenColor(Color.GREEN);
		five.setPenColor(Color.RED);

		Thread r1 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				one.setAngle(i);
				one.move(1);
			}
		});
		Thread r2 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				two.setAngle(i);
				two.move(1);
			}
		});
		Thread r3 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				three.setAngle(i);
				three.move(1);
			}
		});
		Thread r4 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				four.setAngle(i);
				four.move(1);
			}
		});
		Thread r5 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				five.setAngle(i);
				five.move(1);
			}
		});
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
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
		one.penUp();
		two.penUp();
		three.penUp();
		four.penUp();
		five.penUp();
		one.setAngle(0);
		two.setAngle(0);
		three.setAngle(0);
		four.setAngle(0);
		five.setAngle(0);
		one.move(-300);
		two.move(-300);
		three.move(-300);
		four.move(-300);
		five.move(-300);
	}
}

package sep1;

import java.awt.Font;
import edu.princeton.cs.introcs.StdDraw;
import java.util.concurrent.ThreadLocalRandom;

public class AbrahamPong {

	public static double leftPaddleY; // Y value of the left paddle
	public static double rightPaddleY; // Y value of the right paddle
									
	public static boolean gameInAction; // boolean if the game is still in action
										
	public static boolean ballUp; // boolean if the ball is moving up
	public static boolean ballDown; // boolean if the ball is moving down
	public static boolean ballLeft; // boolean if the ball is moving left or right

	// coordinates and radius of the ball
	public static double ballX;
	public static double ballY;
	public static double r;

	public static double ballSpeedX; // X speed of moving ball
	public static double ballSpeedY; // Y speed of moving ball

	public static double paddleSpeed; // speed of paddle

	public static void main(String[] args) {

		// set the scale
		StdDraw.setXscale(0, 512);
		StdDraw.setYscale(0, 512);

		// set background color
		StdDraw.clear(StdDraw.BLACK);

		// set the speed
		ballSpeedX = 0.5;
		paddleSpeed = 53.99;

		// pre-start up the game
		startUp();
	}

	public static void startUp() {

		// reset initial ball location
		ballX = 477;
		ballY = 256;
		r = 15;

		StdDraw.clear(StdDraw.BLACK);
		StdDraw.show();

		// initial paddle locations
		leftPaddleY = 472;
		rightPaddleY = 40;

		// draw the paddles to start, left is at (10,472) right is at (502,40)
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(10, leftPaddleY, 10, 40);
		StdDraw.filledRectangle(502, rightPaddleY, 10, 40);

		// draw the initial ball
		StdDraw.filledCircle(ballX, ballY, r);

		// prevent blinking
		StdDraw.enableDoubleBuffering();
		StdDraw.show();

		// set the ball to be moving left
		ballLeft = true;
		ballUp = false;
		ballDown = false;

		// set the game to move boolean = true
		gameInAction = true;

		// start the game
		startGame();
	}

	public static void startGame() {
		// start a while loop if the game is in action
		while (gameInAction == true) {

			ballSpeedY = ThreadLocalRandom.current().nextDouble(0.1, 1.3);
			// generates a random value every time for Y between 0.1 and 1.3 for
			// movement variation

			if (StdDraw.hasNextKeyTyped()) { // if a key is pressed
				checkKey(); // check the key that was pressed
			}
			if (ballX > 35 && (ballLeft == true)) { // if ball x is over 35 and
													// ballLeft is true continue
													// moving left
				ballX = ballX - ballSpeedX;
				if (ballUp == true) { // check if ball should be going up or down
										
					ballY = ballY + ballSpeedY;
				}
				if (ballDown == true) {
					ballY = ballY - ballSpeedY;
				}
				reDraw(); // redraw the game
			}

			if (ballX < 477 && (ballLeft == false)) { // if ball x is under 477
														// and ballLeft is false
														// continue moving right
				ballX = ballX + ballSpeedX;
				if (ballUp == true) { // check if ball should be going up or down
										
					ballY = ballY + ballSpeedY;
				}
				if (ballDown == true) {
					ballY = ballY - ballSpeedY;
				}
				reDraw(); // redraw the game
			}

			else if (ballX == 35 && (leftPaddleY + 60) < (ballY)) {
				quit(); // if ball hits the wall, end the game
			}

			else if (ballX == 477 && (rightPaddleY + 60) < (ballY)) {
				quit(); // if ball hits the wall, end the game
			}

			else if (ballX == 35 && (ballY) < (leftPaddleY - 60)) {
				quit(); // if ball hits the wall, end the game
			}

			else if (ballX == 477 && (ballY) < (rightPaddleY - 60)) {
				quit(); // if ball hits the wall, end the game
			}

		}
	}

	public static void checkKey() { // method to check which key was pressed
		char key = StdDraw.nextKeyTyped(); // stores the key that was pressed in
											// a char

		if ((key) == 'a') {
			if (leftPaddleY < 472) {
				leftPaddleY = leftPaddleY + paddleSpeed;
				reDraw();
			}

		}
		// if the key pressed was a, and the Y of the left paddle is below 472,
		// move paddle up
		else if ((key) == 'z') {
			if (leftPaddleY > 41) {
				leftPaddleY = leftPaddleY - paddleSpeed;
				reDraw();
			}
		}
		// if the key pressed was z, and the Y of the left paddle is above 40,
		// move paddle down
		else if ((key) == 'k') {
			if (rightPaddleY < 471) {
				rightPaddleY = rightPaddleY + paddleSpeed;
				reDraw();
			}
		}
		// if the key pressed was k, and the Y of the right paddle is below 472,
		// move paddle up
		else if ((key) == 'm') {
			if (rightPaddleY > 41) {
				rightPaddleY = rightPaddleY - paddleSpeed;
				reDraw();
			}
		}
		// if the key pressed was m, and the Y of the right paddle is above 40,
		// move paddle down
		else if ((key) == ' ') {
			startUp();
		}
		// if the key pressed was space, start a new game
		else if ((key) == 'q') {
			quit();
		}
		// if the key pressed was q, quit the new game

	}

	public static void reDraw() { // this method redraws the game according to
									// our new paddle locations

		if (ballY < 30 && ballY > 0) { // if ball hits the bottom, change Y direction
										
			ballDown = false;
			ballUp = true;
		}
		if (ballY > 480 && ballY < 512) { // if ball hits the top, change Y direction
											
			ballDown = true;
			ballUp = false;
		}

		// check if the ball hit the left paddle, then change direction to right
		if (ballX == 35 && ((leftPaddleY - 60) < (ballY)) && (ballY) < (leftPaddleY + 60)) {
			// check if the ball is hitting the top or bottom of the paddle
			// if it hits the top set the ball to go up, if it hit the bottom of
			// the paddle set the ball to go down
			if ((leftPaddleY) < (ballY) && (ballY) < (leftPaddleY + 60)) {
				ballLeft = false;
				ballDown = false;
				ballUp = true;
			} else if ((leftPaddleY - 60) < (ballY) && (ballY) < (leftPaddleY)) {
				ballLeft = false;
				ballDown = true;
				ballUp = false;
			}
		}

		// check if the ball hit the right paddle, then change direction to left
		else if (ballX == 477 && ((rightPaddleY - 60) < (ballY)) && (ballY) < (rightPaddleY + 60)) {
			// check if the ball is hitting the top or bottom of the paddle
			// if it hits the top set the ball to go up, if it hit the bottom of
			// the paddle set the ball to go down
			if ((rightPaddleY) < (ballY) && (ballY) < (rightPaddleY + 60)) {
				ballLeft = true;
				ballDown = false;
				ballUp = true;
			} else if (((rightPaddleY - 60) < (ballY)) && (ballY) < (rightPaddleY)) {
				ballLeft = true;
				ballDown = true;
				ballUp = false;
			}
		}

		// redraw ball and paddles
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.filledRectangle(10, leftPaddleY, 10, 40);
		StdDraw.filledRectangle(502, rightPaddleY, 10, 40);
		StdDraw.filledCircle(ballX, ballY, r);
		StdDraw.show();

	}

	public static void quit() // This method shows a quick message and then
								// closes the game
	{
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.show();
		// clear the game
		Font font = new Font("Arial", Font.BOLD, 50); // set the font
		StdDraw.setFont(font);
		StdDraw.text(256, 256, "Thanks for playing!");
		StdDraw.show(); // show the text
		try {
			Thread.sleep(2000); // wait 2000 milliseconds
			System.exit(0); // close the game
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

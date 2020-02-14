package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import me.jjfoley.gfx.GFX;



/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 */
public class Aquarium extends GFX {
	/**
	 * This is a static variable that tells us how wide the aquarium is.
	 */
	

	
	public static int WIDTH = 500;
	/**
	 * This is a static variable that tells us how tall the aquarium is.
	 */
	public static int HEIGHT = 500;
	
	// source: http://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html
	public static final Color BROWN = new Color(102, 51, 0);
	public static final Color GREEN2 = new Color(0, 64, 0, 200);

	/**
	 * Put a snail on the top of the tank.
	 */
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");

	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 */
	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		super(WIDTH, HEIGHT);

		
		// TA Grace helped me put the floating for loop I had in a method
		this.fillBubble();
			
		Random random = new Random();
		
		for (int i = 0; i < this.fish.length; i++) {
			Color rcolor = Color.getHSBColor( random.nextFloat(), 0.8f, 0.8f);
			boolean isLittle = random.nextBoolean();
			boolean facingLeft = random.nextBoolean();
			int x = random.nextInt(500);
			int y = random.nextInt(500);
			
			this.fish[i] = new Fish(x, y, rcolor, isLittle, facingLeft);
		}
		
		
		for (int i = 0; i < this.hungryfish.length; i++) {
			Color rcolor = Color.getHSBColor( random.nextFloat(), 0.8f, 0.8f);
			boolean isLittle = random.nextBoolean();
			boolean facingLeft = random.nextBoolean();
			int x = random.nextInt(500);
			int y = random.nextInt(500);
			
			this.hungryfish[i] = new HungryFish2(x, y, rcolor, isLittle, facingLeft);
		}
	}


	Fish[] fish = new Fish[5];
	BubbleSystem[] bubble = new BubbleSystem[10];
	HungryFish food = new HungryFish();

	HungryFish2[] hungryfish = new HungryFish2[10];
	public void fillBubble() {

		for (int i = 0; i < bubble.length; i++) {
			Random random = new Random(); 

			int nX = random.nextInt(500 + 1 - 450) + 450; 
			int nY = random.nextInt(500);

			// source: https://stackoverflow.com/questions/2444019/how-do-i-generate-a-random-integer-between-min-and-max-in-java
			int nW = random.nextInt(15 + 1 - 7) + 7;

			bubble[i] = new BubbleSystem(Color.white, nX, nY, nW, nW);
		}

	}


	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
	
		algorithm.update();
		
		g.setColor(new Color(0, algorithm.green, 255));
		
		g.fillRect(0, 0, getWidth(), getHeight());

	
		for (BubbleSystem bubble: bubble){
			bubble.draw(g);
			}
		
		for (Fish fish: fish){
			fish.draw(g);
			}
		
		for (HungryFish2 hungryfish: hungryfish){
			hungryfish.draw(g);
			}
		
		
		g.setColor(BROWN);
		// https://docs.oracle.com/javase/tutorial/2d/geometry/primitives.html
		g.fillRect(400, 430, 120, 80);
		
		food.draw(g);

		// Draw our snail!
	
		algorithm.draw(g);
		

		//food.animate();
	}

	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}

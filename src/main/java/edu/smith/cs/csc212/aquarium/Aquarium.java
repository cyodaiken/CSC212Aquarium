package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics2D;

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
		
		this.fillBubble();
	}

	/*
	 * int fish1X = getWidth() + 100; int fish2X = getWidth() - 300; // little red
	 * fish int fish3X = -200;
	 */

	Fish nemo = new Fish(Color.magenta, 250, 250, true, true);
	Fish marlin = new Fish(Color.orange, 100, 100, false, false);
	Fish dory = new Fish(Color.pink, 300, 100, true, false);
	Fish tuna = new Fish(Color.red, 100, 400, false, true);
	Fish salmon = new Fish(Color.yellow, 20, 400, false, true);

	BubbleSystem[] arr = new BubbleSystem[10];

	// BubbleSystem b1 = new BubbleSystem(Color.white, 200, 200);

	
	public void fillBubble() {
		
		for (int i = 0; i < arr.length; i++) {
			  Random random = new Random(); 
			  int nX = random.nextInt(500); 
			  int nY = random.nextInt(500);  
			  arr[i] = new BubbleSystem(Color.white, nX, nY);
		}
		
	}
	
	
	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());

		salmon.draw(g);
		nemo.draw(g);
		tuna.draw(g);

		marlin.draw(g);
		dory.draw(g);
		
		
		
		for (BubbleSystem bubble: arr)	{
			
			bubble.draw(g);
			
		}
		
		
		
		// b1.draw(g);


		//	for(int i = 0; i < arr.length; i++) {
		//		arr[i].draw(g);
		//	}

		/*
		 * // Draw the fish! DrawFish.facingLeft(g, Color.yellow, fish1X, 200); // Draw
		 * the confused fish! DrawFish.facingRight(g, Color.green, fish2X, 300);
		 * 
		 * // What if we wanted this little fish to swim, too?
		 * DrawFish.smallFacingRight(g, Color.red, fish3X, 100);
		 */

		// Draw our snail!
		algorithm.draw(g);

		/*
		 * // Move the fish! fish1X -= 1; fish2X += 2; fish3X += 2;
		 * 
		 * if (fish1X > getWidth() + 100) { fish1X = 100; }
		 * 
		 * if (fish2X > getWidth() + 100) { fish2X = -100; }
		 * 
		 * if (fish3X > getWidth() + 100) { fish3X = -100; }
		 */
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

package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Predator {
	
	int x;
	int y;
	Color color;
	
	boolean facingLeft;
	int destX;
	int destY;
	int speedX;
	int speedY;
	
	
	public Predator(int startX, int startY, Color startColor, boolean isLittle, boolean facingLeft) {
		this.color = startColor;
		this.x = startX;
		this.y = startY;
		
		this.facingLeft = facingLeft;

		Random random = new Random();
		this.destX = random.nextInt(500);
		this.destY = random.nextInt(500);
		this.speedX = 1;
		this.speedY = 1;
	}
	
	public void swim() {

		if (this.x < this.speedX + this.destX) { 
			facingLeft = false;
			this.x += this.speedX;

		} else if (this.x > this.speedX - this.destX) {
			facingLeft = true;
			this.x -= this.speedX;
		} 

		if (this.y < this.speedY + this.destY) { 
			this.y += this.speedY; 

		} else if (this.y > this.speedY - this.destY) { 
			this.y -= this.speedY; 
		} 

		if (this.y == this.destY || this.x == this.destX) {
			Random random = new Random(); 
			this.destX = random.nextInt(500); 
			this.destY = random.nextInt(500);

		}

	}
	
public void draw(Graphics2D g) {

		if (facingLeft) {
			this.facingLeft(g, this.color, this.x, this.y);
		} else {
			this.facingRight(g, this.color, this.x, this.y);
		}
		
		this.swim();

	}

/**
 * This code based on the Python fish in CSC111 labs, e.g.,
 * https://jcrouser.github.io/CSC111/labs/lab-10-animation.html
 * 
 * @author jfoley
 */
public void facingLeft(Graphics2D g, Color color, int x, int y) {
	// Draw the fish.
	g.setColor(color);

	Shape body = new Ellipse2D.Double(x - 40, y - 20, 160, 80);
	Shape tail = new Ellipse2D.Double(x + 100, y - 40, 40, 120);
	Shape eye = new Ellipse2D.Double(x - 15, y + 5 , 10, 10);

	g.fill(body);

	// draw body outline.
	g.setColor(Color.black);
	g.draw(body);

	// draw eye (still black):
	g.fill(eye);

	// draw tail:
	Color tailColor = color.darker();
	g.setColor(tailColor);
	g.fill(tail);

	// draw tail outline.
	g.setColor(Color.black);
	g.draw(tail);
}

/**
 * This method is implemented by creating a new Graphics "world" located at x,y
 * that is scaled in a "backwards" X world.
 * 
 * @param g     the original graphics world.
 * @param color the color of the fish!
 * @param x     the x-coordinate of the position to draw the fish.
 * @param y     the y-coordinate of the position to draw the fish.
 */
public void facingRight(Graphics2D g, Color color, int x, int y) {
	Graphics2D flipped = (Graphics2D) g.create();
	flipped.translate(x, y);
	flipped.scale(-1, 1);
	facingLeft(flipped, color, 0, 0);
	flipped.dispose();
}

	

}

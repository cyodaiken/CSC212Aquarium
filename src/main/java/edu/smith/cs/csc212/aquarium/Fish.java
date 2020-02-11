package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {
	// Every fish has an x which is an int
	
	int x;
	int y;
	Color color;
	boolean isLittle;
	boolean facingLeft;
	// every fish has a destination: (x,y), eventually random
	int destX;
	int destY;
	int speedX;
	int speedY;

	public Fish(int startX, int startY, Color startColor, boolean isLittle, boolean facingLeft) {

		this.color = startColor;
		this.x = startX;
		this.y = startY;
		this.isLittle = isLittle;
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
		  
		  Random random = new Random(); this.destX = random.nextInt(500); this.destY =
		  random.nextInt(500);
		  
		  }
		 
	
		/*
		 * if (this.facingLeft) { this.x += -speedX; if (this.x == -20) { this.x = 520;
		 * } else if (this.x == 520) { this.x = -20; } } else { this.x += speedX;
		 * if(this.x == 520) { this.x = -20; } else if (this.x == -20) { this.x = 520; }
		 * }
		 * 
		 * if (this.y < this.destY) { // if (Math.abs(this.y - this.destY) < 10) //
		 * somehow pick a new destination} this.y += speedY; } else if (this.y >
		 * this.destY) { this.y -= 1; } else { Random random = new Random(); this.destX
		 * = random.nextInt(500); this.destY = random.nextInt(500); }
		 */
	}


	public void draw(Graphics2D g) {
		
		this.swim();

		if (isLittle && facingLeft) {
			DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
		} else if (isLittle && !facingLeft) {
			DrawFish.smallFacingRight(g, this.color, this.x, this.y);

		} else if (!isLittle && facingLeft) {
			DrawFish.facingLeft(g, this.color, this.x, this.y);
		} else {
			DrawFish.facingRight(g, this.color, this.x, this.y);
		}

		

	}

}

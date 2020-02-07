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
	
	public Fish (Color c, int startX, int startY, boolean isLittle, boolean facingLeft) {
		this.color = c;
		this.x = startX;
		this.y = startY;
		this.isLittle = isLittle;
		this.facingLeft = facingLeft;
		
		Random random = new Random();
		this.destX = random.nextInt(500);
		this.destY = random.nextInt(500);
	}
	
	public void swim() {
			
		if (this.facingLeft) {
			if (this.x < this.destX) {
				this.x -= 1;
				if (this.x == 0) {
					this.x = 500;
				}
			} 
		} else {
			if(this.x < this.destX) {
				this.x += 1;
				if (this.x == 500) {
					this.x = 0;
				}
			} 
		}

		if (this.y < this.destY) {
			// if (Math.abs(this.y - this.destY) < 10) {
		// somehow pick a new destination}
			this.y += 1;
		} else if (this.y > this.destY) {
			this.y -= 1;
		} // else choose new destination
		
		
		
	}
	
	public void draw(Graphics2D g) {
		
		// assumes fish face left and are small so add boolean
		if (isLittle && facingLeft) {	
			DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
			/*
			 * if (this.x < 0) { DrawFish.smallFacingLeft(g, this.color, 500, this.y); }
			 */
		} else if (isLittle && !facingLeft) {
			DrawFish.smallFacingRight(g, this.color, this.x, this.y);
			
		} else if (!isLittle && facingLeft) {
			DrawFish.facingLeft(g, this.color, this.x, this.y);
		} else {
			DrawFish.facingRight(g, this.color, this.x, this.y);
		}
		
		this.swim();
		
	}

}

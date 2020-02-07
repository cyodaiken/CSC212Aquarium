package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

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
		this.destX = 450;
		this.destY = 450;
	}
	
	public void swim() {
		
		if (this.x < this.destX) {
			this.x += 1;
	}
		
		if (this.y < this.destY) {
				this.y += 1;
		}
	}
	
	public void draw(Graphics2D g) {
		this.swim();
		// assumes fish face left and are small so add boolean
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

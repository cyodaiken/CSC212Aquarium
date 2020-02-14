package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class HungryFish2 {
	
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
	int hungry;
	
	
	
	public HungryFish2(int startX, int startY, Color startColor, boolean isLittle, boolean facingLeft) {

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
	
	
	public void animate(Graphics2D g) {
		
		Random random = new Random();
		
		if ((this.x < 200 && this.y > 400) && this.hungry >=20) {
			this.hungry = 0;
			
			this.color = Color.getHSBColor(random .nextFloat(), 0.8f, 0.8f);
			
		} else {
			
			this.hungry += 1;
		}

		  if (this.x < this.speedX + this.destX) { 
			  facingLeft = false; 
			  this.x += this.speedX;
		  
		  } else if (this.x > this.speedX - this.destX) {
			  facingLeft = true; this.x -= this.speedX; }
		  
		  if (this.y < this.speedY + this.destY) { 
			  this.y += this.speedY;
		  
		  } else if (this.y > this.speedY - this.destY) {
			  this.y -= this.speedY; 
			  }
		  
		  if (this.y == this.destY || this.x == this.destX) {
			  
			 // Random random = new Random(); 
			  int aDestX = random.nextInt(200 + 1); 
			  int aDestY = random.nextInt(500 + 1 - 400) + 400; 
			  if (this.hungry >= 20) { 
				  // choose destination in algae 
				  this.destX = aDestX; 
				  this.destY = aDestY; 
				  this.hungry = 0;
				  this.color = Color.blue;
				  
				  
			} else { 
				this.destX = random.nextInt(500); 
				 this.destY = random.nextInt(500); 
				 
				 
				  } 
			  }
		  
		  }
	
	
	
	public void draw(Graphics2D g) {
		
		this.animate(g);

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



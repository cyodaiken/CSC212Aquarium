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

	public Fish(Color c, int startX, int startY, boolean isLittle, boolean facingLeft) {

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

		/*
		 * if (this.facingLeft) { if (this.x < this.destX) { this.x -= 1; if (this.x ==
		 * 0) { this.x = 500; } } } else { if(this.x < this.destX) { this.x += 1; if
		 * (this.x == 500) { this.x = 0; } } }
		 */

		// int direction = 1;

		if (this.facingLeft) {

			// direction = -1;
			this.x += -1;

			if (this.x == -20) {
				this.x = 520;
			} else if (this.x == 520) {
				this.x = -20;
			}
		} else {
			this.x += 1;

			if(this.x == 520) {
				this.x = -20;
			} else if (this.x == -20) {
				this.x = 520;
			}

		}

		if (this.y < this.destY) {
			// if (Math.abs(this.y - this.destY) < 10) {
			// somehow pick a new destination}
			this.y += 1;
		} else if (this.y > this.destY) {
			this.y -= 1;
		} 
		else {

			Random random = new Random(); this.destX = random.nextInt(500); this.destY =
					random.nextInt(500); }
	}

	public void draw(Graphics2D g) {

		if (isLittle && facingLeft) {
			DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
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

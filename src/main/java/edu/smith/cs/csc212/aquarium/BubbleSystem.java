package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class BubbleSystem {
	
	int x;
	int y;
	Color color;
	int period = 0; 
	
	
	public BubbleSystem(Color c, int startX, int startY) {
		
		this.color = c;
		this.x = startX;
		this.y = startY;
		
		
		
	}
	
	public void swim() {
		
		this.y -= 1;
		
		if (this.y == -20) {
			this.y = 540;	
			
		}
		
		//this.x -= 1;
		
		/*
		 * if (period == 30) {
		 * 
		 * period = 0;
		 * 
		 * this.x = -this.x;
		 * 
		 * } else {
		 * 
		 * period += 1; }
		 */
		
	}
	
	
	public void draw(Graphics2D g) {
		
		g.setColor(color);
		
		Random random = new Random(); 
		int dx = random.nextInt(15);
		
		Shape bubble = new Ellipse2D.Double(x - 15, y - 10, 10, 10);
		
		g.draw(bubble);
		g.fill(bubble);
		
		
		this.swim();
	
	}
	


	}


package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class BubbleSystem {
	
	int x;
	int y;
	int wiggle;
	int w;
	int h; 
	Color color;
	int period = 0; 
	// int delay = 0;
	
	
	public BubbleSystem(Color c, int startX, int startY, int width, int height) {
		
		this.color = c;
		this.x = startX;
		this.y = startY;
		this.w = width;
		this.h = width;
		this.wiggle = 0;
		// this.delay = delay;	
		
	}
	
	public void swim() {
		
		// this.delay += 1;
		
		this.y -= 1;
		
		if (this.y == -30) {
			this.y = 540;	
		}
		
		/*
		 * if (this.delay > 100) { this.delay = 0; this.x -= 40; if(this.x < 0 ) {
		 * this.x = 500; } }
		 */
		this.wiggle = (int) (30.0 * Math.sin(this.y / 80.0)); 
		
	}
	
	
	public void draw(Graphics2D g) {
		
		g.setColor(color);
		
		Shape bubble = new Ellipse2D.Double(x - 15 + this.wiggle, y - 10, w, h);
		
		g.draw(bubble);
		g.fill(bubble);
		
		this.swim();
	
	}
	


	}


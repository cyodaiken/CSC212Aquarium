
  package edu.smith.cs.csc212.aquarium;
  
  import java.awt.Color; 
  import java.awt.Font; 
  import java.awt.Graphics2D;
  
  
  public class HungryFish {
  
  int x; 
  int y; 
  int w; 
  int h; 
  Color color; 

  
  // source: http://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html
  public static final Color GREEN2 = new Color(0, 64, 0, 200);

  public HungryFish() {

	  this.x = 0; 
	  this.y = 400; 
	  this.w = 200; 
	  this.h = 100; 

  }



  public void draw(Graphics2D g) {

	  g.setColor(GREEN2); 
	  g.fillRect(this.x, this.y, this.w, this.h); 
	  Font f = g.getFont(); 
	  g.setFont(f.deriveFont(30f)); 
	  g.setColor(Color.black);
	  g.drawString("algae", 50, 450);



  }

  }
 
package PongGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
	
	//Attributes//
	public double x,y; 
	public int width, height;
	
	//Constructor//
	public Enemy (int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 3;
	}
	
	//Event Tick and Render//
	public void eventTick() {	
		x+= (Game.ball.x - x - 6) * 0.3;
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(255,0,0));
		g.fillRect((int)x, (int)y, width, height);
	}
}

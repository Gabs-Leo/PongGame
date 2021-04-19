package PongGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	//Attributes//
	public double x,y; 
	public int width, height;
	public double dx, dy;
	public double speed = 3;
	
	//Constructor//
	public Ball (int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = 4;
		int angle = new Random().nextInt(120-45)+45;
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.cos(Math.toRadians(angle));
	}
	
	//Event Tick and Render//
	public void eventTick() {	
		if(x+(dx*speed) + width >= Game.WIDTH) {
			dx*=-1;
		}
		else if(x + (dx*speed) < 0){
			dx*=-1;
		}
		
		if(y >= Game.HEIGHT) {
			//TODO enemy point//
			System.out.println("Enemy Point!");
			new Game();
			return;
		}
		else if (y < 0) {
			//TODO my point//
			System.out.println("Your point!");
			new Game();
			return;
		}
		Rectangle bounds = new Rectangle((int)(x+dx*speed),(int)(y+(dy*speed)),width,height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(120-45)+45;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.cos(Math.toRadians(angle));
			if(dy > 0) {
				dy*=-1;
			}
		}
		else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(120-45)+45;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.cos(Math.toRadians(angle));
			if(dy < 0) {
				dy*=-1;
			}
		}
		x+=dx*speed;
		y+=dy*speed;
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(255,255,255));
		g.fillOval((int)x, (int)y, width, height);
	}
}
